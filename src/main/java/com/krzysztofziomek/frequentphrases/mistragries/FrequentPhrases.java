package com.krzysztofziomek.frequentphrases.mistragries;

import com.krzysztofziomek.utils.FileUtils;
import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Krzysztof Ziomek
 * @since 15/03/2017.
 * <p>
 * https://en.wikipedia.org/wiki/External_sorting
 * <p>
 * Assumptions
 * 1. File might be really huge i.e. 1TB
 * 1. Every phrase in file may be different -> In this case I can't go for sollution to keep HashMap of phrases with number of occurences because it would be size similar to file size (to big for memory)
 * <p>
 * O(nlogm)
 * n - number of elements in file
 * m - size of hashmap - 100000
 * <p>
 * Algorihm has its limitations. It is erroneous according to equation ...
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
public class FrequentPhrases {



    public MistraGriesMap processFile(String file, int k) throws IOException {

        MistraGriesMap map = new MistraGriesMap(k-1);

        //build mistra map
        Stream<String> stream = Files.lines(Paths.get(file));
        stream.forEach(line -> {
            String[] elements = StringUtils.splitString(line, "|");
            for (String elem : elements) {
                map.put(elem);
                System.out.println(map.toString());
            }
        });

        // pass again throug stream to count Fj for every element in map
        // remove infrequent elements


        return map;
    }


    public static void main(String[] args) throws IOException {
        FileUtils.printCurrentPath();

        MistraGriesMap map = new MistraGriesMap(2);

        String fileName = "FrequentPhrases/src/file.txt";

        Stream<String> stream = Files.lines(Paths.get(fileName));
        stream.forEach(line -> {
            String[] elements = StringUtils.splitString(line, "|");
            for (String elem : elements) {
                map.put(elem);
            }
        });

        /*
        http://www.cs.dartmouth.edu/~ac/Teach/CS49-Fall11/Notes/lecnotes.pdf
        Using this algorithm, we can now easily solve the FREQUENT problem in one additional pass. By the above
        theorem, if some token j has fj > m=k, then its corresponding counter AŒj will be positive at the end of the MisraGries
        pass over the stream, i.e., j will be in keys.A/. Thus, we can make a second pass over the input stream, counting
        exactly the frequencies fj for all j 2 keys.A/, and then output the desired set of items.
        */

    }


}
