class MyLinkedList {
    // Head node of the linked list
    private Node head;

    // Inner class representing a node in the linked list
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Constructor initializes an empty linked list
    public MyLinkedList() {
        head = null;
    }

    // Get the value of the node at a specific index
    public int get(int index) {
        Node current = head;
        // Traverse the list up to index
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return -1;  // Index is out of bounds
            }
            current = current.next;
        }
        // Return value if node at index exists, else -1
        return (current != null) ? current.value : -1;
    }

    // Add a new node at the beginning of the list
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    // Add a new node at the end of the list
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val);
    }

    // Add a new node before the node at the specified index
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node current = head;
        // Traverse to one node before the target index
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            return;  // Index is out of bounds, do nothing
        }
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete the node at the specified index
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;  // List empty, nothing to delete
        }
        if (index == 0) {
            head = head.next;  // Remove head node
            return;
        }
        Node current = head;
        // Traverse to one node before the target index
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return;  // Index out of bounds, nothing to delete
        }
        // Bypass the node at index to delete it
        current.next = current.next.next;
    }
}
