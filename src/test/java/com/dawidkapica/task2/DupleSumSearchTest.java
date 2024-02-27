package com.dawidkapica.task2;

import com.dawidkapica.util.Duple;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DupleSumSearchTest {

    @Test
    public void DupleSumSearchDataTest() {
        List<Integer> testData = Arrays.asList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0);

        verifyIfDataWasCreatedCorrectly(testData, 4);
    }

    @Test
    public void DupleSumSearchAscDescDataTest() {
        List<Integer> testDataAsc = Arrays.asList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0);
        List<Integer> testDataDesc = Arrays.asList(0, 13, 6, 7, 3, 5, 7, 10, 2, 1);

        int expectedTuple = 4;
        verifyIfDataWasCreatedCorrectly(testDataAsc, expectedTuple);
        verifyIfDataWasCreatedCorrectly(testDataDesc, expectedTuple);

    }

    @Test
    public void DupleSumSearchNoSumTest() {
        List<Integer> testData = Arrays.asList(1, 2, 3, 4, 3, 2, 1, 0);

        verifyIfDataWasCreatedCorrectly(testData, 0);
    }

    @Test
    public void Single13WithoutPairTest() {
        List<Integer> testData = Arrays.asList(13);

        verifyIfDataWasCreatedCorrectly(testData, 0);
    }

    @Test
    public void TwoSameNumberTest() {
        List<Integer> testData = Arrays.asList(6, 6, 7, 7);

        verifyIfDataWasCreatedCorrectly(testData, 4);
    }

    @Test
    public void EmptyListTest() {
        verifyIfDataWasCreatedCorrectly(new ArrayList<>(), 0);
    }

    private void verifyIfDataWasCreatedCorrectly(List<Integer> testData, int expectedTuple) {
        DupleSumSearch dupleSumSearch = new DupleSumSearch();
        List<Duple<Integer, Integer>> outputList = dupleSumSearch.matchAndSortPairs(testData);

        Assert.assertEquals("number of component in list", expectedTuple, outputList.size());
        Assert.assertEquals("tuple sum to expected value", expectedTuple, outputList.stream().filter(x -> x.getX1() + x.getX2() == 13).count());
        Assert.assertEquals("first value in tuple should be smaller than second", expectedTuple, outputList.stream().filter(x -> x.getX1() < x.getX2()).count());
        Assert.assertEquals(outputList, outputList.stream().sorted(Comparator.comparing(Duple::getX1)).collect(Collectors.toList()));
    }
}
