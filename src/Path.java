/** a representative of an edge */
public class Path {

    /** vertices of the edge */
    private int from, to;
    /** distance between nodes */
    private int distance;

    /** construct Path */
    public Path(int from, int to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    /** get from */
    public final int getFrom() {
        return this.from;
    }

    /** get to */
    public final int getTo() {
        return this.to;
    }

    /** get distance */
    public final int getDistance() {
        return this.distance;
    }

    /** modify distance */
    public final void updateDistance(int newDistance) {
        this.distance = newDistance;
    }

    @Override
    public final boolean equals(Object that) {
        if (that instanceof  Path) {
            Path path = (Path) that;
            return this.getFrom() == path.getFrom() &&
                   this.getTo() == path.getTo() &&
                   this.getDistance() == path.getDistance() ||
                   this.getTo() == path.getFrom() &&
                   this.getFrom() == path.getTo() &&
                   this.getDistance() == path.getDistance();
        }
        else {
            return false;
        }
    }
}