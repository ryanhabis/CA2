package collections;

import utils.Appointment;

import java.util.NoSuchElementException;

public class AppointmentLinkedList {
    protected int numElements;
    protected Node first;
    protected Node last;

    /**
     * An AppointmentLinkedList class setting first and last
     * Nodes to null
     */
    public AppointmentLinkedList() {
        first = null;
        last = null;
    }

    /**
     * a method called size, which returns the lists capacity
     *
     * @return numElements, the number of Appointments stored in the list
     */
    public int size() {
        return numElements;
    }

    /**
     *
     * Returns the Appointment at the specified position in the List.
     *
     * @param pos the position of the Appointment to be returned.
     * @return the Appointment at the specified position.
     * @throws IndexOutOfBoundsException if the position is out of range.
     */
    public Appointment get(int pos) {
        if (isEmpty() || pos >= numElements || pos < 0) {
            throw new IndexOutOfBoundsException("Invalid position supplied, Appointment not found");
        } else {
            Node current = first;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    /**
     * indexOf, where which a linear search is used to find a match with the value
     * and returns the position in the list if not found -1 is returned
     *
     * @param value, which is used to search the list for a matching Appointment
     *
     * @return count, which is the number of where the Appointment appears on the
     *         list
     */
    public int indexOf(Appointment value) {
        Node current = first;
        int count = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return count;
            } else {
                current = current.next;
                count++;
            }

        }
        return -1;
    }
    /**
     * set, where pos is validated and if not an IndexOutOfBoundsException is thrown otherwise,
     *      then it tranverses through the Node links, until it reaches the pos supplied
     *      where an Appointment object called temp is created and is set to the current Node
     *      and the current node is set to the new Appointment and the temp is returned
     *
     * @param app, the Appointment which will be set at the appropiate position
     * @param pos, the position of the list which to set the new Appointment
     *
     * @return temp, which is the old Appointment object comfirming the set method
     *               worked correctly
     */
    public Appointment set(Appointment app, int pos) {
        if (pos >= numElements || pos < 0) {
            throw new IndexOutOfBoundsException("Invalid position supplied");
        }
        Node current = first;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        Appointment temp = current.data;
        current.data = app;
        return temp;
    }



    /**
     * Inserts the specified element into the List, which is at the end of th.
     * The number of elements will be updated
     *
     * @param data the Appointment to be inserted.
     * @return true,if the element was successfully inserted, otherwise false.
     */
    public boolean add(Appointment data) throws DuplicateAppointmentException {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        numElements++;
        return true;
    }

    /**
     *
     * Removes and returns the first instance of the Appointment in the List.
     * By tranversing the node Links checking the first Node and if so it is deleted.
     * Then it tranverses the rest of the links, true is returned if the Appointment is found
     * The number of elements was updated
     *
     * @param data, the Appointment to remove from the List
     * @return isRemoved, true if the Appointment has been removed, false if it hasnt.
     */
    public boolean remove(Appointment data) {
        boolean isRemoved = false;
        if (first.data.equals(data)) {
            first = first.next;
            numElements--;
            isRemoved = true;
        }
        Node current = first.next;
        Node previous = first;

        while (current != null) {
            if (current.data.equals(data)) {
                previous.next = current.next;
                numElements--;
                isRemoved = true;
            }
            previous = current;
            current = current.next;
        }
        return isRemoved;
    }
    /**
     *
     * Checks whether the list is empty.
     *
     * @return true,if the list is empty, otherwise false is returned.
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    protected static class Node {
        protected Appointment data;
        protected Node next;

        /**
         * Constructs a new node with the given data.
         *
         * @param a the Appointment data to be stored in the node.
         */
        public Node(Appointment a) {
            this.data = a;
            this.next = null;
        }
    }
}
