// public class ResizingArrayStackOfStrings implements StackOfStrings{
public class ResizingArrayStackOfStrings implements Stack<String> {
    private String[] a;
    private int size;
    private int capacity;

    public ResizingArrayStackOfStrings() {
        capacity = 1;
        a = new String[capacity];
        size = 0;
    }

    private void resizeCapacity(int newCapacity) {
        capacity = newCapacity;
        String[] b = new String[capacity];
        for (int i = 0; i < size; i++) {
            b[i] = a[i];
        }
        a = b;
    }

    public void push(String item) {
        a[size] = item;
        size += 1;
        if (size >= capacity) {
            resizeCapacity(capacity * 2);
        }
    }

    public String pop() {
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
