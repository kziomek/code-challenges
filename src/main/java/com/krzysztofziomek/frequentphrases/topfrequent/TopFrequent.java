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
 * for (file : files) {
 * <p>
 * }
 */
public class TopFrequent {

    private static final String KEY_VALUE_SEPARATOR = "=";

    public Map<String, Long> findTopFrequents(String file, int mapsize, int topfrequent) throws IOException {

        /* 1. First iteration.
            Go through file and count frequencies in map. When map is full flush it to tmp file and continue counting.
         */
        List<Path> tmpFiles = countFragmentaryFrequencies(file, mapsize);
        System.out.println(tmpFiles);

        /* 2. Merge files occurences */
        mergeCounters(tmpFiles);

        /* In this stage we should have unique phrases spattered in fragmentary files. */

        /* 3. BuildTopCounterMap */
        TopCounterMap topCounterMap = buildTopCounterMap(tmpFiles, topfrequent);
        Long minCounter = topCounterMap.getLowestCounter();
        int surplusValue = topCounterMap.getSurplusValue();

        /* 4  go through files to get phrases of highest occurences */
        Map<String, Long> topPhrases = readTopPhrases(tmpFiles, minCounter, surplusValue);

        //Print top phrases
        System.out.println("**** TOP PHRASES ****");
        System.out.println(topPhrases);


        // Clean up
        deleteTmpFiles(tmpFiles);

        return topPhrases;

    }

    private Map<String, Long> readTopPhrases(List<Path> files, Long minCounter, int surplusValue) throws IOException {
        Map<String, Long> topPhrases = new HashMap<>();

        int[] surplas = {surplusValue};
        for (Path file : files) {
            Files.lines(file).forEach(line -> {
                String[] entry = StringUtils.splitString(line, KEY_VALUE_SEPARATOR);
                Long value = Long.valueOf(entry[1]);
                if (value >= minCounter){
                    if (value.compareTo(minCounter) == 0 && surplas[0] >= 0) {
                        topPhrases.put(entry[0], value);
                        surplas[0]--;
                    } else if (value > minCounter) {
                        topPhrases.put(entry[0], value);
                    }
                }
            });
        }

        return topPhrases;

    }

    public TopCounterMap buildTopCounterMap(List<Path> files, int topFrequent) throws IOException {

        TopCounterMap topCounterMap = new TopCounterMap(topFrequent);

        for (Path file : files) {
            Files.lines(file).forEach(line -> {
                String[] entry = StringUtils.splitString(line, KEY_VALUE_SEPARATOR);
                topCounterMap.add(Long.valueOf(entry[1]));
            });
        }
        return topCounterMap;

    }





    private void mergeCounters(List<Path> tmpFiles) throws IOException {
        for (int i = 0; i < tmpFiles.size(); i++) {
           for (int j = i + 1; j<tmpFiles.size(); j++){
               Path iFile = tmpFiles.get(i);
               Path jFile = tmpFiles.get(j);

               System.out.println("mergeCounters i=" + i + " j="+j);

               Map<String, Long> imap = readMapFromFile(iFile);
               Map<String, Long> jmap = readMapFromFile(jFile);
               Files.deleteIfExists(iFile);
               Files.deleteIfExists(jFile);

               System.out.println(imap);
               System.out.println(jmap);

               mergeMaps(imap, jmap);

               Path iUpdatedFile = saveMapToFile(imap, "");
               Path jUpdatedFile = saveMapToFile(jmap, "");
               tmpFiles.set(i, iUpdatedFile);
               tmpFiles.set(j, jUpdatedFile);
           }
        }

    }

    private void mergeMaps(Map<String, Long> imap, Map<String, Long> jmap) {
        Iterator<Map.Entry<String, Long>> jIterator = jmap.entrySet().iterator();
        while (jIterator.hasNext()) {
            Map.Entry<String, Long> jElement = jIterator.next();
            if (imap.containsKey(jElement.getKey())){
                Long aCounter = imap.get(jElement.getKey());
                aCounter = aCounter + jElement.getValue();
                imap.put(jElement.getKey(), aCounter);
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


    private List<Path> countFragmentaryFrequencies(String file, int mapsize) throws IOException {
        Map<String, Long> map = new HashMap<>(mapsize);
        List<Path> fragmentaryFiles = new ArrayList<>();

        Files.lines(Paths.get(file)).forEach(line -> {
            String[] elements = StringUtils.splitString(line, "|");
            for (String elem : elements) {
                if (map.size() >= mapsize) {
                    fragmentaryFiles.add(saveMapToFile(map, Integer.toString(fragmentaryFiles.size())));
                    map.clear();
                }
                putElementInMap(map, elem);
            }
        });

        fragmentaryFiles.add(saveMapToFile(map, Integer.toString(fragmentaryFiles.size())));
        map.clear();
        return fragmentaryFiles;
    }

    private void putElementInMap(Map<String, Long> map, String element) {
        Long counter = map.get(element);
        if (counter == null) {
            map.put(element, 1L);
        } else {
            map.put(element, counter + 1);
        }

    }



    private Path saveMapToFile(Map<String, Long> map, String suffix) {
        System.out.println("flush to file");
        System.out.println(map);

        try {
            Path tempFile = Files.createTempFile("TopFrequent", "_" + suffix);
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

    private Map<String, Long> readMapFromFile(Path path) throws IOException {
        System.out.println("Read file to map: "+ path);
        Map<String, Long> map = new HashMap<>();
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        bufferedReader.lines().forEach(line -> {
            String[] entry = StringUtils.splitString(line, KEY_VALUE_SEPARATOR);
            map.put(entry[0], Long.valueOf(entry[1]));
        });
        bufferedReader.close();
        return map;
    }

}