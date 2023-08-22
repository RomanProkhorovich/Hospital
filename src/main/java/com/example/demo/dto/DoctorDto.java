package com.example.demo.dto;

import com.example.demo.model.Specialization;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demo.model.Doctor}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto implements Serializable {
    @NotNull
    Specialization specialization;
    @NotNull
    @NotEmpty
    @NotBlank
    String fullName;
    @Min(25)
    @Max(85)
    @Range(min = 25, max = 85)
    Integer age;
}