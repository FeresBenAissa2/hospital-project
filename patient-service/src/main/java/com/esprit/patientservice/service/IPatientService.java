package com.esprit.patientservice.service;

import com.esprit.patientservice.dto.PatientDto;
import org.springframework.data.domain.Page;
import java.util.Map;

public interface IPatientService {
    PatientDto add(PatientDto patientDto);

    PatientDto update(String idPatient, Map<Object,Object> fields);

    boolean delete(String idPatient);


    Page<PatientDto> getPatients(int pageNbr, int pageSize);

    PatientDto getPatient(String id);

    PatientDto getPatientByLastName(String lastname);
}
