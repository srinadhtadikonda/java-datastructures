Java Program — Bellman-Ford with Negative Cycle Detection
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
        }
    }

    public void addVertexData(int vertex, String data) {
        if (vertex >= 0 && vertex < size) {
            vertexData[vertex] = data;
        }
    }

    public void bellmanFord(String startVertexData) {
        int startVertex = -1;
        for (int i = 0; i < size; i++) {
            if (vertexData[i].equals(startVertexData)) {
                startVertex = i;
                break;
            }
        }

        if (startVertex == -1) {
            System.out.println("Start vertex not found: " + startVertexData);
            return;
        }

        int[] distances = new int[size];
        int[] predecessor = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        distances[startVertex] = 0;

        // Step 1: Relax all edges |V|-1 times
        for (int i = 0; i < size - 1; i++) {
            for (int u = 0; u < size; u++) {
                for (int v = 0; v < size; v++) {
                    if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                        if (distances[u] + adjMatrix[u][v] < distances[v]) {
                            distances[v] = distances[u] + adjMatrix[u][v];
                            predecessor[v] = u;
                        }
                    }
                }
            }
        }

        // Step 2: Check for negative weight cycles
        boolean hasNegativeCycle = false;
        for (int u = 0; u < size; u++) {
            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE
                        && distances[u] + adjMatrix[u][v] < distances[v]) {
                    System.out.println("\n⚠ Negative weight cycle detected involving edge "
                            + vertexData[u] + " -> " + vertexData[v]);
                    hasNegativeCycle = true;
                }
            }
        }

        // Step 3: Print results
        if (!hasNegativeCycle) {
            System.out.println("\n✅ No negative weight cycles detected.");
            System.out.println("\nShortest distances from " + startVertexData + ":");
            for (int i = 0; i < size; i++) {
                if (distances[i] == Integer.MAX_VALUE)
                    System.out.println("No path to " + vertexData[i]);
                else
                    System.out.println("Distance to " + vertexData[i] + ": " + distances[i]);
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

        // Add edges (some with negative weights)
        g.addEdge(0, 1, 1);   // A → B
        g.addEdge(1, 2, -1);  // B → C
        g.addEdge(2, 3, -1);  // C → D
        g.addEdge(3, 1, -1);  // D → B  (creates a negative cycle: B → C → D → B)
        g.addEdge(0, 4, 2);   // A → E

        System.out.println("🔍 Running Bellman-Ford Algorithm from vertex A:");
        g.bellmanFord("A");
    }
}
