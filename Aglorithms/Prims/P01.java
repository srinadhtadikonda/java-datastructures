import java.util.Arrays;

class Graph {
    private int[][] adjMatrix;
    private int size;
    private String[] vertexData;

    // Constructor
    public Graph(int size) {
        this.size = size;
        adjMatrix = new int[size][size];
        vertexData = new String[size];
    }

    // Add vertex data
    public void addVertexData(int vertex, String data) {
        if (vertex >= 0 && vertex < size) {
            vertexData[vertex] = data;
        }
    }

    // Add edge (undirected)
    public void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight; // undirected
        }
    }

    // Prim's algorithm
    public void primsAlgorithm() {
        boolean[] inMST = new boolean[size];
        int[] key = new int[size];
        int[] parent = new int[size];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0; // Start from vertex 0

        System.out.println("Edge \tWeight");

        for (int count = 0; count < size; count++) {
            // Pick the minimum key vertex not yet included in MST
            int u = -1;
            int minKey = Integer.MAX_VALUE;
            for (int v = 0; v < size; v++) {
                if (!inMST[v] && key[v] < minKey) {
                    minKey = key[v];
                    u = v;
                }
            }

            inMST[u] = true;

            // Print edge from parent[u] to u
            if (parent[u] != -1) {
                System.out.println(vertexData[parent[u]] + "-" + vertexData[u] + "\t" + adjMatrix[u][parent[u]]);
            }

            // Update key values and parent index
            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] != 0 && !inMST[v] && adjMatrix[u][v] < key[v]) {
                    key[v] = adjMatrix[u][v];
                    parent[v] = u;
                }
            }
        }
    }
}

public class PrimsAlgorithmDemo {
    public static void main(String[] args) {
        Graph g = new Graph(8);

        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");
        g.addVertexData(5, "F");
        g.addVertexData(6, "G");
        g.addVertexData(7, "H");

        g.addEdge(0, 1, 4);  // A - B
        g.addEdge(0, 3, 3);  // A - D
        g.addEdge(1, 2, 3);  // B - C
        g.addEdge(1, 3, 5);  // B - D
        g.addEdge(1, 4, 6);  // B - E
        g.addEdge(2, 4, 4);  // C - E
        g.addEdge(2, 7, 2);  // C - H
        g.addEdge(3, 4, 7);  // D - E
        g.addEdge(3, 5, 4);  // D - F
        g.addEdge(4, 5, 5);  // E - F
        g.addEdge(4, 6, 3);  // E - G
        g.addEdge(5, 6, 7);  // F - G
        g.addEdge(6, 7, 5);  // G - H

        System.out.println("Prim's Algorithm MST:");
        g.primsAlgorithm();
    }
}
