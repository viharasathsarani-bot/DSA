class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Node class
    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Insert at the beginning
    void insertFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    void insertLast(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete from the beginning
    int deleteFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        int value = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        return value;
    }

    // Delete from the end
    int deleteLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }

        int value = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        return value;
    }

    // Delete a specific value
    void deleteValue(int value) {
        Node current = head;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found");
            return;
        }

        if (current == head) {
            deleteFirst();
            return;
        }

        if (current == tail) {
            deleteLast();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    // Display forward
    void displayForward() {
        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Display backward
    void displayBackward() {
        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(30);
        list.insertLast(40);

        list.displayForward();
        list.displayBackward();

        System.out.println("Deleted first: " + list.deleteFirst());
        System.out.println("Deleted last: " + list.deleteLast());

        list.insertLast(50);
        list.deleteValue(30);

        list.displayForward();
        list.displayBackward();
    }
}