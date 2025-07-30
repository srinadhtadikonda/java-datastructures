import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public CircularLinkedList() {
        head = null;
    }

    // Insert at beginning
    public void insertBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        last.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        last.next = newNode;
        newNode.next = head;
    }

    // Insert at index
    public void insertAtIndex(int index, int data) {
        if (index < 0) {
            System.out.println("Index must be non‑negative\n");
            return;
        }

        if (index == 0) {
            insertBegin(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;

        while (count < index - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (count != index - 1) {
            System.out.println("Index out of range\n");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Display the list
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty\n");
            return;
        }

        Node temp = head;
        while (true) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            if (temp == head)
                break;
        }
        System.out.println("(back to head)\n");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        // Optional: initialize with values
        for (int val : new int[]{10, 20, 30, 40}) {
            cll.insertEnd(val);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("CURRENT LIST:");
            cll.display();
            System.out.println("MENU");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at a specific index");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter value to insert at beginning: ");
                    int beginVal = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    cll.insertBegin(beginVal);
                    break;
                case "2":
                    System.out.print("Enter value to insert at end: ");
                    int endVal = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    cll.insertEnd(endVal);
                    break;
                case "3":
                    try {
                        System.out.print("Enter index (0‑based): ");
                        int index = scanner.nextInt();
                        System.out.print("Enter value to insert: ");
                        int val = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        cll.insertAtIndex(index, val);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter integers only.\n");
                        scanner.nextLine(); // clear invalid input
                    }
                    break;
                case "4":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 4.\n");
            }
        }
    }
}
