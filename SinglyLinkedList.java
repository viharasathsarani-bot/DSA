class SinglyLinkedList {
    private Node head;

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at the beginning
    void insertFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    void insertLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Delete from the beginning
    int deleteFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        int value = head.data;
        head = head.next;
        return value;
    }

    // Delete a value
    void deleteValue(int value) {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found");
            return;
        }

        current.next = current.next.next;
    }

    // Display list
    void display() {
        Node current = head;

        System.out.print("List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(30);
        list.insertLast(40);

        list.display();

        System.out.println("Deleted: " + list.deleteFirst());

        list.deleteValue(30);

        list.display();
    }
}