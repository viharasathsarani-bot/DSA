class ArrayCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        System.out.println("Enqueued: " + value);
    }

    // Dequeue operation
    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int value = queue[front];
        front = (front + 1) % capacity;
        size--;

        return value;
    }

    // Get front element
    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return queue[front];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    int getSize() {
        return size;
    }

    // Display queue elements
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();
        System.out.println("Front: " + queue.peek());
    }
}