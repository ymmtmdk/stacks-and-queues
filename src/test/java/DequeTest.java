import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import com.twitter.common.objectsize.ObjectSizeCalculator;
import java.util.Iterator;
import org.junit.Test;

public class DequeTest {

    @Test(expected = java.lang.NullPointerException.class)
    public void nullPointerTest() {
        Deque q = new Deque();
        q.addFirst(null);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void nullPointerTest2() {
        Deque q = new Deque();
        q.addLast(null);
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void noSuchElementTest() {
        Deque q = new Deque();
        q.removeFirst();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void noSuchElementTest2() {
        Deque q = new Deque();
        q.removeLast();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void noSuchElementItrTest() {
        Deque q = new Deque();
        q.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unsupportedTest() {
        Deque q = new Deque();
        q.iterator().remove();
    }

    @Test
    public void dequeIteratorTest() {
        Deque q = new Deque();
        assertEquals(false, q.iterator().hasNext());

        q.addLast("a");
        q.addLast("b");
        Iterator itr = q.iterator();
        assertEquals(true, itr.hasNext());
        assertEquals("a", itr.next());
        assertEquals(2, q.size());
        assertEquals(true, itr.hasNext());
        assertEquals("b", itr.next());
        assertEquals(false, itr.hasNext());
        assertEquals(2, q.size());
    }

    @Test
    public void dequeObjectSizeTest() {
        Deque q = new Deque<Byte>();
        assertThat(ObjectSizeCalculator.getObjectSize(q), lessThanOrEqualTo(192L));
        int n = 100000;
        for (int i = 0; i < n; i++) {
            q.addFirst(0);
        }
        assertThat(ObjectSizeCalculator.getObjectSize(q), lessThanOrEqualTo(48L * n + 192L));
    }

    @Test
    public void dequeTest() {
        Deque q;
        q = new Deque<String>();

        assertEquals(0, q.size());
        assertEquals(true, q.isEmpty());
        q.addLast("s");
        assertEquals(1, q.size());
        assertEquals(false, q.isEmpty());
        assertEquals("s", q.removeFirst());
        assertEquals(0, q.size());
        assertEquals(true, q.isEmpty());
        q.addLast("a");
        assertEquals(1, q.size());
        q.addLast("b");
        assertEquals(2, q.size());
        assertEquals("a", q.removeFirst());
        assertEquals(1, q.size());
        assertEquals("b", q.removeFirst());
        assertEquals(0, q.size());

        q.addLast("a");
        q.addLast("b");
        assertEquals("b", q.removeLast());
        assertEquals("a", q.removeLast());
        assertEquals(0, q.size());

        q.addFirst("a");
        q.addFirst("b");
        assertEquals("a", q.removeLast());
        assertEquals("b", q.removeLast());
    }
}
