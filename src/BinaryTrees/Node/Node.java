package BinaryTrees.Node;

public class Node<T> {

    public Node<T> left;
    public Node<T> right;
    public T data;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
