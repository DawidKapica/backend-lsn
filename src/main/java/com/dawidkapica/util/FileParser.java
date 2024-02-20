package com.dawidkapica.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileParser {

    public static List<String> parseFile(String path) {
        try {
            return Arrays.stream(new String(Files.readAllBytes(Paths.get(path))).split("\n")).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("problem during reading file from path " + path);
            throw new RuntimeException(e);
        }
    }
}
