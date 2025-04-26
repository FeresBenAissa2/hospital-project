package com.esprit.patientservice.repository;

import com.esprit.patientservice.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findByLastName(String lastName);
}
