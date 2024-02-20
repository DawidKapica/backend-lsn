package com.dawidkapica.task3;

import java.util.Set;

public class Vertex {
    Integer nodeValue;
    Set<Vertex> connectedVertices;

    public Vertex(Integer nodeValue, Set<Vertex> connectedVertices) {
        this.nodeValue = nodeValue;
        this.connectedVertices = connectedVertices;
    }

    public Integer getNodeValue() {
        return nodeValue;
    }

    public Set<Vertex> getConnectedVertex() {
        return connectedVertices;
    }
}
