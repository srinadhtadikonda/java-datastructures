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

    // Display the circular linked list
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

        System.out.println("(back to head)");
    }

    // Insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next; // Find the last node
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Create initial list
    public void createInitialList() {
        Node n = new Node(10);
        head = n;

        Node n1 = new Node(20);
        n.next = n1;

        Node n2 = new Node(30);
        n1.next = n2;

        Node n3 = new Node(40);
        n2.next = n3;

        n3.next =
