Java Program — Returning Paths from Dijkstra’s Algorithm
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

    public Result dijkstra(String startVertexData) {
        int startVertex = -1;
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
        boolean[] visited = new boolean[size];
        int[] previous = new int[size];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distances[startVertex] = 0;

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

        // Construct readable paths
        Map<String, List<String>> paths = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            List<String> path = new ArrayList<>();
            if (distances[i] != Integer.MAX_VALUE) {
                buildPath(previous, i, path);
            }
            paths.put(vertexData[i], path);
        }

        return new Result(vertexData[startVertex], vertexData, distances, paths);
    }

    private int minDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
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

class Result {
    String startVertex;
    String[] vertexData;
    int[] distances;
    Map<String, List<String>> paths;

    public Result(String startVertex, String[] vertexData, int[] distances, Map<String, List<String>> paths) {
        this.startVertex = startVertex;
        this.vertexData = vertexData;
        this.distances = distances;
        this.paths = paths;
    }

    public Map<String, List<String>> getPaths() {
        return paths;
    }

    public int[] getDistances() {
        return distances;
    }

    public void printPaths() {
        for (int i = 0; i < vertexData.length; i++) {
            List<String> path = paths.get(vertexData[i]);
            if (path.isEmpty()) {
                System.out.println("No path from " + startVertex + " to " + vertexData[i]);
            } else {
                System.out.println("Path from " + startVertex + " to " + vertexData[i] + ": " +
                        String.join(" → ", path) + " | Distance: " + distances[i]);
            }
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

        Result result = g.dijkstra("D");
        System.out.println("\nDijkstra's Algorithm starting from vertex D:");
        result.printPaths();

        // Example: Accessing returned data programmatically
        System.out.println("\nReturned Path Example:");
        List<String> pathToF = result.getPaths().get("F");
        System.out.println("Shortest path from D to F: " + String.join(" → ", pathToF));
    }
}
