// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// CircularLinkedList class
class CircularLinkedList {
    Node head;

    // Append data at the end
    public void append(int data) {
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

    // Insert data at a specific index (0-based)
    public void insertAtIndex(int index, int data) {
        Node newNode = new Node(data);

        if (index == 0) {
            if (head == null) {
                head = newNode;
                newNode.next = head;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = head;
                head = newNode;
            }
            return;
        }

        Node temp = head;
        int count = 0;

        while (count < index - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (count != index - 1) {
            System.out.println("Index out of range.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }
}

// Main class to test functionality
public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.append(10);
        cll.append(20);
        cll.append(30);

        System.out.println("Original li
