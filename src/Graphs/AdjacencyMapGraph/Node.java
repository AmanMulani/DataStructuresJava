package Graphs.AdjacencyMapGraph;

public class Node<T> {

    public int weight;
    public T to;
    public T from;

    Node(T f, T to, int w) {
        this.weight = w;
        this.to = to;
        this.from = f;
    }


    public String toString() {
        return "Edge from: " + from + ", to: " + to + ", weight: " + weight;
    }

}
