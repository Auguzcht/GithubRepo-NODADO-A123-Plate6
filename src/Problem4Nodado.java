import java.util.*;

public class Problem4Nodado {
    // Adjacency list representation of the graph
    private Map<Integer, List<Integer>> adjacencyListNodado;

    public Problem4Nodado() {
        adjacencyListNodado = new HashMap<>();
    }

    public void solve() {
        // Test Case 1: Example graph
        int[][] edgesNodado1 = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println("Test Case 1:");
        testGraph(edgesNodado1);

        // Test Case 2: Graph with isolated node
        int[][] edgesNodado2 = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println("\nTest Case 2:");
        testGraph(edgesNodado2);

        // Test Case 3: Single node graph
        int[][] edgesNodado3 = {};
        System.out.println("\nTest Case 3:");
        testGraph(edgesNodado3);

        // Test Case 4: Fully connected graph
        int[][] edgesNodado4 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};
        System.out.println("\nTest Case 4:");
        testGraph(edgesNodado4);

        // Test Case 5: Disconnected graph
        int[][] edgesNodado5 = {{0, 1}, {2, 3}, {3, 4}, {4, 2}};
        System.out.println("\nTest Case 5:");
        testGraph(edgesNodado5);
    }

    private void testGraph(int[][] edgesNodado) {
        adjacencyListNodado.clear(); // Clear previous graph data
        constructGraph(edgesNodado); // Construct the graph from edges
        Map<Integer, Integer> degreeMapNodado = calculateDegrees(); // Calculate degrees of vertices
        System.out.println("Degrees of vertices:");
        for (Map.Entry<Integer, Integer> entryNodado : degreeMapNodado.entrySet()) {
            System.out.println("d(" + entryNodado.getKey() + "): " + entryNodado.getValue());
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

    private Map<Integer, Integer> calculateDegrees() {
        Map<Integer, Integer> degreeMapNodado = new HashMap<>();
        // Calculate degrees of vertices
        for (int vertexNodado : adjacencyListNodado.keySet()) {
            degreeMapNodado.put(vertexNodado, adjacencyListNodado.get(vertexNodado).size());
        }
        return degreeMapNodado;
    }
}
