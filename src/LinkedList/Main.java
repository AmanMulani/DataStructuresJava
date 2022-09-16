package LinkedList;

public class Main {

    public static void main(String args[]) {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("Aman");
        linkedList.add("Safa");

        System.out.println(linkedList.contains("aman"));
    }
}
