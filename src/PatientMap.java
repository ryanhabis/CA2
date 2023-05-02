import java.util.LinkedList;

public class PatientMap
{
    // Declare instance variables
    private final int mapSize = 100; // Assuming Map size is 100
    private LinkedList<Patient>[] map;

    public PatientMap() {
        map = new LinkedList[mapSize];
        for (int i = 0; i < mapSize; i++) {
            map[i] = new LinkedList<Patient>();
        }
    }

}
