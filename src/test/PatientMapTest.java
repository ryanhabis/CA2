package test;
import collections.AppointmentLinkedList;
import collections.PatientMap;
import org.junit.jupiter.api.Test;
import utils.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientMapTest
{
    /**
     * Checks if the PatientMap has added one to the size
     */
    @Test
    public void testSize() {
        PatientMap patientMap = new PatientMap();
        assertNull(patientMap.put("key1", "value1"));
        assertEquals(1, patientMap.size());
    }

    /**
     * tests to see if the value is there once its added.
     */
    @Test
    public void testPut()
    {
        PatientMap patientMap = new PatientMap();
        assertNull(patientMap.put("key1", "value1"));
        assertEquals(1, patientMap.size());
        assertEquals("value1", patientMap.get("key1"));

        assertNull(patientMap.put("key2", "value2"));
        assertEquals(2, patientMap.size());
        assertEquals("value2", patientMap.get("key2"));

        assertEquals("value1", patientMap.put("key1", "new_value"));
        assertEquals(2, patientMap.size());
        assertEquals("new_value", patientMap.get("key1"));

    }
}