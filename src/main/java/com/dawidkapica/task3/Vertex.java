package com.dawidkapica.task3;

import java.util.Set;

public class Vertex {
    Integer nodeValue;
    Boolean visited = false;
    Set<Vertex> connectedVertex;

    public Vertex(Integer nodeValue, Set<Vertex> connectedVertex) {
        this.nodeValue = nodeValue;
        this.connectedVertex = connectedVertex;
    }

    public Integer getNodeValue() {
        return nodeValue;
    }

    public Set<Vertex> getConnectedVertex() {
        return connectedVertex;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
}