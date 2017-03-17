package com.krzysztofziomek.frequentphrases.mistragries;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FrequestPhrasesTest {


    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * m = 12
     * k = 1
     * <p>
     * -7 <= Fij <= 5
     * <p>
     * In this test C is last element which stays in map after first iteration
     * C is removed in second iteration because it is infrequent
     */

    @Test
    public void infrequestElementCWillNotStayAfterSecondIteration() throws IOException {
        long k = 2;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/B_disposess_A__C_wins.txt";

        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(0, mistraGriesMap.size());
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 6 (for element A)
     * m = 12
     * k = 2
     * <p>
     * -1 <= Fij <= 5
     */
    @Test
    public void frequentElementsAandBstayInMapFork3() throws IOException {
        long k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/B_disposess_A__C_wins.txt";

        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        System.out.println(mistraGriesMap.toString());
        Assert.assertEquals(2, mistraGriesMap.size());
        Assert.assertTrue(mistraGriesMap.containsKey("A"));
        Assert.assertTrue(mistraGriesMap.containsKey("B"));
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 10 (for element A)
     * m = 20
     * k = 2
     * <p>
     * <p>
     * 0 <= Fij <= 10
     */
    @Test
    public void infrequent10A_disposedBy10Others() throws IOException {
        long k = 2;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/10A_10Others.txt";

        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        System.out.println(mistraGriesMap.toString());
        Assert.assertEquals(0, mistraGriesMap.size());
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 6 (for element A)
     * m = 18
     * k = 3
     * m/k = 6
     * <p>
     * <p>
     * 0 <= Fij <= 6
     */
    @Test//OK
    public void noneElementInFileIsFrequent() throws IOException {
        long k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/6A_6B_6Different.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(0, mistraGriesMap.size());
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 6 (for element A)
     * m = 18
     * k = 3
     * m/k = 6
     * <p>
     * <p>
     * 0 <= Fij <= 6
     * <p>
     * Element A put at the end of file will be present in map after first iteration but will not stay there because is nof frequent (Fj <= m/k)
     */
    @Test//OK
    public void infrequentElementAShouldntStayInMapEvenIfPutAtTheEndOfFile() throws IOException {
        long k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/6B_6Different_6A.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(0, mistraGriesMap.size());
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 7 (for element A)
     * m = 19
     * k = 3
     * m/k = 6,(3)
     * <p>
     * <p>
     * 0,(6) <= Fij <= 7
     */
    @Test//OK
    public void frequentElementAShouldStayInMap() throws IOException {
        long k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/7A_6B_6Different.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(1, mistraGriesMap.size());
        Assert.assertTrue(mistraGriesMap.containsKey("A"));
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 7 (for element A, and B)
     * m = 20
     * k = 3
     * m/k = 6,(6)
     * <p>
     * <p>
     * 0,(3) <= Fij <= 7
     */
    @Test//OK
    public void frequentElementsABShouldStayInMap() throws IOException {
        long k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/7A_7B_6Different.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(2, mistraGriesMap.size());
        Assert.assertTrue(mistraGriesMap.containsKey("A"));
        Assert.assertTrue(mistraGriesMap.containsKey("B"));
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 6 (for element A)
     * m = 18
     * k = 3
     * m/k = 6
     * <p>
     * <p>
     * 0 <= Fij <= 6
     */
    @Test
    public void noneElementInFileIsFrequent3() throws IOException {
        long k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/6A_4B_4C_4D.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        System.out.println("result");
        System.out.println(mistraGriesMap.toString());
        Assert.assertEquals(0, mistraGriesMap.size());
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 10 (for element A)
     * m = 18
     * k = 3
     * m/k = 6
     * <p>
     * <p>
     * 0 <= Fij <= 6
     */
    @Test
    public void frequestElement_A_ShouldStayInMap() throws IOException {
        int k = 3;
        FrequentPhrases frequentPhrases = new FrequentPhrases();
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/mistragries/7A_6B_6Different.txt";
        // execute
        MistraGriesMap mistraGriesMap = frequentPhrases.processFile(file, k);

        // assert
        Assert.assertEquals(1, mistraGriesMap.size());
        Assert.assertTrue(mistraGriesMap.containsKey("A"));
    }

    /**
     * Fj - m/k <= Fij <= Fj
     * Fij - counter after processing
     * Fj = 10 (for element A)
     * m = 18
     * k = 3
     * m/k = 6
     * <p>
     * <p>
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
