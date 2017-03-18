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
    public void whenMapIsNotFlushedToTmpFiles() {

    }


    @Test
    public void shouldFindA9B4C3() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequent.txt";
        int mapsize = 5;
        int topfrequent = 3;

        TopFrequentPhrases topFrequentPhrases = new TopFrequentPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopFrequents(file, mapsize, topfrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("A"));
        Assert.assertEquals(Long.valueOf(9), topPhrases.get("A"));
        Assert.assertTrue(topPhrases.containsKey("B"));
        Assert.assertEquals(Long.valueOf(4), topPhrases.get("B"));
        Assert.assertTrue(topPhrases.containsKey("C"));
        Assert.assertEquals(Long.valueOf(3), topPhrases.get("C"));

    }



}
