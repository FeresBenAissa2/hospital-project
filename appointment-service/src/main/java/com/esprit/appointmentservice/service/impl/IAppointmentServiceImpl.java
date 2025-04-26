package com.esprit.appointmentservice.service.impl;

import com.esprit.appointmentservice.dto.AppointmentDto;
import com.esprit.appointmentservice.mapper.AppointmentMapper;
import com.esprit.appointmentservice.model.Appointment;
import com.esprit.appointmentservice.repository.AppointmentRepository;
import com.esprit.appointmentservice.service.IAppointmentService;

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
public class IAppointmentServiceImpl implements IAppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    @Override
    public AppointmentDto add(AppointmentDto AppointmentDto) {
        Appointment appointment = appointmentMapper.mapToEntity(AppointmentDto);
        appointment.setCreatedAt(LocalDateTime.now());
        return appointmentMapper.mapToDto(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentDto update(String idAppointment, Map<Object, Object> fields) {
        Appointment appointment = appointmentRepository.findById(idAppointment)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found: " + idAppointment));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Appointment.class, (String) key);
            field.setAccessible(true);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, appointment , localDate);
            }else {
                ReflectionUtils.setField(field, appointment , value);
            }

        });
        appointment.setUpdatedAt(LocalDateTime.now());

        return appointmentMapper.mapToDto(appointmentRepository.save(appointment));
    }

    @Override
    public boolean delete(String idAppointment) {
        appointmentRepository.deleteById(idAppointment);
        return appointmentRepository.existsById(idAppointment);
    }

    @Override
    public Page<AppointmentDto> getAppointments(int pageNbr, int pageSize) {
        return appointmentRepository.findAll(PageRequest.of(pageNbr,pageSize))
                .map(appointmentMapper::mapToDto);
    }

    @Override
    public AppointmentDto getAppointment(String id) {
        return appointmentRepository.findById(id)
                .map(appointmentMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
    }


}
