import Backtracking.NQueens.NQueens;
import BinaryTrees.BinaryTree.BinaryTree;
import Heap.Heap.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Backtracking: N-Queens
//        NQueens nqueens = new NQueens(4);
//        nqueens.solveNQueens();

//        Binary Trees
//        List<Integer> elements = Arrays.asList(1, 2, 4, null, null, 5, 7, null, null, null, 3, null, 6, null, null);
//        BinaryTree<Integer> bTree = new BinaryTree<>(elements);
//        System.out.println(bTree.height());
//        bTree.inOrderTraversal(bTree.head);

        Integer[] arr = {2,13,4,56,72,8};
        Heap<Integer> heap = new Heap<Integer>(arr);
        heap.add(10);
        heap.add(1);
        heap.add(100);
        heap.heapSort();
        System.out.println(heap);

    }
}
