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

    // Insert at the end
    void insend(int data) {
        Node ne = new Node(data);
        if (head == null) {
            head = ne;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = ne;
        }
    }

    // Display list
    void display() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("null");
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
        System.out.println("-------------------");
        L.insend(45);
        L.display();
    }
}
