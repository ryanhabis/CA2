package utils;

import java.time.LocalDate;

public class Appointment implements Comparable<Appointment> {
    //	This is a paired project to manage patients, their appointments and their appointment history. It is designed to test that you can
//	implement the data structures you have studied, and employ them in an applied situation. You may not use any of Java’s built-in
//	data structures to carry out the logic of this project. The project must be hosted on github.
//	Application Data:
//	Appointment
//	Appointments are made up of the following information:
//	• The patient’s first name (a String)
//	• The patient’s last name (a String)
//	• The patient’s date of birth (a LocalDate)
//	• The issue (a String)
//	• The date (a LocalDate)
//	• A triage level (an int)
//	• The full name of the Doctor (a String)
//	Two Appointments are considered equal where they have the same patient data, issue and date, (irrespective of the rest of their
//	fields). The natural order for Appointments is by triage level, where 1 has a higher priority than 5.
    private String firstName;
    private String surName;
    private LocalDate dob;
    private String issue;
    private LocalDate date;
    private int triageLevel;
    private String doctor;

    /**
     * Constructs a new Appointment with the specified Patient data, issue,date and
     * trigageLevel.
     *
     * @param firstName,   the Patients firstname
     * @param surName,     the Patients surname.
     * @param dob,         the Patients date of birth
     * @param issue,       issue of the Appointment.
     * @param date,        the date of the Appointment
     * @param triageLevel, the importance level of the Appointment
     * @param doctor,      the doctors name
     * @throws IllegalArgumentException If the date of birth and the date is in the
     *                                  past.
     */
    public Appointment(String firstName, String surName, LocalDate dob, String issue, LocalDate date, int triageLevel,
                       String doctor) {
        if (dob.compareTo(LocalDate.now()) <= 0) {
            throw new IllegalArgumentException("Date of Birth cannot be after today");
        } else if (date.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("Appointment Date cannot be in the past");
        } else {
            this.firstName = firstName;
            this.surName = surName;
            this.dob = dob;
            this.issue = issue;
            this.date = date;
            this.triageLevel = triageLevel;
            this.doctor = doctor;
        }
    }


    /**
     *
     * Compares this Appointment to another Appointment instance based on their triage levels.
     *
     * @param a1 The other Appointment to compare with.
     * @return A negative integer, zero, or a positive integer as this Appointment is less
     *         than, equal to, or greater than the specified triagelevel.
     */
    @Override
    public int compareTo(Appointment a1) {
        int triage = 0;

        if (a1.getTriageLevel() < triageLevel) {
            triage = -1;
        } else if (a1.getTriageLevel() > triageLevel) {
            triage = 1;
        } else {
            return 0;
        }
        return triage;

    }
}