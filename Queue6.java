import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
    public static void main(String[] args) {
        // Create a Queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Enqueue (add elements to the queue)
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");

        System.out.println("Queue: " + queue);

        // Peek (check the head of the queue without removing)
        System.out.println("Peek: " + queue.peek());

        // Dequeue (remove elements from the queue)
        System.out.println("Removed: " + queue.poll());
        System.out.println("Removed: " + queue.poll());

        System.out.println("Queue after removals: " + queue);

        // Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
