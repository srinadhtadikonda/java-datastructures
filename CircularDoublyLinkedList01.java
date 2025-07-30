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

    public void display() {
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
}

public class Main {
    public static void main(String[] args) {
        CircularDLL list = new CircularDLL();

        // Create nodes
        Node n1 = new Node(10);
        list.head = n1;

        Node n2 = new Node(20);
        n2.prev = n1;
        n1.next = n2;

        Node n3 = new Node(30);
        n3.prev = n2;
        n2.next = n3;

        Node n4 = new Node(40);
        n4.prev = n3;
        n3.next = n4;

        Node n5 = new Node(50); // Final node
        n4.next = n5;
        n5.prev = n4;

        // Make it circular
        n5.next = list.head;
        list.head.prev = n5;

        // Display the list
        list.display();
    }
}
