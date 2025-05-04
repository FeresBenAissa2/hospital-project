package com.esprit.appointmentservice.client;

import com.esprit.shared.config.FeignConfig;
import com.esprit.shared.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "patient-service",
        url = "${patient.service.url}",
        configuration = FeignConfig.class
)
public interface PatientServiceClient  {

    @GetMapping("/api/patients/{id}/exists")
    boolean patientExists(@PathVariable String id);

    @GetMapping("/api/patients/{id}")
    PatientDto getPatientById(@PathVariable String id);
}
