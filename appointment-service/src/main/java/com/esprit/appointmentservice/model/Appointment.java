package com.esprit.appointmentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String patientId;
     LocalDateTime appointmentDateTime;
     String doctorName;
     String department;
     Status status;
     String notes;

     LocalDateTime createdAt;
     LocalDateTime updatedAt;
}
