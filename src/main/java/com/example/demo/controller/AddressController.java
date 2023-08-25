package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.model.Address;
import com.example.demo.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
    private final AddressMapper mapper;
    private final AddressService service;

    public AddressController(AddressMapper mapper, AddressService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public List<AddressDto> findAll(){
        return mapper.toDtoList(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toDto(service.findById(id)));
    }


}
