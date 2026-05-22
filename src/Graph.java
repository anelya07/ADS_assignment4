import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V;
    private int E;
    LinkedList<int[]> adj[];

    public Graph(int nodes) {
        V = nodes;
        E = 0;
        this.adj = new LinkedList[nodes];

        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addVertex(Vertex v) {
        System.out.println("Vertex " + v.getId() + " is in the graph.");
    }

    public void addEdge(int u, int v) {
        adj[u].add(new int[]{v, 1});
        adj[v].add(new int[]{u, 1});
        E++;
    }

    public void addWeightedEdge(int u, int v, int weight) {
        adj[u].add(new int[]{v, weight});
        adj[v].add(new int[]{u, weight});
        E++;
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");
        for (int v = 0; v < V; v++) {
            System.out.print("AdjList[" + v + "]: ");
            for (int w = 0; w < adj[v].size(); w++) {
                int neighbor = adj[v].get(w)[0];
                int weight = adj[v].get(w)[1];
                System.out.print("(" + neighbor + ", weight=" + weight + ") ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        visited[start] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        System.out.print("BFS: ");

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int w = 0; w < adj[u].size(); w++) {
                int neighbor = adj[u].get(w)[0];
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS: ");
        visitVertex(start, visited);
        System.out.println();
    }

    private void visitVertex(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int w = 0; w < adj[v].size(); w++) {
            int neighbor = adj[v].get(w)[0];
            if (!visited[neighbor]) {
                visitVertex(neighbor, visited);
            }
        }
    }

    public void dijkstra(int start) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        for (int i = 0; i < V; i++) {
            int u = -1;
            for (int v = 0; v < V; v++) {
                if (!visited[v] && (u == -1 || dist[v] < dist[u])) {
                    u = v;
                }
            }
            if (u == -1 || dist[u] == Integer.MAX_VALUE) {
                break;
            }
            visited[u] = true;

            for (int w = 0; w < adj[u].size(); w++) {
                int neighbor = adj[u].get(w)[0];
                int weight = adj[u].get(w)[1];

                if (dist[u] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[u] + weight;
                }
            }
        }

        System.out.println("Dijkstra shortest paths from vertex " + start + ":");
        for (int v = 0; v < V; v++) {
            if (dist[v] == Integer.MAX_VALUE) {
                System.out.println("  Vertex " + v + ": unreachable");
            } else {
                System.out.println("  Vertex " + v + ": " + dist[v]);
            }
        }
    }
}
