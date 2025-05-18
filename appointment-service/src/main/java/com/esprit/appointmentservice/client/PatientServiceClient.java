package com.esprit.appointmentservice.client;

import com.esprit.shared.config.FeignConfig;
import com.esprit.shared.dto.PatientDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "patient-service",
        url = "${patient.service.url}",
        configuration = FeignConfig.class,
        fallback = PatientServiceClientFallback.class
)
public interface PatientServiceClient  {

    @GetMapping("/api/v1/patient/{id}/exists")
    boolean patientExists(@PathVariable String id);

    @GetMapping("/api/patients/{id}")
    PatientDto getPatientById(@PathVariable String id);
}
