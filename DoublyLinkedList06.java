// Node class
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// DoublyLinkedList class
class DoublyLinkedList {
    Node head;

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("None");
    }

    // Delete the last node
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        if (head.next == null) { // Only one node
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null; // Remove last node
    }

    // Create the initial list
    public void createInitialList() {
        Node n = new Node(10);
        head = n;

        Node n1 = new Node(20);
        n.next = n1;
        n1.prev = n;

        Node n2 = new Node(30);
        n1.next = n2;
        n2.prev = n1;

        Node n3 = new Node(40);
        n2.next = n3;
        n3.prev = n2;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createInitialList();

        System.out.println("Original List:");
        dll.display();

        System.out.println("\nDeleting the last element...");
        dll.deleteEnd();

        System.out.println("List after deletion:");
        dll.display();
    }
}
