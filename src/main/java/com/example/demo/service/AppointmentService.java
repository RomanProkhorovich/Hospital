package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }


    public List<Appointment> findAll(){
        return repository.findAll();
    }

    public Appointment findById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Address not found"));
    }

    public Appointment save(Appointment appointment){
        if (isExist(appointment))
            throw new RuntimeException("Address already exist");
        return repository.save(appointment);
    }
    public Appointment update(Appointment appointment){
        if (!isExist(appointment))
            return save(appointment);
        var add=findById(appointment.getId());

        return repository.save(add);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    private Boolean isExist(Appointment appointment){
        return findAll().stream()
                .anyMatch(x->x.equals(appointment));
    }
}
