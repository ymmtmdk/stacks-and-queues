import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int head, tail;
    private int capacity;

    public RandomizedQueue() { // construct an empty randomized queue
        capacity = 2;
        a = (Item[]) new Object[capacity];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() { // is the queue empty?
        return size() == 0;
    }

    public int size() { // return the number of items on the queue
        return (tail - head + capacity) % capacity;
    }

    public void enqueue(Item item) { // add the item
        if (item == null) {
            throw new java.lang.NullPointerException();
        }

        if (size() >= capacity - 1) {
            resizeCapacity(capacity * 2);
        }
        a[tail++] = item;
        tail %= capacity;
    }

    public Item dequeue() { // remove and return a random item
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        if (size() <= 1) {
            resizeCapacity(2);
        } else if (size() < capacity / 3) {
            resizeCapacity(capacity / 2);
        }
        int i = randomIndex();
        Item item = a[i];
        a[i] = a[head];
        a[head++] = null;
        head %= capacity;
        return item;
    }

    public Item sample() { // return (but do not remove) a random item
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        return a[randomIndex()];
    }

    public Iterator<Item> iterator() { // return an independent iterator over items in random order
        return new RandomIterator(stripedArray(), size());
    }

    private int randomIndex() {
        int i = StdRandom.uniform(size());
        return (head + i) % capacity;
    }

    private void resizeCapacity(int newCapacity) {
        Item[] b = (Item[]) new Object[newCapacity];
        copy(b);
        tail = size();
        head = 0;
        a = b;
        capacity = newCapacity;
    }

    private Item[] copy(Item[] b) {
        for (int i = 0; i < size(); i++) {
            int j = (head + i) % capacity;
            b[i] = a[j];
        }

        return b;
    }

    private Item[] stripedArray() {
        Item[] b = (Item[]) new Object[size()];
        return copy(b);
    }

    private class RandomIterator implements Iterator<Item> {
        private Item[] a;
        private int head, tail;

        private RandomIterator(Item[] a, int size) {
            this.a = a;
            this.head = 0;
            this.tail = size;
        }

        public boolean hasNext() {
            return size() > 0;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            int i = head + StdRandom.uniform(size());
            Item item = a[i];
            a[i] = a[head];
            a[head++] = null;
            return item;
        }

        private int size() {
            return tail - head;
        }
    }

    // public static void main(String[] args);   // unit testing (optional)
}
