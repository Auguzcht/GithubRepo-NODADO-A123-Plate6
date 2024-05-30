import java.util.*;

public class Problem8Nodado {
    // Graph representations using adjacency lists
    private Map<Integer, List<Integer>> graph1Nodado;
    private Map<Integer, List<Integer>> graph2Nodado;

    // Constructor
    public Problem8Nodado() {}

    // Method to solve the problem with different test cases
    public void solve() {
        // Test Case 1: Isomorphic graphs
        int[][] edgesGraph1 = {{0, 1}, {0, 2}, {1, 3}, {2, 4}};
        int[][] edgesGraph2 = {{0, 1}, {0, 2}, {1, 4}, {2, 3}};
        System.out.println("Test Case 1:");
        testIsomorphism(edgesGraph1, edgesGraph2, 5);

        // Test Case 2: Non-isomorphic graphs with different number of vertices
        int[][] edgesGraph3 = {{0, 1}, {1, 2}, {2, 0}};
        int[][] edgesGraph4 = {{0, 1}, {1, 2}};
        System.out.println("\nTest Case 2:");
        testIsomorphism(edgesGraph3, edgesGraph4, 3);

        // Test Case 3: Non-isomorphic graphs with same number of vertices
        int[][] edgesGraph5 = {{0, 1}, {0, 2}};
        int[][] edgesGraph6 = {{0, 1}, {1, 2}};
        System.out.println("\nTest Case 3:");
        testIsomorphism(edgesGraph5, edgesGraph6, 3);

        // Test Case 4: Isomorphic graphs with different edge multiplicities
        int[][] edgesGraph7 = {{0, 1}, {0, 2}, {0, 2}, {1, 3}};
        int[][] edgesGraph8 = {{0, 1}, {0, 2}, {1, 2}, {1, 3}};
        System.out.println("\nTest Case 4:");
        testIsomorphism(edgesGraph7, edgesGraph8, 4);

        // Test Case 5: Isomorphic graphs with different edge orders
        int[][] edgesGraph9 = {{0, 1}, {1, 2}, {2, 0}};
        int[][] edgesGraph10 = {{1, 2}, {2, 0}, {0, 1}};
        System.out.println("\nTest Case 5:");
        testIsomorphism(edgesGraph9, edgesGraph10, 3);
    }

    // Method to test if two graphs are isomorphic
    private void testIsomorphism(int[][] edgesGraph1, int[][] edgesGraph2, int numVertices) {
        constructGraphs(edgesGraph1, edgesGraph2, numVertices);
        if (areIsomorphic()) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }

    // Method to construct graphs from edge lists
    private void constructGraphs(int[][] edgesGraph1, int[][] edgesGraph2, int numVertices) {
        graph1Nodado = constructGraph(edgesGraph1, numVertices);
        graph2Nodado = constructGraph(edgesGraph2, numVertices);
    }

    // Helper method to construct a graph from edge list
    private Map<Integer, List<Integer>> constructGraph(int[][] edges, int numVertices) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }
        return graph;
    }

    // Method to check if two graphs are isomorphic
    private boolean areIsomorphic() {
        if (graph1Nodado.size() != graph2Nodado.size()) {
            return false; // Different number of vertices
        }
        // Check if the adjacency structures match
        return isIsomorphicHelper(new ArrayList<>(graph1Nodado.values()), new ArrayList<>(graph2Nodado.values()));
    }

    // Helper method to compare adjacency lists for isomorphism
    private boolean isIsomorphicHelper(List<List<Integer>> adjacencyList1, List<List<Integer>> adjacencyList2) {
        // Sort adjacency lists based on their sizes for efficiency
        adjacencyList1.sort(Comparator.comparing(List::size));
        adjacencyList2.sort(Comparator.comparing(List::size));

        // Check if the sorted lists match
        for (int i = 0; i < adjacencyList1.size(); i++) {
            if (adjacencyList1.get(i).size() != adjacencyList2.get(i).size()) {
                return false; // Different degrees of vertices
            }
        }
        return true;
    }
}
