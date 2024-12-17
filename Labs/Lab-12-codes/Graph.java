
public abstract class Graph {
    protected int[][] adjacencyMatrix; // 2D array to represent the graph
    protected int numVertices; // Number of vertices in the graph

    // Constructor to initialize the graph
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices]; // Initialize the matrix with 0s
    }

    // Add an edge between source and destination (undirected graph)
    public void addEdge(int source, int destination) {
        if (source < 0 || source >= numVertices || destination < 0 || destination >= numVertices) {
            throw new IllegalArgumentException("Invalid vertex number");
        }
        adjacencyMatrix[source][destination] = 1; // Add edge
        adjacencyMatrix[destination][source] = 1; // Undirected graph (symmetric)
    }

    // Print the adjacency matrix representation of the graph
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example implementation of the abstract class
        Graph graph = new Graph(5) { }; // Anonymous subclass of Graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        // Print the graph
        graph.printGraph();
    }
}
