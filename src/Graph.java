import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V;
    private int E;
    LinkedList<Integer> adj[];

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
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");
        for (int v = 0; v < V; v++) {
            System.out.print("AdjList[" + v + "]: ");
            for (int w = 0; w < adj[v].size(); w++) {
                System.out.print(adj[v].get(w) + " ");
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
                if (!visited[adj[u].get(w)]) {
                    visited[adj[u].get(w)] = true;
                    q.add(adj[u].get(w));
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
            if (!visited[adj[v].get(w)]) {
                visitVertex(adj[v].get(w), visited);
            }
        }
    }
}
