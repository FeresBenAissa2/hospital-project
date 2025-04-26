package com.esprit.appointmentservice.model;

import jakarta.persistence.Entity;
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
     String id;
     Long patientId;
     LocalDateTime appointmentDateTime;
     String doctorName;
     String department;
     String status;
     String notes;

     LocalDateTime createdAt;
     LocalDateTime updatedAt;
}
