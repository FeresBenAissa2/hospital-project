package com.esprit.appointmentservice.service;

import com.esprit.appointmentservice.dto.AppointmentDto;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface IAppointmentService {
    AppointmentDto add(AppointmentDto appointmentDto);

    AppointmentDto update(String idAppointment, Map<Object,Object> fields);

    boolean delete(String idAppointment);


    Page<AppointmentDto> getAppointments(int pageNbr, int pageSize);

    AppointmentDto getAppointment(String id);

}
