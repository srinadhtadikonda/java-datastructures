
import java.util.Deque;
import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {
        // Initialize a queue
        Deque<String> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.addLast("g"); // equivalent to Python's append
        queue.addLast("f");
        queue.addLast("g");

        System.out.println("Initial queue:");
        System.out.println(queue);
    }
}
