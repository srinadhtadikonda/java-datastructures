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

    // Function to print the leaf nodes of the binary tree
    public static void printLeafNodes(Node root) {
        if (root == null)
            return;

        // If node is a leaf, print it
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }

        // Recurse left and right
        if (root.left != null)
            printLeafNodes(root.left);
        if (root.right != null)
            printLeafNodes(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        System.out.println("Leaf Nodes:");
        printLeafNodes(root);
    }
}
