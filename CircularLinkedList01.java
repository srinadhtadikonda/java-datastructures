// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// CircularLinkedList class
class CircularLinkedList {
    Node head;

    // Display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    // Create the initial circular linked list
    public void createInitialList() {
        Node n = new Node(10);
        head = n;

        Node n1 = new Node(20);
        n.next = n1;

        Node n2 = new Node(30);
        n1.next = n2;

        Node n3 = new Node(40);
        n2.next = n3;

        n3.next = head; // Make it circular
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createInitialList();

        System.out.println("Circular Linked List:");
        cll.display();
    }
}
