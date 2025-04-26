package com.esprit.appointmentservice.mapper;

import com.esprit.appointmentservice.dto.AppointmentDto;
import com.esprit.appointmentservice.model.Appointment;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment mapToEntity(AppointmentDto AppointmentDto);
    AppointmentDto mapToDto(Appointment Appointment);
}
