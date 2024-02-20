package com.dawidkapica;

import com.dawidkapica.task1.IntegerListDataDetails;
import com.dawidkapica.task2.DupleSumSearch;
import com.dawidkapica.task3.GraphOperations;
import com.dawidkapica.util.Duple;
import com.dawidkapica.util.FileParser;
import com.dawidkapica.util.InputParser;
import com.dawidkapica.util.ParseData;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        executeTask(args.length == 0 ? null : args[0], args.length == 2 ? args[1] : null);
    }

    private static void executeTask(String taskNumber, String pathToFile) {
        List<String> data;
        switch (taskNumber) {
            case "task1" -> {
                data = pathToFile == null ? InputParser.getInputListWithScanner() : FileParser.parseFile(pathToFile);
                IntegerListDataDetails informationNumber = new IntegerListDataDetails(ParseData.getIntegerListFromString(data.getFirst()));
                System.out.println(informationNumber);
            }
            case "task2" -> {
                data = pathToFile == null ? InputParser.getInputListWithScanner() : FileParser.parseFile(pathToFile);
                DupleSumSearch dupleSumSearch = new DupleSumSearch();
                List<Duple<Integer, Integer>> searched = dupleSumSearch.matchAndSortPairs(ParseData.getIntegerListFromString(data.getFirst()));
                for (Duple<Integer, Integer> duple : searched) {
                    System.out.println(duple.getX1() + " " + duple.getX2());
                }
            }
            case "task3" -> {
                data = pathToFile == null ? InputParser.getPairsInputWithScanner() : FileParser.parseFile(pathToFile);
                GraphOperations graphCalculator = new GraphOperations();
                int uniqueGraphs = graphCalculator.calculateNumberOfDistinctGraph(ParseData.getPairsListFromStringList(data));
                System.out.println(uniqueGraphs);
            }
            default -> help();
        }
    }

    private static void help() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usage: java -jar backend-lsn-1.0.0.jar <task_name> [data_file_path]").append("\n")
                .append("\n")
                .append("task_name options :").append("\n")
                .append("\ttask1").append("\n")
                .append("\ttask2").append("\n")
                .append("\ttask3").append("\n");

        System.out.println(sb);
    }
}
