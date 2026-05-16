public class Experiment {
    private long[] bfsResults;
    private long[] dfsResults;
    private int[] sizes;

    public Experiment() {
        bfsResults = new long[3];
        dfsResults = new long[3];
        sizes = new int[]{10, 30, 100};
    }

    public void runTraversals(Graph g, int index) {
        long start = System.nanoTime();
        g.bfs(0);
        long end = System.nanoTime();
        bfsResults[index] = end - start;

        start = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();
        dfsResults[index] = end - start;
    }

    public void runMultipleTests() {
        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            System.out.println("\n--- Graph with " + size + " vertices ---");

            Graph g = new Graph(size);

            for (int v = 0; v < size - 1; v++) {
                g.addEdge(v, v + 1);
            }
            g.addEdge(0, size / 2);
            g.addEdge(1, size - 1);

            if (size == 10) {
                g.printGraph();
            }

            runTraversals(g, i);
        }
    }

    public void printResults() {
        System.out.println("\n========== RESULTS ==========");

        for (int i = 0; i < sizes.length; i++) {
            System.out.println("Graph size: " + sizes[i] + " vertices");
            System.out.println("  BFS time: " + bfsResults[i] + " ns");
            System.out.println("  DFS time: " + dfsResults[i] + " ns");
            System.out.println();
        }

        System.out.println("=============================");
    }
}