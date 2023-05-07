package collections;

import Exceptions.MapFullException;
import Exceptions.SlotOccupiedException;
import utils.Patient;
import java.util.HashMap;

/**
 The collections.PatientMap class implements a hash map data structure to store patient data. The class supports adding and
 retrieving patient data using key-value pairs.
 */

public class PatientMap
{
    // Declare instance variables
    private static final int DEFAULT_CAPACITY = 103;
    private Entry[] data;
    private int size;
    private static HashMap<Integer, Patient> patientMap = new HashMap<>();
    private static int id = 0;
    private int niqueID;
    /**
     Constructor for collections.PatientMap class with default capacity.
     */
    public PatientMap() {
        data = new Entry[DEFAULT_CAPACITY];
        id++;
        niqueID= id;
    }

    /**
     Constructor for collections.PatientMap class with user-defined capacity.
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
     @return the hash code for the key
      * @param key the key to be hashed
     */
    private int hash(int key){
        int hash = Integer.hashCode(key);
        hash = Math.abs(hash);
        hash = hash % data.length;
        return hash;
    }

    public void addPatient(Patient patient) {
        patientMap.put(niqueID, patient);
    }
    /**
     Adds a key-value pair to the map.
     @return the previous value associated with the key, or null if the key is not present
     @throws IllegalArgumentException if either key or value is null
     @throws SlotOccupiedException if the provided key maps to an occupied slot in the map
      * @param key the key for the data
     * @param value the data to be stored
     */
    public Patient put(int key, Patient value){
        if(key == 0 || value == null){
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
            if(key == data[slot].key){
                Patient oldValue = data[slot].updateValue(value);
                return oldValue;
            }else{
                throw new SlotOccupiedException("Provided key maps to occupied slot in map.");
            }
        }
    }


    /**
     Retrieves the value associated with the given key.
     @return the data associated with the key, or null if the key is not present
      * @param key the key for the data
     */
    public Patient get(int key){
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
            int key = data[i].key;
            int slot = key;
            slot = Math.abs(slot);
            slot = slot % newMap.length;
            if(newMap[slot] != null){
                throw new MapFullException("Cannot complete resize operation. Continued action would result in data loss.");
            }
            newMap[slot]=data[i];
        }

        return newMap;
    }



    public static void removePatient(Patient key) {
        // Use the remove() method to remove the entry with the given key
        Patient removedPatient = patientMap.remove(key.getFirstName() + key.getSurName() + key.getDob().toString());
    }

    public boolean containsPatient(int key, Patient patient) {
        if (patientMap.containsKey(key)) {
            Patient storedPatient = patientMap.get(key);
            return storedPatient.equals(patient);
        } else {
            return false;
        }
    }


    public void displayAllPatients(PatientMap patientMap) {
//        for (Patient patient : patientMap.getValue()) {
//            System.out.println(patient);
//        }
    }



    /**
     This is a static inner class representing an entry in the collections.PatientMap.
     Each Entry object contains a key-value pair.
     */
    private static class Entry{
        // The key associated with this entry.
        private final int key;
        // The value associated with this entry.
        private Patient value;

        /**
         Constructs a new Entry object with the specified key and value.
         * @param key the key to be associated with this entry.
         * @param value the value to be associated with this entry.
         */
        public Entry(int key, Patient value){
            this.key = key;
            this.value = value;
        }

        /**
         Returns the key associated with this entry.
         @return the key associated with this entry.
         */
        public int getKey()
        {
            return key;
        }

        /**
         Returns the value associated with this entry.
         @return the value associated with this entry.
         */
        public Patient getValue(){
            return value;
        }

        /**
         Updates the value associated with this entry and returns the old value.
         @return the old value associated with this entry.
          * @param newValue the new value to be associated with this entry.
         */
        public Patient updateValue(Patient newValue){
            Patient oldValue = value;
            this.value = newValue;
            return oldValue;
        }



    }
}

