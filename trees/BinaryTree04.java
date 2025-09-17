// Binary Tree Implementation in Java
class Main {

    // Node structure for Binary Tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to print the degree of each node
    public static void printDegrees(Node root) {
        if (root == null)
            return;

        // Calculate degree for current node
        int degree = 0;
        if (root.left != null) degree++;
        if (root.right != null) degree++;

        System.out.println(root.data + ": " + degree);

        // Recurse left and right
        printDegrees(root.left);
        printDegrees(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        System.out.println("Degrees of Nodes:");
        printDegrees(root);
    }
}
