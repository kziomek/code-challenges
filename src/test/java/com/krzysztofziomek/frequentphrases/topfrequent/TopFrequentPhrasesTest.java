package com.krzysztofziomek.frequentphrases.topfrequent;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 18/03/2017.
 */
public class TopFrequentPhrasesTest {

    @Test
    public void shouldPickA2D2C1WhenHugeFileFitsInDefinedMapSize() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentA2D2C1.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopFrequentPhrases topFrequentPhrases = new TopFrequentPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopFrequents(file, mapSize, topFrequent);

        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("A"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("A"));
        Assert.assertTrue(topPhrases.containsKey("D"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("D"));
        Assert.assertTrue(topPhrases.containsKey("C"));
        Assert.assertEquals(Long.valueOf(1), topPhrases.get("C"));
    }

    @Test
    public void shouldPickA2D2C1WhenHugeFileScatteredToThreeTemporaryFiles() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentA2D2C1.txt";
        int mapSize = 2;
        int topFrequent = 3;

        TopFrequentPhrases topFrequentPhrases = new TopFrequentPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopFrequents(file, mapSize, topFrequent);

        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("A"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("A"));
        Assert.assertTrue(topPhrases.containsKey("D"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("D"));
        Assert.assertTrue(topPhrases.containsKey("C"));
        Assert.assertEquals(Long.valueOf(1), topPhrases.get("C"));
    }


    @Test
    public void shouldFindA9B4C3() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentA9B4C3.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopFrequentPhrases topFrequentPhrases = new TopFrequentPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopFrequents(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("A"));
        Assert.assertEquals(Long.valueOf(9), topPhrases.get("A"));
        Assert.assertTrue(topPhrases.containsKey("B"));
        Assert.assertEquals(Long.valueOf(4), topPhrases.get("B"));
        Assert.assertTrue(topPhrases.containsKey("C"));
        Assert.assertEquals(Long.valueOf(3), topPhrases.get("C"));

    }

    @Test
    public void shouldFindA40H10I10When_H_And_I_CounterIsTheSame() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentA40H10I10.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopFrequentPhrases topFrequentPhrases = new TopFrequentPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopFrequents(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("A"));
        Assert.assertEquals(Long.valueOf(40), topPhrases.get("A"));
        Assert.assertTrue(topPhrases.containsKey("H"));
        Assert.assertEquals(Long.valueOf(10), topPhrases.get("H"));
        Assert.assertTrue(topPhrases.containsKey("I"));
        Assert.assertEquals(Long.valueOf(10), topPhrases.get("I"));

    }

    @Test
    public void shouldFindThreeDifferentTopPhrasesWhenAllCountersEqual() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentA6B6C6D6E6.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopFrequentPhrases topFrequentPhrases = new TopFrequentPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopFrequents(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
    }

    @Test
    public void shouldFind7DifferentTopPhrasesWhenAllCountersEqual1() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentQWERTY.txt";
        int mapSize = 5;
        int topFrequent = 7;

        TopFrequentPhrases topFrequentPhrases = new TopFrequentPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopFrequents(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(7, topPhrases.size());
    }

}
