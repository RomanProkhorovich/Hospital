package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findById(Long id){
        return addressRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Address not found"));
    }

    public Address save(Address address){
        if (isExist(address))
            throw new RuntimeException("Address already exist");
        return addressRepository.save(address);
    }
    public Address update(Address address){
        if (!isExist(address))
            return save(address);
        var add=findById(address.getId());
        if (address.getCity()!=null && !address.getCity().isBlank()){
            add.setCity(address.getCity());
        }

        if (address.getStreet()!=null && !address.getStreet().isBlank()){
            add.setStreet(address.getStreet());
        }


        if (address.getHouse()!=null ){
            add.setHouse(address.getHouse());
        }
        return addressRepository.save(add);
    }
    public void delete(Long id){
        addressRepository.deleteById(id);
    }

    private Boolean isExist(Address address){
        return findAll().stream()
                .anyMatch(x->x.equals(address));
    }
}
