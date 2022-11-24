package BinaryTrees.BinaryTree;

import BinaryTrees.Node.Node;

import java.sql.Array;
import java.util.*;

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
        Queue<Node<T>> qNodes = new LinkedList<>();
        qNodes.add(this.head);
        while (!qNodes.isEmpty()) {
            List<Node<T>> currLevelNodes = new ArrayList<>();
            int qSize = qNodes.size();
            for(int i = 0; i<qSize; i++) {
                assert qNodes.peek() != null;
                if(qNodes.peek().left != null) {
                    qNodes.add(qNodes.peek().left);
                }
                if(qNodes.peek().right != null) {
                    qNodes.add(qNodes.peek().right);
                }
                currLevelNodes.add(qNodes.poll());
            }

            nodes.add(currLevelNodes);
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


    public boolean isBalanced() {
        return isBalanced(this.head) != -1;
    }


    private int isBalanced(Node<T> node) {
        //Function returns -1 if the tree is not balanced.
        //Else returns the height of the tree.

        if(node == null)
            return 0;

        int leftHeight = isBalanced(node.left);
        int rightHeight = isBalanced(node.right);

        if(leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }


    public void iterativePreorderTraversal(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        List<Node<T>> preOrderTraversal = new ArrayList<>();

        if(node == null)  {
            System.out.println(preOrderTraversal);
        }

        stack.push(node);
        while(!stack.isEmpty()) {
            Node<T> currNode = stack.pop();

            preOrderTraversal.add(currNode);

            if(currNode.right != null)
                stack.push(currNode.right);

            if(currNode.left != null)
                stack.push(currNode.left);

        }

        System.out.println(preOrderTraversal.toString());
    }


    public void preOrderTraversal(Node<T> node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data.toString());
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }


    public void iterativeInOrder(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        List<Node<T>> inOrder = new ArrayList<>();
        while(true) {
            if(node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if(stack.isEmpty())
                    break;
                node = stack.pop();
                inOrder.add(node);
                node = node.right;
            }
        }
        System.out.println(inOrder);
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


    public void iterativePostOrderTraversal(Node<T> node) {
        Stack<Node<T>> stack1 = new Stack<>();
        Stack<Node<T>> stack2 = new Stack<>();
        List<Node<T>> postOrder = new ArrayList<>();

        if(node == null) {
            System.out.println("[]");
            return;
        }
        stack1.add(node);
        while(!stack1.isEmpty()) {
            Node<T> currNode = stack1.pop();
            if(currNode.left != null)
                stack1.add(currNode.left);

            if(currNode.right != null)
                stack1.add(currNode.right);

            stack2.add(currNode);
        }
        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop());
        }
        System.out.println(postOrder);

    }
}
