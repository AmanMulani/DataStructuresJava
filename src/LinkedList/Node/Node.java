package LinkedList.Node;

public class Node<T extends  Comparable<T>> {

    public T data;
    public Node<T> next;
    public Node<T> prev;


    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(Node<T> node) {
        this.data = node.data;
        this.next = node.next == null ? null : new Node<T>(node.next.data);
        this.prev = node.prev == null ? null : new Node<T>(node.prev.data);
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
