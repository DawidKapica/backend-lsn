package com.dawidkapica.task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InformationNumberTest {

    @Test
    public void checkCalculatedDataTest() {
        List<Integer> testData = Arrays.asList(1, 10, 20, 20, 2, 5);

        IntegerListDataDetails informationNumber = new IntegerListDataDetails(testData);

        Assert.assertEquals(Arrays.asList(1, 2, 5, 10, 20), informationNumber.getSortedAndDistinctList());
        Assert.assertEquals(6, informationNumber.getCount());
        Assert.assertEquals(5, informationNumber.getDistinct());
        Assert.assertEquals(1, informationNumber.getMinVal());
        Assert.assertEquals(20, informationNumber.getMaxVal());
    }

    @Test
    public void checkCalculatedDataSingleElementTest() {
        List<Integer> testData = Arrays.asList(1, 1, 1, 1);
        IntegerListDataDetails informationNumber = new IntegerListDataDetails(testData);
        Assert.assertEquals(Arrays.asList(1), informationNumber.getSortedAndDistinctList());
        Assert.assertEquals(4, informationNumber.getCount());
        Assert.assertEquals(1, informationNumber.getDistinct());
        Assert.assertEquals(1, informationNumber.getMinVal());
        Assert.assertEquals(1, informationNumber.getMaxVal());

    }
}
