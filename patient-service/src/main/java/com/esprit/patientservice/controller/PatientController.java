package com.esprit.patientservice.controller;

import com.esprit.patientservice.dto.PatientDto;
import com.esprit.patientservice.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final IPatientService patientService;

    @PostMapping
    public PatientDto add(@RequestBody PatientDto PatientDto) {
        return patientService.add(PatientDto);
    }

    @PatchMapping("{id}")
    public PatientDto patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable String id){
        return patientService.update(id,fields);
    }

    @DeleteMapping("{id}")
    public boolean delete( @PathVariable String id){
        return patientService.delete(id);
    }


    @GetMapping
    public Page<PatientDto> getPatients(int pageNbr, int pageSize){
        return patientService.getPatients(pageNbr,pageSize);
    }

    @GetMapping("{id}")
    public PatientDto getPatient(@PathVariable String id){
        return patientService.getPatient(id);
    }

    @GetMapping("name/{name}")
    public PatientDto getPatientByName(@PathVariable String lastName){
        return patientService.getPatientByLastName(lastName);
    }

}
