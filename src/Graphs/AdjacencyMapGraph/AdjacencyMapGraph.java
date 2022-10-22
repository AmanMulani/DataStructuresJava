package Graphs.AdjacencyMapGraph;

import Graphs.Graph.GraphMap;

import java.util.*;



public class AdjacencyMapGraph<T extends Comparable<T>> implements GraphMap<T> {


    public Map<T, ArrayList<Node<T>>> graph;

    public AdjacencyMapGraph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(T from, T to, boolean bidirectional) {
        addEdge(from, to, 0);
        if(bidirectional) {
            addEdge(to, from, 0);
        }
    }

    public void addEdgeWithWeight(T from, T to, int weight, boolean bidirectional) {
        addEdge(from, to, weight);

        if(bidirectional) {
            addEdge(to, from, weight);
        }
    }

    private void addEdge(T node1, T node2, int weight) {
        if(!this.graph.containsKey(node1)) {
            ArrayList<Node<T>> val= new ArrayList<>();
            this.graph.put(node1, val);
        }

        this.graph.get(node1).add(new Node(node1, node2, weight));
    }


    private Map<T, Boolean> getVisitedMap() {
        Map<T, Boolean> visited = new HashMap<>();
        for(T key : this.graph.keySet()) {
            visited.put(key, false);
        }
        return visited;
    }


    @Override
    public List<T> dfs(T start) {

        if(!this.graph.containsKey(start))
            throw new Error("No such node exists");

        List<T> dfs = new ArrayList<>();
        if(this.graph.size() == 0) {
            return dfs;
        }
        Map<T, Boolean> visited = getVisitedMap();
        dfs(start, dfs, visited);
        return dfs;
    }

    private void dfs(T currNode, List<T> dfs, Map<T, Boolean> visited) {
        if(visited.get(currNode)) {
            return;
        }

        visited.put(currNode, true);
        dfs.add(currNode);

        if(this.graph.containsKey(currNode)) {
            for(Node<T> neighbor : this.graph.get(currNode)) {
                if(!visited.get(neighbor.to)) {
                    dfs(neighbor.to, dfs, visited);
                }
            }
        }
    }

    @Override
    public List<T> bfs(T start) {

        if(!this.graph.containsKey(start))
            throw new Error("No such node exists");

        List<T> bfs = new ArrayList<>();
        if(this.graph.size() == 0) {
            return bfs;
        }
        Map<T, Boolean> visited = getVisitedMap();
        Queue<T> bfsQueue = new LinkedList<>();
        bfsQueue.add(start);
        visited.put(start, true);

        while(!bfsQueue.isEmpty()) {
            T currNode = bfsQueue.poll();
            bfs.add(currNode);
            if(this.graph.containsKey(currNode)) {
                for(Node<T> neighbor : this.graph.get(currNode)) {
                    if(!visited.get(neighbor.to)) {
                        bfsQueue.add(neighbor.to);
                        visited.put(neighbor.to, true);
                    }
                }
            }
        }
        return bfs;
    }
}
