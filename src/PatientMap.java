import utils.Patient;

import java.util.HashMap;

/**
 The PatientMap class implements a hash map data structure to store patient data. The class supports adding and
 retrieving patient data using key-value pairs.
 */

public class PatientMap
{
    // Declare instance variables
    private static final int DEFAULT_CAPACITY = 103;
    private Entry[] data;
    private int size;


    /**
     Constructor for PatientMap class with default capacity.
     */
    public PatientMap() {
        data = new Entry[DEFAULT_CAPACITY];

    }

    /**
     Constructor for PatientMap class with user-defined capacity.
     @param capacity the maximum capacity of the map
     @throws IllegalArgumentException if capacity is less than or equal to zero
     */
    public PatientMap(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Map capacity cannot be less than 1");
        }
        data = new Entry[capacity];
    }

    /**
     Returns the number of key-value pairs in the map.
     @return the number of key-value pairs in the map
     */
    public int size(){
        return size;
    }

    /**

     Computes the hash code for a given key.
     @param key the key to be hashed
     @return the hash code for the key
     */
    private int hash(String key){
        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % data.length;
        return hash;
    }

    /**
     Adds a key-value pair to the map.
     @param key the key for the data
     @param value the data to be stored
     @return the previous value associated with the key, or null if the key is not present
     @throws IllegalArgumentException if either key or value is null
     @throws SlotOccupiedException if the provided key maps to an occupied slot in the map
     */
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

        // Below uses list based chaining collision
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

    /**
     Retrieves the value associated with the given key.
     @param key the key for the data
     @return the data associated with the key, or null if the key is not present
     */
    public String get(String key){
        int slot = hash(key);
        if(data[slot] != null){
            return data[slot].value;
        }else{
            return null;
        }
    }

/**

 Resizes the map to twice its current size.
 @return the new, resized map
 @throws MapFullException if there is no space to store the data after resizing
 */
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
    public void removePatient(HashMap<String, Patient> patientMap, String firstName, String lastName , String DOB) {
        // Construct the key by concatenating first and last name
        String key = firstName + " " + lastName;

        // Use the remove() method to remove the entry with the given key
        Patient removedPatient = patientMap.remove(key);

        // Check if the remove() method returned a non-null value, indicating that a patient was removed
        if (removedPatient != null) {
            System.out.println("Patient " + firstName + " " + lastName + " has been removed successfully.");
        } else {
            System.out.println("Patient " + firstName + " " + lastName + " was not found in the system.");
        }
    }
    /**
     This is a static inner class representing an entry in the PatientMap.
     Each Entry object contains a key-value pair.
     */
    private static class Entry{
        // The key associated with this entry.
        private final String key;
        // The value associated with this entry.
        private String value;

        /**
         Constructs a new Entry object with the specified key and value.
         @param key the key to be associated with this entry.
         @param value the value to be associated with this entry.
         */
        public Entry(String key, String value){
            this.key = key;
            this.value = value;
        }

        /**
         Returns the key associated with this entry.
         @return the key associated with this entry.
         */
        public String getKey(){
            return key;
        }

        /**
         Returns the value associated with this entry.
         @return the value associated with this entry.
         */
        public String getValue(){
            return value;
        }

        /**
         Updates the value associated with this entry and returns the old value.
         @param newValue the new value to be associated with this entry.
         @return the old value associated with this entry.
         */
        public String updateValue(String newValue){
            String oldValue = value;
            this.value = newValue;
            return oldValue;
        }



    }
}
