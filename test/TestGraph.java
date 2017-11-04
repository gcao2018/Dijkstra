/** tester class for Graph */
/**public class TestGraph {

    @Test
    public final void testGetters() {
        Graph graph = new Graph();
        Assert.assertEquals(graph.getNodes(),
                new HashMap<Integer, ArrayList<Path>>());
        Assert.assertEquals(graph.getDisconnectedPaths(),
                new ArrayList<Path>());
    }

    @Test
    public final void testConnectEdges() {
        Path path0 = new Path(0, 1, 3);
        Path path_0 = new Path(1, 0, 3);
        Graph graph = new Graph();
        graph.connectEdge(path0);
        Assert.assertTrue(graph.getNodes().get(0).contains(path0));
        Assert.assertTrue(graph.getNodes().get(1).contains(path0));
        Assert.assertTrue(graph.getNodes().get(0).contains(path_0));
        Assert.assertTrue(graph.getNodes().get(1).contains(path_0));
    }

    @Test
    public final void testDisconnectEdges() {
        Path path0 = new Path(0, 1, 3);
        Path path1 = new Path(0, 2, 2);
        Graph graph = new Graph();
        graph.connectEdge(path0);
        graph.connectEdge(path1);
        Assert.assertTrue(graph.getNodes().get(0).contains(path0));
        Assert.assertTrue(graph.getNodes().get(0).contains(path1));
        Assert.assertTrue(graph.getNodes().get(1).contains(path0));
        Assert.assertTrue(graph.getNodes().get(2).contains(path1));
        graph.disconnectEdge(path0);
        Assert.assertFalse(graph.getNodes().get(0).contains(path0));
        Assert.assertTrue(graph.getNodes().get(0).contains(path1));
        Assert.assertFalse(graph.getNodes().get(1).contains(path0));
        Assert.assertTrue(graph.getNodes().get(2).contains(path1));
    }

    @Test
    public final void testNodeNeighbors() {
        Path path0 = new Path(0, 1, 4);
        Path path1 = new Path(0, 2, 2);
        Graph graph = new Graph();
        graph.connectEdge(path0);
        graph.connectEdge(path1);
        ArrayList<Path> node0Neighbors = new ArrayList<>();
        node0Neighbors.add(path0);
        node0Neighbors.add(path1);
        ArrayList<Path> node1Neighbors = new ArrayList<>();
        node1Neighbors.add(path0);
        ArrayList<Path> node2Neigbors = new ArrayList<>();
        node2Neigbors.add(path1);
        Assert.assertEquals(node0Neighbors, graph.getNodes().get(0));
        Assert.assertEquals(node1Neighbors, graph.getNodes().get(1));
        Assert.assertEquals(node2Neigbors, graph.getNodes().get(2));
    }
}*/