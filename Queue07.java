import java.util.Stack;

class Queue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public Queue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue operation (costly)
    public void enQueue(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push item into s1
        s1.push(x);

        // Move everything back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue operation
    public int deQueue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return s1.pop();
    }
}
