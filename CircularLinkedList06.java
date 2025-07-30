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
            // Find the last node
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Delete at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is Empty, nothing to delete.");
            return;
        }

        if (head.next == head) {
            // Only one node
            head = null;
        } else {
            Node temp = head;
            // Find last node
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("
