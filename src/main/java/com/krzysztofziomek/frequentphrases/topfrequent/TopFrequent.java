package com.krzysztofziomek.frequentphrases.topfrequent;

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
public class TopFrequent {
}
