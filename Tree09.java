// Java program to delete a specific 
// element in a binary tree

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class GfG {
    
    // Function to delete the deepest node in
  	// binary tree
    static void deletDeepest(Node root, Node dNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node curr;
        while (!q.isEmpty()) {
            curr = q.poll();

            // If current node is the deepest 
          	// node, delete it
            if (curr == dNode) {
                curr = null;
                dNode = null;
                return;
            }

            // Check the right child first
            if (curr.right != null) {
              
                // If right child is the deepest node,
              	// delete it
                if (curr.right == dNode) {
                    curr.right = null;
                    dNode = null;
                    return;
                }
                q.add(curr.right);
            }

            // Check the left child
            if (curr.left != null) {
              
                // If left child is the deepest node,
              	// delete it
                if (curr.left == dNode) {
                    curr.left = null;
                    dNode = null;
                    return;
                }
                q.add(curr.left);
            }
        }
    }

    // Function to delete the node with the given key
    static Node deletion(Node root, int key) {
      
        if (root == null)
            return null;

        // If the tree has only one node
        if (root.left == null && root.right == null) {
          
            // If the root node is the key, 
          	// delete it
            if (root.data == key)
                return null;
            else
                return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node curr = null;
        Node keyNode = null;

        // Level order traversal to find the 
      	// deepest node and the key node
        while (!q.isEmpty()) {
            curr = q.poll();

            // If current node is the key node
            if (curr.data == key)
                keyNode = curr;

            if (curr.left != null)
                q.add(curr.left);

            if (curr.right != null)
                q.add(curr.right);
        }

        // If key node is found, replace its
      	// data with the deepest node
        if (keyNode != null) {
          
          	 // Store the data of the
          	// deepest node
            int x = curr.data; 
          
          	 // Replace key node data with 
          	// deepest node's data
            keyNode.data = x; 
          
          	 // Delete the deepest node
            deletDeepest(root, curr); 
        }
        return root;
    }

    // Inorder traversal of a binary tree
    static void inorder(Node curr) {
        if (curr == null)
            return;
        inorder(curr.left);
        System.out.print(curr.data + " ");
        inorder(curr.right);
    }

    public static void main(String[] args) {
      
        // Construct the binary tree
        //       10         
        //      /  \       
        //    11    9
        //   / \   / \     
        //  7  12 15  8   
          Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right.left = new Node(15);
        root.right.right = new Node(8);


        int key = 11;
        root = deletion(root, key);
        inorder(root);
    }
}
