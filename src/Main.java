import Backtracking.NQueens.NQueens;
import BinaryTrees.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        NQueens nqueens = new NQueens(4);
//        nqueens.solveNQueens();

        List<Integer> elements = Arrays.asList(1, 2, 4, null, null, 5, 7, null, null, null, 3, null, 6, null, null);

        BinaryTree<Integer> bTree = new BinaryTree<>(elements);
        System.out.println(bTree.height());
//        bTree.inOrderTraversal(bTree.head);
    }
}
