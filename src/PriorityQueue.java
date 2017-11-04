import java.util.ArrayList;

/** a heap based priority queue */
public class PriorityQueue {

    /** internal binary tree representation */
    private ArrayList<Path> heap;

    /** construct PriorityQueue */
    public PriorityQueue() {
        //this.start = start;
        this.heap = new ArrayList<>();
        //this.heap.add(new Path(start, start, 0));
    }

    /** get internal binary tree representation */
    public final ArrayList<Path> getHeap() {
        return this.heap;
    }

    /** add to priority queue a path leading to finish-line node */
    public final void addPath(Path pathToFinish) {
        this.getHeap().add(pathToFinish);
        this.heapifyUp(this.getHeap().size() - 1);
    }

    /** swap items in those two positions */
    private void swap(int index1, int index2) {
        Path element1 = this.getHeap().get(index1);
        Path element2 = this.getHeap().get(index2);
        this.getHeap().add(index1, element2);
        this.getHeap().remove(index1 + 1);
        this.getHeap().add(index2, element1);
        this.getHeap().remove(index2 + 1);
    }

    /** heapify-up */
    private void heapifyUp(int childPosition) {
        int parentPosition = (childPosition - 1) / 2;
        Path child = this.getHeap().get(childPosition);
        Path parent = this.getHeap().get(parentPosition);
        if (child.getDistance() < parent.getDistance()) {
            this.swap(parentPosition, childPosition);
            this.heapifyUp(parentPosition);
        }
    }

    /** heapify down */
    public final void heapifyDown(int parentPosition) {
        Path parent = this.getHeap().get(parentPosition);
        int childPosition1 = parentPosition * 2 + 1;
        int childPosition2 = parentPosition * 2 + 2;
        if (childPosition2 < this.getHeap().size()) {
            Path child1 = this.getHeap().get(childPosition1);
            Path child2 = this.getHeap().get(childPosition2);
            if (child1.getDistance() < child2.getDistance()) {
                if (child1.getDistance() < parent.getDistance()) {
                    this.swap(childPosition1, parentPosition);
                    this.heapifyDown(childPosition1);
                }
            }
            else {
                if (child2.getDistance() < parent.getDistance()) {
                    this.swap(childPosition2, parentPosition);
                    this.heapifyDown(childPosition2);
                }
            }
        }
        else if (childPosition1 < this.getHeap().size()) {
            Path child1 = this.getHeap().get(childPosition1);
            if (child1.getDistance() < parent.getDistance()) {
                this.swap(parentPosition, childPosition1);
                this.heapifyDown(childPosition1);
            }
        }
    }

    /** extract min */
    public final Path extractMin() {
        if (this.getHeap().size() == 1) {
            return this.getHeap().remove(0);
        }
        else if (!this.getHeap().isEmpty()) {
            Path last = this.getHeap().remove(this.getHeap().size() - 1);
            this.getHeap().add(0, last);
            Path min = this.getHeap().remove(1);
            this.heapifyDown(0);
            return min;
        }
        else {
            throw new RuntimeException("heap is empty");
        }
    }
}