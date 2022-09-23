import Backtracking.NQueens.NQueens;
import BinaryTrees.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        NQueens nqueens = new NQueens(4);
//        nqueens.solveNQueens();

        List<Integer>  elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        BinaryTree<Integer> bTree = new BinaryTree<>(elements);
        bTree.inOrderTraversal(bTree.head);
    }
}
