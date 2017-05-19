// public class LinkedStackOfStrings implements StackOfStrings{
public class LinkedQueue<Item> implements Queue<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first, last;
    private int size;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = null;
        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size += 1;
    }

    public Item dequeue() {
        Node node = first;
        first = first.next;
        if (first == null) {
            last = null;
        }
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
