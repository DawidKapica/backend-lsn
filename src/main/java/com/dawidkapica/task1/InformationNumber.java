package com.dawidkapica.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InformationNumber {

    public class InformationAboutNumber {
        List<Integer> sortedList;
        long count;
        long distinct;
        int minVal;
        int maxVal;

        public InformationAboutNumber(List<Integer> sortedList, long count, long distinct, int minVal, int maxVal) {
            this.sortedList = sortedList;
            this.count = count;
            this.distinct = distinct;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }

        public List<Integer> getSortedList() {
            return sortedList;
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
            return Arrays.toString(sortedList.toArray()) + '\n' +
                    "count: " + count + '\n' +
                    "distinct: " + distinct + '\n' +
                    "minVal: " + minVal + '\n' +
                    "maxVal: " + maxVal;
        }
    }

    public InformationAboutNumber calculateInformation(List<Integer> inputList) {
        List<Integer> sortAndDistinctList = inputList.stream().sorted().distinct().collect(Collectors.toList());
        InformationAboutNumber informationAboutNumber = new InformationAboutNumber(
                sortAndDistinctList,
                inputList.size(),
                sortAndDistinctList.size(),
                sortAndDistinctList.getFirst(),
                sortAndDistinctList.getLast());
        return informationAboutNumber;
    }
}
