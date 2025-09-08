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

// Main class to run the code
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Creating initial nodes
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

    }
}
