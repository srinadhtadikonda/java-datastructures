//Post Oreder Traversal
class Node {
    int data;
    Node left, right;
    Node(int v) {
        data = v;
        left = right = null;
    }
}

public class GfG{
    // Function to print postorder traversal
    void printPostorder(Node node) {
        if (node == null)
            return;

        // First recur on left subtree
        printPostorder(node.left);

        // Then recur on right subtree
        printPostorder(node.right);

        // Now deal with the node
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        GfG tree = new GfG();
        tree.printPostorder(root);
    }
}
