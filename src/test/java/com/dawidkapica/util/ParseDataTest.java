package com.dawidkapica.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParseDataTest {

    @Test
    public void readIntegerListDataTest() throws IOException {
        List<String> input = FileParser.parseFile("src/test/resources/task1input.txt");
        List<Integer> integersInput = ParseData.getIntegerListFromString(input.getFirst());

        Assert.assertEquals(1, input.size());
        Assert.assertEquals("1 10 20 20 2 5", input.getFirst());
        Assert.assertEquals(Arrays.asList(1, 10, 20, 20, 2, 5), integersInput);
    }

    @Test
    public void readTupleListDataTest() throws IOException {
        List<String> input = FileParser.parseFile("src/test/resources/task3input.txt");
        List<Duple<Integer, Integer>> integersInput = ParseData.getPairsListFromStringList(input);

        Assert.assertEquals(4, input.size());
        Assert.assertEquals(Arrays.asList(new Duple<>(4, 3), new Duple<>(1, 4), new Duple<>(5, 6)), integersInput);
    }

    @Test
    public void readIntegerListDataWithCharsTest() throws IOException {
        List<String> input = FileParser.parseFile("src/test/resources/task1inputWrong.txt");
        Assert.assertThrows(NumberFormatException.class, () -> ParseData.getIntegerListFromString(input.getFirst()));
    }

    @Test
    public void readTupleListDataWithCharsTest() throws IOException {
        List<String> input = FileParser.parseFile("src/test/resources/task3inputWrong.txt");
        Assert.assertThrows(NumberFormatException.class, () -> ParseData.getPairsListFromStringList(input));
    }

    @Test
    public void readTupleListDataSingleIntForTupleTest() throws IOException {
        List<String> input = FileParser.parseFile("src/test/resources/task3inputSingleIntTuple.txt");
        Assert.assertThrows(TupleFormatException.class, () -> ParseData.getPairsListFromStringList(input));
    }
}
