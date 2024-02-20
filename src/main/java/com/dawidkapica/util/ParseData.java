package com.dawidkapica.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ParseData {

    public static List<Integer> getIntegerListFromString(String data) throws NumberFormatException {
        List<Integer> intList = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(data, " ");
        while (st.hasMoreTokens()) {
            intList.add(Integer.parseInt(st.nextToken()));
        }
        return intList;
    }

    public static List<Duple<Integer, Integer>> getPairsListFromStringList(List<String> data) throws NumberFormatException {
        List<Duple<Integer, Integer>> pairsList = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(data.getFirst()); i++) {
            String[] lineSplited = data.get(i).split(" ");
            if (lineSplited.length != 2)
                throw new TupleFormatException("line number " + i + "contain wrong data \"" + data.get(i) + "\"");
            pairsList.add(new Duple<>(Integer.valueOf(lineSplited[0]), Integer.valueOf(lineSplited[1])));
        }

        return pairsList;
    }
}
