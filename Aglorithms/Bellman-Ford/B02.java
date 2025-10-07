Java Program: Bellman-Ford with Path Reconstruction
import java.util.*;

class Graph {
    private int[][] adjMatrix;
    private int size;
    private String[] vertexData;

    public Graph(int size) {
        this.size = size;
        adjMatrix = new int[size][size];
        vertexData = new String[size];
    }

    public void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = weight;
            // adjMatrix[v][u] = weight; // Uncomment for undirected graph
        }
    }

    public void addVertexData(int vertex, String data) {
        if (vertex >= 0 && vertex < size) {
            vertexData[vertex] = data;
        }
    }

    public void bellmanFord(String startVertexData) {
        int startVertex = -1;

        // Find index of start vertex
        for (int i = 0; i < size; i++) {
            if (vertexData[i].equals(startVertexData)) {
                startVertex = i;
                break;
            }
        }

        if (startVertex == -1) {
            throw new IllegalArgumentException("Start vertex not found: " + startVertexData);
        }

        int[] distances = new int[size];
        int[] predecessor = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        distances[startVertex] = 0;

        // Relax edges |V|-1 times
        for (int i = 0; i < size - 1; i++) {
            for (int u = 0; u < size; u++) {
                for (int v = 0; v < size; v++) {
                    if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                        if (distances[u] + adjMatrix[u][v] < distances[v]) {
                            distances[v] = distances[u] + adjMatrix[u][v];
                            predecessor[v] = u;
                            System.out.println("Relaxing edge " + vertexData[u] + " -> " + vertexData[v]
                                    + ", Updated distance to " + vertexData[v] + ": " + distances[v]);
                        }
                    }
                }
            }
        }

        // Detect negative weight cycle (optional)
        for (int u = 0; u < size; u++) {
            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE
                        && distances[u] + adjMatrix[u][v] < distances[v]) {
                    System.out.println("Graph contains a negative weight cycle!");
                    return;
                }
            }
        }

        // Print distances and paths
        System.out.println("\nShortest distances and paths from " + startVertexData + ":");
        for (int i = 0; i < size; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("No path to " + vertexData[i]);
            } else {
                System.out.print("Distance to " + vertexData[i] + ": " + distances[i] + " | Path: ");
                printPath(predecessor, i);
                System.out.println();
            }
        }
    }

    // Helper method to print path recursively
    private void printPath(int[] predecessor, int vertex) {
        if (vertex == -1)
            return;
        if (predecessor[vertex] != -1) {
            printPath(predecessor, predecessor[vertex]);
        }
        System.out.print(vertexData[vertex] + " ");
    }
}

public class BellmanFordWithPaths {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");

        g.addEdge(3, 0, 4);  // D -> A, weight 4
        g.addEdge(3, 2, 7);  // D -> C, weight 7
        g.addEdge(3, 4, 3);  // D -> E, weight 3
        g.addEdge(0, 2, 4);  // A -> C, weight 4
        g.addEdge(2, 0, -3); // C -> A, weight -3
        g.addEdge(0, 4, 5);  // A -> E, weight 5
        g.addEdge(4, 2, 3);  // E -> C, weight 3
        g.addEdge(1, 2, -4); // B -> C, weight -4
        g.addEdge(4, 1, 2);  // E -> B, weight 2

        System.out.println("\nThe Bellman-Ford Algorithm starting from vertex D:");
        g.bellmanFord("D");
    }
}
