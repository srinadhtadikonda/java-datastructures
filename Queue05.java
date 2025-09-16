import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        // Initializing a queue with max size 3
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);

        // q.size() gives current size of the queue
        System.out.println("Initial size: " + q.size());

        // Adding elements to the queue
        q.offer("g");  // offer instead of put to avoid blocking
        q.offer("f");
        q.offer("g");

        // Check if queue is full
        System.out.println("\nFull: " + (q.remainingCapacity() == 0));

        // Removing elements from queue
        System.out.println("\nElements dequeued from the queue:");
        System.out.println(q.poll()); // removes "g"
        System.out.println(q.poll()); // removes "f"
        System.out.println(q.poll()); // removes "g"

        // Check if queue is empty
        System.out.println("\nEmpty: " + q.isEmpty());

        // Add another element
        q.offer("1");
        System.out.println("\nEmpty: " + q.isEmpty());
        System.out.println("Full: " + (q.remainingCapacity() == 0));
    }
}


