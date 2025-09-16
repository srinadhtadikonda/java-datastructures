
import java.util.Deque;
import java.util.LinkedList;

class PriorityQueueCustom {
    private LinkedList<Integer> queue;

    public PriorityQueueCustom() {
        queue = new LinkedList<>();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Insert element into queue
    public void insert(int data) {
        queue.add(data);
    }

    // Delete element based on priority (max value)
    public int delete() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int maxIndex = 0;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) > queue.get(maxIndex)) {
                maxIndex = i;
            }
        }

        return queue.remove(maxIndex);
    }
}

public class QueueAndPriorityQueueDemo {
    public static void main(String[] args) {
        // --------- Deque as Queue ---------
        Deque<String> q = new LinkedList<>();
        q.addLast("g");
        q.addLast("f");
        q.addLast("g");

        System.out.println("Initial queue:");
        System.out.println(q);

        System.out.println("\nElements dequeued from the queue:");
        System.out.println(q.removeFirst());
        System.out.println(q.removeFirst());
        System.out.println(q.removeFirst());

        System.out.println("\nQueue after removing elements:");
        System.out.println(q);

        // --------- Custom Priority Queue ---------
        PriorityQueueCustom myQueue = new PriorityQueueCustom();
        myQueue.insert(12);
        myQueue.insert(1);
        myQueue.insert(14);
        myQueue.insert(7);

        System.out.println("\nPriority Queue:");
        System.out.println(myQueue);

        System.out.println("\nDeleting elements based on priority:");
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.delete());
        }
    }
}
