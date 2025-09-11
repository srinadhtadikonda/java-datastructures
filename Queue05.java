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

import java.util.LinkedList;

class Queue {
    private LinkedList<String> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    // Enqueue operation
    public void enqueue(String item) {
        queue.addLast(item); // Add at the end
        System.out.println("Enqueued: " + item);
    }

    // Dequeue operation
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        String item = queue.removeFirst(); // Remove from front
        System.out.println("Dequeued: " + item);
        return item;
    }

    // Peek at the front element
    public String front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return queue.getFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return queue.size();
    }

    // Display the queue
    public void display() {
        System.out.println("Queue: " + queue);
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.display(); // Queue: [A, B, C]

        q.dequeue();
        q.display(); // Queue: [B, C]

        System.out.println("Front element: " + q.front());   // B
        System.out.println("Queue is empty: " + q.isEmpty()); // false
        System.out.println("Queue size: " + q.size());        // 2
    }
}
