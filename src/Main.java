import Backtracking.NQueens.NQueens;
import BinaryTrees.BinaryTree.BinaryTree;
import Graphs.AdjacencyListGraph.AdjacencyListGraph;
import Graphs.AdjacencyMapGraph.AdjacencyMapGraph;
import Graphs.DijkstraAlgorithm.DijkstraAlgorithm;
import Graphs.Graph.Graph;
import Heap.Heap.Heap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//*************Backtracking: N-Queens***************//
//
//        NQueens nqueens = new NQueens(4);
//        nqueens.solveNQueens();

//*************Binary Trees***************//
//        List<Integer> elements = Arrays.asList(1, 2, 4, null, null, 5, 7, null, null, null, 3, null, 6, null, null);
//        BinaryTree<Integer> bTree = new BinaryTree<>(elements);
//        System.out.println(bTree.breathFirstTraversal());
//        System.out.println(bTree.height());
//        bTree.inOrderTraversal(bTree.head);


//*************Heap***************//
//        Integer[] arr = {2,13,4,56,72,8};
//        Heap<Integer> heap = new Heap<Integer>(arr);
//        heap.add(10);
//        heap.add(1);
//        heap.add(100);
//        heap.heapSort();
//        System.out.println(heap);


//*************Graph*************//
        System.out.println("Adjacency List Graph");
        AdjacencyListGraph graph = new AdjacencyListGraph(8);
        graph.addEdge(0, 1, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(2, 5, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 7, true);
        graph.addEdge(7, 6, true);
        graph.addEdge(5, 8, true);
        graph.addEdge(3, 4, true);
        graph.addEdge(4, 7, true);

        System.out.println("DFS===> " + graph.dfs());
        System.out.println("BFS===> " + graph.bfs());

        System.out.println("Adjacency Map Graph");
        AdjacencyMapGraph<Integer> adjMapGraph = new AdjacencyMapGraph<Integer>();
        adjMapGraph.addEdge(0, 1, true);
        adjMapGraph.addEdge(1, 2, true);
        adjMapGraph.addEdge(1, 3, true);
        adjMapGraph.addEdge(2, 5, true);
        adjMapGraph.addEdge(2, 3, true);
        adjMapGraph.addEdge(3, 7, true);
        adjMapGraph.addEdge(7, 6, true);
        adjMapGraph.addEdge(5, 8, true);
        adjMapGraph.addEdge(3, 4, true);
        adjMapGraph.addEdge(4, 7, true);

        System.out.println("DFS===> " + adjMapGraph.dfs(0));
        System.out.println("BFS===> " + adjMapGraph.bfs(0));

        System.out.println("Dijkstra's Algorithm");

        AdjacencyMapGraph<Integer> dijkstraGraph = new AdjacencyMapGraph<>();

        dijkstraGraph.addEdgeWithWeight(0, 1, 4, true);
        dijkstraGraph.addEdgeWithWeight(0, 7, 8, true);
        dijkstraGraph.addEdgeWithWeight(1, 7, 11, true);
        dijkstraGraph.addEdgeWithWeight(1, 2, 8, true);
        dijkstraGraph.addEdgeWithWeight(2, 8, 2, true);
        dijkstraGraph.addEdgeWithWeight(2, 3, 7, true);
        dijkstraGraph.addEdgeWithWeight(7, 8, 7, true);
        dijkstraGraph.addEdgeWithWeight(7, 6, 1, true);
        dijkstraGraph.addEdgeWithWeight(8, 6, 6, true);
        dijkstraGraph.addEdgeWithWeight(2, 5, 4, true);
        dijkstraGraph.addEdgeWithWeight(6, 5, 2, true);
        dijkstraGraph.addEdgeWithWeight(3, 5, 14, true);
        dijkstraGraph.addEdgeWithWeight(3, 4, 9, true);
        dijkstraGraph.addEdgeWithWeight(5, 4, 10, true);

        DijkstraAlgorithm<Integer> dijkstraAlgorithm = new DijkstraAlgorithm<>(dijkstraGraph, 0);
        System.out.println("Shortest distance from 0 to 4: " + dijkstraAlgorithm.getDistance(4));
        dijkstraAlgorithm.displayDistance();
    }
}
