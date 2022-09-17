package LinkedList;

import LinkedList.SinglyLinkedList.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.add("1");
        singlyLinkedList.add("2");
        singlyLinkedList.add("3");
        singlyLinkedList.add("4");
        singlyLinkedList.reverse();
        System.out.println(singlyLinkedList);

        SinglyLinkedList<Integer> singlyLinkedListFromArr = new SinglyLinkedList<>(new Integer[]{1,2,3,4,5});
        System.out.println(singlyLinkedListFromArr);
    }
}
