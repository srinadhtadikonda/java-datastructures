import java.util.Arrays;

class Graph {
    private int[][] adjMatrix;  				// adjacency matrix
    private int size;         				  // number of vertices
    private String[] vertexData; 			// vertex labels

  
  // Constructor
    public Graph(int size) {
        this.size = size;
        adjMatrix = new int[size][size];
        vertexData = new String[size];
    }

    // Add an undirected edge with weight
    public void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight;  // Undirected graph
        }
    }

    // Add a vertex label
    public void addVertexData(int vertex, String data) {
        if (vertex >= 0 && vertex < size) {
            vertexData[vertex] = data;
        }
    }

    



// Dijkstra’s algorithm implementation
    public int[] dijkstra(String startVertexData) 
{
        int startVertex = -1;
        // Find start vertex index
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
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int count = 0; count < size; count++) {
            int u = -1;
            int minDistance = Integer.MAX_VALUE;

          
  // Find the unvisited vertex with the smallest distance
            for (int i = 0; i < size; i++) {
                if (!visited[i] && distances[i] < minDistance) {
                    minDistance = distances[i];
                    u = i;
                }
            }

            if (u == -1) break; // No reachable vertices left
            visited[u] = true;
            // Relax edges
            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] != 0 && !visited[v]) {
                    int alt = distances[u] + adjMatrix[u][v];
                    if (alt < distances[v]) {
                        distances[v] = alt;
                    }
                }
            }
        }
        return distances;
    }





    // Display distances from a starting vertex
    public void printDijkstra(String startVertexData) {
        System.out.println("\nDijkstra's Algorithm starting from vertex " + startVertexData + ":");
        int[] distances = dijkstra(startVertexData);
        for (int i = 0; i < size; i++) 
{
            String distStr = (distances[i] == Integer.MAX_VALUE) ? "∞" : String.valueOf(distances[i]);
            System.out.println(vertexData[i] + " : " + distStr);
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Graph g = new Graph(7);

        // Add vertex labels
        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");
        g.addVertexData(5, "F");
        g.addVertexData(6, "G");

     
   // Add undirected edges with weights
        g.addEdge(3, 0, 4);  // D - A
        g.addEdge(3, 4, 2);  // D - E
        g.addEdge(0, 2, 3);  // A - C
        g.addEdge(0, 4, 4);  // A - E
        g.addEdge(4, 2, 4);  // E - C
        g.addEdge(4, 6, 5);  // E - G
        g.addEdge(2, 5, 5);  // C - F
        g.addEdge(2, 1, 2);  // C - B
        g.addEdge(1, 5, 2);  // B - F
        g.addEdge(6, 5, 5);  // G - F

        // Run Dijkstra from vertex D
        g.printDijkstra("D");
    }
}
