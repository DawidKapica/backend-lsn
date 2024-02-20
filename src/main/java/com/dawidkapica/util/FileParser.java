package com.dawidkapica.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileParser {

    public static List<Integer> parseFileIntegerList(String path) throws IOException, NumberFormatException {
        return Arrays.stream(new String(Files.readAllBytes(Paths.get(path))).split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static List<Duple<Integer, Integer>> fileParse(String path) {
        List<Duple<Integer, Integer>> parsedValues = new ArrayList<>();

        File fileToRead = new File(path);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileToRead));

            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                int x1 = Integer.valueOf(line.split(" ")[0]);
                int x2 = Integer.valueOf(line.split(" ")[1]);

                parsedValues.add(new Duple<>(x1, x2));

                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return parsedValues;
    }

    public static void generateData(String path) {
        List<Duple<Integer, Integer>> generatedData = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int randomInt = r.nextInt(100) + 1;
            int randomInt2 = r.nextInt(100) + 1;
            generatedData.add(new Duple<>(randomInt, randomInt2));
        }

        File fileToBeModified = new File(path);
        FileWriter writer = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            writer = new FileWriter(fileToBeModified);
            for (Duple<Integer, Integer> duple: generatedData) {
                stringBuilder.append(duple.getX1() + ' ' + duple.getX2() + '\n');
                writer.write(duple.getX1() + " " + duple.getX2() + "\n");

            }
//            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}