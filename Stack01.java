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

    public String peek() {
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return null; // or throw exception
    }
}

public class Main {
    public static void main(String[] args) {
        Stack aStack = new Stack();

        aStack.add("Mon");
        aStack.add("Tue");

        System.out.println(aStack.peek());

        aStack.add("Wed");
        aStack.add("Thu");

        System.out.println(aStack.peek());
    }
}
