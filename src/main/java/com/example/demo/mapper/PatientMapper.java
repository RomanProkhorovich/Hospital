package com.example.demo.mapper;

import com.example.demo.dto.PatientDto;
import com.example.demo.model.Patient;
import org.mapstruct.Mapper;

@Mapper
public interface PatientMapper {
    PatientDto toDto(Patient patient);
    Patient toModel(PatientDto dto);
}
