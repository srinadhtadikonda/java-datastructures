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

    public CircularLinkedList() {
        head = null;
    }

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

    // Insert a node at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) {
            if (head == null) {
                head = newNode;
                newNode.next = head;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = head;
                head = newNode;
            }
        } else {
            Node temp = head;
            int count = 0;

            while (count < position - 1 && temp.next != head) {
                temp = temp.next;
                count++;
            }

            if (temp.next == head) {
                // Inserting at the end
                temp.next = newNode;
                newNode.next = head;
            } else {
                // Inserting in the middle
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList C = new CircularLinkedList();

        // Create nodes manually
        Node n = new Node(10);
        C.head = n;

        Node n1 = new Node(20);
        n.next = n1;

        Node n2 = new Node(30);
        n1.next = n2;

        Node n3 = new Node(40);
        n2.next = n3;

        // Make the list circular
        n3.next = C.head;

        System.out.println("Initial Circular Linked List:");
        C.display();

        // Insert at position 2
        C.insertAtPosition(25, 2);
        System.out.println("List after inserting 25 at position 2:");
        C.display();

        // Insert at head
        C.insertAtPosition(5, 0);
        System.out.println("List after inserting 5 at head:");
        C.display();

        // Insert at end (position 5)
        C.insertAtPosition(50, 5);
        System.out.println("List after inserting 50 at position 5:");
        C.display();
    }
}
