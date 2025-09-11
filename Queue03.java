// Queue implementation using Linked List in Java

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front; // Front of the queue (head)
    private Node rear;  // Rear of the queue (end)

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue (Add element to the end of the queue)
    public void enqueue(String data) {
        Node newNode = new Node(data);

        if (rear == null) { // Queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueued " + data + " into the queue");
    }

    // Dequeue (Remove element from the front of the queue)
    public String dequeue() {
        if (isEmpty()) {
            return "Queue is empty!";
        }
        String removedData = front.data;
        front = front.next;

        if (front == null) { // If queue becomes empty
            rear = null;
        }
        return removedData;
    }

    // Peek (View front element without removing)
    public String peek() {
        if (isEmpty()) {
            return "Queue is empty!";
        }
        return front.data;
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue("Mon");
        q.enqueue("Tue");
        q.enqueue("Wed");

        System.out.println("Front element: " + q.peek());   // Mon
        System.out.println("Dequeued: " + q.dequeue());     // Mon
        System.out.println("Dequeued: " + q.dequeue());     // Tue
        System.out.println("Front element: " + q.peek());   // Wed
    }
}
