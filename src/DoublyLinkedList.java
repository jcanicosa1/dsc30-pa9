/*
 * NAME: Jenna Canicosa
 * PID: A16957972
 */

import java.util.AbstractList;

/**
 * Double Linked List class
 * @author Jenna Canicosa
 * @since April 19, 2022
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            // Unlinks the node from its list.
            Node oldPrev = getPrev();
            Node newNext = getNext();
            newNext.setPrev(getPrev());
            oldPrev.setNext(newNext);
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        this.head = new Node(null);
        this.tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        Node toAdd = new Node(element);
        if (head.next == null) { // checks if the list is empty
            head.next = toAdd;
            toAdd.prev = head;
            tail.prev = toAdd;
            toAdd.next = tail;
        } else {
            Node previous = tail.prev;
            toAdd.prev = tail.prev;
            tail.prev = toAdd;
            toAdd.next = tail;
            previous.next = toAdd;
        }
        nelems++;
        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * @param index where the element will be added
     * @param element to be added to the list
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        Node toAdd = new Node(element);
        if (index == 0) { // checks if head connection needs to be changed
            Node oldFirst = head.next;
            head.next = toAdd;
            toAdd.prev = head;
            oldFirst.prev = toAdd;
            toAdd.next = oldFirst;
        } else if (index == nelems) { // uses the add element so the end is connected to tail
            add(element);
        } else { // if it is inserted in the middle
            Node oldPrev = head.next;
            Node oldNext = oldPrev.getNext();

            for (int i = 1; i < index; i++) {
                oldPrev = oldPrev.getNext();
                oldNext = oldNext.getNext();
            }

            oldPrev.next = toAdd;
            toAdd.next = oldNext;
            oldNext.prev = toAdd;
            toAdd.prev = oldPrev;
        }
        nelems++;
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        head.next = null;
        tail.prev = null;
        nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     * @param element checks if this is in the list at least once
     * @return true if the element is in the list, else false if not
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        Node check = new Node(data);
        Node current = head.next;
        for (int i = 0; i < size(); i++) {
            if (current.data == check.data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     * @param index of the node to be returned
     * @exception IndexOutOfBoundsException index is outside of the range [0, size -1]
     * @return the data at the given index
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Helper method to get the Nth node in our list
     * @param index of the node to be returned
     * @return the node at the given index
     */
    private Node getNth(int index) {
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            if (i == index) {
                break;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    /**
     * Determine if the list empty
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (nelems == 0) {
            return true;
        }
        return false;
    }

    /**
     * Remove the element from position index in the list
     * @param index removes the element at a specific index
     * @return the data contained from the specific index
     * @exception IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node current = this.getNth(index);
        Node temp = current;
        current.remove();
        nelems--;
        return temp.data;
    }

    /**
     * Set the value of an element at a certain index in the list.
     * @param index the node index to be changed
     * @param element the new value in the node
     * @exception IndexOutOfBoundsException if index is out of range
     * @exception NullPointerException if data is null
     * @return the data stored in the node at the given index
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        T val = remove(index);
        add(index, element);
        return val;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     * @returns the number of elements in the list
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     * @return string created
     */
    @Override
    public String toString() {
        String data = String.valueOf(head.next.data);
        String toReturn = "[" + data;
        Node current = head.next;
        String currentStr = "";
        if (nelems == 1) {
            toReturn += " --> " + data;
        } else {
            for (int i = 1; i < nelems; i++) {
                current = current.next;
                currentStr = String.valueOf(current.data);
                toReturn += " --> " + currentStr;
            }
        }
        return toReturn + "]";
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     * @param base the multiple of base is the indexes that is searched for
     * @throws IllegalArgumentException base is less than 1
     */
    public void removeMultipleOf(int base) {
        if (base < 2) {
            throw new IllegalArgumentException();
        }
        int currentBase = 0;
        while (currentBase < nelems) {
            remove(currentBase);
            currentBase += base;
        }
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     * @param other DDL to swap values with
     * @param splitIndex swaps [0, splitIndex]
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        Node currentOriginal = head.next;
        Node currentSwap = other.head.next;
        for (int i = 0; i <= splitIndex; i++) {
            Node temp = currentOriginal;
            currentOriginal.data = set(i, temp.data);
            currentSwap.data = set(i, currentSwap.data);
            currentOriginal = currentOriginal.next;
            currentSwap = currentSwap.next;
        }
    }

}
