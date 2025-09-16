

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        // Initialize a deque with some elements
        Deque<String> doubleEnded = new LinkedList<>();
        doubleEnded.add("Mon");
        doubleEnded.add("Tue");
        doubleEnded.add("Wed");

        // Append at right
        doubleEnded.addLast("Thu");
        System.out.println("Appended at right - ");
        System.out.println(doubleEnded);

        // Append at left
        doubleEnded.addFirst("Sun");
        System.out.println("Appended at left - ");
        System.out.println(doubleEnded);

        // Delete from right
        doubleEnded.removeLast();
        System.out.println("Deleting from right - ");
        System.out.println(doubleEnded);

        // Delete from left
        doubleEnded.removeFirst();
        System.out.println("Deleting from left - ");
        System.out.println(doubleEnded);
    }
}
