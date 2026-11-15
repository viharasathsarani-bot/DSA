import java.util.LinkedList;
import java.util.Queue;

class PopFriendlyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    void push(int value) {
        q2.add(value);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation
    int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return q1.remove();
    }
}