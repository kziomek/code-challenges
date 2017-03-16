package com.krzysztofziomek.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Krzysztof Ziomek
 * @since 15/03/2017.
 */
public class FileUtils {

    public static void printCurrentPath() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
    }
}
