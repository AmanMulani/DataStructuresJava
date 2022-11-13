package BinaryTrees.BinaryTree;

import BinaryTrees.Node.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        while(!nodesQueue.isEmpty()) {
            Node<T> currElem = nodesQueue.poll();
            if(currElem == null) {
                continue;
            }
            if(i<elements.size()) {
                Node<T> left = elements.get(i) == null ? null : new Node<>(elements.get(i));
                currElem.left = left;
                nodesQueue.add(left);
                i++;
            }
            if(i<elements.size()) {
                Node<T> right = elements.get(i) == null ? null : new Node<>(elements.get(i));
                currElem.right = right;
                nodesQueue.add(right);
                i++;
            }
        }

    }


    public List<List<Node<T>>> breathFirstTraversal() {
        List<List<Node<T>>> nodes = new ArrayList<>();
        List<Node<T>> currLevelNodes = new ArrayList<>();

        Queue<Node<T>> qNodes = new LinkedList<>();

        currLevelNodes.add(this.head);
        qNodes.add(this.head);

        while (!qNodes.isEmpty()) {
            Node<T> node = qNodes.poll();

            
        }

        return nodes;
    }

    public int height() {
        return this.height(this.head);
    }


    private int height(Node<T> node) {
        if(node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
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
