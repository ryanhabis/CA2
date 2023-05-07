package test;

import Exceptions.DuplicateAppointmentException;
import collections.AppointmentLinkedList;
import collections.PriorityQueue;
import org.junit.jupiter.api.Test;
import utils.Appointment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueTest {

    public PriorityQueueTest() {


    }

    /**
     * This tests the add method, of class PriorityQueue, where the Task
     * is first added to the Queue
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Tasks present
     */
    @Test
    public void add_FirstAppointmentTest() throws DuplicateAppointmentException {
        System.out.println("add, Adding the First Appointment to the Queue");
        Appointment a1 = new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        PriorityQueue appointments = new PriorityQueue();
        assertEquals(0, appointments.size());
        boolean expected = true;
        boolean actual = appointments.add(a1);
        assertEquals(expected, actual);
        Appointment result = appointments.remove();
        assertEquals(a1, result);
    }





}
