package com.dawidkapica.task3;

import com.dawidkapica.util.Duple;
import com.dawidkapica.util.FileParser;
import com.dawidkapica.util.ParseData;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphOperationsTest {

    @Test
    public void calculateNumberOfDistinctGraphTest() {
        List<Duple<Integer, Integer>> inputData = new ArrayList<>();
        inputData.add(new Duple<>(4, 3));
        inputData.add(new Duple<>(1, 4));
        inputData.add(new Duple<>(5, 6));

        GraphOperations graphOperations = new GraphOperations();
        int separatedGraphs = graphOperations.calculateNumberOfDistinctGraph(inputData);

        Assert.assertEquals(2, separatedGraphs);
    }

    @Test
    public void calculateNumberOfDistinctGraphFromFileTest() throws IOException {
        List<String> data = FileParser.parseFile("src/test/resources/task3inputExtend.txt");

        GraphOperations graphOperations = new GraphOperations();
        int separatedGraphs = graphOperations.calculateNumberOfDistinctGraph(ParseData.getPairsListFromStringList(data));

        Assert.assertEquals(3, separatedGraphs);
    }
}
