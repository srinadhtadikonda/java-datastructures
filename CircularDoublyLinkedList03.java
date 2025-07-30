class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class CircularDLL {
    Node head;

    public CircularDLL() {
        head = null;
    }

    // Display the circular doubly linked list
    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // Insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;

            last.next = newNode;
            newNode.prev = last;

            newNode.next = head;
            head.prev = newNode;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CircularDLL list = new CircularDLL();

        // Manually create initial nodes
        Node n1 = new Node(10);
        list.head = n1;

        Node n2 = new Node(20);
        n1.next = n2;
        n2.prev = n1;

        Node n3 = new Node(30);
        n2.next = n3;
        n3.prev = n2;

        Node n4 = new Node(40);
        n3.next = n4;
        n4.prev = n3;

        Node n5 = new Node(50);
        n4.next = n5;
        n5.prev = n4;

        // Make it circular
        n5.next =
