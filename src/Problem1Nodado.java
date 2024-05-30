import java.util.*;

public class Problem1Nodado {
    // Adjacency list representation of the graph
    private Map<Integer, List<Integer>> adjacencyListNodado;
    // Array to keep track of visited nodes during DFS traversal
    private boolean[] visitedNodado;

    public Problem1Nodado() {
        adjacencyListNodado = new HashMap<>();
    }

    public void solve() {
        // Test Case 1: Connected graph
        int[][] edgesNodado1 = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println("Test Case 1:");
        testGraph(edgesNodado1);

        // Test Case 2: Disconnected graph with two components
        int[][] edgesNodado2 = {{0, 1}, {0, 2}, {3, 4}};
        System.out.println("\nTest Case 2:");
        testGraph(edgesNodado2);

        // Test Case 3: Single node
        int[][] edgesNodado3 = {};
        System.out.println("\nTest Case 3:");
        testGraph(edgesNodado3);

        // Test Case 4: Disconnected graph with multiple components
        int[][] edgesNodado4 = {{0, 1}, {2, 3}, {4, 5}};
        System.out.println("\nTest Case 4:");
        testGraph(edgesNodado4);

        // Test Case 5: Larger connected graph
        int[][] edgesNodado5 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 0}};
        System.out.println("\nTest Case 5:");
        testGraph(edgesNodado5);
    }

    private void testGraph(int[][] edgesNodado) {
        adjacencyListNodado.clear(); // Clear previous graph data
        constructGraph(edgesNodado); // Construct the graph from edges
        if (isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int connectedComponentsNodado = findConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponentsNodado);
        }
    }

    private void constructGraph(int[][] edgesNodado) {
        // Build adjacency list representation of the graph
        for (int[] edgeNodado : edgesNodado) {
            adjacencyListNodado.putIfAbsent(edgeNodado[0], new ArrayList<>());
            adjacencyListNodado.putIfAbsent(edgeNodado[1], new ArrayList<>());
            adjacencyListNodado.get(edgeNodado[0]).add(edgeNodado[1]);
            adjacencyListNodado.get(edgeNodado[1]).add(edgeNodado[0]);
        }
    }

    private boolean isConnected() {
        if (adjacencyListNodado.isEmpty()) {
            return true; // A graph with no nodes is trivially connected
        }
        int nodeCountNodado = adjacencyListNodado.size();
        visitedNodado = new boolean[nodeCountNodado];
        // Perform DFS traversal from the first node
        dfs(0);
        // Check if all nodes are visited
        for (boolean isVisitedNodado : visitedNodado) {
            if (!isVisitedNodado) {
                return false; // Graph is not connected
            }
        }
        return true; // Graph is connected
    }

    private void dfs(int nodeNodado) {
        // Mark current node as visited
        visitedNodado[nodeNodado] = true;
        // Recursively visit neighbors
        for (int neighborNodado : adjacencyListNodado.getOrDefault(nodeNodado, new ArrayList<>())) {
            if (!visitedNodado[neighborNodado]) {
                dfs(neighborNodado);
            }
        }
    }

    private int findConnectedComponents() {
        if (adjacencyListNodado.isEmpty()) {
            return 0; // No nodes means no components
        }
        int nodeCountNodado = adjacencyListNodado.size();
        visitedNodado = new boolean[nodeCountNodado];
        int componentsNodado = 0;
        // Perform DFS traversal from each unvisited node
        for (int nodeNodado : adjacencyListNodado.keySet()) {
            if (!visitedNodado[nodeNodado]) {
                dfs(nodeNodado);
                componentsNodado++; // Increment component count for each traversal
            }
        }
        return componentsNodado; // Return total connected components
    }
}