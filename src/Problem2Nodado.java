import java.util.*;

public class Problem2Nodado {

    public void solve() {
        // Test Case 1: Example adjacency matrix
        int[][] adjacencyMatrixNodado1 = {
            {0, 1, 1, 0, 0},
            {1, 0, 1, 1, 0},
            {1, 1, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 0, 1, 1, 0}
        };
        System.out.println("Test Case 1:");
        testGraphNodado(adjacencyMatrixNodado1);

        // Test Case 2: Fully connected graph
        int[][] adjacencyMatrixNodado2 = {
            {0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 0}
        };
        System.out.println("\nTest Case 2:");
        testGraphNodado(adjacencyMatrixNodado2);

        // Test Case 3: Disconnected graph
        int[][] adjacencyMatrixNodado3 = {
            {0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 1, 1, 0}
        };
        System.out.println("\nTest Case 3:");
        testGraphNodado(adjacencyMatrixNodado3);

        // Test Case 4: No edges
        int[][] adjacencyMatrixNodado4 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        System.out.println("\nTest Case 4:");
        testGraphNodado(adjacencyMatrixNodado4);

        // Test Case 5: Single node self-loop
        int[][] adjacencyMatrixNodado5 = {{1}};
        System.out.println("\nTest Case 5:");
        testGraphNodado(adjacencyMatrixNodado5);
    }

    private void testGraphNodado(int[][] adjacencyMatrixNodado) {
        // Count and list edges in the graph
        Map<String, Integer> edgeCountMapNodado = listAndCountEdgesNodado(adjacencyMatrixNodado);
        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entryNodado : edgeCountMapNodado.entrySet()) {
            System.out.println("Edge " + entryNodado.getKey() + ": " + entryNodado.getValue() + " time(s)");
        }
    }

    private Map<String, Integer> listAndCountEdgesNodado(int[][] adjacencyMatrixNodado) {
        Map<String, Integer> edgeCountMapNodado = new HashMap<>();
        int numNodesNodado = adjacencyMatrixNodado.length;
        // Iterate over the upper triangular portion of the matrix to avoid duplicate edges
        for (int i = 0; i < numNodesNodado; i++) {
            for (int j = i; j < numNodesNodado; j++) {
                // Check if an edge exists between nodes i and j
                if (adjacencyMatrixNodado[i][j] > 0) {
                    // Construct edge representation as "i-j"
                    String edgeNodado = i + "-" + j;
                    // Put the edge into the map with its count
                    edgeCountMapNodado.put(edgeNodado, adjacencyMatrixNodado[i][j]);
                }
            }
        }
        return edgeCountMapNodado;
    }
}
