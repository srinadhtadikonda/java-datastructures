import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
    Queue<Integer> q = new LinkedList<>();

    // Append operation (acts like push)
    public void append(int val) {
        int size = q.size();

        // Add current element at rear
        q.add(val);

        // Rotate the queue to move current element to front
        for (int i = 0; i < size; i++) {
            int x = q.remove();
            q.add(x);
        }
    }

    // Removes the top element (acts like pop)
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("No elements");
            return -1;
        }
        return q.remove();
    }

    // Returns top element
    public int top() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek
