

public class QueueAndPriorityQueueDemo {
    public static void main(String[] args) {
        // --------- Deque as Queue ---------
        Deque<String> q = new LinkedList<>();
        q.addLast("g");
        q.addLast("f");
        q.addLast("g");

        System.out.println("Initial queue:");
        System.out.println(q);

        System.out.println("\nElements dequeued from the queue:");
        System.out.println(q.removeFirst());
        System.out.println(q.removeFirst());
        System.out.println(q.removeFirst());

        System.out.println("\nQueue after removing elements:");
        System.out.println(q);

        // --------- Custom Priority Queue ---------
        PriorityQueueCustom myQueue = new PriorityQueueCustom();
        myQueue.insert(12);
        myQueue.insert(1);
        myQueue.insert(14);
        myQueue.insert(7);

        System.out.println("\nPriority Queue:");
        System.out.println(myQueue);

        System.out.println("\nDeleting elements based on priority:");
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.delete());
        }
    }
}
