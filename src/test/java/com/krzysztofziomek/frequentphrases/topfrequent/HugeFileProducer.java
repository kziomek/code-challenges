package com.krzysztofziomek.frequentphrases.topfrequent;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Krzysztof Ziomek
 * @since 18/03/2017.
 */
public class HugeFileProducer {

    public static Path produceRandomFile(int x, int y, int randomRange) throws IOException {

        Path tempFile = Files.createTempFile("HugeFile50x100", "");
        BufferedWriter writer = Files.newBufferedWriter(tempFile);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int phrase = ThreadLocalRandom.current().nextInt(0, randomRange);
                writer.write("W"+phrase + "|");
            }
            writer.newLine();

        }
        writer.close();

        System.out.println("Generated file size: " +Files.size(tempFile));

        return tempFile;
    }

}
