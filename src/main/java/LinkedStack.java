// public class LinkedStackOfStrings implements StackOfStrings{
public class LinkedStack<Item> implements Stack<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int size;

    public LinkedStack() {
        first = new Node();
        size = 0;
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        size += 1;
    }

    public Item pop() {
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
