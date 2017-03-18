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
 * <p>
 * <p>
 * <p>
 * https://en.wikipedia.org/wiki/External_sorting
 * <p>
 * Assumptions
 * 1. File might be really huge i.e. 1TB
 * 1. Every phrase in file may be different -> In this case I can't go for sollution to keep HashMap of phrases with number of occurences because it would be size similar to file size (to big for memory)
 * <p>
 * O(nlogm)
 * m - number of elements in file
 * k - size of hashmap - 100000
 * <p>
 * <p>
 * 1. If we need sth more accurate than we would need to flush hashmap with occurences to file when it's full and build new one
 * After processing file we processFile our result hashmaps from files
 * <p>
 * String[] files = new String[no_of_files]
 * <p>
 * 2. Merge files occurences
 * for (int i=0: i<files.size; i++){
 * for(int j=i+1, j<file.size; j++{
 * merge(files[i], files[j] // rewrite j files to new file without elements which were accrued
 * }
 * valuesAmounts
 * <p>
 * 3. Find the k largest number in a running stream.
 * go through files again to get highest 100000 occurences with TreeMap (value, nrOfElementsWithThisValue)
 * if (valuesAmounts >= k+firstElementValue )  remove tree.firstElement
 * <p>
 * <p>
 * <p>
 * <p>
 * 4. go through files to get phrases of highest occurences
 * <p>
 * Read about heaps. Does it contain the same elements? You can implement such heap.
 * * Find the k largest number in a running stream.
 * http://qa.geeksforgeeks.org/78/find-the-k-largest-number-in-a-running-stream
 * <p>
 * <p>
 * Further improvements:
 * Trim phrase between pipes
 */
public class TopFrequentPhrases {

    private static final String KEY_VALUE_SEPARATOR = "=";

    /**
     * @param hugeInputFile            - huge file, which doesn't fit in memory i.e. 10GB or 1TB
     * @param memoryCounterMapMaxSize  - max size of map for counters which is stored in memory. When map is full it is saved to tmpFile and cleared (flushed).
     * @param topFrequentPhrasesNumber - number of top frequent phrases we are looking for
     * @return map of top frequent phrases with their counters
     * @throws IOException
     */
    public Map<String, Long> findTopFrequents(String hugeInputFile, int memoryCounterMapMaxSize, int topFrequentPhrasesNumber) throws IOException {

        /* 1. First iteration.
         *    Go through file and count frequencies in map. When map is full flush it to tmp file and continue counting.
         */

        List<Path> tmpFiles = countFragmentaryFrequencies(hugeInputFile, memoryCounterMapMaxSize);
        System.out.println(tmpFiles);

        /* 2. Merge counters stored in files occurences
             At this stage we have fragmentary counters spattered through tmp files.
             It means the same phrase might be stored in many files but sum of counters is equal to frequency in huge file.
             Let's merge phrases' counters.
             After this phase we will have only one occurence of phrase throughout all files with sum of previous counters.
         */

        mergeCounters(tmpFiles);

        /* In this stage we should have unique phrases in throughout all fragmentary files. */

        /* 3. BuildTopCounterMap
         *  In this phase we will calculate minimum counter threshold to consider phrase as top frequent
         */
        TopCountersMap topCountersMap = buildTopCounterMap(tmpFiles, topFrequentPhrasesNumber);
        Long minCounter = topCountersMap.getLowestCounter();
        long lowerCounterFreeSlots = topCountersMap.getLowestCounterFreeSlots(); // todo test surplus

        /* 4  go through files to pick top phrases, counter >= minCounter
         * If there is more than one phrase with counter == minCounter. We take first phrases in stream so we return no more than topFrequentPhrasesNumber in return map
         * surplusValue is to be watch if we can take more phrases with counter == minCounter
         */
        Map<String, Long> topPhrases = readTopPhrases(tmpFiles, minCounter, lowerCounterFreeSlots);

        //Print top phrases
        System.out.println("**** TOP PHRASES ****");
        System.out.println(topPhrases);


        // Clean up tmp files
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


    private void mergeCounters(List<Path> tmpFiles) throws IOException {
        for (int i = 0; i < tmpFiles.size(); i++) {
            for (int j = i + 1; j < tmpFiles.size(); j++) {
                Path iFile = tmpFiles.get(i);
                Path jFile = tmpFiles.get(j);

                System.out.println("mergeCounters i=" + i + " j=" + j);

                Map<String, Long> imap = loadMapFromTmpFile(iFile);
                Map<String, Long> jmap = loadMapFromTmpFile(jFile);

                System.out.println(imap);
                System.out.println(jmap);

                mergeMaps(imap, jmap);

                Path iUpdatedFile = saveMapToTmpFile(imap);
                Path jUpdatedFile = saveMapToTmpFile(jmap);

                tmpFiles.set(i, iUpdatedFile);
                tmpFiles.set(j, jUpdatedFile);
            }
        }

    }

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
            System.out.println("Delete tmp file: " + tmpFile);
        }
    }


    /**
     * This method will produce fragmentary files witch contain Map<String,Long> where String is phrase and Long is counter of occurences before map was flushed to file.
     * O(n log memoryCounterMapMaxSize ) ~ O(n)
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
                putElementInMap(memoryCounterMap, phrase);
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
        System.out.println("flush to file");
        System.out.println(map);

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
        System.out.println("Read file to map: " + path);
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