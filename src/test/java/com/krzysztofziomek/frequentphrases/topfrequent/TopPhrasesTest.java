package com.krzysztofziomek.frequentphrases.topfrequent;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 18/03/2017.
 */
public class TopPhrasesTest {

    @Test
    public void shouldReturnEmptyMapWhenProvidedFileIsEmpty() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/empty.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

        Assert.assertEquals(0, topPhrases.size());

    }

    @Test
    public void shouldPickA2D2C1WhenHugeFileFitsInDefinedMapSize() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentA2D2C1.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

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

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

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

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

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

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

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

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
    }

    @Test
    public void shouldFind7DifferentTopPhrasesWhenAllCountersEqual1() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentQWERTY.txt";
        int mapSize = 5;
        int topFrequent = 7;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(7, topPhrases.size());
    }

    @Test
    public void shouldFindA6C6E6WhenTheyAreScatteredThroughout5TmpFilesDuringProcessing() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentPhrasesScattered.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("A"));
        Assert.assertEquals(Long.valueOf(6), topPhrases.get("A"));
        Assert.assertTrue(topPhrases.containsKey("C"));
        Assert.assertEquals(Long.valueOf(6), topPhrases.get("C"));
        Assert.assertTrue(topPhrases.containsKey("E"));
        Assert.assertEquals(Long.valueOf(6), topPhrases.get("E"));

    }

    @Test
    public void shouldFindTopPhrasesWhenTrimmedMultiWordPhrases() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentTrimmedMultiWordPhrases.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("Foobar Candy"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("Foobar Candy"));
        Assert.assertTrue(topPhrases.containsKey("CNET"));
        Assert.assertEquals(Long.valueOf(3), topPhrases.get("CNET"));
        Assert.assertTrue(topPhrases.containsKey("PGA"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("PGA"));

    }

    @Test
    public void shouldFindTopPhrasesWhenPhrasesAreLongerThanSingleWordAndUntrimmed() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequentUntrimmedMultiWordPhrases.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("Foobar Candy"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("Foobar Candy"));
        Assert.assertTrue(topPhrases.containsKey("CNET"));
        Assert.assertEquals(Long.valueOf(3), topPhrases.get("CNET"));
        Assert.assertTrue(topPhrases.containsKey("PGA"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("PGA"));

    }

    @Test
    public void shouldFindTopPhrasesInFileWithEmptyElementsBetweenPipes() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequencesEmptyElementsBetweenPipes.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(3, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("C"));
        Assert.assertEquals(Long.valueOf(3), topPhrases.get("C"));
        Assert.assertTrue(topPhrases.containsKey("E"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("E"));
        Assert.assertTrue(topPhrases.containsKey("A"));
        Assert.assertEquals(Long.valueOf(2), topPhrases.get("A"));

    }

    @Test
    public void shouldFind2TopPhrasesWhenAsked3TopPhrasesButFileContains2DiffrentPhrases() throws IOException {
        String file = "src/test/resources/com/krzysztofziomek/frequentphrases/topfrequent/topfrequencesA10B11.txt";
        int mapSize = 5;
        int topFrequent = 3;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(file, mapSize, topFrequent);

        // assert
        Assert.assertEquals(2, topPhrases.size());
        Assert.assertTrue(topPhrases.containsKey("A"));
        Assert.assertEquals(Long.valueOf(10), topPhrases.get("A"));
        Assert.assertTrue(topPhrases.containsKey("B"));
        Assert.assertEquals(Long.valueOf(11), topPhrases.get("B"));
    }

    @Test
    public void compareResultsToInMemoryAlgorithm() throws IOException {
        // Ranodomly Create files 50 x 100 and compare results

        // file with 500 phrases
        doTestRandomFile(50, 10, 10); //high frequency
        doTestRandomFile(50, 10, 100); //medium frequency
        doTestRandomFile(50, 10, 1000); //low frequency

        // file with 5000 phrases
        doTestRandomFile(50, 100, 10); //high frequency
        doTestRandomFile(50, 100, 100); //medium frequency
        doTestRandomFile(50, 100, 1000); //low frequency

        // file with 50000 phrases
        // uncommented because they are long running tests
//        doTestRandomFile(50, 1000, 10); //high frequency
//        doTestRandomFile(50, 1000, 100); //medium frequency
//        doTestRandomFile(50, 1000, 1000); //low frequency
    }

    @Test
    @Ignore("Long running test.")
    public void shouldGenerateProcessAndFindTopPhrasesIn10GBFile() throws IOException {
        long startTime = System.currentTimeMillis();

        Path hugeFile = HugeFileProducer.produceRandomFile(50, 1000 * 5 * 1000 * 10, 10000);
        int mapSize = 100000;
        int topFrequent = 100000;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(hugeFile.toString(), mapSize, topFrequent);

        // assert
        System.out.println("TopPhrases size: " + topPhrases.size());

        // clean up
        Files.delete(hugeFile);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("execution time in milis: " + elapsedTime);
    }


    public void doTestRandomFile(int x, int y, int randomRange) throws IOException {
        Path hugeFile = HugeFileProducer.produceRandomFile(x, y, randomRange);
        int mapSize = 100;
        int topFrequent = 3;

        TopPhrases topFrequentPhrases = new TopPhrases();
        Map<String, Long> topPhrases = topFrequentPhrases.findTopPhrases(hugeFile.toString(), mapSize, topFrequent);


        InMemoryAlgorithm inMemoryAlgorithm = new InMemoryAlgorithm();
        Map<String, Long> topPhrasesByInMemoryAlgorithm = inMemoryAlgorithm.findTopPhrases(hugeFile);

        System.out.println("IN MEMORY ALGORITHM RESULT");
        System.out.println(topPhrasesByInMemoryAlgorithm);

        // assert
        Assert.assertEquals(topFrequent, topPhrases.size());
        for (Map.Entry<String, Long> entry : topPhrases.entrySet()) {
            Assert.assertEquals(topPhrasesByInMemoryAlgorithm.get(entry.getKey()), entry.getValue());
        }

        // clean up
        Files.delete(hugeFile);
    }


}
