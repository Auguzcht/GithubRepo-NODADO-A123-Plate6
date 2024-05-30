import java.util.*;

public class Problem7Nodado {
    // Incidence matrix to represent the graph
    private int[][] incidenceMatrixNodado;

    // Constructor
    public Problem7Nodado() {}

    // Method to solve the problem with different test cases
    public void solve() {
        // Test Case 1: Example graph
        int[][] edgesNodado1 = {
            {0, 1, 2},
            {0, 2, 1},
            {1, 2, 1},
            {2, 3, 1}
        };
        System.out.println("Test Case 1:");
        testGraph(edgesNodado1, 4);

        // Test Case 2: Graph with multiple edges
        int[][] edgesNodado2 = {
            {0, 1, 2},
            {0, 2, 1},
            {1, 2, 2},
            {2, 3, 1}
        };
        System.out.println("\nTest Case 2:");
        testGraph(edgesNodado2, 4);

        // Test Case 3: Graph with loops
        int[][] edgesNodado3 = {
            {0, 0, 2},
            {0, 2, 1},
            {1, 1, 1},
            {2, 3, 1}
        };
        System.out.println("\nTest Case 3:");
        testGraph(edgesNodado3, 4);

        // Test Case 4: Graph with isolated nodes
        int[][] edgesNodado4 = {
            {0, 1, 1},
            {1, 2, 1},
            {3, 4, 1}
        };
        System.out.println("\nTest Case 4:");
        testGraph(edgesNodado4, 5);

        // Test Case 5: Single edge
        int[][] edgesNodado5 = {
            {0, 1, 1}
        };
        System.out.println("\nTest Case 5:");
        testGraph(edgesNodado5, 2);
    }

    // Method to test a graph with given edges and number of vertices
    private void testGraph(int[][] edgesNodado, int numVerticesNodado) {
        constructIncidenceMatrix(edgesNodado, numVerticesNodado);
        System.out.println("Incidence Matrix:");
        printIncidenceMatrix();
    }

    // Method to construct the incidence matrix from the edges
    private void constructIncidenceMatrix(int[][] edgesNodado, int numVerticesNodado) {
        int numEdgesNodado = edgesNodado.length;
        incidenceMatrixNodado = new int[numVerticesNodado][numEdgesNodado];
        for (int iNodado = 0; iNodado < numEdgesNodado; iNodado++) {
            int vertex1Nodado = edgesNodado[iNodado][0];
            int vertex2Nodado = edgesNodado[iNodado][1];
            int multiplicityNodado = edgesNodado[iNodado][2];
            // Set the incidence of the edge in the matrix
            incidenceMatrixNodado[vertex1Nodado][iNodado] = multiplicityNodado;
            incidenceMatrixNodado[vertex2Nodado][iNodado] = multiplicityNodado;
        }
    }

    // Method to print the incidence matrix
    private void printIncidenceMatrix() {
        for (int iNodado = 0; iNodado < incidenceMatrixNodado.length; iNodado++) {
            for (int jNodado = 0; jNodado < incidenceMatrixNodado[iNodado].length; jNodado++) {
                System.out.print(incidenceMatrixNodado[iNodado][jNodado] + " ");
            }
            System.out.println();
        }
    }
}
