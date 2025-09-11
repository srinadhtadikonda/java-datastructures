import java.util.ArrayList;

class Queue {
    private ArrayList<String> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    // Add data to the queue (enqueue)
    public boolean addToQ(String dataVal) {
        if (!queue.contains(dataVal)) {
            queue.add(0, dataVal); // insert at front (like Python insert(0))
            return true;
        }
        return false;
    }

    // Remove data from the queue (dequeue - like Python pop())
    public String removeFromQ() {
        if (queue.size() > 0) {
            return queue.remove(queue.size() - 1); // remove from end
        }
        return "No elements in Queue!";
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        // ----------- Part 1: Custom Queue class -------------
        Queue theQueue = new Queue();
        theQueue.addToQ("Mon");
        theQueue.addToQ("Tue");
        theQueue.addToQ("Wed");

        System.out.println(theQueue.removeFromQ()); // Wed
        System.out.println(theQueue.removeFromQ()); // Tue

        // ----------- Part 2: Using ArrayList as Queue -------------
        ArrayList<String> queue = new ArrayList<>();

        // Adding elements
        queue.add("g");
        queue.add("f");
        queue.add("g");

        System.out.println("\nInitial queue: " + queue);

        // Removing elements (FIFO)
        System.out.println("\nElements dequeued from queue:");
        System.out.println(queue.remove(0)); // removes "g"
        System.out.println(queue.remove(0)); // removes "f"
        System.out.println(queue.remove(0)); // removes "g"

        System.out.println("\nQueue after removing elements: " + queue);
    }
}
