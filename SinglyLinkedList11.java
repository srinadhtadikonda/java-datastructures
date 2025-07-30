// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List class
class SinglyLinkedList {
    Node head;

    // Display the list
    void display() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("None");
        }
    }

    // Reverse the list using recursion
    void reverse() {
        head = reverseRecursively(head, null);
    }

    // Helper recursive function
    private Node reverseRecursively(Node current, Node prev) {
        if (current == null)
            return prev;
        Node nextNode = current.next;
        current.next = prev;
        return reverseRecursively(nextNode, current);
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList L = new SinglyLinkedList();

        // Creating nodes and linking them
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        L.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println("Original List:");
        L.display();

        // Reverse the list
        L.reverse();

        System.out.println("Reversed List:");
        L.display();
    }
}
