// public class ResizingArrayStackOfStrings implements StackOfStrings{
public class ResizingArrayStack<Item> implements Stack<Item> {
    private Item[] a;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        capacity = 1;
        a = (Item[]) new Object[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resizeCapacity(int newCapacity) {
        capacity = newCapacity;
        Item[] b = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            b[i] = a[i];
        }
        a = b;
    }

    public void push(Item item) {
        a[size] = item;
        size += 1;
        if (size >= capacity) {
            resizeCapacity(capacity * 2);
        }
    }

    public Item pop() {
        if (size < capacity / 4) {
            resizeCapacity(capacity / 2);
        }
        size -= 1;
        return a[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
