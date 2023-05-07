package utils;



//import collections.AppointmentLinkedList;

import Exceptions.DuplicateAppointmentException;
import collections.AppointmentLinkedList;

import java.time.LocalDate;
import java.util.Objects;

public class Patient {
    private String firstName;
    private String surName;
    private LocalDate dob;
    private LocalDate date;
   private AppointmentLinkedList appointment;

    public Patient(String firstName, String surName, LocalDate dob, LocalDate date, AppointmentLinkedList appointment) {
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

    public Patient()
    {

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


    public AppointmentLinkedList getAppointment() {
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

    public void setAppointment(AppointmentLinkedList appointment) {
        this.appointment = appointment;
    }

        public boolean addAppointment(Appointment app) throws DuplicateAppointmentException {
      return appointment.add(app);
        }

    /**
     *
     * Computes the hash code of the Patient, based on their
     * name details and their date of birth
     *
     * @return The hash code of this task.
     */
    @Override
    public int hashCode() {
        int hash = 8;
        hash = 90 * hash + Objects.hashCode(this.firstName);
        hash = 90 * hash + Objects.hashCode(this.surName);
        hash = 90 * hash + Objects.hashCode(this.dob);
        return hash;
    }

    /**
     *
     * Determines whether this Patient is equal to another Patient object based on their
     * name details and their date of birth
     *
     * @param obj The other object to compare with.
     * @return {@code true} if the Patient objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.surName, other.surName)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }

}