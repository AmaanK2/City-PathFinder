package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import ca.mcmaster.cas.se2aa4.a4.pathfinder.Graph;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.Node;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.Pathfinder3;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.PathFinder;
//import org.junit.Before;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

//import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.*;

public class Pathfinder3Test {
    private Graph graph;
    private Pathfinder3 pathfinder;

    @Before
    public void setUp() {
        graph = new Graph();
        pathfinder = new Pathfinder3();
    }

    @Test
    public void testFindPathReturnsCorrectPath() {
        Node nodeA = new Node(1, "A");
        Node nodeB = new Node(2, "B");
        Node nodeC = new Node(3, "C");
        Node nodeD = new Node(4, "D");
        Node nodeE = new Node(5, "E");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        graph.addEdge(nodeA, nodeB, 2);
        graph.addEdge(nodeA, nodeC, 3);
        graph.addEdge(nodeB, nodeD, 5);
        graph.addEdge(nodeC, nodeD, 1);
        graph.addEdge(nodeC, nodeE, 4);
        graph.addEdge(nodeD, nodeE, 1);

        List<Node> expectedPath = Arrays.asList(nodeA, nodeC, nodeD, nodeE);
        List<Node> actualPath = pathfinder.findPath(graph, nodeA, nodeE);

        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testFindPathReturnsOneWhenNoPathExists() {
        Node nodeA = new Node(1, "A");
        Node nodeB = new Node(2, "B");

        graph.addNode(nodeA);
        graph.addNode(nodeB);

        List<Node> actualPath = pathfinder.findPath(graph, nodeA, nodeB);
        assertEquals(1, actualPath.size());
    }

    @Test
    public void testFindPathReturnsCorrectPathWithNegativeWeights() {
        Node nodeA = new Node(1, "A");
        Node nodeB = new Node(2, "B");
        Node nodeC = new Node(3, "C");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);

        graph.addEdge(nodeA, nodeB, -2);
        graph.addEdge(nodeB, nodeC, -3);

        List<Node> expectedPath = Arrays.asList(nodeA, nodeB, nodeC);
        List<Node> actualPath = pathfinder.findPath(graph, nodeA, nodeC);

        assertEquals(expectedPath, actualPath);
    }

}