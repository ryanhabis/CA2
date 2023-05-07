package collections;

import Exceptions.DuplicateAppointmentException;
import collections.AppointmentLinkedList;
import utils.Appointment;

import java.time.LocalDate;

public class PriorityQueue extends AppointmentLinkedList {

    public PriorityQueue() {
        super();

    }

    /**
     *
     * Adds a new task to the collections.PriorityQueue.
     *
     * @param app, the Appointment to add to the collections.PriorityQueue.
     *
     * @return true, if the Appointment was added otherwise false is returned.
     *
     */
    @Override
    public boolean add(Appointment app) throws DuplicateAppointmentException {
        Node newNode = new Node(app);
        if (isEmpty()) {
            first = newNode;
            last = newNode;

        } else if (first.data.compareTo(app) < 0) {
            newNode.next = first;
            first = newNode;
        } else if (last.data.compareTo(app) >= 0) {
            last.next = newNode;
            last = newNode;
        } else {
            Node current = first.next;
            Node previous = first;

            while (current != null && current.data.compareTo(app) >= 0) {
                if (current.data.equals(app)) {
                    throw new DuplicateAppointmentException("Appointment already exits");
                }
                previous = current;
                current = current.next;
            }

            previous.next = newNode;
            newNode.next = current;
        }

        numElements++;
        return true;
    }

    /**
     *
     * Removes all Appointment instances per the Patient details
     *
     * @param fName, the Appointment to add to the collections.PriorityQueue.
     * @param sName, the Appointment to add to the collections.PriorityQueue.
     * @param dob,   the Appointment to add to the collections.PriorityQueue.
     *
     *
     * @return true, if the Appointment was removed otherwise false is returned.
     *
     */
    public boolean removeAppointment(String fName, String sName, LocalDate dob) throws DuplicateAppointmentException {
        if (isEmpty()) {
            return false;
        }
        if (first.data.getFirstName().equals(fName) && first.data.getSurName().equals(sName)
                && first.data.getDob().equals(dob)) {
            first = first.next;
            numElements--;
            return true;
        }

        Node current = first.next;
        Node previous = first;

        while (current != null) {
            if (first.data.getFirstName().equals(fName) && first.data.getSurName().equals(sName) && first.data.getDob().equals(dob)) {
                previous.next = current.next;
                numElements--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;

    }

    @Override
    public Appointment get(int pos) {
        throw new UnsupportedOperationException("This method is not available for the Priority Queue");
    }

}