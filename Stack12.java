import java.util.Scanner;

public class StackWithLimit {
    private String[] stack;
    private int top;
    private int maxSize;

    // Constructor
    public StackWithLimit(int size) {
        maxSize = size;
        stack = new String[maxSize];
        top = -1;
    }

    // Push operation
    public void push(String item) {
        if (top >= maxSize - 1) {
            System.out.println("Stack Overflow: Cannot push item, stack is full.");
        } else {
            stack[++top] = item;
            System.out.println("Item " + item + " pushed to stack.");
        }
    }

    // Pop operation
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow: Cannot pop item, stack is empty.");
        } else {
            String item = stack[top--];
            System.out.println("Item " + item + " popped from stack.");
        }
    }

    // Display stack contents
    public void display() {
        System.out.print("Current Stack: ");
        if (top == -1) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i]);
                if (i != top) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    // Main method for user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        StackWithLimit stack = new StackWithLimit(size);

        while (true) {
            System.out.print("Enter 'push', 'pop', or 'exit': ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "push":
                    System.out.print("Enter item to push: ");
                    String item = scanner.nextLine();
                    stack.push(item);
                    break;

                case "pop":
                    stack.pop();
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 'push', 'pop', or 'exit'.");
            }

            // Display stack after every operation
            stack.display();
        }
    }
}
