package test;

import Exceptions.DuplicateAppointmentException;
import collections.AppointmentLinkedList;
import collections.PriorityQueue;
import org.junit.jupiter.api.Test;
import utils.Appointment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriorityQueueTest {

    public PriorityQueueTest() {


    }

    /**
     * This tests the add method, of class PriorityQueue, where the Appointment
     * is first added to the Queue
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
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

    /**
     * This tests the add method, of class PriorityQueue, where the Appointment
     * is added to the start of the Queue
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void add_StartOfQueueTest() throws DuplicateAppointmentException {
        System.out.println("add, where a Appointment object is added to the start of the Queue");
        Appointment a1 = new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        Appointment a2 = new Appointment("Mary", "Blogg", LocalDate.of(2000, 1, 15),"Severe Back Pain", LocalDate.of(2023, 5, 15),1,"Dr McCardle");
        PriorityQueue appointments = new PriorityQueue();
        appointments.add(a1);
        boolean expected = true;
        boolean actual = appointments.add(a2);
        assertEquals(expected, actual);
        Appointment result = appointments.remove();
        assertEquals(a2, result);
    }
    /**
     * This tests the add method, of class PriorityQueue, where the Appointment
     * is added to the End of the Queue
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void add_EndOfQueueTest() throws DuplicateAppointmentException {
        System.out.println("add, where a Appointment object is added to the End of the Queue");
        Appointment a1 = new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),5,"Dr McCardle");
        Appointment a2 = new Appointment("Mary", "Blogg", LocalDate.of(2000, 1, 15),"Mild Code", LocalDate.of(2023, 5, 15),1,"Dr McCardle");
        PriorityQueue appointments = new PriorityQueue();
        System.out.println("add, where a Task is Added to the End of the Queue");
        appointments.add(a1);
        boolean expected = true;
        boolean actual = appointments.add(a2);
        assertEquals(expected, actual);
        Appointment remove = appointments.remove();
        Appointment resultTask = appointments.remove();
        assertEquals(a1, resultTask);
    }

    /**
     * This tests the add method, of class PriorityQueue, where the Appointment
     * is added to the End of the Queue
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void add_InMiddleOfQueueTest() throws DuplicateAppointmentException {
        System.out.println("add, where a Appointment object is added to the Middle of the Queue");
      Appointment a1= new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        Appointment a2=new Appointment("Matt", "Quinn", LocalDate.of(2002, 2, 25),"Cough", LocalDate.of(2023, 5, 15),3,"Dr McCardle");
        Appointment a3=new Appointment("Mary", "Bloggs", LocalDate.of(2001, 4, 21),"Headache", LocalDate.of(2023, 5, 15),1,"Dr McCardle");

        PriorityQueue appointments = new PriorityQueue();

        appointments.add(a1);
        appointments.add(a3);
        boolean expected = true;
        boolean actual = appointments.add(a2);
        assertEquals(expected, actual);
        appointments.remove();
        Appointment resultTask = appointments.remove();
        assertEquals(a2, resultTask);
    }
    /**
     * This tests the add method, of class PriorityQueue, where the Appointment
     * Objects are equal
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void add_WhereTwoAppointmentsAreEqualTest() throws DuplicateAppointmentException {
        System.out.println("add, Testing to add a Appointment where two Appointment are equal");
        Appointment a1= new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        Appointment a2= new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        PriorityQueue appointments = new PriorityQueue();

        appointments.add(a1);

        Throwable thrown = assertThrows(DuplicateAppointmentException.class, () -> {appointments.add(a2);
        });
        assertEquals("The Appointment has Already been booked", thrown.getMessage());
    }
}
