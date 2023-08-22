package com.example.demo.mapper;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.model.Appointment;
import org.mapstruct.Mapper;

@Mapper(uses = {AddressMapper.class, DoctorMapper.class, PatientMapper.class})
public interface AppointmentMapper {
    AppointmentDto toDto(Appointment appointment);

    Appointment toModel(AppointmentDto dto);
}
