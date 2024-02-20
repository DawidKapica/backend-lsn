package com.dawidkapica.task3;

import com.dawidkapica.util.Duple;

import java.util.*;

public class GraphCalculator {

    //both sets should be manage at once
    Set<Integer> allVertexesVal = new HashSet<>();
    List<Vertex> allVertexes = new ArrayList<>();

    public int calculateNumberOfDistinctGraph(List<Duple<Integer, Integer>> parsedValues) {
        for (Duple<Integer, Integer> duple : parsedValues) {
            Duple<Vertex, Boolean> vertexIsNew1 = addVertex(duple.getX1());
            Duple<Vertex, Boolean> vertexIsNew2 = addVertex(duple.getX2());
            addConnection(vertexIsNew1.getX1(), vertexIsNew2.getX1());
        }
        return calculateUniqueGraphs(allVertexes);
    }

    private Duple<Vertex, Boolean> addVertex(Integer val) { //return Vertex and boolean if value was new
        if (!allVertexesVal.contains(val)) {
            allVertexesVal.add(val);
            Vertex vertex = new Vertex(val, new HashSet<>());
            allVertexes.add(vertex);
            return new Duple<>(vertex, true);
        } else {
            return new Duple<>(allVertexes.stream().filter(v -> v.getNodeValue().equals(val)).findFirst().get(), false);
        }
    }

    private void addConnection(Vertex vertex1, Vertex vertex2) {
        vertex1.getConnectedVertex().add(vertex2);
        vertex2.getConnectedVertex().add(vertex1);
    }

    private int calculateUniqueGraphs(List<Vertex> vertexes) {
        List<Vertex> vertexList = new ArrayList<>(vertexes);
        int uniqueGraphs = 0;
        for (Vertex vertex : vertexList) {
            if (!vertex.getVisited()) {
                uniqueGraphs++;
                markNodeAsVisited(vertex);
            }
        }
        return uniqueGraphs;
    }

    private void markNodeAsVisited(Vertex vertex) {
        if (vertex.getVisited())
            return;
        vertex.setVisited(true);
        for (Vertex v : vertex.getConnectedVertex()) {
            markNodeAsVisited(v);
        }
    }
}
