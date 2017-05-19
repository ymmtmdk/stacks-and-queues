import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackTest {

    @Test
    public void stackTest() {
        for (int i = 0; i < 4; i++) {
            Stack s;
            if (i == 0) {
                s = new ResizingArrayStackOfStrings();
            } else if (i == 1) {
                s = new LinkedStackOfStrings();
            } else if (i == 2) {
                s = new ResizingArrayStack<String>();
            } else {
                s = new LinkedStack<String>();
            }

            assertEquals(0, s.size());
            assertEquals(true, s.isEmpty());
            s.push("s");
            assertEquals(1, s.size());
            assertEquals(false, s.isEmpty());
            assertEquals("s", s.pop());
            assertEquals(0, s.size());
            assertEquals(true, s.isEmpty());
            s.push("a");
            s.push("b");
            s.push("c");
            assertEquals(3, s.size());
            assertEquals(false, s.isEmpty());
            assertEquals("c", s.pop());
            assertEquals("b", s.pop());
            assertEquals("a", s.pop());
        }
    }
}
