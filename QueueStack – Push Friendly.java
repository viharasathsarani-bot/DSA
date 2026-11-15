import java.util.LinkedList;
import java.util.Queue;

class QueueStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    void push(int value) {
        q1.add(value);
        System.out.println("Pushed: " + value);
    }

    // Pop operation
    int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int value = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return value;
    }
}