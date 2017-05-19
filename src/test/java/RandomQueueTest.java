import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import com.twitter.common.objectsize.ObjectSizeCalculator;
import java.util.Iterator;
import org.junit.Test;

public class RandomQueueTest {
    @Test(expected = java.lang.NullPointerException.class)
    public void nullPointerTest() {
        RandomizedQueue q = new RandomizedQueue();
        q.enqueue(null);
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void noSuchElementTest() {
        RandomizedQueue q = new RandomizedQueue();
        q.sample();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void noSuchElementTest2() {
        RandomizedQueue q = new RandomizedQueue();
        q.dequeue();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void noSuchElementItrTest() {
        RandomizedQueue q = new RandomizedQueue();
        q.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unsupportedTest() {
        RandomizedQueue q = new RandomizedQueue();
        q.iterator().remove();
    }

    @Test
    public void randomQueueIteratorTest() {
        RandomizedQueue q = new RandomizedQueue();
        assertEquals(false, q.iterator().hasNext());

        q.enqueue("a");
        q.enqueue("b");
        Iterator itr = q.iterator();
        assertEquals(true, itr.hasNext());
        assertEquals(true, itr.next() != null);
        assertEquals(true, itr.hasNext());
        assertEquals(true, itr.next() != null);
        assertEquals(false, itr.hasNext());
    }

    @Test
    public void objectSizeTest() {
        RandomizedQueue q = new RandomizedQueue<Byte>();
        assertThat(ObjectSizeCalculator.getObjectSize(q), lessThanOrEqualTo(192L));
        int n = 100000;
        for (int i = 0; i < n; i++) {
            q.enqueue(0);
        }
        assertThat(ObjectSizeCalculator.getObjectSize(q), lessThanOrEqualTo(48L * n + 192L));
    }

    @Test
    public void randomQueueTest() {
        RandomizedQueue q;
        q = new RandomizedQueue();

        assertEquals(0, q.size());
        assertEquals(true, q.isEmpty());
        q.enqueue("s");
        assertEquals(1, q.size());
        assertEquals(false, q.isEmpty());
        assertEquals("s", q.dequeue());
        assertEquals(0, q.size());
        assertEquals(true, q.isEmpty());
        q.enqueue("s");
        assertEquals(1, q.size());
        assertEquals("s", q.sample());
        assertEquals(1, q.size());
    }
}
