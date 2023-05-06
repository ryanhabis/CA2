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
        }
    }
}