# Data Structures Ongoing Exercises Week 11

## Introduction:

You are required to complete regular exercises as part of the 20% allocated to ongoing CA. These exercises will be linked
to the current topic. By completing them, along with your unmarked exercise sheets, you will gain proficiency and skill in
programming.

Note 1: All submitted material must be your own work, and you may be examined “in class” at any point during
semester. No code (other than method signatures) may be included.

Note 2: You are required to complete ONE of the following pseudocode assignments. You should write the pseudocode
for your area of CA2, i.e. if you are writing the Patient LinkedList, you should complete the LinkedList pseudocode and if
you are writing the Patient HashMap, you should complete the HashMap pseudocode.
Option 1) LinkedList Specification:
You are required to write and explain the pseudocode for the below functionality in a LinkedList holding Patient
objects. You should also include any class components that are required in order to facilitate the pseudocode
functioning (e.g. any class variables that will be used). These should be listed at the top of the text file. In all cases, you
should provide a method signature, then write the pseudocode. No code other than the method signature is permitted.

Required functionality:

1. A method called size() that takes no parameters & returns the number of Patients currently stored in your list.

2. A method called get() that takes one parameter, an int representing the position from which data should be
retrieved. The position should be validated, and invalid positions handled accordingly.
If the position is valid, the method should return the data (a Patient) in the position specified.

3. A method called indexOf() that takes one parameter, a Patient to be found in the list. The method should return
an int indicating the position at which the Patient could be found. If the Patient could not be found, an
appropriate value should be returned to indicate this.

4. A method called add() that takes a single parameter, a Patient to be added to the end of the list.
The method should return a boolean indicating that the Patient was added.

5. A method called set() that takes two parameters, a Patient to be added and a position at which to insert the
data. The position should be validated, and invalid positions handled accordingly.
If the position is valid, the data at that position should be replaced with the supplied Patient, and the original
content of that position (a Patient) should be returned.

6. A method called remove() that takes one parameter – the Patient to be removed. Only the first instance of this
Patient should be removed from the list.
The method should return a boolean indicating that the Patient was removed.

7. A method called isEmpty() that takes no parameters. This should return whether there is data currently stored
in the list.
Option 2) HashMap Specification:
You are required to write and explain the pseudocode for the below functionality in the Patient from your CA2
submission. Collision resolution should not be included in your logic.
You should include any class components that are required in order to facilitate the pseudocode functioning (e.g. any
class variables that will be used). These should be listed at the top of the text file. In all cases, you should provide a
method signature, then write the pseudocode. No code other than the method signature is permitted.
Required functionality:

1. A method called size() that takes no parameters & returns the number of Patients currently stored in your Map.

2. A method called hashFunction() that takes one parameter, the data representing the key to be used. The
method should calculate the appropriate slot based on the key supplied (an int).

3. A method called put() that takes two parameters, the data representing the key of the new entry and a Patient
representing the value of the new entry. The method should add the new pairing to the map in an appropriate
location. If the key is already present, the method should update the associated value and return the old
version. If the key is not already present in the map, the situation should be handled appropriately.
Data Structures Ongoing Exercises Week 11
Page 2 of 2

4. A method called get() that takes a single parameter, the key mapping to the value to be retrieved.
The method should return a Patient - the value associated with the supplied key. If no such key is found in the
map, an appropriate value should be returned to indicate this.

5. A method called remove() that takes one parameter – the key of the pairing to be removed.
The method should return the value that has been removed. If no such key is found in the map, an appropriate
value should be returned to indicate this.

6. A method called containsKey() that takes one parameter – the key whose presence is being confirmed. This
should return a boolean indicating whether or not this key currently exists within the map.

7. A method called getKeys() that takes no parameters.
This method should return an array containing all of the keys currently stored within the map.

8. A method called getValues() that takes no parameters.
This method should return an array containing all of the values currently stored within the map.

## Deliverables:

One appropriately-formatted (indentation is important in pseudocode, just as in real code) text file containing the
pseudocode listed above, plus your list of any class components needed. This text file should include your name.
Remember, you must provide the pseudocode for each method AND explain it. Pseudocode and explanation are worth
equal marks. Code (other than method signatures) will be awarded 0.
