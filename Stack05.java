// Node class for stack
class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class
class Stack {
    StackNode root;

    Stack() {
        root = null;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Push data onto stack
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = root;
        root = newNode;
        System.out.println(data + " pushed to stack");
    }

    // Pop data from stack
    public int pop() {
        if (isEmpty()) {
            return Integer.MIN_VALUE; // equivalent to -infinity
        }
        int popped = root.data;
        root = root.next;
        return popped;
    }

    // Peek at top element
    public int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return root.data;
    }
}

// Driver code
public class StackUsingLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop() + " popped from stack");
        System.out.println("Top element is " + stack.peek());
    }
}
