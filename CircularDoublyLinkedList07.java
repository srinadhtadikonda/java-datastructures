class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class CircularDLL {
    Node head;

    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            last.next = newNode;
            newNode.prev = last;

            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        Node temp = head;
        int count = 0;

        // Deleting head
        if (position == 0) {
            if (head.next == head) {
                head = null;
            } else {
                Node last = head.prev;
                head = head.next;
                head.prev = last;
                last.next = head;
            }
            return;
        }

        // Traverse to desired position
        while (count < position && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (count == position) {
            if (temp.next == head) {
                // Last node
                Node secondLast = temp.prev;
                secondLast.next = head;
                head.prev = secondLast;
            } else {
                // Middle node
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        } else {
            System.out.println("Position exceeds the number of nodes.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CircularDLL list = new CircularDLL();

        // Manually creating nodes and linking them (as in original Python code)
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        System.out.println("Before deleting at position:");
        list.display();

        list.deleteAtPosition(0);
        System.out.println("After deleting at position 0:");
        list.display();

        list.deleteAtPosition(2);
        System.out.println("After deleting at position 2:");
        list.display();

        list.deleteAtPosition(10);
        System.out.println("After trying to delete at an invalid position:");
        list.display();
    }
}
