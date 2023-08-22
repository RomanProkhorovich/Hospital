package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.model.Appointment}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentDto implements Serializable {
    @NotNull
    private DoctorDto doctor;
    @NotNull
    private PatientDto patient;
    @NotNull
    private AddressDto address;
    @NotNull
    private LocalDateTime dateTime;
}