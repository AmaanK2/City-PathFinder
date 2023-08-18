package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.*;

public class Pathfinder3 implements PathFinder {
    public List<Node> findPath(Graph graph, Node start, Node end) {


        Set<Node> visited = new HashSet<>();
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        queue.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visited.add(current);

            if (current.equals(end)) {
                break;
            }

            for (Edge edge : graph.getEdges(current)) {
                Node neighbour = edge.getDestination();

                if (!visited.contains(neighbour)) {
                    double newDistance = distance.get(current) + edge.getWeight();

                    if (distance.getOrDefault(neighbour, Integer.MAX_VALUE) > newDistance) {
                        distance.put(neighbour, (int) newDistance);
                        previous.put(neighbour, current);
                        queue.add(neighbour);
                    }
                }
            }
        }

        List<Node> path = new ArrayList<>();
        Node current = end;

        while (previous.containsKey(current)) {
            path.add(current);
            current = previous.get(current);
        }

        path.add(start);
        Collections.reverse(path);

        return path;
    }
}
