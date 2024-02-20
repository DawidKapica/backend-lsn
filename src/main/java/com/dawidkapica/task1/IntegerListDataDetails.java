package com.dawidkapica.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerListDataDetails {

    List<Integer> sortedAndDistinctList;
    long count;
    long distinct;
    int minVal;
    int maxVal;

    public IntegerListDataDetails(List<Integer> inputList) {
        sortedAndDistinctList = inputList.stream().sorted().distinct().collect(Collectors.toList());
        count = inputList.size();
        distinct = sortedAndDistinctList.size();
        minVal = sortedAndDistinctList.getFirst();
        maxVal = sortedAndDistinctList.getLast();
    }


    public List<Integer> getSortedAndDistinctList() {
        return sortedAndDistinctList;
    }

    public long getCount() {
        return count;
    }

    public long getDistinct() {
        return distinct;
    }

    public int getMinVal() {
        return minVal;
    }

    public int getMaxVal() {
        return maxVal;
    }

    @Override
    public String toString() {
        return Arrays.toString(sortedAndDistinctList.toArray()) + '\n' +
                "count: " + count + '\n' +
                "distinct: " + distinct + '\n' +
                "minVal: " + minVal + '\n' +
                "maxVal: " + maxVal;
    }
}
