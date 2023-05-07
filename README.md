NOTE: ALL CODE MUST BE COMMENTED USING JAVADOCS

# Project Outline:
This is a paired project to manage patients, their appointments and their appointment history. It is designed to test that you can
implement the data structures you have studied, and employ them in an applied situation. You may not use any of Java’s built-in
data structures to carry out the logic of this project.

The project must be hosted on github.

Application Data:

Appointment

Appointments are made up of the following information:

• The patient’s first name (a String)

• The patient’s last name (a String)

• The patient’s date of birth (a LocalDate)

• The issue (a String)

• The date (a LocalDate)

• A triage level (an int)

• The full name of the Doctor (a String)

Two Appointments are considered equal where they have the same patient data, issue and date, (irrespective of the rest of their
fields).

The natural order for Appointments is by triage level, where 1 has a higher priority than 

## Patient
Patients are made up of the following information:

• The first name of the Patient (a String)

• The second name of the Patient (a String)

• The date of birth of the Patient (a LocalDate)

• The date they joined the practice (a LocalDate)

• The appointments associated with the Patient (an Appointment LinkedList).
Two Patients are considered equal where they have the same first name, second name and date of birth (irrespective of the rest
of their fields).

## Data Structures:

You are required to implement three data structures for this project:
1. LinkedList – this should hold Appointments, and should include all standard components of a LinkedList structure (as
   outlined in class).
2. PriorityQueue – this should hold Appointments, and should include all standard components of a PriorityQueue
   structure (as outlined in class). This should be created by extending your LinkedList. You should offer both fail fast and
   “safe” versions of potentially risky methods.
3. HashMap – this should hold Patients and should employ list-based chaining or linear probing as its collision resolution. It
   must include all standard components of a HashMap structure (as outlined in class).
   # Application:
   Write a program that repeatedly lets the user choose from the following options:
   
• Add a new patient to the practice (where there is already a patient with that first name, last name and date of birth, the
   user should be informed and the patient should not be added).

   • Delete a patient from the practice (you should handle any outstanding appointments appropriately – this may require
   adding an extra method to your queue outside the standard functionality)

   • Display all patients

   • Create a new appointment for a specific patient and add it to the queue (the appointment should be allocated a
   random triage level between 1 and 5)
 
• Call the next patient in

   • Exit

   Data Structures CA2 (updated) 20%

   Data Structures CA2 20%

   Testing & Documentation:

All data structures should be fully unit tested. All data structures AND application data classes should be fully documented using
 JavaDocs. Any methods without a comment will not be marked.

#   Grading:
   All code must be your own work. The project will be assessed with a demonstration and interview. If you cannot show that your
   code is your own, or you do not appear for the demo, you will be awarded 0.
   Division of Labour:
   Each student is required to write (in full):
 
  • One of the application data classes and its documentation.

   • The LinkedList and Priority Queue, plus their tests and documentation

   or

   • The HashMap and associated logic, plus their tests and documentation

   BOTH students must work on the application.

#   Source Control Management:
   This project’s development must be managed in git (hosted on github). Code should be committed to the repository regularly,
   with appropriate commit messages.
 
#  Bonus Option:
   There is a 10% bonus mark available for addition of persistence to your project. This means your application would start by
   reading patient data (including their appointment histories) in from a file and would write the patient data out to a file before
   terminating.
 
#  Deliverables & Deadline:
   A link to the github repository for your project.
   Deadline: 5pm, Tuesday 2nd May
   Demos: Wednesday 3rd May