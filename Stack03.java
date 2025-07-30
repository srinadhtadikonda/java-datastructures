import java.util.ArrayList;

class Stack {
    private ArrayList<String> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Push an item onto the stack
    public void push(String item) {
        stack.add(item);
        System.out.println(item + " pushed to stack");
    }

    // Pop an item from the stack
    public String pop() {
        if (isEmpty()) {
            return String.valueOf(Integer.MIN_VALUE); // mimic minus infinity
        }
        return stack.remove(stack.size() - 1);
    }

    // Peek at the top item of the stack
    public String peek() {
        if (isEmpty()) {
            return String.valueOf(Integer.MIN_VALUE); // mimic minus infinity
        }
        return stack.get(stack.size() - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("10");
        stack.push("20");
        stack.push("30");
        System.out.println(stack.pop() + " popped from stack");
    }
}
