package Exceptions;

public class DuplicateAppointmentException extends Exception {
    public DuplicateAppointmentException() {
        super("The Appointment has Already been booked");
    }
}
