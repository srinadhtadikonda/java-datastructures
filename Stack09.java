import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuesCostlyPop {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation (O(1))
    public void push(int x) {
        q1.add(x);
    }

    // Pop operation (O(n))
    public void pop() {
        if (q1.isEmpty()) {
            return;
        }

        // Leave one element in q1 and push others to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // Remove the last element (i.e., top of the stack)
        q1.poll();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Top operation (O(n))
    public int top() {
        if (q1.isEmpty()) {
            return -1; // or throw exception
        }

        // Leave one element in q1 and push others to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // Get the last element (i.e., top of the stack)
        int top = q1.peek();
        q2.add(q1.poll());  // Re-add top element to q2

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Size of stack
    public int size() {
        return q1.size();
    }

    // Main method (Driver code)
    public static void main(String[] args) {
        StackUsingQueuesCostlyPop s = new StackUsingQueuesCostlyPop();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Current size: " + s.size());
        System.out.println(s.top()); // 3
        s.pop();
        System.out.println(s.top()); // 2
        s.pop();
        System.out.println(s.top()); // 1
        System.out.println("Current size: " + s.size());
    }
}
