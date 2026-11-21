import java.util.Stack;

class StackQueueDequeueFriendly {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue operation
    void enqueue(int value) {
        s1.push(value);
        System.out.println("Enqueued: " + value);
    }

    // Dequeue operation
    int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    // Peek operation
    int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly queue = new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
    }
}