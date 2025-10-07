 Bellman-Ford with All Negative Cycle Detection
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

        int[] dist = new int[size];
        int[] predecessor = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        dist[startVertex] = 0;

        // Step 1: Relax all edges |V|-1 times
        for (int i = 0; i < size - 1; i++) {
            for (int u = 0; u < size; u++) {
                for (int v = 0; v < size; v++) {
                    if (adjMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
                        if (dist[u] + adjMatrix[u][v] < dist[v]) {
                            dist[v] = dist[u] + adjMatrix[u][v];
                            predecessor[v] = u;
                        }
                    }
                }
            }
        }

        // Step 2: Detect all negative cycles
        Set<String> uniqueCycles = new HashSet<>();
        boolean hasNegativeCycle = false;

        for (int u = 0; u < size; u++) {
            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + adjMatrix[u][v] < dist[v]) {

                    hasNegativeCycle = true;
                    predecessor[v] = u;

                    int y = v;
                    for (int i = 0; i < size; i++) {
                        y = predecessor[y]; // Go |V| steps to ensure inside the cycle
                    }

                    List<Integer> cycle = new ArrayList<>();
                    Set<Integer> seen = new HashSet<>();

                    for (int cur = y;; cur = predecessor[cur]) {
                        if (seen.contains(cur)) break;
                        seen.add(cur);
                        cycle.add(cur);
                    }

                    Collections.reverse(cycle);

                    // Create canonical string representation (sorted to avoid duplicates)
                    String cycleKey = getCanonicalCycleKey(cycle);

                    if (!uniqueCycles.contains(cycleKey)) {
                        uniqueCycles.add(cycleKey);
                        System.out.print("⚠ Negative cycle detected: ");
                        for (int node : cycle) {
                            System.out.print(vertexData[node] + " ");
                        }
                        System.out.println(vertexData[cycle.get(0)]); // Close the loop
                    }
                }
            }
        }

        if (!hasNegativeCycle) {
            System.out.println("\n✅ No negative weight cycles detected.");
            System.out.println("\nShortest distances from " + startVertexData + ":");
            for (int i = 0; i < size; i++) {
                if (dist[i] == Integer.MAX_VALUE)
                    System.out.println("No path to " + vertexData[i]);
                else
                    System.out.println("Distance to " + vertexData[i] + ": " + dist[i]);
            }
        }
    }

    private String getCanonicalCycleKey(List<Integer> cycle) {
        // Rotate cycle so smallest vertex index is first — ensures same cycle order
        int minIndex = 0;
        for (int i = 1; i < cycle.size(); i++) {
            if (cycle.get(i) < cycle.get(minIndex)) {
                minIndex = i;
            }
        }

        List<Integer> rotated = new ArrayList<>();
        for (int i = 0; i < cycle.size(); i++) {
            rotated.add(cycle.get((i + minIndex) % cycle.size()));
        }
        return rotated.toString();
    }
}

public class BellmanFordAllNegativeCycles {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");
        g.addVertexData(5, "F");

        // Two separate negative cycles
        g.addEdge(0, 1, 1);   // A → B
        g.addEdge(1, 2, -2);  // B → C
        g.addEdge(2, 0, -2);  // C → A (Cycle 1: A-B-C-A)

        g.addEdge(3, 4, -1);  // D → E
        g.addEdge(4, 5, -2);  // E → F
        g.addEdge(5, 3, -1);  // F → D (Cycle 2: D-E-F-D)

        System.out.println("🔍 Running Bellman-Ford Algorithm from vertex A:");
        g.bellmanFord("A");
    }
}
