package com.esprit.appointmentservice.model;

public enum Status {
    //- Appointment is confirmed for a future date/time
    BOOKED ,
    //- Appointment occurred as planned
    COMPLETED ,
    // - Appointment was cancelled (consider sub-types below)
    CANCELLED,
    //- Patient didn't arrive without cancellation
    NO_SHOW,
    // - Appointment was moved to a new time
    RESCHEDULED
}
