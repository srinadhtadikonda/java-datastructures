Java Program — Dijkstra’s Algorithm (Single Source → Single Destination)
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
            adjMatrix[v][u] = weight; // Undirected graph
        }
    }

    public void addVertexData(int vertex, String data) {
        if (vertex >= 0 && vertex < size) {
            vertexData[vertex] = data;
        }
    }

    public PathResult dijkstra(String startVertexData, String endVertexData) {
        int start = findVertexIndex(startVertexData);
        int end = findVertexIndex(endVertexData);

        if (start == -1 || end == -1) {
            throw new IllegalArgumentException("Invalid vertex data provided!");
        }

        int[] distances = new int[size];
        boolean[] visited = new boolean[size];
        int[] previous = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);

        distances[start] = 0;

        for (int count = 0; count < size - 1; count++) {
            int u = minDistance(distances, visited);
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < size; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 &&
                    distances[u] != Integer.MAX_VALUE &&
                    distances[u] + adjMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjMatrix[u][v];
                    previous[v] = u;
                }
            }
        }

        List<String> path = new ArrayList<>();
        if (distances[end] != Integer.MAX_VALUE) {
            buildPath(previous, end, path);
        }

        return new PathResult(vertexData[start], vertexData[end], distances[end], path);
    }

    private int findVertexIndex(String vertex) {
        for (int i = 0; i < size; i++) {
            if (vertexData[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    private int minDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < size; v++) {
            if (!visited[v] && distances[v] < min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void buildPath(int[] previous, int vertex, List<String> path) {
        if (vertex == -1) return;
        buildPath(previous, previous[vertex], path);
        path.add(vertexData[vertex]);
    }
}

class PathResult {
    String start;
    String end;
    int distance;
    List<String> path;

    public PathResult(String start, String end, int distance, List<String> path) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.path = path;
    }

    public void printResult() {
        if (distance == Integer.MAX_VALUE) {
            System.out.println("No path exists from " + start + " to " + end);
        } else {
            System.out.println("Shortest path from " + start + " to " + end + ":");
            System.out.println(String.join(" → ", path));
            System.out.println("Total distance: " + distance);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");
        g.addVertexData(5, "F");
        g.addVertexData(6, "G");

        g.addEdge(3, 0, 4); // D - A
        g.addEdge(3, 4, 2); // D - E
        g.addEdge(0, 2, 3); // A - C
        g.addEdge(0, 4, 4); // A - E
        g.addEdge(4, 2, 4); // E - C
        g.addEdge(4, 6, 5); // E - G
        g.addEdge(2, 5, 5); // C - F
        g.addEdge(2, 1, 2); // C - B
        g.addEdge(1, 5, 2); // B - F
        g.addEdge(6, 5, 5); // G - F

        // Example: Find shortest path from D to F
        PathResult result = g.dijkstra("D", "F");
        result.printResult();
    }
}
