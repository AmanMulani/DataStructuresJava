package LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.reverse();
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());
    }
}
