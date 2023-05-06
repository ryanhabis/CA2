import utils.Appointment;

import java.util.NoSuchElementException;

public class AppointmentLinkedList {
    protected int numElements;
    protected Node first;
    protected Node last;

    public AppointmentLinkedList() {
        first = null;
        last = null;
    }
    /**
     * a method called size, which returns the lists capacity
     *
     * @return numElements, the number of elements stored in the list
     */
    public int size() {
        return numElements;
    }
    /**
     *
     * Returns the element at the specified position in the List.
     *
     * @param pos the position of the Appointment to be returned.
     * @return the Appointment at the specified position.
     * @throws IndexOutOfBoundsException if the position is out of range.
     */
    public Appointment get(int pos) {
        if (isEmpty() || pos >= numElements || pos < 0) {
            throw new IndexOutOfBoundsException("Invalid position supplied");
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
     * @return count, which is the number of where the Appointment appears on the list
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

    public Appointment set(Appointment str, int pos) {
        if (pos >= numElements || pos < 0) {
            throw new IndexOutOfBoundsException("Invalid position supplied");
        }
        Node current = first;
  for (int i=0;i<pos;i++){
      current=current.next;
  }
        Appointment temp = current.data;
  current.data=temp;
        return temp;
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

    /**
     *
     * Returns the first element in the queue without removing it.
     *
     * @return the first element in the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public Appointment peek() {
        Node current = first;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return current.data;
    }



    /**
     * Inserts the specified element into the queue.
     *
     * @param data the element to be inserted.
     * @return true,if the element was successfully inserted, otherwise
     *         false.
     * @throws DuplicateAppointmentException if the Appointment already exists in the queue.
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
     * Removes and returns the first element in the queue.
     *
     * @return the first element in the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public Appointment remove() {
        Appointment temp = null;
        if (isEmpty()) {
            throw new NoSuchElementException("Element dosen't exist, Queue is Empty");
        } else {
            temp = first.next;
            first = first.next;
        }
        numElements--;
        return temp;
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
