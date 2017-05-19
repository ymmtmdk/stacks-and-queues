
public class ResizingArrayQueue<Item> implements Queue<Item> {
    private Item[] a;
    private int head, tail;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ResizingArrayQueue() {
        capacity = 1;
        a = (Item[]) new Object[capacity];
        head = tail = 0;
    }

    @SuppressWarnings("unchecked")
    private void resizeCapacity(int newCapacity) {
        Item[] b = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            int j = (head + i) % capacity;
            b[i] = a[j];
        }
        tail = size();
        head = 0;
        a = b;
        capacity = newCapacity;
    }

    public void enqueue(Item item) {
        if (size() >= capacity - 1) {
            resizeCapacity(capacity * 2);
        }
        a[tail++] = item;
        tail %= capacity;
    }

    public Item dequeue() {
        if (size() < capacity / 4) {
            resizeCapacity(capacity / 2);
        }
        Item item = a[head++];
        head %= capacity;
        return item;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return (tail - head + capacity) % capacity;
    }
}
