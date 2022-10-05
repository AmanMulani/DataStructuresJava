package Graphs.DijkstraAlgorithm;

import Graphs.AdjacencyMapGraph.AdjacencyMapGraph;

import java.util.*;

public class DijkstraAlgorithm<T extends Comparable<T>> {

    static class Pair<T extends Comparable<T>> {
        T node;
        int distance;
        Pair(T n, int d) {
            this.node = n;
            this.distance = d;
        }

        public int compareTo(Pair<T> p2) {
            return this.distance - p2.distance;
        }
    }

    AdjacencyMapGraph<T> graph;
    T startPoint;
    Map<T, Integer> distance;

    public DijkstraAlgorithm(AdjacencyMapGraph<T> graph, T startPoint) {
        this.graph = graph;
        this.startPoint = startPoint;
        this.distance = dijkstraAlgorithm();
    }

    private Map<T, Integer> dijkstraAlgorithm() {
        Map<T, Integer> distance = new HashMap<>();
        Map<T, Boolean> visited = new HashMap<>();

        for(T key : this.graph.graph.keySet()) {
            distance.put(key, Integer.MAX_VALUE);
            visited.put(key, false);
        }

        PriorityQueue<Pair<T>> pq = new PriorityQueue<>();
        pq.add(new Pair<>(this.startPoint, 0));

        while(!pq.isEmpty()) {
            Pair<T> node = pq.poll();
            if(visited.get(node.node)) {
                continue;
            }
            visited.put(node.node, true);
            for(T neighbor : this.graph.graph.get(node.node)) {
                if(!visited.get(neighbor)) {
                    int d = Math.min(distance.get(neighbor), distance.get(node.node) + node.distance);
                    distance.put(neighbor, d);
                }
            }
        }
        return distance;
    }

    public int getDistance(T endNode) {
        if(!this.graph.graph.containsKey(endNode)) {
            throw new Error("No such node exists");
        }
        int dist = this.distance.get(endNode);
        if(dist == Integer.MAX_VALUE) {
            return -1;
        }
        return dist;
    }
}
