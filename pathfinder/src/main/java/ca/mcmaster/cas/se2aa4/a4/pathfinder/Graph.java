package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.*;

public class Graph {
    private Map<Node, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node source, Node destination, double weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
    }

    public void clear() {
        this.adjacencyList.clear();
    }

    public List<Edge> getEdges(Node node) {
        List<Edge> edges = adjacencyList.get(node);
        if (edges == null) {
            return Collections.emptyList();
        } else {
            return edges;
        }
    }
}

class Edge {
    private Node source;
    private Node destination;
    private double weight;

    public Edge(Node source, Node destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}

