import utils.Patient;
import java.util.Map;

public class PatientMap
{
    // Declare instance variables
    private static final int DEFAULT_CAPACITY = 103;
    private Entry[] data;
    private int size;



    public PatientMap() {
        data = new Entry[DEFAULT_CAPACITY];

    }

    public PatientMap(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Map capacity cannot be less than 1");
        }
        data = new Entry[capacity];
    }

    public int size(){
        return size;
    }


    private int hash(String key){
        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % data.length;
        return hash;
    }


    public String put(String key, String value){
        if(key == null || value == null){
            throw new IllegalArgumentException("Null fields not permitted");
        }
        if(size == data.length){
            data = growMap();
        }

        int slot = hash(key);
        System.out.println("Size of map: " + size + ", capacity: " + data.length);
        System.out.println("Slot calculated: " + slot);

        if(data[slot] == null){
            Entry newEntry = new Entry(key, value);
            data[slot] = newEntry;
            size++;
            return null;
        }else{
            if(data[slot].key.equals(key)){
                String oldValue = data[slot].updateValue(value);
                return oldValue;
            }else{
                throw new SlotOccupiedException("Provided key maps to occupied slot in map.");
            }
        }
    }
    public String get(String key){
        int slot = hash(key);
        if(data[slot] != null){
            return data[slot].value;
        }else{
            return null;
        }
    }

    private Entry[] growMap(){
        Entry[] newMap = new Entry[data.length*2];
        for(int i = 0; i < data.length; i++){
            String key = data[i].key;
            int slot = key.hashCode();
            slot = Math.abs(slot);
            slot = slot % newMap.length;
            if(newMap[slot] != null){
                throw new MapFullException("Cannot complete resize operation. Continued action would result in data loss.");
            }
            newMap[slot]=data[i];
        }

        return newMap;
    }

    private static class Entry{
        private final String key;
        private String value;

        public Entry(String key, String value){
            this.key = key;
            this.value = value;
        }

        public String getKey(){
            return key;
        }
        public String getValue(){
            return value;
        }
        public String updateValue(String newValue){
            String oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }
}
