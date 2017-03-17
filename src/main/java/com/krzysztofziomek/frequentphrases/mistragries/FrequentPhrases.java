package com.krzysztofziomek.frequentphrases.mistragries;

import com.krzysztofziomek.utils.FileUtils;
import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Krzysztof Ziomek
 * @since 16/03/2017.
 *
 * http://www.cs.dartmouth.edu/~ac/Teach/CS49-Fall11/Notes/lecnotes.pdf
 *
 * Fj - m/k <= Fij <= Fj
 * Fj - number of element j in file
 * Fij - counter after processing
 * m - number of elements in file
 * (k-1) number of frequent elements to be found
 *
 * Element is frequent when Fj > m/k
 * Algorithm guarantee that those elements will stay in map after first iteration.
 * But, map might contain elements with low frequency.
 * We can eliminate those low frequency elements by passing through file second time to count occurences of elements in map
 * and then filter those with counter <= m/k.
 *
 *
 * This is what MistraGries algorithm guarantee. You will get frequent elements, and you will have all of them!
 *
 * References:
 * http://cs.stackexchange.com/questions/7291/finding-the-element-that-occurs-the-most-in-a-very-large-file
 * http://www.cs.dartmouth.edu/~ac/Teach/CS49-Fall11/Notes/lecnotes.pdf
 * http://www.cs.rug.nl/~wim/pub/whh348.pdf
 *
 * <p>
 * http://stackoverflow.com/questions/19621993/efficient-algorithm-to-find-most-common-phrases-in-a-large-volume-of-text
 *
 *
 */
public class FrequentPhrases {

    // TODO Refactoring

    public MistraGriesMap processFile(String file, long k) throws IOException {

        MistraGriesMap map = new MistraGriesMap(k - 1);

        //build mistra map
        Stream<String> stream = Files.lines(Paths.get(file));
        stream.forEach(line -> {
            String[] elements = StringUtils.splitString(line, "|");
            for (String elem : elements) {
                map.put(elem);
                System.out.println(map.toString());
            }
        });

        // set all values to 0
        map.resetValues(0L);

        // pass again throug stream to count Fj for every element in map
        final long[] m = {0};
        Stream<String> stream2 = Files.lines(Paths.get(file));
        stream2.forEach(line -> {
            String[] elements = StringUtils.splitString(line, "|");
            for (String elem : elements) {
                m[0]++;
                if (map.containsKey(elem)) {
                    map.put(elem);
                }
            }
        });
        // remove infrequent elements
        map.removeInfrequentElements(m[0], k);


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

    }


}
