import Backtracking.NQueens.NQueens;
import BinaryTrees.BinaryTree.BinaryTree;
import Graphs.AdjacencyListGraph.AdjacencyListGraph;
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

        System.out.println(graph.bfs());
        System.out.println(graph.dfs());
    }
}
