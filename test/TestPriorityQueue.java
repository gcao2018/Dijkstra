/**
import junit.framework.Assert;
import org.junit.Test;
*/
/** tester class for priority queue */
/**public class TestPriorityQueue {

    @Test
    public final void testGetHeap() {
        PriorityQueue priorityQueue = new PriorityQueue();
        Path path0 = new Path(0, 0, 0);
        priorityQueue.addPath(path0);
        Assert.assertEquals(priorityQueue.getHeap().get(0), path0);
    }

    @Test
    public final void testAddPath() {
        Path path0 = new Path(0, 0, 0);
        Path path1 = new Path(0, 1, 1);
        Path path2 = new Path(0, 2, 2);
        Path path3 = new Path(0, 3, 3);
        Path path4 = new Path(0, 4, 4);
        Path path5 = new Path(0, 5, 5);
        Path path6 = new Path(0, 6, 6);
        Path path7 = new Path(0, 7, 7);
        Path path8 = new Path(0, 8, 8);
        Path path9 = new Path(0, 9, 9);
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.addPath(path9);
        priorityQueue.addPath(path8);
        priorityQueue.addPath(path7);
        priorityQueue.addPath(path6);
        priorityQueue.addPath(path5);
        priorityQueue.addPath(path4);
        priorityQueue.addPath(path3);
        priorityQueue.addPath(path2);
        priorityQueue.addPath(path1);
        priorityQueue.addPath(path0);
        Assert.assertEquals(priorityQueue.getHeap().get(0), path0);
        Assert.assertEquals(priorityQueue.getHeap().get(1), path1);
        Assert.assertEquals(priorityQueue.getHeap().get(2), path4);
        Assert.assertEquals(priorityQueue.getHeap().get(3), path3);
        Assert.assertEquals(priorityQueue.getHeap().get(4), path2);
        Assert.assertEquals(priorityQueue.getHeap().get(5), path8);
        Assert.assertEquals(priorityQueue.getHeap().get(6), path5);
        Assert.assertEquals(priorityQueue.getHeap().get(7), path9);
        Assert.assertEquals(priorityQueue.getHeap().get(8), path6);
        Assert.assertEquals(priorityQueue.getHeap().get(9), path7);
    }

    @Test
    public final void testHeapifyDown() {
        Path path0 = new Path(0, 0, 0);
        Path path1 = new Path(0, 1, 1);
        Path path2 = new Path(0, 2, 2);
        Path path3 = new Path(0, 3, 3);
        Path path4 = new Path(0, 4, 4);
        Path path5 = new Path(0, 5, 5);
        Path path6 = new Path(0, 6, 6);
        Path path7 = new Path(0, 7, 7);
        Path path8 = new Path(0, 8, 8);
        Path path9 = new Path(0, 9, 9);
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.addPath(path0);
        priorityQueue.addPath(path1);
        priorityQueue.addPath(path2);
        priorityQueue.addPath(path3);
        priorityQueue.addPath(path4);
        priorityQueue.addPath(path5);
        priorityQueue.addPath(path6);
        priorityQueue.addPath(path7);
        priorityQueue.addPath(path8);
        priorityQueue.getHeap().remove(0);
        priorityQueue.getHeap().add(0, path9);
        priorityQueue.heapifyDown(0);
        Assert.assertEquals(priorityQueue.getHeap().get(0), path1);
        Assert.assertEquals(priorityQueue.getHeap().get(1), path3);
        Assert.assertEquals(priorityQueue.getHeap().get(2), path2);
        Assert.assertEquals(priorityQueue.getHeap().get(3), path7);
        Assert.assertEquals(priorityQueue.getHeap().get(4), path4);
        Assert.assertEquals(priorityQueue.getHeap().get(5), path5);
        Assert.assertEquals(priorityQueue.getHeap().get(6), path6);
        Assert.assertEquals(priorityQueue.getHeap().get(7), path9);
        Assert.assertEquals(priorityQueue.getHeap().get(8), path8);
        priorityQueue.getHeap().remove(8);
        priorityQueue.getHeap().remove(7);
        priorityQueue.getHeap().remove(6);
        priorityQueue.getHeap().remove(0);
        priorityQueue.getHeap().add(0, path6);
        priorityQueue.heapifyDown(0);
        Assert.assertEquals(priorityQueue.getHeap().get(0), path2);
        Assert.assertEquals(priorityQueue.getHeap().get(1), path3);
        Assert.assertEquals(priorityQueue.getHeap().get(2), path5);
        Assert.assertEquals(priorityQueue.getHeap().get(3), path7);
        Assert.assertEquals(priorityQueue.getHeap().get(4), path4);
        Assert.assertEquals(priorityQueue.getHeap().get(5), path6);
    }

    @Test
    public final void testExtractMin() {
        Path path0 = new Path(0, 0, 0);
        Path path1 = new Path(0, 1, 1);
        Path path2 = new Path(0, 2, 2);
        Path path3 = new Path(0, 3, 3);
        Path path4 = new Path(0, 4, 4);
        Path path5 = new Path(0, 5, 5);
        Path path6 = new Path(0, 6, 6);
        Path path7 = new Path(0, 7, 7);
        Path path8 = new Path(0, 8, 8);
        Path path9 = new Path(0, 9, 9);
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.addPath(path0);
        priorityQueue.addPath(path1);
        priorityQueue.addPath(path2);
        priorityQueue.addPath(path3);
        priorityQueue.addPath(path4);
        priorityQueue.addPath(path5);
        priorityQueue.addPath(path6);
        priorityQueue.addPath(path7);
        priorityQueue.addPath(path8);
        priorityQueue.addPath(path9);
        Assert.assertEquals(priorityQueue.extractMin().getDistance(), 0);
        Assert.assertEquals(priorityQueue.getHeap().get(0), path1);
        Assert.assertEquals(priorityQueue.getHeap().get(1), path3);
        Assert.assertEquals(priorityQueue.getHeap().get(2), path2);
        Assert.assertEquals(priorityQueue.getHeap().get(3), path7);
        Assert.assertEquals(priorityQueue.getHeap().get(4), path4);
        Assert.assertEquals(priorityQueue.getHeap().get(5), path5);
        Assert.assertEquals(priorityQueue.getHeap().get(6), path6);
        Assert.assertEquals(priorityQueue.getHeap().get(7), path9);
        Assert.assertEquals(priorityQueue.getHeap().get(8), path8);
        Assert.assertEquals(priorityQueue.extractMin(), path1);
        Assert.assertEquals(priorityQueue.getHeap().get(0), path2);
        Assert.assertEquals(priorityQueue.getHeap().get(1), path3);
        Assert.assertEquals(priorityQueue.getHeap().get(2), path5);
        Assert.assertEquals(priorityQueue.getHeap().get(3), path7);
        Assert.assertEquals(priorityQueue.getHeap().get(4), path4);
        Assert.assertEquals(priorityQueue.getHeap().get(5), path8);
        Assert.assertEquals(priorityQueue.getHeap().get(6), path6);
        Assert.assertEquals(priorityQueue.getHeap().get(7), path9);
        Assert.assertEquals(priorityQueue.extractMin(), path2);
        Assert.assertEquals(priorityQueue.getHeap().get(0), path3);
        Assert.assertEquals(priorityQueue.getHeap().get(1), path4);
        Assert.assertEquals(priorityQueue.getHeap().get(2), path5);
        Assert.assertEquals(priorityQueue.getHeap().get(3), path7);
        Assert.assertEquals(priorityQueue.getHeap().get(4), path9);
        Assert.assertEquals(priorityQueue.getHeap().get(5), path8);
        Assert.assertEquals(priorityQueue.getHeap().get(6), path6);
    }
}

*/