import java.util.*;

// Edge class representing a connection between vertices
class Edge {
    int source;
    int dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

// Graph class using Adjacency List
public class Graph {
    private int numVertices; // Number of vertices
    private ArrayList<ArrayList<Edge>> adjacencyList; // Adjacency List

    // Constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge (undirected graph)
    public void addEdge(int source, int dest) {
        adjacencyList.get(source).add(new Edge(source, dest));
        adjacencyList.get(dest).add(new Edge(dest, source));
    }

    // Print the adjacency list
    public void getAllNeighbour() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }
    }

    // Breadth-First Search (BFS)
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Edge edge : adjacencyList.get(vertex)) {
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    queue.add(edge.dest);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS)
    public void DFS(int startVertex, boolean[] visited) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        for (Edge edge : adjacencyList.get(startVertex)) {
            if (!visited[edge.dest]) {
                DFS(edge.dest, visited);
            }
        }
    }

    // Wrapper function for DFS
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        System.out.print("DFS Traversal: ");
        DFS(startVertex, visited);
        System.out.println();
    }

    // Print all paths from source to destination in a directed graph
    public void printAllPaths(int source, int destination) {
        boolean[] visited = new boolean[numVertices];
        ArrayList<Integer> pathList = new ArrayList<>();

        pathList.add(source);
        System.out.println("All Paths from " + source + " to " + destination + ":");
        printAllPathsUtil(source, destination, visited, pathList);
    }

    private void printAllPathsUtil(int current, int destination, boolean[] visited, ArrayList<Integer> pathList) {
        if (current == destination) {
            System.out.println(pathList);
            return;
        }

        visited[current] = true;

        for (Edge edge : adjacencyList.get(current)) {
            if (!visited[edge.dest]) {
                pathList.add(edge.dest);
                printAllPathsUtil(edge.dest, destination, visited, pathList);
                pathList.remove(pathList.size() - 1);
            }
        }

        visited[current] = false;
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        Graph graph = new Graph(5); // Create a graph with 5 vertices

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        // Print adjacency list
        System.out.println("Adjacency List:");
        graph.getAllNeighbour();

        // Perform BFS and DFS Traversals
        graph.BFS(0);
        graph.DFS(0);

        // Directed Graph Example for finding all paths
        Graph directedGraph = new Graph(4);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(1, 3);

        directedGraph.printAllPaths(0, 3); // All paths from vertex 0 to 3
    }
}
