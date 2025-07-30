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

    // Insert at a specific position (1-based index)
    void insertAtPosition(int pos, int data) {
        Node newNode = new Node(data);

        if (pos == 1) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // Display the list
    void display() {
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
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Creating initial list manually
        Node n = new Node(10);
        list.head = n;

        Node n1 = new Node(20);
        n.next = n1;
        n1.prev = n;

        Node n2 = new Node(30);
        n1.next = n2;
        n2.prev = n1;

        Node n3 = new Node(40);
        n2.next = n3;
        n3.prev = n2;

        System.out.println("Initial List:");
        list.display();

        System.out.println("\nAfter inserting 12 at position 3:");
        list.insertAtPosition(3, 12);
        list.display();
    }
}
