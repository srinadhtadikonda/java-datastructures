// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List class
class SinglyLinkedList {
    Node head;

    SinglyLinkedList() {
        this.head = null;
    }

    void display() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList L = new SinglyLinkedList();

        Node n = new Node(10);
        L.head = n;

        Node n1 = new Node(20);
        n.next = n1;

        Node n2 = new Node(30);
        n1.next = n2;

        Node n3 = new Node(40);
        n2.next = n3;

        L.display();
    }
}
