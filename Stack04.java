import java.util.ArrayList;
import java.util.List;

public class StackExample {
    public static void main(String[] args) {
        // Creating a stack using ArrayList
        List<String> stack = new ArrayList<>();

        // Push elements to the stack using add()
        stack.add("g");
        stack.add("f");
        stack.add("g");

        System.out.println("Initial stack:");
        System.out.println(stack);

        // Pop elements from stack in LIFO order
        System.out.println("\nElements popped from stack:");
        System.out.println(stack.remove(stack.size() - 1));
        System.out.println(stack.remove(stack.size() - 1));
        System.out.println(stack.remove(stack.size() - 1));

        System.out.println("\nStack after elements are popped:");
        System.out.println(stack);

        // Uncommenting the next line will throw IndexOutOfBoundsException as the stack is empty
        // System.out.println(stack.remove(stack.size() - 1));
    }
}
