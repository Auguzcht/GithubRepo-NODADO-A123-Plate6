import java.util.*;

public class Problem6Nodado {
    // Adjacency matrix to represent the graph
    private int[][] adjacencyMatrixNodado;

    // Constructor
    public Problem6Nodado() {}

    // Method to solve the problem with different test cases
    public void solve() {
        // Test Case 1: Undirected graph with loops and multiple edges
        int[][] edgesNodado1 = {{0, 1}, {0, 1}, {1, 2}, {2, 0}, {2, 2}};
        System.out.println("Test Case 1:");
        testGraph(edgesNodado1, 3, false);

        // Test Case 2: Directed graph
        int[][] edgesNodado2 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("\nTest Case 2:");
        testGraph(edgesNodado2, 3, true);

        // Test Case 3: Graph with isolated node
        int[][] edgesNodado3 = {{0, 1}, {1, 2}};
        System.out.println("\nTest Case 3:");
        testGraph(edgesNodado3, 4, false);

        // Test Case 4: Fully connected directed graph
        int[][] edgesNodado4 = {{0, 1}, {0, 2}, {1, 2}, {1, 0}, {2, 0}, {2, 1}};
        System.out.println("\nTest Case 4:");
        testGraph(edgesNodado4, 3, true);

        // Test Case 5: Single node with loop
        int[][] edgesNodado5 = {{0, 0}};
        System.out.println("\nTest Case 5:");
        testGraph(edgesNodado5, 1, false);
    }

    // Method to test a graph with given edges, number of vertices, and whether it is directed
    private void testGraph(int[][] edgesNodado, int numVerticesNodado, boolean directedNodado) {
        constructAdjacencyMatrix(edgesNodado, numVerticesNodado, directedNodado);
        System.out.println("Adjacency Matrix:");
        printAdjacencyMatrix();
    }

    // Method to construct the adjacency matrix from the edges
    private void constructAdjacencyMatrix(int[][] edgesNodado, int numVerticesNodado, boolean directedNodado) {
        adjacencyMatrixNodado = new int[numVerticesNodado][numVerticesNodado];
        for (int[] edgeNodado : edgesNodado) {
            int fromNodado = edgeNodado[0];
            int toNodado = edgeNodado[1];
            adjacencyMatrixNodado[fromNodado][toNodado]++;
            // If the graph is undirected, add the edge in both directions
            if (!directedNodado && fromNodado != toNodado) {
                adjacencyMatrixNodado[toNodado][fromNodado]++;
            }
        }
    }

    // Method to print the adjacency matrix
    private void printAdjacencyMatrix() {
        for (int iNodado = 0; iNodado < adjacencyMatrixNodado.length; iNodado++) {
            for (int jNodado = 0; jNodado < adjacencyMatrixNodado[iNodado].length; jNodado++) {
                System.out.print(adjacencyMatrixNodado[iNodado][jNodado] + " ");
            }
            System.out.println();
        }
    }
}
