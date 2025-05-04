package com.esprit.appointmentservice.dto;

import com.esprit.appointmentservice.model.Status;

import java.time.LocalDateTime;

public record AppointmentDto(
        Long id,
        String patientId,
        LocalDateTime appointmentDateTime,
        String doctorName,
        String department,
        Status status,
        String notes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
