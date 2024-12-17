import java.util.*;

public class Graph {
    private int numVertices; // Number of vertices
    private ArrayList<Pair>[] graph; // Array of lists to represent the adjacency list

    // Constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        graph = new ArrayList[numVertices]; // Initialize array

        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>(); // Initialize each list
        }
    }

    // Pair class to represent node and weight
    public static class Pair implements Comparable<Pair> {
        public int node;   // Destination vertex
        public int weight; // Weight of the edge

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        // Compare two pairs by weight (for PriorityQueue)
        @Override
        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }

    // Add an edge (undirected graph)
    public void addEdge(int src, int dest, int weight) {
        graph[src].add(new Pair(dest, weight));
        graph[dest].add(new Pair(src, weight));
    }

    // Print the adjacency list of each vertex
    public void getAllNeighbour() {
        System.out.println("Adjacency List of the Graph:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Pair edge : graph[i]) {
                System.out.print("(Node: " + edge.node + ", Weight: " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Dijkstra's Algorithm to print shortest path distances
    public void dijkstra(int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] distance = new int[numVertices]; // Distance array
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Pair(source, 0));
        distance[source] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            for (Pair neighbor : graph[u]) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                if (distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    pq.add(new Pair(v, distance[v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + " -> " + distance[i]);
        }
    }

    // Prim's Algorithm to find the Minimum Spanning Tree
    public void primMST() {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] inMST = new boolean[numVertices];
        int[] key = new int[numVertices]; // Key values for selecting edges
        int[] parent = new int[numVertices]; // To store MST structure

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        pq.add(new Pair(0, 0)); // Start from vertex 0
        key[0] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            if (inMST[u]) continue; // Skip if already included in MST

            inMST[u] = true; // Include vertex in MST

            for (Pair neighbor : graph[u]) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Pair(v, key[v]));
                    parent[v] = u; // Update parent
                }
            }
        }

        System.out.println("Minimum Spanning Tree (Prim's Algorithm):");
        for (int i = 1; i < numVertices; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " (Weight: " + key[i] + ")");
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Adding edges
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // Print adjacency list
        graph.getAllNeighbour();

        // Dijkstra's Algorithm
        graph.dijkstra(0);

        // Prim's Algorithm
        graph.primMST();
    }
}
