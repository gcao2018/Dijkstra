import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/** representation of a graph */
public class Graph {

    /**
     * key is for each node of the graph
     * key of value is for neighbors of each node
     * value of value is for distance between each node and each of its
     * neighbors */
    private HashMap<Integer, ArrayList<Path>> nodes;
    /** all edges that have been connected */
    private ArrayList<Path> connectedPaths;
    /** all disconnected edges that have been disconnected */
    private ArrayList<Path> disconnectedPaths;

    /** construct Graph */
    public Graph() {
        this.nodes = new HashMap<>();
        this.connectedPaths = new ArrayList<>();
        this.disconnectedPaths = new ArrayList<>();
    }

    /** get internal representation of graph */
    public final HashMap<Integer, ArrayList<Path>> getNodes() {
        return this.nodes;
    }

    /** get all edges that have been disconnected */
    public final ArrayList<Path> getDisconnectedPaths() {
        return this.disconnectedPaths;
    }

    /** add a node with no neighbors to this graph */
    private void addNode(Integer that) {
        this.nodes.put(that, new ArrayList<>());
    }

    /** get connnectedPaths */
    public final ArrayList<Path> getConnectedPaths() {
        return this.connectedPaths;
    }

    /** add or connect an edge to this Graph */
    public final void connectEdge(Path that) {
        if (!this.getConnectedPaths().contains(that)) {
            this.getConnectedPaths().add(that);
        }
        if (this.getDisconnectedPaths().contains(that)) {
            this.getDisconnectedPaths().remove(that);
        }
        if (!this.getNodes().containsKey(that.getFrom())) {
            this.addNode(that.getFrom());
        }
        if (!this.getNodes().containsKey(that.getTo())) {
            this.addNode(that.getTo());
        }
        this.getNodes().get(that.getFrom()).add(new Path(that.getFrom(),
                that.getTo(), that.getDistance()));
        this.getNodes().get(that.getTo()).add(new Path(that.getTo(),
                that.getFrom(), that.getDistance()));
    }

    /** disconnect that edge in this graph */
    public final void disconnectEdge(Path that) {
        this.getNodes().get(that.getFrom()).remove(that);
        this.getNodes().get(that.getTo()).remove(that);
        if (!this.getDisconnectedPaths().contains(that)) {
            this.getDisconnectedPaths().add(that);
        }
        if (this.getConnectedPaths().contains(that)) {
            this.getConnectedPaths().remove(that);
        }
    }

    /** get that node's neighbors if that node is in the graph */
    public final ArrayList<Path> nodeNeighbors(int that) {
        return this.getNodes().get(that);
    }

    /** populate the graph by file */
    public void popGraphByFile(String graph_file_name) {
        String line, len_del = "=", vet_del = ",";
        String[] tmpPathLen, tmpFromToVet;
        int fromVid, toVid, length;
        try {
            BufferedReader br = new BufferedReader(new FileReader(graph_file_name));
            while ((line = br.readLine()) != null) {
                tmpPathLen = line.split(len_del);
                length = Integer.parseInt(tmpPathLen[1]);
                tmpFromToVet = tmpPathLen[0].split(vet_del);
                fromVid = Integer.parseInt(tmpFromToVet[0].substring(1));
                toVid = Integer.parseInt(tmpFromToVet[1].substring(1));
                Path p = new Path(fromVid, toVid, length);
                this.connectEdge(p);
            }
            br.close();
        }
        catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}