import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDeque {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        // Push elements to the stack
        stack.push("g");
        stack.push("f");
        stack.push("g");

        System.out.println("Initial stack:");
        System.out.println(stack);

        // Pop elements from the stack in LIFO order
        System.out.println("\nElements popped from stack:");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("\nStack after elements are popped:");
        System.out.println(stack);

        // Push elements again
        stack.push("g");
        stack.push("f");
        stack.push("g");

        System.out.println("\nInitial stack:");
        System.out.println(stack);

        // Pop again
        System.out.println("\nElements popped from stack:");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("\nStack after elements are popped:");
        System.out.println(stack);

        // Uncommenting the following line will throw NoSuchElementException
        // System.out.println(stack.pop());
    }
}
