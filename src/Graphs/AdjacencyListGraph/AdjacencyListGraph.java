package Graphs.AdjacencyListGraph;
import Graphs.Graph.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyListGraph implements Graph<Integer> {

    public List<List<Integer>> graph;
    public int N;

    public AdjacencyListGraph(int N) {
        this.N = N;
        graph = new ArrayList<>();
        for(int i = 0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, boolean bidirectional) {
        if(from > this.N || to > this.N || from < 0 || to < 0) {
            throw new Error("Given Node does not exist.");
        }
        this.graph.get(from).add(to);
        if(bidirectional) {
            this.graph.get(to).add(from);
        }
    }


    @Override
    public List<Integer> bfs() {
        List<Integer> _bfs = new ArrayList<>();
        if(this.N == 0) {
            return _bfs;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[this.N + 1];

        q.add(0);
        while (!q.isEmpty()) {
            Integer node = q.poll();
            visited[node] = true;
            _bfs.add(node);
            for(Integer neighbor : graph.get(node)) {
                if(!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return _bfs;
    }

    @Override
    public List<Integer> dfs() {
        List<Integer> _dfs =  new ArrayList<>();
        if(this.N == 0) {
            return _dfs;
        }
        boolean[] visited = new boolean[this.N + 1];
        dfsUtil(0, visited, _dfs);
        return _dfs;
    }

    private void dfsUtil(Integer node, boolean[] visited, List<Integer> dfs) {
        if(visited[node]) {
            return;
        }
        visited[node] = true;
        dfs.add(node);
        for(Integer neighbor : this.graph.get(node)) {
            dfsUtil(neighbor, visited, dfs);
        }
    }
}
