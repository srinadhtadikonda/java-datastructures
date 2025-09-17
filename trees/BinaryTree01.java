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

    // Function to print parent of each node (DFS)
    public static void printParents(Node node, int parent) {
        if (node == null) return;

        if (parent == 0)
            System.out.println(node.data + " -> Root");
        else
            System.out.println(node.data + " -> " + parent);

        // Traverse left and right
        printParents(node.left, node.data);
        printParents(node.right, node.data);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left=new Node(7);
        
        // Print parents of each node
        System.out.println("The parents of each node are:");
        printParents(root, 0);
    }
}
