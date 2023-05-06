package utils;

import java.time.LocalDate;
import java.util.LinkedList;

public class Patient {
    private String firstName;
    private String surName;
    private LocalDate dob;
    private LocalDate date;
    private LinkedList appointment;

    public Patient(String firstName, String surName, LocalDate dob, LocalDate date, LinkedList appointment) {
        if (dob.compareTo(LocalDate.now()) > 0) {
            throw new IllegalArgumentException("Date of Birth cannot be after today");
        } else if (date.compareTo(LocalDate.now()) > 0) {
            throw new IllegalArgumentException("Invalid Date,Patient SignUp date must be today or in the past");
        }else {
            this.firstName = firstName;
            this.surName = surName;
            this.dob = dob;
            this.date = date;
            this.appointment = appointment;
        }//
    }
    /**
     * These are the Accessor Methods
     */
    public String getFirstName() {
        return firstName;
    }


    public String getSurName() {
        return surName;
    }


    public LocalDate getDob() {
        return dob;
    }


    public LocalDate getDate() {
        return date;
    }


    public LinkedList getAppointment() {
        return appointment;
    }

    /**
     * These are the Mutator Methods
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setDob(LocalDate dob) {
        if (dob.compareTo(LocalDate.now()) <= 0) {
            throw new IllegalArgumentException("Date of Birth cannot be after today");
        }
        this.dob = dob;
    }

    public void setDate(LocalDate dob) {
        if (dob.compareTo(LocalDate.now()) > 0) {
            throw new IllegalArgumentException("Invalid Date,Patient SignUp date must be today or in the past");
        }
        this.dob = dob;
    }

    public void setAppointment(LinkedList appointment) {
        this.appointment = appointment;
    }

}