

import java.util.Deque;
import java.util.LinkedList;

class PriorityQueueCustom {
    private LinkedList<Integer> queue;

    public PriorityQueueCustom() {
        queue = new LinkedList<>();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Insert element into queue
    public void insert(int data) {
        queue.add(data);
    }

    // Delete element based on priority (max value)
    public int delete() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int maxIndex = 0;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) > queue.get(maxIndex)) {
                maxIndex = i;
            }
        }

        return queue.remove(maxIndex);
    }
}
