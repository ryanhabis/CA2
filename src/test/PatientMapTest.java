package test;
import Exceptions.SlotOccupiedException;
import collections.AppointmentLinkedList;
import collections.PatientMap;
import org.junit.jupiter.api.Test;
import utils.Patient;

import java.time.LocalDate;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class PatientMapTest
{
    @Test
    public void testPut() {
        PatientMap map = new PatientMap();

        // Add a patient to the map
        AppointmentLinkedList appointmentList1 = new AppointmentLinkedList();
        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now(), appointmentList1);
        Patient result = map.put(1, patient1);

        // Check that the returned value is null
        assertNull(result);

        // Add a second patient to the same key as the first
        AppointmentLinkedList appointmentList2 = new AppointmentLinkedList();
        Patient patient2 = new Patient("Jane", "Doe", LocalDate.of(1992, 2, 2), LocalDate.now(), appointmentList2);
        assertThrows(SlotOccupiedException.class, () -> map.put(1, patient2));

        // Add a third patient with a different key
        AppointmentLinkedList appointmentList3 = new AppointmentLinkedList();
        Patient patient3 = new Patient("Bob", "Smith", LocalDate.of(1985, 3, 3), LocalDate.now(), appointmentList3);
        result = map.put(2, patient3);

        // Check that the returned value is null
        assertNull(result);

        // Check that the size of the map has increased to 2
        assertEquals(2, map.size());
    }

    @Test
    public void testSize() {
        PatientMap map = new PatientMap();

        // Add some patients to the map
        map.put(1, new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now(), new AppointmentLinkedList()));
        map.put(2, new Patient("Jane", "Doe", LocalDate.of(1992, 2, 2), LocalDate.now(), new AppointmentLinkedList()));

        // Check that the size of the map is 2
        assertEquals(2, map.size());
    }

    @Test
    public void testGet() {
        PatientMap map = new PatientMap();

        // Add a patient to the map
        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now(), new AppointmentLinkedList());
        map.put(1, patient1);

        // Get the patient from the map
        Patient result = map.get(1);

        // Check that the returned value is the same as the inserted value
        assertEquals(patient1, result);

        // Try to get a patient that does not exist
        result = map.get(2);

        // Check that the returned value is null
        assertNull(result);
    }


}