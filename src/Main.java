public class Main {

    public static void main(String[] args) {
        Experiment experiment = new Experiment();
        experiment.runMultipleTests();
        experiment.printResults();

        System.out.println("\n==== Dijkstra Algorithm =====");
        Graph g = new Graph(6);
        g.addWeightedEdge(0, 1, 4);
        g.addWeightedEdge(0, 2, 2);
        g.addWeightedEdge(1, 3, 5);
        g.addWeightedEdge(2, 3, 1);
        g.addWeightedEdge(2, 4, 3);
        g.addWeightedEdge(3, 5, 2);
        g.addWeightedEdge(4, 5, 4);

        g.printGraph();
        System.out.println();
        g.dijkstra(0);
    }
}