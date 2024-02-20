package com.dawidkapica.util;

import java.util.*;

public class InputParser {
    public static List<Integer> getInputListWithScanner() {
        List<Integer> inputList = new ArrayList<>();
        final Scanner in = new Scanner(System.in);
        System.out.println("Provide list data:");
        final StringTokenizer st = new StringTokenizer(in.nextLine(), " ");
        in.close();
        while (st.hasMoreTokens()) {
            inputList.add(Integer.parseInt(st.nextToken()));
        }

        return inputList;
    }

    public static List<Duple<Integer, Integer>> getPairsInputWithScanner() {
        List<Duple<Integer, Integer>> pairs = new ArrayList<>();
        final Scanner in = new Scanner(System.in);
        System.out.println("Provide pair data:");
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            pairs.add(new Duple<>(in.nextInt(), in.nextInt()));
        }
        in.close();

        return pairs;
    }
}

