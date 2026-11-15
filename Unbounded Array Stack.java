class UnboundedArrayStack {
    private int[] stack;
    private int top;

    UnboundedArrayStack() {
        stack = new int[2];
        top = -1;
    }

    // Resize array
    private void resize(int capacity) {
        int[] newStack = new int[capacity];

        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    // Push operation
    void push(int value) {
        if (top == stack.length - 1) {
            resize(stack.length * 2);
        }

        stack[++top] = value;
    }

    // Pop operation
    int pop() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }

        int value = stack[top--];

        if (stack.length > 2 && top + 1 <= stack.length / 4) {
            resize(Math.max(2, stack.length / 2));
        }

        return value;
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}