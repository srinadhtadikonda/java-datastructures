class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    // Display the list
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

    // Delete node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is Empty, nothing to delete.");
            return;
        }

        // Deleting head node
        if (position == 0) {
            if (head.next == head) {
                head = null; // Only one node
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next; // Find last node
                }
                head = head.next;     // Move head
                temp.next = head;     // Last node points to new head
            }
            return;
        }

        Node current = head;
        Node prev = null;
        int count = 0;

        while (count < position) {
            prev = current;
            current = current.next;
            count++;

            if (current == head) {
                System.out.println("Position out of bounds.");
                return;
            }
        }

        // Delete the node
        prev.next = current.next;
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList C = new CircularLinkedList();

        // Create and link nodes
        Node n = new Node(10);
        Node n1 = new Node(20);
        Node n2 = new Node(30);
        Node n3 = new Node(40);

        C.head = n;
        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = C.head; // Make circular

        // Display initial list
        C.display();

        // Delete node at specific position (1 = second element)
        C.deleteAtPosition(1);

        // Display updated list
        C.display();
    }
}
