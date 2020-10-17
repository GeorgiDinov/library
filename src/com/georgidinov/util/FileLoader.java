package com.georgidinov.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FileLoader {

    private static final List<String[]> rawData = new ArrayList<>();

    private FileLoader() {
    }

    public static FileLoader getInstance() {
        return FileLoaderHelper.instance;
    }

    public List<String[]> getRawData(Path pathToFile) {
        rawData.clear();
        loadData(pathToFile);
        return rawData;
    }

    private static class FileLoaderHelper {
        private static FileLoader instance = new FileLoader();
    }

    private void loadData(Path pathToFile) {
        try (Scanner scanner = new Scanner(Files.newBufferedReader(pathToFile))) {
            String input = scanner.nextLine();
            String[] inputData = input.split(",");
            rawData.add(inputData);
        } catch (IOException e) {
            System.out.println("Exception while reading " + pathToFile.getFileName() + ": " + e.getMessage());
        }
    }

}
