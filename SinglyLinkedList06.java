package corejavaprograms;
// Insert at given position
import  java.util.*;
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

    // Insert at given position (0-based index: pos=0 means after 1st node)
    void insertAtPosition(int pos, int data) {
        Node np = new Node(data);
        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of range");
                return;
            }
            temp = temp.next;
        }

        np.next = temp.next;
        temp.next = np;
    }
    // Display the list
    void display() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
        }
    }
}
public class Main 
{
    public static void main(String[] args)
    {
        SinglyLinkedList L = new SinglyLinkedList();
        
          Node n = new Node(10);
          L.head = n;

        Node n1 = new Node(20);
        n.next = n1;

        Node n2 = new Node(30);
        n1.next = n2;

        Node n3 = new Node(40);
        n2.next = n3;

        L.display();
        
        
        Scanner sc = new Scanner(System.in);
           System.out.print("Enter position to insert at: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter data to insert: ");
                    int posData = sc.nextInt();
                    L.insertAtPosition(pos, posData);
                    L.display();
    }
    }
