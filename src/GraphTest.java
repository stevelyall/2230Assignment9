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

    @Test
    // remove edge by indices
    public void testRemoveEdge() throws Exception {
        g1.addVertex("Hello");
        g1.addVertex("World");
        assertEquals(2, g1.size());
        g1.addEdge(0, 1);
        assertTrue(g1.isConnected());
        g1.removeEdge(0, 1);
        assertFalse(g1.isConnected());


    }

    @Test
    public void testRemoveEdge1() throws Exception {

    }

    @Test
    public void testAddVertex() throws Exception {

    }

    @Test
    public void testRemoveVertex() throws Exception {

    }

    @Test
    public void testIsConnected() throws Exception {
        assertTrue(g1.isEmpty());
        assertTrue(g1.isConnected());
        g1.addVertex("Hello");
        g1.addVertex("World");
        assertFalse(g1.isConnected());
        g1.addEdge(0, 1);
        assertTrue(g1.isConnected());


    }

    @Test
    public void testGetIndex() throws Exception {
        g1.addVertex("Hello");
        g1.addVertex("World");
        g1.addVertex("How");
        g1.addVertex("Hello");
        g1.addVertex("You");

        assertEquals(0, g1.getIndex("Hello"));
        assertEquals(1, g1.getIndex("World"));
        assertEquals(2, g1.getIndex("How"));
        assertEquals(4, g1.getIndex("You"));
    }

    @Test
    public void testIndexIsValid() throws Exception {
        assertFalse(g1.indexIsValid(0));
        assertFalse(g1.indexIsValid(2));

        g1.addVertex("Hello");
        g1.addVertex("World");

        assertTrue(g1.indexIsValid(0));
        assertTrue(g1.indexIsValid(1));
        assertFalse(g1.indexIsValid(2));


        g1.addVertex("What's Up");

        assertTrue(g1.indexIsValid(2));
        assertFalse(g1.indexIsValid(3));

        // TODO after removing, say, index 1? holes may cause issue?

    }
}