package com.krzysztofziomek.frequentphrases.mistragries;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

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
 *
 * Only Fij > 0 for element guarantee that element will be in MistraGries map after processing
 * Otherwise, presence of element in map depends on sequence of elements.
 *
 * Morover, map might contain elements with low frequency.
 * We can eliminate those low frequency elements by passing through file second time to count occurences of elements in map
 * and then filter those whose counter is < m/k
 *
 * This is what MistraGries algorithm guarantee. You will get frequent elements,
 * but doesn't guarantee that you will have complementary set of them.
 *
 *
 *
 * Using this algorithm, we can now easily solve the FREQUENT problem in one additional pass. By the above
 * theorem, if some token j has fj > m=k, then its corresponding counter AŒj will be positive at the end of the MisraGries
 * pass over the stream, i.e., j will be in keys.A/. Thus, we can make a second pass over the input stream, counting
 * exactly the frequencies fj for all j 2 keys.A/, and then output the desired set of items.
 *
 */
public class FrequestPhrasesTest {


    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * m = 12
     * k = 1
     *
     * -7 <= Fij <= 5
     */
    @Test
    public void testB_disposess_A__C_wins() throws IOException {
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/B_disposess_A__C_wins.txt";

        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, 1);

        // assert
        Assert.assertEquals(1, mistraGriesMap.size());
        Assert.assertEquals(Long.valueOf(1), mistraGriesMap.get("C"));
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 6 (for element A)
     * m = 12
     * k = 2
     *
     * -1 <= Fij <= 5
     */
    @Test
    public void testA_B_wins() throws IOException {
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/B_disposess_A__C_wins.txt";

        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, 2);

        // assert
        System.out.println(mistraGriesMap.toString());
        Assert.assertEquals(2, mistraGriesMap.size());
        Assert.assertEquals(Long.valueOf(5), mistraGriesMap.get("A"));
        Assert.assertEquals(Long.valueOf(4), mistraGriesMap.get("B"));
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 10 (for element A)
     * m = 20
     * k = 2
     *
     *
     * 0 <= Fij <= 10
     */
    @Test
    public void test10A_disposedBy10Others() throws IOException {
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/10A_10Others.txt";

        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, 1);

        // assert
        System.out.println(mistraGriesMap.toString());
        Assert.assertEquals(1, mistraGriesMap.size());
        Assert.assertEquals(Long.valueOf(1), mistraGriesMap.get("0"));
    }

    /**
     *
     *
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 10 (for element A)
     * m = 18
     * k = 3
     * m/k = 6
     *
     *
     * 0 <= Fij <= 6
     */
    @Test
    public void noneElementInFileIsFrequent() throws IOException {
        int k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/6A_6B_6Different.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(0, mistraGriesMap.size());
    }

    /**
     *
     *
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 10 (for element A)
     * m = 18
     * k = 3
     * m/k = 6
     *
     *
     * 0 <= Fij <= 6
     */
    @Test
    public void element_A_IsFrequent() throws IOException {
        int k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/7A_6B_6Different.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(0, mistraGriesMap.size());
    }

    /**
     *
     *
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 10 (for element A)
     * m = 18
     * k = 3
     * m/k = 6
     *
     *
     * 0 <= Fij <= 6
     */
    @Test
    public void noneElementInFileIsFrequent2() throws IOException {
        int k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/6A_4B_4C_4D.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(0, mistraGriesMap.size());
    }
}
