package com.esprit.patientservice.mapper;
import com.esprit.patientservice.dto.PatientDto;
import com.esprit.patientservice.model.Patient;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient mapToEntity(PatientDto patientDto);
    PatientDto mapToDto(Patient patient);
}
