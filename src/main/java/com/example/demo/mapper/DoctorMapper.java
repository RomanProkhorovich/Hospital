package com.example.demo.mapper;

import com.example.demo.dto.DoctorDto;
import com.example.demo.model.Doctor;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorMapper {
    Doctor toModel(DoctorDto dto);
    DoctorDto toDto(Doctor doctor);
}
