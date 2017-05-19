import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int size;

    public Deque() { // construct an empty deque
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() { // is the deque empty?
        return size() == 0;
    }

    public int size() { // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item) { // add the item to the front
        if (item == null) {
            throw new java.lang.NullPointerException();
        }

        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            first.prev = node;
            node.next = first;
            first = node;
        }
        size += 1;
    }

    public void addLast(Item item) { // add the item to the end
        if (item == null) {
            throw new java.lang.NullPointerException();
        }

        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size += 1;
    }

    public Item removeFirst() { // remove and return the item from the front
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Node node = first;
        if (size() == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }

        size -= 1;
        return node.item;
    }

    public Item removeLast() { // remove and return the item from the end
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Node node = last;
        if (size() == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }

        size -= 1;
        return node.item;
    }

    public Iterator<Item> iterator() { // return an iterator over items in order from front to end
        return new DequeIterator(first);
    }

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node first;

        private DequeIterator(Node f) {
            first = f;
        }

        public boolean hasNext() {
            return first != null;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            Node node = first;
            first = first.next;
            return node.item;
        }
    }
    // public static void main(String[] args)   // unit testing (optional)
}

// public class LinkedStackOfStrings implements StackOfStrings{
