package Heap.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    public List<T> heap;
    private int size;

    public Heap() {
        heap = new ArrayList<>();
        this.size = 0;
    }


    public Heap(T[] collection) {
        this.heap = new ArrayList<>();
        Collections.addAll(heap, collection);
        this.size = collection.length;
        minHeapify();
    }

    public void add(T data) {
        this.heap.add(data);
        this.size++;
        int currIndex = this.size - 1;

        while(currIndex >= 0) {
            heapify(currIndex, this.size);
            currIndex = parent(currIndex);
        }
    }

    private int parent(int idx) {
        if(idx % 2 == 0) {
            return idx/2 -1;
        } else {
            return (idx-1)/2;
        }
    }


    private void heapify(int index, int size) {
        int left = this.left(index);
        int right = this.right(index);

        int largestIndex = index;
        if(left < size && heap.get(index).compareTo(heap.get(left)) < 0) {
            largestIndex = left;
        }

        if(right < size && heap.get(largestIndex).compareTo(heap.get(right)) < 0) {
            largestIndex = right;
        }

        if(largestIndex != index) {
            swap(largestIndex, index);
            heapify(largestIndex, size);
        }
    }


    private void minHeapify() {

        for(int i = (this.size/2) - 1; i>=0; i--) {
            heapify(i, this.size);
        }

    }


    public void heapSort() {
        for(int i = this.size-1; i>=0; i--) {
            swap(0, i);
            heapify(0, i);
        }
    }


    public String toString() {
        return heap.toString();
    }


    private void swap(int i, int j) {
        T temp = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, temp);
    }


    private int left(int index) {
        return 2*index + 1;
    }


    private int right(int index) {
        return 2*index + 2;
    }

}
