package com.dawidkapica.task2;

import com.dawidkapica.util.Duple;

import java.util.*;
import java.util.stream.Collectors;

public class DupleSumSearch {
    private static final int SUM_OF_DUPLE = 13;

    public List<Duple<Integer, Integer>> matchAndSortPairs(List<Integer> inputList) {
        Map<Integer, Integer> frequencyOfVal = getFrequencyMap(inputList);
        List<Duple<Integer, Integer>> searchedPairs = new ArrayList<>();
        Set<Integer> visitedVal = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : frequencyOfVal.entrySet()) {
            Integer searchedValToSum = SUM_OF_DUPLE - entry.getKey();
            if (frequencyOfVal.containsKey(searchedValToSum) && !visitedVal.contains(entry.getKey())) {
                visitedVal.add(searchedValToSum);
                int numberOfPairs = Integer.max(entry.getValue(), frequencyOfVal.get(searchedValToSum));
                List<Duple<Integer, Integer>> listOfCopies = (Collections.nCopies(numberOfPairs,
                        new Duple<>(
                                Integer.min(entry.getKey(), searchedValToSum),
                                Integer.max(entry.getKey(), searchedValToSum))));
                searchedPairs.addAll(listOfCopies);
            }
        }
        return searchedPairs.stream().sorted(Comparator.comparing(Duple::getX1)).collect(Collectors.toList());
    }

    private Map<Integer, Integer> getFrequencyMap(List<Integer> inputList) {
        Map<Integer, Integer> frequencyOfVal = new HashMap<>();
        inputList.forEach(val -> {
            frequencyOfVal.merge(val, 1, Integer::sum);
        });
        return frequencyOfVal;
    }
}
