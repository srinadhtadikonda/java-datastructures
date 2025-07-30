//program to define singly linked list
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
}

// Main class to test the list
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList L = new SinglyLinkedList();
        Node n = new Node(10);
        L.head = n;
        System.out.println(L.head.data);
    }
}
