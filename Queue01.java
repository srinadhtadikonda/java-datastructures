import java.util.ArrayList;

class Queue {
    private ArrayList<String> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    // Add data to the queue (enqueue)
    public boolean addToQ(String dataVal) {
        if (!queue.contains(dataVal)) {
            queue.add(dataVal); // add at the end (FIFO)
            return true;
        }
        return false;
    }

    // Remove data from the queue (dequeue)
    public String removeFromQ() {
        if (queue.size() > 0) {
            return queue.remove(0); // remove from front
        }
        return null;
    }

    // Get size of queue
    public int size() {
        return queue.size();
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue theQueue = new Queue();
        theQueue.addToQ("Mon");
        theQueue.addToQ("Tue");
        theQueue.addToQ("Wed");

        System.out.println("Queue size: " + theQueue.size()); // Output: 3
        System.out.println("Removed: " + theQueue.removeFromQ()); // Output: Mon
        System.out.println("Queue size after removal: " + theQueue.size()); // Output: 2
    }
}
