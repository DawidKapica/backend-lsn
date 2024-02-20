package com.dawidkapica.task3;

import com.dawidkapica.util.Duple;

import java.util.*;

public class GraphOperations {

    Map<Integer, Vertex> allVertices = new HashMap<>();
    Set<Integer> visitedVerticesNodeValues = new HashSet<>();

    public int calculateNumberOfDistinctGraph(List<Duple<Integer, Integer>> parsedValues) {
        for (Duple<Integer, Integer> duple : parsedValues) {
            Vertex vertex1 = addVertex(duple.getX1());
            Vertex vertex2 = addVertex(duple.getX2());
            addConnection(vertex1, vertex2);
        }
        return calculateUniqueGraphs(allVertices.values());
    }

    private Vertex addVertex(Integer val) {
        if (!allVertices.containsKey(val)) {
            Vertex vertex = new Vertex(val, new HashSet<>());
            allVertices.put(val, vertex);
            return vertex;
        } else {
            return allVertices.entrySet().stream().filter(v -> v.getKey().equals(val)).findFirst().get().getValue();
        }
    }

    private void addConnection(Vertex vertex1, Vertex vertex2) {
        vertex1.getConnectedVertex().add(vertex2);
        vertex2.getConnectedVertex().add(vertex1);
    }

    private int calculateUniqueGraphs(Collection<Vertex> vertexes) {
        List<Vertex> vertexList = new ArrayList<>(vertexes);
        int uniqueGraphs = 0;
        for (Vertex vertex : vertexList) {
            if (!visitedVerticesNodeValues.contains(vertex.getNodeValue())) {
                uniqueGraphs++;
                markNodeAsVisited(vertex);
            }
        }
        return uniqueGraphs;
    }

    private void markNodeAsVisited(Vertex vertex) {
        if (visitedVerticesNodeValues.contains(vertex.getNodeValue()))
            return;

        visitedVerticesNodeValues.add(vertex.getNodeValue());
        for (Vertex v : vertex.getConnectedVertex()) {
            markNodeAsVisited(allVertices.get(v.getNodeValue()));
        }
    }
}
