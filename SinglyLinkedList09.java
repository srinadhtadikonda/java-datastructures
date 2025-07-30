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

    // Display the list
    void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("None");
    }

    // Delete at specific position (1-based index)
    void deleteAtPosition(int pos) {
        if (head == null || pos <= 0) {
            System.out.println("Invalid position or empty list.");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node temp = head.next;
        Node prev = head;

        for (int i = 1; i < pos - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
            prev = prev.next;
        }

        prev.next = temp.next;
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
        Node n2 = new Node(3
