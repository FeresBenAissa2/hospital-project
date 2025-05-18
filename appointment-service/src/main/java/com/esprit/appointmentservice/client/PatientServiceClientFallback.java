package com.esprit.appointmentservice.client;

import com.esprit.shared.dto.PatientDto;
import com.esprit.shared.exception.PatientNotFoundException;
import com.esprit.shared.exception.PatientServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PatientServiceClientFallback implements PatientServiceClient{
    @Override
    public boolean patientExists(String id) {
        log.error("[Fallback] Patient Exists Check for ID: {}", id);
        throw new PatientServiceException("Patient service is currently unavailable");
    }

    @Override
    public PatientDto getPatientById(String id) {
        log.error("[Fallback] get Patient By  ID: {}", id);
        throw new PatientServiceException("Patient service is currently unavailable");
    }
}
