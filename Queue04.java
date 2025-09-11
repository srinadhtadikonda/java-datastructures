import java.util.ArrayList;

public class QueueUsingList {
    public static void main(String[] args) {
        // Queue using ArrayList
        ArrayList<String> queue = new ArrayList<>();

        // Adding elements to the queue
        queue.add("g");
        queue.add("f");
        queue.add("g");

        System.out.println("Initial queue");
        System.out.println(queue);

        // Removing elements from the queue (FIFO)
        System.out.println("\nElements dequeued from queue");
        System.out.println(queue.remove(0)); // removes "g"
        System.out.println(queue.remove(0)); // removes "f"
        System.out.println(queue.remove(0)); // removes "g"

        System.out.println("\nQueue after removing elements");
        System.out.println(queue);
    }
}

import java.util.ArrayList;

class Queue {
    private ArrayList<String> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    // Enqueue operation
    public void enqueue(String item) {
        queue.add(item);
        System.out.println("Enqueued: " + item);
    }

    // Dequeue operation
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        String item = queue.remove(0); // FIFO
        System.out.println("Dequeued: " + item);
        return item;
    }

    // Peek at the front element
    public String front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return queue.get(0);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get size of the queue
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
        q.display();

        q.dequeue();
        q.display();

        System.out.println("Front element: " + q.front());
        System.out.println("Queue is empty: " + q.isEmpty());
        System.out.println("Queue size: " + q.size());
    }
}
