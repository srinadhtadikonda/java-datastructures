// Binary Tree Implementation in Java
import java.util.*;

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

    // Function to print the children of each node
    public static void printChildren(Node root) {
        if (root == null) return;

        // Queue for level-order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.data + " -> ");

            if (node.left != null) {
                System.out.print(node.left.data + " ");
                q.add(node.left);
            }
            if (node.right != null) {
                System.out.print(node.right.data + " ");
                q.add(node.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);

        // Print children of each node
        System.out.println("The children of each node are:");
        printChildren(root);
    }
}
