package com.example.demo.mapper;

import com.example.demo.dto.AddressDto;
import com.example.demo.model.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {
    Address toModel(AddressDto dto);
    AddressDto toDto(Address address);
}
