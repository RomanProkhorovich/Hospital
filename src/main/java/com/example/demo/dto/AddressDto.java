package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.demo.model.Address}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto implements Serializable {
    @NotNull
    @NotEmpty
    @NotBlank
    String city;
    @NotNull
    @NotEmpty
    @NotBlank
    String street;
    @NotNull
    @NotEmpty
    @NotBlank
    Integer house;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(house, that.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house);
    }
}