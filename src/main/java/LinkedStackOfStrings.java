// public class LinkedStackOfStrings implements StackOfStrings{
public class LinkedStackOfStrings implements Stack<String> {
    private class Node {
        String item;
        Node next;
    }

    private Node first;
    private int size;

    public LinkedStackOfStrings() {
        first = new Node();
        size = 0;
    }

    public void push(String item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        size += 1;
    }

    public String pop() {
        Node node = first;
        first = first.next;
        size -= 1;
        return node.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
