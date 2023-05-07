package Exceptions;

public class DuplicateAppointmentException extends Exception {
    public DuplicateAppointmentException(String app) {
        super(app+"The Appointment has Already been booked");
    }
}
