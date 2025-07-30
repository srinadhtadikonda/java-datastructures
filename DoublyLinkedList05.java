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
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " <--> ");
                temp = temp.next;
            }
            System.out.println("None");
        }
    }

    // Delete the first node
    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is Empty, cannot delete");
            return;
        }

        Node temp = head;
        head = temp.next;

        if (head != null) {
            head.prev = null;
        }

        temp.next = null;  // Help GC
    }

    // Helper to create initial nodes (same as your example)
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

        System.out.println("\nDeleting the first node...\n");
        dll.deleteBeginning();

        System.out.println("List after deletion:");
        dll.display();
    }
}
