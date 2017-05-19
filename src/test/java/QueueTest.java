import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueTest {
    @Test
    public void queueSize() {
        Queue q;
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                q = new ResizingArrayQueue<String>();
            } else {
                q = new LinkedQueue<String>();
            }

            assertEquals(0, q.size());
            q.enqueue("s");
            assertEquals(1, q.size());
            q.dequeue();
            assertEquals(0, q.size());
            q.enqueue("s");
            assertEquals(1, q.size());
            q.enqueue("s");
            assertEquals(2, q.size());
        }
    }

    @Test
    public void queueTest() {
        Queue q;
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                q = new ResizingArrayQueue<String>();
            } else {
                q = new LinkedQueue<String>();
            }

            assertEquals(0, q.size());
            assertEquals(true, q.isEmpty());
            q.enqueue("s");
            assertEquals(1, q.size());
            assertEquals(false, q.isEmpty());
            assertEquals("s", q.dequeue());
            assertEquals(0, q.size());
            assertEquals(true, q.isEmpty());
            q.enqueue("a");
            q.enqueue("b");
            q.enqueue("c");
            assertEquals(3, q.size());
            assertEquals(false, q.isEmpty());
            assertEquals("a", q.dequeue());
            assertEquals("b", q.dequeue());
            assertEquals("c", q.dequeue());
            assertEquals(0, q.size());
            assertEquals(true, q.isEmpty());
            q.enqueue("a");
            q.enqueue("b");
            q.enqueue("c");
            q.enqueue("d");
            assertEquals(4, q.size());
            assertEquals(false, q.isEmpty());
            assertEquals("a", q.dequeue());
            assertEquals("b", q.dequeue());
            assertEquals("c", q.dequeue());
            assertEquals("d", q.dequeue());
        }
    }
}
