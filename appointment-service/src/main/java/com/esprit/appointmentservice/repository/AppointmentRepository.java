package com.esprit.appointmentservice.repository;


import com.esprit.appointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
