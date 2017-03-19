package com.krzysztofziomek.frequentphrases.topfrequent;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 17/03/2017.
 * <p>
 * <p>
 * Challenge description:
 * Given a large file that does not fit in memory (say 10GB), find the top 100000 most frequent phrases. The file has 50 phrases per line separated by a pipe (|). Assume that the phrases do not contain pipe.
 * Example line may look like: Foobar Candy | Olympics 2012 | PGA | CNET | Microsoft Bing ....
 * The above line has 5 phrases in visible region.
 * <p>
 * Assumptions
 * 1. File might be really huge i.e. 1TB
 * 2. Every phrase in file may be different -> In this case I can't go for solution to keep HashMap of phrases with number of occurrences because it would be size similar to file size (to big for memory)
 * 3. Phrases are not words so it is not limited set of phrases which fits in memory.
 * <p>
 * Algorithm description
 * 1. First iteration. Count fragmentary frequencies.
 * Go through file and count element frequencies. Counters store in map, where key is phrase and value is number of occurences.
 * When map is full flush it to tmp file and continue counting with empty map.
 * Repeat reading and flushing until whole huge file is processes.
 * <p>
 * 2. Merge counters stored in files
 * At this stage we have fragmentary counters spattered through tmp files.
 * In this stage the same phrase might be stored in more than one file but sum of counters is equal to frequency in huge file.
 * Let's merge phrases' counters.
 * After this phase we will have only one occurrence of phrase throughout all files with sum of partial counters.
 * In this stage we should have unique phrases throughout all fragmentary files.
 * <p>
 * 3. BuildTopCounterMap
 * In this phase we will calculate lowestCounter threshold which we use next to pick top frequent phrases
 * <p>
 * 4. Go through tmp files to pick top phrases, counter >= lowestCounter
 * If there is more than one phrase with counter == lowestCounter,
 * we take first phrases in stream so we return no more than lowerCounterFreeSlots which was calculated in TopCounterMap.
 * <p>
 * 5. Clean up tmp files
 */
public class TopFrequentPhrases {

    public static final String KEY_VALUE_SEPARATOR = "=";
    private static final boolean IS_DEBUG_MODE = false;

    /**
     * @param hugeInputFile            - huge file, which doesn't fit in memory i.e. 10GB or 1TB
     * @param memoryCounterMapMaxSize  - max size of map for counters which is stored in memory. When map is full it is saved to tmpFile and cleared (flushed).
     * @param topFrequentPhrasesNumber - number of top frequent phrases we are looking for
     * @return map of top frequent phrases with their counters
     * @throws IOException
     */
    public Map<String, Long> findTopPhrases(String hugeInputFile, int memoryCounterMapMaxSize, int topFrequentPhrasesNumber) throws IOException {


        /* 0. Validate file is not empty */
        if (Files.size(Paths.get(hugeInputFile)) == 0) {
            return new HashMap<>();
        }

        /* 1. First iteration. Count fragmentary frequencies. */
        List<Path> tmpFiles = countFragmentaryFrequencies(hugeInputFile, memoryCounterMapMaxSize);
        if (IS_DEBUG_MODE) {
            System.out.println(tmpFiles);
        }

        /* 2. Merge counters stored in files */
        mergeCounters(tmpFiles);

        /* In this stage we should have unique phrases in throughout all fragmentary files. */

        /* 3. BuildTopCounterMap */
        TopCountersMap topCountersMap = buildTopCounterMap(tmpFiles, topFrequentPhrasesNumber);
        Long minCounter = topCountersMap.getLowestCounter();
        long lowerCounterFreeSlots = topCountersMap.getLowestCounterFreeSlots();

        /* 4. Go through tmp files to pick top phrases */
        Map<String, Long> topPhrases = readTopPhrases(tmpFiles, minCounter, lowerCounterFreeSlots);

        //Print top phrases
        if (IS_DEBUG_MODE) {
            System.out.println("**** TOP PHRASES ****");
            System.out.println(topPhrases);
        }


        // 5. Clean up tmp files
        deleteTmpFiles(tmpFiles);

        return topPhrases;

    }

    private Map<String, Long> readTopPhrases(List<Path> files, Long minCounter, long lowerCounterFreeSlots) throws IOException {
        Map<String, Long> topPhrases = new HashMap<>();
        long[] freeSlots = {lowerCounterFreeSlots};
        for (Path file : files) {
            Files.lines(file).forEach(line -> {
                String[] entry = StringUtils.splitString(line, KEY_VALUE_SEPARATOR);
                Long value = Long.valueOf(entry[1]);
                if (value >= minCounter) {
                    if (value.compareTo(minCounter) == 0 && freeSlots[0] > 0) {
                        topPhrases.put(entry[0], value);
                        freeSlots[0]--;
                    } else if (value > minCounter) {
                        topPhrases.put(entry[0], value);
                    }
                }
            });
        }

        return topPhrases;

    }

    public TopCountersMap buildTopCounterMap(List<Path> files, int topFrequent) throws IOException {

        TopCountersMap topCountersMap = new TopCountersMap(topFrequent);

        for (Path file : files) {
            Files.lines(file).forEach(line -> {
                String[] entry = StringUtils.splitString(line, KEY_VALUE_SEPARATOR);
                topCountersMap.add(Long.valueOf(entry[1]));
            });
        }
        return topCountersMap;

    }


    /*
     *  Complexity of mergeCounters method is O(n^2).
     *  However n is not number of elements in huge file but number of tmp files.
     *
     *  Performance of algorithm depends on number of tmp files.
     *  Seeking for better complexity:
     *  First I would try approach with sorted elements in tmp files. It should give O(nlogn).
     *  But notice, that even if complexity would be O(nlogn) it doesn't mean it will be faster for relatively small number of elements like in 10GB file.
     *  Execution time benchmark is must.
     *  Moreover I would consider algorithm for multithreading processing.
     */
    private void mergeCounters(List<Path> tmpFiles) throws IOException {
        for (int i = 0; i < tmpFiles.size(); i++) {
            for (int j = i + 1; j < tmpFiles.size(); j++) {
                Path iFile = tmpFiles.get(i);
                Path jFile = tmpFiles.get(j);


                Map<String, Long> imap = loadMapFromTmpFile(iFile);
                Map<String, Long> jmap = loadMapFromTmpFile(jFile);

                if (IS_DEBUG_MODE) {
                    System.out.println("mergeCounters i=" + i + " j=" + j);
                    System.out.println(imap);
                    System.out.println(jmap);
                }

                mergeMaps(imap, jmap);

                Path iUpdatedFile = saveMapToTmpFile(imap);
                Path jUpdatedFile = saveMapToTmpFile(jmap);

                tmpFiles.set(i, iUpdatedFile);
                tmpFiles.set(j, jUpdatedFile);
            }
        }

    }

    /**
     * When both maps contain the same phrase then we sum counters, assign value to phrase in imap and remove phrase from jmap
     *
     * @param imap
     * @param jmap
     */
    protected void mergeMaps(Map<String, Long> imap, Map<String, Long> jmap) {
        Iterator<Map.Entry<String, Long>> jIterator = jmap.entrySet().iterator();
        while (jIterator.hasNext()) {
            Map.Entry<String, Long> jElement = jIterator.next();
            if (imap.containsKey(jElement.getKey())) {
                Long iCounter = imap.get(jElement.getKey());
                iCounter = iCounter + jElement.getValue();
                imap.put(jElement.getKey(), iCounter);
                jIterator.remove();
            }
        }
    }

    private void deleteTmpFiles(List<Path> tmpFiles) throws IOException {
        for (Path tmpFile : tmpFiles) {
            Files.deleteIfExists(tmpFile);
            if (IS_DEBUG_MODE) {
                System.out.println("Delete tmp file: " + tmpFile);
            }
        }
    }


    /**
     * This method will produce fragmentary files witch contain Map<String,Long> where String is phrase and Long is counter of occurences before map was flushed to file.
     * Complexity: O(n)
     *
     * @param hugeInputFile
     * @param memoryCounterMapMaxSize
     * @return List of files with fragmentary counters
     * @throws IOException
     */
    private List<Path> countFragmentaryFrequencies(String hugeInputFile, int memoryCounterMapMaxSize) throws IOException {
        Map<String, Long> memoryCounterMap = new HashMap<>(memoryCounterMapMaxSize);
        List<Path> fragmentaryTmpFiles = new ArrayList<>();

        Files.lines(Paths.get(hugeInputFile)).forEach(line -> {
            String[] phrases = StringUtils.splitString(line, "|");
            for (String phrase : phrases) {
                if (memoryCounterMap.size() >= memoryCounterMapMaxSize) {
                    fragmentaryTmpFiles.add(
                            flushMapToFile(memoryCounterMap)
                    );
                }
                putElementInMap(memoryCounterMap, StringUtils.trimWhitespace(phrase));
            }
        });

        // flush last fragmentary counter map to file to have all fragmentary counters in tmp files
        fragmentaryTmpFiles.add(
                flushMapToFile(memoryCounterMap)
        );
        return fragmentaryTmpFiles;
    }

    private void putElementInMap(Map<String, Long> map, String element) {
        Long counter = map.get(element);
        if (counter == null) {
            map.put(element, 1L);
        } else {
            map.put(element, counter + 1);
        }

    }

    /**
     * Method will save map content to file, clear map, and returns file Path
     */
    private Path flushMapToFile(Map<String, Long> memoryCounterMap) {
        Path path = saveMapToTmpFile(memoryCounterMap);
        memoryCounterMap.clear();
        return path;
    }


    private Path saveMapToTmpFile(Map<String, Long> map) {
        if (IS_DEBUG_MODE) {
            System.out.println("flush to file");
            System.out.println(map);
        }

        try {
            Path tempFile = Files.createTempFile("TopFrequentPhrases", "");
            BufferedWriter writer = Files.newBufferedWriter(tempFile);
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                writer.write(entry.getKey() + KEY_VALUE_SEPARATOR + entry.getValue());
                writer.newLine();
            }
            writer.close();
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Filed to save into tmp file.", e);

        }
    }

    private Map<String, Long> loadMapFromTmpFile(Path path) throws IOException {
        if (IS_DEBUG_MODE) {
            System.out.println("Read file to map: " + path);
        }
        Map<String, Long> map = new HashMap<>();
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        bufferedReader.lines().forEach(line -> {
            String[] entry = StringUtils.splitString(line, KEY_VALUE_SEPARATOR);
            map.put(entry[0], Long.valueOf(entry[1]));
        });
        bufferedReader.close();
        Files.deleteIfExists(path);
        return map;
    }

}