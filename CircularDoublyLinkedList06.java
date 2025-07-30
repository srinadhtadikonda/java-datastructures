class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class CircularDLL {
    Node head;

    // Display the circular doubly linked list
    void display() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            do {
                System.out.print(temp.data + " <=> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("(back to head)");
        }
    }

    // Insert a node at the end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            Node last = head.prev;

            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Delete a node from the end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
        } else if (head.next == head) {
            // Only one node
            head = null;
        } else {
            Node last = head.prev;
            Node secondLast = last.prev;

            secondLast.next = head;
            head.prev = secondLast;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CircularDLL list = new CircularDLL();

        // Manually creating nodes
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);

        // Linking nodes
        list.head = n1;
        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        n4.next = n5;
        n5.prev = n4;

        n5.next = n1;
        n1.prev = n5;

        // Display before deletion
        System.out.println("Before deleting at end:");
        list.display();

        // Delete from end
        list.deleteAtEnd();
        System.out.println("After deleting at end:");
        list.display();

        // Delete again
        list.deleteAtEnd();
        System.out.println("After deleting again at end:");
        list.display();
    }
}
