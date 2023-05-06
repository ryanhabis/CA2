import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Patient;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

class PatientMapTest
{
    private HashMap<Integer, Patient> hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new HashMap<>();
    }

    @Test
    public void testPutWhenKeyNotPresent() {

    }


}