package com.esprit.appointmentservice.controller;

import com.esprit.appointmentservice.dto.AppointmentDto;
import com.esprit.appointmentservice.service.IAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final IAppointmentService appointmentService;

    @PostMapping
    public AppointmentDto add(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.add(appointmentDto);
    }

    @PatchMapping("{id}")
    public AppointmentDto patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable String id){
        return appointmentService.update(id,fields);
    }

    @DeleteMapping("{id}")
    public boolean delete( @PathVariable String id){
        return appointmentService.delete(id);
    }


    @GetMapping
    public Page<AppointmentDto> getAppointments(@RequestParam  int pageNbr, @RequestParam int pageSize){
        return appointmentService.getAppointments(pageNbr,pageSize);
    }

    @GetMapping("{id}")
    public AppointmentDto getAppointment(@PathVariable String id){
        return appointmentService.getAppointment(id);
    }


}
