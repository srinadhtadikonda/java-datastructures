import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    // Insert node at the end
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is Empty\n");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)\n");
    }

    // Delete node at beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is Empty, nothing to delete.\n");
            return;
        }

        if (head.next == head) {
            System.out.println("Deleted node: " + head.data);
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            System.out.println("Deleted node: " + head.data);
            head = head.next;
            temp.next = head;
        }
    }

    // Delete node at end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is Empty, nothing to delete.\n");
            return;
        }

        if (head.next == head) {
            System.out.println("Deleted node: " + head.data);
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            System.out.println("Deleted node: " + temp.next.data);
            temp.next = head;
        }
    }

    // Delete node at specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is Empty, nothing to delete.\n");
            return;
        }

        if (position == 0) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        Node prev = null;
        int count = 0;

        while (count < position) {
            prev = current;
            current = current.next;
            count++;
            if (current == head) {
                System.out.println("Position out of bounds.\n");
                return;
            }
        }

        System.out.println("Deleted node: " + current.data);
        prev.next = current.next;
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList C = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);

        // Initial list setup (optional)
        for (int value : new int[]{10, 20, 30, 40}) {
            C.insertEnd(value);
        }

        while (true) {
            System.out.println("CURRENT LIST:");
            C.display();

            System.out.println("MENU:");
            System.out.println("1. Delete node at the beginning");
            System.out.println("2. Delete node at the end");
            System.out.println("3. Delete node at a specific position");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    C.deleteAtBeginning();
                    break;
                case "2":
                    C.deleteAtEnd();
                    break;
                case "3":
                    try {
                        System.out.print("Enter position (0-based index): ");
                        int pos = Integer.parseInt(sc.nextLine());
                        C.deleteAtPosition(pos);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.\n");
                    }
                    break;
                case "4":
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select from 1 to 4.\n");
            }
        }
    }
}
