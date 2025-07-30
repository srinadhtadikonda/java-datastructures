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

        Node n1 = new Node(10);
        L.head = n1;
        System.out.println(L.head.data);

        Node n2 = new Node(20);
        n2.next = n1;
        System.out.println(n2.data);

        Node n3 = new Node(30);
        n3.next = n2;
        System.out.println(n3.data);

        Node n4 = new Node(40);
        System.out.println(n4.data);
    }
}
