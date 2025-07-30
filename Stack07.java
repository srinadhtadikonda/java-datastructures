import java.util.concurrent.LinkedBlockingDeque;

public class StackUsingLifoQueue {
    public static void main(String[] args) {
        // Max size 3 like Python's LifoQueue(maxsize=3)
        LinkedBlockingDeque<String> stack = new LinkedBlockingDeque<>(3);

        // stack.size() shows current number of elements
        System.out.println("Initial size: " + stack.size());

        // Add elements to the stack (top = end of deque)
        try {
            stack.putFirst("g"); // Acts like push
            stack.putFirst("f");
            stack.putFirst("g");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Full: " + (stack.remainingCapacity() == 0));
        System.out.println("Size: " + stack.size());

        // Remove elements from stack in LIFO order
        System.out.println("\nElements popped from the stack:");
        try {
            System.out.println(stack.takeFirst());
            System.out.println(stack.takeFirst());
            System.out.println(stack.takeFirst());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nEmpty: " + stack.isEmpty());
    }
}
