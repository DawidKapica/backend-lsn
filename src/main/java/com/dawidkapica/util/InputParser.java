package com.dawidkapica.util;

import java.util.*;

public class InputParser {

    public static List<String> getInputListWithScanner() {
        List<String> inputList = new ArrayList<>();

        final Scanner in = new Scanner(System.in);
        System.out.println("Provide list data:");
        inputList.add(in.nextLine());
        in.close();

        return inputList;
    }

    public static List<String> getPairsInputWithScanner() {
        List<String> inputList = new ArrayList<>();
        final Scanner in = new Scanner(System.in);

        System.out.println("Provide pair data:");
        String n = in.nextLine();
        inputList.add(n);
        for (int i = 0; i < Integer.parseInt(n); i++) {
            inputList.add(in.nextLine());
        }
        in.close();

        return inputList;
    }
}
