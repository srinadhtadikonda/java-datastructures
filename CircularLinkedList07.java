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

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Delete at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is Empty, nothing to delete.");
            return;
        }

        if (head.next == head) {
            // Only one node
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = head; // Second last node points to head
        }
    }

    // Display the list
