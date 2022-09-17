package LinkedList.SinglyLinkedList;

import LinkedList.Node.Node;

public class SinglyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;

    private int _size = 0;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public SinglyLinkedList(T[] elements) {
        int len = elements.length;
        if(len == 0) {
            this.head = null;
            this.tail = null;
        }

        for(T element : elements) {
            add(element);
        }
    }

    public Node<T> getHead() {
        return this.head;
    }



    public int size() {
        return this._size;
    }

    private void updateIfTail(Node<T> node) {
        if(node.next == null) {
            this.tail = node;
        }
    }

    private void updateIfHead(Node<T> node, Node<T> currNode) {
        if(currNode == this.head) {
            this.head = node;
        }
    }


    private void resetHeadAndTail() {
        this.head = null;
        this.tail = null;
        this._size = 0;
    }


    public boolean isEmpty() {
        return this._size == 0;
    }


    public void add(T data) {
        Node<T> node = new Node<>(data);
        this._size++;

        if(this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }

        Node<T> currNode = this.head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = node;
        updateIfTail(node);
    }


    public void insertAt(T data, int pos) {
        Node<T> node = new Node<>(data);

        if(pos > this._size) {
            throw new Error("Requested position out of bounds");
        }

        Node<T> currNode = this.head;
        int i = 0;
        while(i<pos) {
            currNode = currNode.next;
            i++;
        }

        node.next = currNode.next;
        currNode.next = node;

        updateIfHead(node, currNode);
        updateIfTail(node);
        this._size++;
    }


    public void deleteAt(int pos) {
        if(pos >= this._size) {
            throw new Error("Request position out of bounds");
        }

        if(this._size == 1) {
            resetHeadAndTail();
            return;
        }

        Node<T> currNode = this.head;
        Node<T> prevNode = null;
        int i = 0;
        while(i<pos) {
            prevNode = currNode;
            currNode = currNode.next;
            i++;
        }

        assert prevNode != null;

        prevNode.next = currNode.next;
        currNode.next = null;

        updateIfHead(prevNode, currNode);
        updateIfTail(prevNode);
        this._size--;

    }


    public void remove(T data) {
        if(!contains(data)) {
            throw new Error("No such element exists in List");
        }

        if(this._size == 1) {
            resetHeadAndTail();
            return;
        }

        Node<T> prevNode = null;
        Node<T> currNode = this.head;

        while(currNode.data.compareTo(data) != 0) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        assert prevNode != null;

        prevNode.next = currNode.next;
        currNode.next = null;

        updateIfHead(prevNode, currNode);
        updateIfTail(prevNode);
        this._size--;
    }


    public boolean contains(T data) {
        Node<T> currNode = this.head;
        while(currNode.next != null) {
            if(currNode.data.compareTo(data) == 0) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }


    public void reverse() {
        if(this._size == 0 || this._size == 1) {
            return;
        }
        Node<T> nextNode = head;
        Node<T> prevNode = null;

        tail = head;

        while(nextNode != null) {
            Node<T> tempNode = new Node<>(nextNode);
            tempNode.next = prevNode;
            prevNode = tempNode;
            nextNode = nextNode.next;
        }
        head = prevNode;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if(this._size == 0) {
            return string.toString();
        }
        Node<T> currNode = this.head;
        while(currNode != null) {
            String str = currNode + "->";
            string.append(str);
            currNode = currNode.next;
        }

        string.append("null");
        return  string.toString();
    }


}
