import java.util.ArrayList;
import java.util.List;

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

    // Append a new node at the end
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Display the linked list
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

// Main class to test
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Create list from ArrayList
        List<Integer> dataList = new ArrayList<>();
        dataList.add(10);
        dataList.add(20);
        dataList.add(30);
        dataList.add(40);
        dataList.add(50);

        for (int data : dataList) {
            list.append(data);
        }

        list.display();
    }
}
