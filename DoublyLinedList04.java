import java.util.Scanner;

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

// Doubly Linked List class
class DoublyLinkedList {
    Node head;

    // 1️⃣ Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // 2️⃣ Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // 3️⃣ Insert at given position (1-based index)
    void insertAtPosition(int pos, int data) {
        if (pos < 1) {
            System.out.println("⚠️  Position must be ≥ 1");
            return;
        }
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("⚠️  Position out of bounds");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("⚠️  Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // Display the list
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("None");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        while (true) {
            System.out.println("\n======== Doubly Linked List ========");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Display list");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1‑5): ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter value to insert at beginning: ");
                    int val1 = Integer.parseInt(sc.nextLine());
                    dll.insertAtBeginning(val1);
                    break;
                case "2":
                    System.out.print("Enter value to insert at end: ");
                    int val2 = Integer.parseInt(sc.nextLine());
                    dll.insertAtEnd(val2);
                    break;
                case "3":
                    System.out.print("Enter position (1‑based index): ");
                    int pos = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter value to insert: ");
                    int val3 = Integer.parseInt(sc.nextLine());
                    dll.insertAtPosition(pos, val3);
                    break;
                case "4":
                    dll.display();
                    break;
                case "5":
                    Sy
