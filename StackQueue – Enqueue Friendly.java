import java.util.Stack;

class StackQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation
    void enqueue(int value) {
        s1.push(value);
        System.out.println("Added: " + value);
    }

    // Dequeue operation
    int dequeue() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int value = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return value;
    }
}