import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    Graph<String> g1;

    @Before
    public void setUp() throws Exception {
        g1 = new Graph<String>();
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, g1.size());
        g1.addVertex("Hello");
        assertEquals(1, g1.size());
        g1.addVertex("World");
        assertEquals(2,g1.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(g1.isEmpty());
        g1.addVertex("Hello");
        assertFalse(g1.isEmpty());
    }
}