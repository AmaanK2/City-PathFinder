package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.*;

public interface PathFinder {
    List<Node> findPath(Graph graph, Node start, Node end);
}



