Full Java Program (with shortest paths)
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

        return new Result(distances, previous, vertexData, startVertex);
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

    public String getVertexData(int index) {
        return vertexData[index];
    }
}

class Result {
    int[] distances;
    int[] previous;
    String[] vertexData;
    int startVertex;

    public Result(int[] distances, int[] previous, String[] vertexData, int startVertex) {
        this.distances = distances;
        this.previous = previous;
        this.vertexData = vertexData;
        this.startVertex = startVertex;
    }

    public void printPaths() {
        for (int i = 0; i < distances.length; i++) {
            System.out.print("Path from " + vertexData[startVertex] + " to " + vertexData[i] + ": ");
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("No path");
            } else {
                printPath(i);
                System.out.println(" | Distance: " + distances[i]);
            }
        }
    }

    private void printPath(int vertex) {
        if (previous[vertex] == -1) {
            System.out.print(vertexData[vertex]);
            return;
        }
        printPath(previous[vertex]);
        System.out.print(" → " + vertexData[vertex]);
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

        System.out.println("\nDijkstra's Algorithm starting from vertex D:");
        Result result = g.dijkstra("D");
        result.printPaths();
    }
}
