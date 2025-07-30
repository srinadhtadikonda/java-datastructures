import java.util.ArrayList;

class Stack {
    private ArrayList<String> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public boolean add(String dataVal) {
        if (!stack.contains(dataVal)) {
            stack.add(dataVal);
            return true;
        } else {
            return false;
        }
    }

    public String remove() {
        if (stack.isEmpty()) {
            return "No element in the Stack";
        } else {
            return stack.remove(stack.size() - 1);  // Removes and returns the last item
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Stack aStack = new Stack();
        aStack.add("Mon");
        aStack.add("Tue");
        aStack.add("Wed");
        aStack.add("Thu");

        System.out.println(aStack.remove());
        System.out.println(aStack.remove());
    }
}
