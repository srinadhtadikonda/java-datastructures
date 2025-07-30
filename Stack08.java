import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element onto the stack
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack
    public void pop() {
        if (q1.isEmpty()) {
            return;
        }

        // Leave one element in q1 and move the rest to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // Remove the last element (top of stack)
        q1.poll();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Get the top element
    public int top() {
        if (q1.isEmpty()) {
            return -1;  // Or throw exception
        }

        // Leave one element in q1 and move the rest to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // Get the last element
        int top = q1.peek();
        q2.add(q1.poll());  // Reinsert it into q2

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Return current size of the stack
    public int size() {
        return q1.size();
    }

    // Driver code
    public static void main(String[] args) {
        StackUsingTwoQueues s = new StackUsingTwoQueues();
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
