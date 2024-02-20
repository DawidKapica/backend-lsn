package com.dawidkapica;

import com.dawidkapica.task1.InformationNumber;
import com.dawidkapica.task2.DupleSumSearch;
import com.dawidkapica.task3.GraphCalculator;
import com.dawidkapica.util.Duple;
import com.dawidkapica.util.FileParser;
import com.dawidkapica.util.InputParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0 || args.length > 2)
            help();

        try {
            switch (args[0]) {
                case "task1":
                    List<Integer> inputDataTask1 = args.length == 2 ? FileParser.parseFileIntegerList(args[1]) : InputParser.getInputListWithScanner();
                    InformationNumber informationNumber = new InformationNumber();
                    InformationNumber.InformationAboutNumber informationAboutNumber = informationNumber.calculateInformation(inputDataTask1);
                    System.out.println(informationAboutNumber.toString());
                    break;

                case "task2":
                    List<Integer> inputDataTask2 = args.length == 2 ? FileParser.parseFileIntegerList(args[1]) : InputParser.getInputListWithScanner();
                    DupleSumSearch dupleSumSearch = new DupleSumSearch();
                    List<Duple<Integer, Integer>> searched = dupleSumSearch.matchAndSortPairs(inputDataTask2);
                    for (Duple<Integer, Integer> duple : searched) {
                        System.out.println(duple.getX1() + " " + duple.getX2());
                    }
                    break;
                case "task3":
                    List<Duple<Integer, Integer>> parsedConnections = args.length == 2 ? FileParser.fileParse(args[1]) : InputParser.getPairsInputWithScanner();
                    GraphCalculator graphCalculator = new GraphCalculator();
                    int uniqueGraphs = graphCalculator.calculateNumberOfDistinctGraph(parsedConnections);
                    System.out.println(uniqueGraphs);
                    break;
                default:
                    help();
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void help() {
        System.out.println("run with first argument as a name of the task to get data from keyboard: task1 | task2 | task3 ");
        System.out.println("run with first argument as a name of the task and second argument as a path to file get data from it : task1 | task2 | task3 <path_to_file>");
    }
}
