import java.util.LinkedList;
import java.util.Queue;

public class StackUsingDeque {
    private Queue<Integer> q;

    public StackUsingDeque() {
        q = new LinkedList<>();
    }

    // Push operation
    public void push(int data) {
        int size = q.size();
        q.add(data);

        // Rotate the queue to move the new element to front
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
    }

    // Pop operation
    public void pop() {
        if (q.isEmpty()) {
            System.out.println("No elements");
        } else {
            q.remove();
        }
    }

    // Top operation
    public Integer top() {
        if (q.isEmpty()) {
            return null;
        }
        return q.peek(); // Front of the queue is the top of the stack
    }

    // Size of stack
    public int size() {
        return q.size();
    }

    // Main method to test
    public static void main(String[] args) {
        StackUsingDeque st = new StackUsingDeque();

        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println("Current size: " + st.size()); // 3
        System.out.println(st.to
