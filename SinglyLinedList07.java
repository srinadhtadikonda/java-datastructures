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

    void insertAtBeginning(int data) {
        Node nb = new Node(data);
        nb.next = head;
        head = nb;
    }

    void insertAtEnd(int data) {
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

    void insertAtPosition(int pos, int data) {
        if (pos <= 0) {
            System.out.println("Invalid Position!");
            return;
        }

        Node np = new Node(data);

        if (pos == 1) {
            np.next = head;
            head = np;
            return;
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        np.next = temp.next;
        temp.next = np;
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
            System.out.println("None");
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList L = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);

        // Initial list setup
        L.insertAtEnd(10);
        L.insertAtEnd(20);
        L.insertAtEnd(30);
        L.insertAtEnd(40);

        while (true) {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at beginning: ");
                    int begData = sc.nextInt();
                    L.insertAtBeginning(begData);
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    int endData = sc.nextInt();
                    L.insertAtEnd(endData);
                    break;
                case 3:
                    System.out.print("Enter position to insert at: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter data to insert: ");
                    int posData = sc.nextInt();
                    L.insertAtPosition(pos, posData);
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
