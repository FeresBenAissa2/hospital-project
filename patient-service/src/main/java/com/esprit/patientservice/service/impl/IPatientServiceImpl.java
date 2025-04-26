package com.esprit.patientservice.service.impl;

import com.esprit.patientservice.dto.PatientDto;
import com.esprit.patientservice.mapper.PatientMapper;
import com.esprit.patientservice.model.Patient;
import com.esprit.patientservice.repository.PatientRepository;
import com.esprit.patientservice.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IPatientServiceImpl implements IPatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    @Override
    public PatientDto add(PatientDto patientDto) {
        Patient patient = patientMapper.mapToEntity(patientDto);
        patient.setCreatedAt(LocalDateTime.now());
        return patientMapper.mapToDto(patientRepository.save(patient));
    }

    @Override
    public PatientDto update(String idpatient, Map<Object, Object> fields) {
        Patient patient = patientRepository.findById(idpatient)
                .orElseThrow(() -> new IllegalArgumentException("patient not found: " + idpatient));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Patient.class, (String) key);
            field.setAccessible(true);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, patient , localDate);
            }else {
                ReflectionUtils.setField(field, patient , value);
            }

        });
        patient.setUpdatedAt(LocalDateTime.now());

        return patientMapper.mapToDto(patientRepository.save(patient));
    }

    @Override
    public boolean delete(String idpatient) {
        patientRepository.deleteById(idpatient);
        return patientRepository.existsById(idpatient);
    }

    @Override
    public Page<PatientDto> getPatients(int pageNbr, int pageSize) {
        return patientRepository.findAll(PageRequest.of(pageNbr,pageSize))
                .map(patientMapper::mapToDto);
    }

    @Override
    public PatientDto getPatient(String id) {
        return patientRepository.findById(id)
                .map(patientMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("patient not found"));
    }

    @Override
    public PatientDto getPatientByLastName(String lastName) {
        return patientRepository.findByLastName(lastName)
                .map(patientMapper::mapToDto)
                .orElseThrow(() ->new IllegalArgumentException("patient not found with this name"));
    }
}
