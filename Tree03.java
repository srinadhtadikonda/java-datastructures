//Pre-Order Traversal
import java.util.*;

// Structure of a Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int v) {
        data = v;
        left = right = null;
    }
}

// Class for BinaryTree
class BinaryTree {
    Node root;

    // Function to print preorder traversal
    public static void printPreorder(Node node) {
        if (node == null)
            return;

        // First deal with the node
        System.out.print(node.data + " ");

        // Then recur on left subtree
        printPreorder(node.left);

        // Finally recur on right subtree
        printPreorder(node.right);
    }
}

class GFG {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        BinaryTree.printPreorder(tree.root);
    }
}
