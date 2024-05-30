import java.util.*;

public class Problem3Nodado {
    // Adjacency list representation of the graph
    private Map<Integer, List<Integer>> adjacencyListNodado;
    // Array to keep track of visited nodes during DFS traversal
    private boolean[] visitedNodado;

    public Problem3Nodado() {
        adjacencyListNodado = new HashMap<>();
    }

    public void solve() {
        // Test Case 1: Graph with a cycle
        int[][] edgesNodado1 = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        System.out.println("Test Case 1:");
        testGraph(edgesNodado1);

        // Test Case 2: Graph without a cycle
        int[][] edgesNodado2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("\nTest Case 2:");
        testGraph(edgesNodado2);

        // Test Case 3: Disconnected graph with a cycle in one component
        int[][] edgesNodado3 = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println("\nTest Case 3:");
        testGraph(edgesNodado3);

        // Test Case 4: Disconnected graph without a cycle
        int[][] edgesNodado4 = {{0, 1}, {2, 3}};
        System.out.println("\nTest Case 4:");
        testGraph(edgesNodado4);

        // Test Case 5: Single node without edges
        int[][] edgesNodado5 = {};
        System.out.println("\nTest Case 5:");
        testGraph(edgesNodado5);
    }

    private void testGraph(int[][] edgesNodado) {
        adjacencyListNodado.clear(); // Clear previous graph data
        constructGraph(edgesNodado); // Construct the graph from edges
        if (hasCycle()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
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

    private boolean hasCycle() {
        visitedNodado = new boolean[adjacencyListNodado.size()];
        // Iterate over each node and perform DFS
        for (int nodeNodado : adjacencyListNodado.keySet()) {
            if (!visitedNodado[nodeNodado]) {
                // If a cycle is detected, return true
                if (dfs(nodeNodado, -1)) {
                    return true;
                }
            }
        }
        return false; // No cycle found
    }

    private boolean dfs(int nodeNodado, int parentNodado) {
        visitedNodado[nodeNodado] = true; // Mark current node as visited
        // Traverse neighbors of the current node
        for (int neighborNodado : adjacencyListNodado.get(nodeNodado)) {
            if (!visitedNodado[neighborNodado]) {
                // Recursively visit unvisited neighbors
                if (dfs(neighborNodado, nodeNodado)) {
                    return true; // Cycle detected in the subtree
                }
            } else if (neighborNodado != parentNodado) {
                return true; // Back edge detected
            }
        }
        return false; // No cycle found in the subtree rooted at the current node
    }
}
