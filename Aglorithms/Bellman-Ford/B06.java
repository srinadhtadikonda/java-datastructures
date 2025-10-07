 Bellman-Ford Algorithm with Negative Cycle Detection (Java)
import java.util.*;

class Graph {
    private int vertices;
    private int[][] adjMatrix;
    private String[] vertexData;

    // Constructor
    public Graph(int size) {
        this.vertices = size;
        adjMatrix = new int[size][size];
        vertexData = new String[size];
    }

    // Add edge with weight
    public void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < vertices && v >= 0 && v < vertices) {
            adjMatrix[u][v] = weight;
        }
    }

    // Add vertex data (like names A, B, C...)
    public void addVertexData(int vertex, String data) {
        if (vertex >= 0 && vertex < vertices) {
            vertexData[vertex] = data;
        }
    }

    // Bellman-Ford algorithm with negative cycle detection
    public void bellmanFord(String startVertexData) {
        int startVertex = -1;
        for (int i = 0; i < vertices; i++) {
            if (vertexData[i].equals(startVertexData)) {
                startVertex = i;
                break;
            }
        }

        if (startVertex == -1) {
            System.out.println("Start vertex not found!");
            return;
        }

        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 0; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                for (int v = 0; v < vertices; v++) {
                    if (adjMatrix[u][v] != 0 && distance[u] != Integer.MAX_VALUE) {
                        if (distance[u] + adjMatrix[u][v] < distance[v]) {
                            distance[v] = distance[u] + adjMatrix[u][v];
                            System.out.println("Relaxing edge " + vertexData[u] + " -> " + vertexData[v] +
                                    ", Updated distance to " + vertexData[v] + ": " + distance[v]);
                        }
                    }
                }
            }
        }

        // Check for negative-weight cycles
        boolean hasNegativeCycle = false;
        for (int u = 0; u < vertices; u++) {
            for (int v = 0; v < vertices; v++) {
                if (adjMatrix[u][v] != 0 && distance[u] != Integer.MAX_VALUE &&
                        distance[u] + adjMatrix[u][v] < distance[v]) {
                    hasNegativeCycle = true;
                    System.out.println("⚠️ Negative-weight cycle detected involving edge: "
                            + vertexData[u] + " -> " + vertexData[v]);
                }
            }
        }

        // Print results
        if (!hasNegativeCycle) {
            System.out.println("\nNo negative-weight cycles detected.");
            System.out.println("Shortest distances from vertex " + startVertexData + ":");
            for (int i = 0; i < vertices; i++) {
                System.out.println("Distance to " + vertexData[i] + ": " +
                        (distance[i] == Integer.MAX_VALUE ? "∞" : distance[i]));
            }
        }
    }
}

public class BellmanFordNegativeCycle {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");

        g.addEdge(3, 0, 4);   // D -> A
        g.addEdge(3, 2, 7);   // D -> C
        g.addEdge(3, 4, 3);   // D -> E
        g.addEdge(0, 2, 4);   // A -> C
        g.addEdge(2, 0, -3);  // C -> A
        g.addEdge(0, 4, 5);   // A -> E
        g.addEdge(4, 2, 3);   // E -> C
        g.addEdge(1, 2, -4);  // B -> C
        g.addEdge(4, 1, 2);   // E -> B

        System.out.println("\nThe Bellman-Ford Algorithm starting from vertex D:");
        g.bellmanFord("D");
    }
}
