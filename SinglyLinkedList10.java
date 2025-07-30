import java.util.Scanner;

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
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("None");
    }

    void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is Empty. Nothing to delete.");
        } else {
            Node temp = head;
            head = temp.next;
            temp.next = null;
            System.out.println("Node deleted from beginning.");
        }
    }

    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is Empty. Nothing to delete.");
        } else if (head.next == null) {
            head = null;
            System.out.println("Only node deleted from end.");
        } else {
            Node temp = head.next;
            Node prev = head;
            while (temp.next != null) {
                temp = temp.next;
                prev = prev.next;
            }
            prev.next = null;
            System.out.println("Node deleted from end.");
        }
    }

    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is Empty. Nothing to delete.");
            return;
        }
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            head = head.next;
            System.out.println("Node at position " + pos + " deleted.");
            return;
        }

        Node temp = head.next;
        Node prev = head;

        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
            prev = prev.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else {
            prev.next = temp.next;
            System.out.println("Node at position " + pos + " deleted.");
        }
    }
}

// Main class with menu
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList L = new SinglyLinkedList();

        // Initial list setup
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        L.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        while (true) {
            System.out.println("\n--- Linked List Deletion Menu ---");
            System.out.println("1. Delete at Beginning");
            System.out.println("2. Delete at End");
            System.out.println("3. Delete at Specific Position");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    L.deleteAtBeginning();
                    break;
                case 2:
                    L.deleteAtEnd();
                    break;
                case 3:
                    System.out.print("Enter the position to delete: ");
                    int pos = sc.nextInt();
                    L.deleteAtPosition(pos);
                    break;
                case 4:
                    L.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice. Try Again.");
            }
        }
    }
}
