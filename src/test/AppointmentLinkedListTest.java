package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import collections.AppointmentLinkedList;
import Exceptions.DuplicateAppointmentException;
import utils.Appointment;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Conor Garvey
 */
public class AppointmentLinkedListTest {


    public AppointmentLinkedListTest() {
    }

    /**
     * Test of size method, of class AppointmentLinkedList where the Queue is
     * empty.
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void size_EmptyLinkedListTest()  throws DuplicateAppointmentException {
        System.out.println("size, being tested when the List is empty");
        AppointmentLinkedList appointments = new AppointmentLinkedList();
        int expected = 0;
        int actual = appointments.size();
        assertEquals(expected, actual);
    }

    /**
     * This tests the size method, of class AppointmentLinkedList, where there is
     * one Appointment present
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void size_LinkedListContainsOneAppointmentTest() throws DuplicateAppointmentException {
        System.out.println("size,being tested where there is an Appointment present");

        AppointmentLinkedList appointments = new AppointmentLinkedList();
        Appointment a1 = new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        appointments.add(a1);
        int expected = 1;
        int actual = appointments.size();
        assertEquals(expected, actual);

    }

    /**
     * This tests the indexOf method, of class AppointmentLinkedList, where there the
     * Appointment is Valid
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void indexOf_LinkedListValidAppointmentTest() throws DuplicateAppointmentException {
        Appointment s = new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        AppointmentLinkedList appointments = new AppointmentLinkedList();
        appointments.add(new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle"));
        appointments.add(new Appointment("Matt", "Quinn", LocalDate.of(2002, 2, 25),"Cough", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));
        appointments.add(new Appointment("Mary", "Bloggs", LocalDate.of(2001, 4, 21),"Headache", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));

        int expResult = 0;
        int result = appointments.indexOf(s);
        assertEquals(expResult, result);
    }

    /**
     * This tests the indexOf method, of class AppointmentLinkedList, where there is
     * Appointments present and the Appointment is invalid
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void testIndexOf_SongNotInList() throws DuplicateAppointmentException {

        Appointment a = new Appointment("Joe", "Bloggs2", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        AppointmentLinkedList appointments = new AppointmentLinkedList();
        appointments.add(new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle"));
        appointments.add(new Appointment("Matt", "Quinn", LocalDate.of(2002, 2, 25),"Cough", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));
        appointments.add(new Appointment("Mary", "Bloggs", LocalDate.of(2001, 4, 21),"Headache", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));

        int expResult = -1;
        int result = appointments.indexOf(a);
        assertEquals(expResult, result);
    }


    /**
     * This tests the get method, of class AppointmentLinkedList, where there is
     * the middle Appointment
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void get_LinkedListMiddleAppointment() throws DuplicateAppointmentException {
        AppointmentLinkedList appointments = new AppointmentLinkedList();
        appointments.add(new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle"));
        appointments.add(new Appointment("Matt", "Quinn", LocalDate.of(2002, 2, 25),"Cough", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));
        appointments.add(new Appointment("Mary", "Bloggs", LocalDate.of(2001, 4, 21),"Headache", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));

        Appointment expResult = new Appointment("Matt", "Quinn", LocalDate.of(2002, 2, 25),"Cough", LocalDate.of(2023, 5, 15),1,"Dr McCardle");
        Appointment result = appointments.get(1);
        assertEquals(expResult, result);
    }

    /**
     * This tests the get method, of class AppointmentLinkedList, where there is
     * the last Appointment
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void get_LinkedListLastAppointment() throws DuplicateAppointmentException {
        AppointmentLinkedList appointments = new AppointmentLinkedList();
        appointments.add(new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle"));
        appointments.add(new Appointment("Matt", "Quinn", LocalDate.of(2002, 2, 25),"Cough", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));
        appointments.add(new Appointment("Mary", "Bloggs", LocalDate.of(2001, 4, 21),"Headache", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));

        Appointment expResult = new Appointment("Mary", "Bloggs", LocalDate.of(2001, 4, 21),"Headache", LocalDate.of(2023, 5, 15),1,"Dr McCardle");
        Appointment result = appointments.get(2);
        assertEquals(expResult, result);
    }

    /**
     * This tests the get method, of class AppointmentLinkedList, where there is a
     * invalid value supplied
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void get_LinkedListInvalidGet() throws DuplicateAppointmentException {
        AppointmentLinkedList appointments = new AppointmentLinkedList();
        appointments.add(new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle"));
        appointments.add(new Appointment("Matt", "Quinn", LocalDate.of(2002, 2, 25),"Cough", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));
        appointments.add(new Appointment("Mary", "Bloggs", LocalDate.of(2001, 4, 21),"Headache", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            appointments.get(-1);
        });
    }
//
    /**
     * This tests the get method, of class AppointmentLinkedList, where there is an UpperBound
     * Greater than size
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void get_LinkedListUpperBound() throws DuplicateAppointmentException {
        AppointmentLinkedList appointments = new AppointmentLinkedList();
        appointments.add(new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle"));
        appointments.add(new Appointment("Matt", "Quinn", LocalDate.of(2002, 2, 25),"Cough", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));
        appointments.add(new Appointment("Mary", "Bloggs", LocalDate.of(2001, 4, 21),"Headache", LocalDate.of(2023, 5, 15),1,"Dr McCardle"));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            appointments.get(4);
        });
    }


    /**
     * This tests the isEmpty method, of class AppointmentLinkedList, where there
     * is one Appointment present
     */
    @Test
    public void isEmpty_NoAppointment() {
        System.out.println("isEmpty,being tested on an empty LinkedList");
        AppointmentLinkedList appointment = new AppointmentLinkedList();
        boolean expected = true;
        boolean actual = appointment.isEmpty();
        assertEquals(expected, actual);
    }

    /**
     * This tests the isEmpty method, of class AppointmentLinkedList, where there
     * is one Appointment present
     *
     *
     * @throws DuplicateAppointmentException, to ensure there is unique Appointments present
     */
    @Test
    public void isEmpty_OneAppointment() throws DuplicateAppointmentException {
        System.out.println("isEmpty, being tested where a LinkedList has an Appointment present ");
        AppointmentLinkedList appointment = new AppointmentLinkedList();
        Appointment a1 = new Appointment("Joe", "Bloggs", LocalDate.of(2000, 6, 15),"Severe Neck Pain", LocalDate.of(2023, 5, 15),4,"Dr McCardle");
        appointment.add(a1);
        boolean expected = false;
        boolean actual = appointment.isEmpty();
        assertEquals(expected, actual);
    }


}
