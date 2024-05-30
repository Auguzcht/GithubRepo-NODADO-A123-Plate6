import java.util.*;

public class Problem5Nodado {
    // Adjacency list to represent the graph
    private Map<Integer, List<Integer>> adjacencyListNodado;

    // Constructor to initialize the adjacency list
    public Problem5Nodado() {
        adjacencyListNodado = new HashMap<>();
    }

    public void solve() {
        // Test Case 1: Bipartite graph
        int[][] edgesNodado1 = {{0, 1}, {0, 3}, {1, 2}, {2, 3}};
        System.out.println("Test Case 1:");
        testGraph(edgesNodado1);

        // Test Case 2: Non-bipartite graph (odd-length cycle)
        int[][] edgesNodado2 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("\nTest Case 2:");
        testGraph(edgesNodado2);

        // Test Case 3: Disconnected bipartite graph
        int[][] edgesNodado3 = {{0, 1}, {2, 3}, {2, 4}};
        System.out.println("\nTest Case 3:");
        testGraph(edgesNodado3);

        // Test Case 4: Disconnected non-bipartite graph
        int[][] edgesNodado4 = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println("\nTest Case 4:");
        testGraph(edgesNodado4);

        // Test Case 5: Single node
        int[][] edgesNodado5 = {};
        System.out.println("\nTest Case 5:");
        testGraph(edgesNodado5);
    }

    // Method to test a graph with given edges
    private void testGraph(int[][] edgesNodado) {
        adjacencyListNodado.clear();
        constructGraph(edgesNodado);
        if (isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }

    // Method to construct the graph from the edges
    private void constructGraph(int[][] edgesNodado) {
        for (int[] edgeNodado : edgesNodado) {
            adjacencyListNodado.putIfAbsent(edgeNodado[0], new ArrayList<>());
            adjacencyListNodado.putIfAbsent(edgeNodado[1], new ArrayList<>());
            adjacencyListNodado.get(edgeNodado[0]).add(edgeNodado[1]);
            adjacencyListNodado.get(edgeNodado[1]).add(edgeNodado[0]);
        }
    }

    // Method to check if the graph is bipartite
    private boolean isBipartite() {
        // Map to store the color of each node
        Map<Integer, Integer> colorMapNodado = new HashMap<>();
        // Check each component of the graph
        for (int nodeNodado : adjacencyListNodado.keySet()) {
            if (!colorMapNodado.containsKey(nodeNodado)) {
                if (!bfsCheck(nodeNodado, colorMapNodado)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to perform BFS and check bipartiteness
    private boolean bfsCheck(int startNodeNodado, Map<Integer, Integer> colorMapNodado) {
        // Queue for BFS
        Queue<Integer> queueNodado = new LinkedList<>();
        queueNodado.offer(startNodeNodado);
        colorMapNodado.put(startNodeNodado, 0); // Start coloring with color 0

        while (!queueNodado.isEmpty()) {
            int nodeNodado = queueNodado.poll();
            int currentColorNodado = colorMapNodado.get(nodeNodado);
            int nextColorNodado = 1 - currentColorNodado; // Alternate color

            for (int neighborNodado : adjacencyListNodado.get(nodeNodado)) {
                if (!colorMapNodado.containsKey(neighborNodado)) {
                    colorMapNodado.put(neighborNodado, nextColorNodado);
                    queueNodado.offer(neighborNodado);
                } else if (colorMapNodado.get(neighborNodado) == currentColorNodado) {
                    return false; // Found same color on both ends of an edge
                }
            }
        }
        return true;
    }
}
