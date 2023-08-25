package com.example.demo.mapper;

import com.example.demo.dto.AddressDto;
import com.example.demo.model.Address;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AddressMapper {
    Address toModel(AddressDto dto);
    AddressDto toDto(Address address);

    List<AddressDto> toDtoList(List<Address> addresses);
    List<Address> toModelList(List<AddressDto> dtoList);
}
