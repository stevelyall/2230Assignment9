import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("==== Test Output for Graph.java ====");
        System.out.println();

        System.out.println("Creating a new graph...");
        Graph<String> graph = new Graph<String>();

        System.out.println("Graph is Empty = true?  " + graph.isEmpty());
        System.out.println("Graph size is 0?  " + graph.size());
        System.out.println();

        System.out.println("Adding Kamloops...");
        graph.addVertex("Kamloops");

        System.out.println("Graph is connected = false?  " + graph.isEmpty());

        System.out.println("Adding Vernon...");
        graph.addVertex("Vernon");
        System.out.println("Graph is Empty = false?  " + graph.isEmpty());
        System.out.println("Graph size is 2?  " + graph.size());
        System.out.println("Graph is connected = false?  " + graph.isEmpty());
        System.out.println();
        System.out.println("Add edge by vertex between Kamloops and Vernon...");
        graph.addEdge("Kamloops", "Vernon");

        System.out.println("Get vertices...");
        System.out.println(Arrays.toString(graph.getVertices()));

        System.out.println();
        System.out.println(graph);
        System.out.println();

        System.out.println("Graph is connected = true?  " + graph.isConnected());

        System.out.println();

        System.out.println("Adding Kelowna...");
        graph.addVertex("Kelowna");

        System.out.println("Index of Kelowna is 2?  " + graph.getIndex("Kelowna"));
        System.out.println("Index of Merritt is -1?  " + graph.getIndex("Merritt"));
        System.out.println();

        System.out.println("Graph is connected = false?  " + graph.isConnected());
        System.out.println("Add edge between Vernon and Kelowna by index 1 , 2...");
        graph.addEdge(1, 2);
        System.out.println("Graph is connected = true?  " + graph.isConnected());
        System.out.println();

        System.out.println("Index 1 is valid = true?" + graph.indexIsValid(1));
        System.out.println("Index 3 is valid = false?" + graph.indexIsValid(3));
        System.out.println();

        System.out.println();
        System.out.println(graph);
        System.out.println();

        System.out.println("Removing Kamloops...");
        System.out.println("Graph is connected = true?  " + graph.isConnected());

        System.out.println("Removing edge between Kelowna and Vernon...");
        graph.removeEdge(graph.getIndex("Kelowna"), graph.getIndex("Vernon"));
        System.out.println("Graph is connected = false?  " + graph.isConnected());






    }
}
