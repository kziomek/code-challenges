package com.krzysztofziomek.frequentphrases.topfrequent;


import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 18/03/2017.
 */
public class InMemoryAlgorithm {

    public Map<String, Long> findTopPhrases(Path hugeFile) throws IOException {
        Map<String, Long> phraseCounter = new HashMap<>();

        Files.lines(hugeFile).forEach(line -> {
            String[] phrases = StringUtils.split(line, "|");
            for (String phrase : phrases) {
                if (phraseCounter.containsKey(phrase)) {
                    phraseCounter.put(phrase, phraseCounter.get(phrase) + 1);
                } else {
                    phraseCounter.put(phrase, 1L);
                }
            }
        });
        return phraseCounter;
    }
}
