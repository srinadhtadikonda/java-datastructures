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

    // Insert a node at the end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Display the list
    void display() {
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
}

// Main class
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Creating initial nodes manually
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

        System.out.println("\nAfter inserting 45 at the end:");
        list.insertAtEnd(45);
        list.display();
    }
}
