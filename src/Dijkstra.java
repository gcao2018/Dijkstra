import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/** main class */
public class Dijkstra {

    /** internal graph representation */
    public static Graph graph = new Graph();
    /** priority queue for shortest paths */
    //public static PriorityQueue priorityQueue = new PriorityQueue();
    /** nodes we've already been to */
    public static ArrayList<Integer> beenTo = new ArrayList<>();
    /** nodes we haven't been to */
    public static ArrayList<Integer> notBeenTo = new ArrayList<>();
    // minimal spanning tree
    public static HashMap<Integer, Integer> distancesFromStart = new HashMap<>();
    // all paths not in minimal spanning tree
    public static ArrayList<Path> notInMinimalSpanningTree = new ArrayList<>();

    /** construct Dijkstra */
    public Dijkstra() {
    }

    /** extract Min */
    public static Path extractMinUntilNoCycle(Path currentMin,
                                              PriorityQueue priorityQueue) {
        if (Dijkstra.beenTo.contains(currentMin.getTo())) {
            return Dijkstra.extractMinUntilNoCycle(priorityQueue.extractMin(),
                    priorityQueue);
        }
        else {
            return currentMin;
        }
    }

    // read a line of instructions
    public static Path parseInstructionLine(String line) {
        String ins_del = "=", vet_del = ",";
        String[] tmpPathIns, tmpFromToVet;
        int fromVid, toVid;
        // System.out.println(line);
        tmpPathIns = line.split(ins_del);
        tmpFromToVet = tmpPathIns[0].split(vet_del);
        fromVid = Integer.parseInt(tmpFromToVet[0].substring(1));
        toVid = Integer.parseInt(tmpFromToVet[1].substring(1));
        java.util.Iterator<Path> itr = Dijkstra.graph.getDisconnectedPaths()
                .iterator();
        int distance = 9999;
        boolean foundInDisconnectedPaths = false;
        Path path;
        while (itr.hasNext()) {
            path = itr.next();
            if (path.getFrom() == fromVid && path.getTo() == toVid ||
                    path.getFrom() == toVid && path.getTo() == fromVid) {
                foundInDisconnectedPaths = true;
                distance = path.getDistance();
                if (tmpPathIns[1].contentEquals("U")) {
                    itr.remove();
                }
            }
        }
        if (!foundInDisconnectedPaths) {
            for (Path path2 : Dijkstra.graph.nodeNeighbors(fromVid)) {
                if (path2.getTo() == toVid) {
                    distance = path2.getDistance();
                }
            }
        }
        if (tmpPathIns[1].contentEquals("D")) {
            if (!foundInDisconnectedPaths) {
                Dijkstra.graph.disconnectEdge(new Path(fromVid, toVid, distance));
            }
        }
        else if (tmpPathIns[1].contentEquals("U")) {
            Dijkstra.graph.connectEdge(new Path(fromVid, toVid, distance));
        }
        return new Path(fromVid, toVid, distance);
    }

    /** update graph */
    public static void updateGraphByFile(String update_file_name) {
        String line;
        //System.out.println("\nEntry from update file: ");
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(update_file_name));
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                Path edge = Dijkstra.parseInstructionLine(line);
                if (Dijkstra.notInMinimalSpanningTree.contains(edge)) { // && edge update tells disconnect
                    System.out.println("no need to recompute");
                }
                Dijkstra.DijkstraAlgorithm();
            }
            bufferedReader.close();
        }
        catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /** Dijkstra's algorithm */
    public static void DijkstraAlgorithm() {
        PriorityQueue priorityQueue = new PriorityQueue();
        for (Path path : Dijkstra.graph.getConnectedPaths()) {
            if (!Dijkstra.beenTo.contains(path.getTo())) {
                Dijkstra.notBeenTo.add(path.getTo());
            }
            if (!Dijkstra.beenTo.contains(path.getFrom())) {
                Dijkstra.notBeenTo.add(path.getFrom());
            }
        }
        //HashMap<Integer, Integer> distancesFromStart = new HashMap<>();
        int start = 0; //Dijkstra.notBeenTo.get(0);
        int key = start; //Dijkstra.notBeenTo.get(0);
        Dijkstra.distancesFromStart.put(start, 0);
        Dijkstra.beenTo.add(key);
        Dijkstra.notBeenTo.remove(Dijkstra.notBeenTo.indexOf(key));
        //System.out.print("V" + key + "->V" + key + "=" + 0);
        int i = 0;
        while (!Dijkstra.notBeenTo.isEmpty() && i <= priorityQueue.getHeap().size()) {
            for (Path path : Dijkstra.graph.nodeNeighbors(key)) {
                int fromDistance = Dijkstra.distancesFromStart.get(path.getFrom());
                if (!Dijkstra.distancesFromStart.containsKey(path.getTo()) ||
                        Dijkstra.distancesFromStart.get(path.getTo()) >
                                path.getDistance() + fromDistance) {
                    Dijkstra.distancesFromStart.put(path.getTo(),
                            path.getDistance() + fromDistance);
                }
                else {
                    // add all not in minimal spanning tree to list
                    Dijkstra.notInMinimalSpanningTree.add(path);
                }
                priorityQueue.addPath(new Path(path.getFrom(),
                        path.getTo(),
                        Dijkstra.distancesFromStart.get(path.getTo())));
            }
            Path currentMin = priorityQueue.extractMin();
            Path traversed = Dijkstra.extractMinUntilNoCycle(currentMin,
                    priorityQueue);
            //System.out.print(",V" + start + "->V" + traversed.getTo()
            // + "=" + traversed.getDistance());
            key = traversed.getTo();
            Dijkstra.beenTo.add(key);
            Dijkstra.notBeenTo.remove(Dijkstra.notBeenTo.indexOf(key));
            i++;
        }
        // hashMap library of past paths is already sorted!!!!
        for (Integer hashKeyVertexId : Dijkstra.distancesFromStart.keySet()) {
            if (hashKeyVertexId == start) {
                System.out.print("V" + hashKeyVertexId + "=" +
                        Dijkstra.distancesFromStart.get(hashKeyVertexId));
            }
            else {
                System.out.print(",V" + hashKeyVertexId + "=" +
                        Dijkstra.distancesFromStart.get(hashKeyVertexId));
            }
        }
        System.out.println();
        Dijkstra.beenTo.clear();
        Dijkstra.notBeenTo.clear();
        //Dijkstra.distancesFromStart.clear();
        //priorityQueue.getHeap().clear();
    }

    /** ... */
    public static void main(String args[]) {
        long before = System.nanoTime();
        Dijkstra.graph.popGraphByFile(args[0]);
        Dijkstra.DijkstraAlgorithm();
        Dijkstra.distancesFromStart.clear();
        Dijkstra.notInMinimalSpanningTree.clear();
        Dijkstra.updateGraphByFile(args[1]);
        long after = System.nanoTime();
        System.err.println("Elapsed time: " + (after - before));
    }
}