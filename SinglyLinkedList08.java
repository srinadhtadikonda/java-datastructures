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

    // Delete at end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is Empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head.next;
            Node prev = head;
            while (temp.next != null) {
                temp = temp.next;
                prev = prev.next;
            }
            prev.next = null;
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
