package BinaryTrees.BinaryTree;

import BinaryTrees.Node.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinaryTree<T> {

    public Node<T> head;

    public BinaryTree(List<T> elements) {
        buildBinaryTree(elements);
    }


    private void buildBinaryTree(List<T> elements) {
        if(elements.size() == 0) {
            this.head = null;
            return;
        }

        Queue<Node<T>> nodesQueue = new LinkedList<>();
        this.head = new Node<>(elements.get(0));
        nodesQueue.add(this.head);
        int i = 1;
        while(!nodesQueue.isEmpty() && i<elements.size()) {
            Node<T> currElem = nodesQueue.poll();
            if(i<elements.size()) {
                Node<T> left = new Node<>(elements.get(i++));
                currElem.left = left;
                nodesQueue.add(left);
            }
            if(i<elements.size()) {
                Node<T> right = new Node<>(elements.get(i++));
                currElem.right = right;
                nodesQueue.add(right);
            }
        }

    }


    public void preOrderTraversal(Node<T> node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data.toString());
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }


    public void inOrderTraversal(Node<T> node) {
        if(node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data.toString());
        inOrderTraversal(node.right);
    }


    public void postOrderTraversal(Node<T> node) {
        if(node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.data.toString());
    }
}
