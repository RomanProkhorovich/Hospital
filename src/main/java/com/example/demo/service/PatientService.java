package com.example.demo.service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient findById(Long id){
        return patientRepository.findById(id).orElseThrow(()->new NoSuchElementException("Patient not found"));
    }
    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public void delete(Long id){
        patientRepository.deleteById(id);
    }

    public Patient save(Patient patient){
        if (isExist(patient))
            throw new NoSuchElementException("Doctor already exist");
        return patientRepository.save(patient);
    }
    public Patient update(Patient patient){
        if (!isExist(patient))
            return save(patient);

        var pat=findById(patient.getId());
        if(patient.getAge()!=null)
            pat.setAge(patient.getAge());
        if (patient.getFullName()!= null && !patient.getFullName().isBlank())
            pat.setFullName(patient.getFullName());
        if (patient.getPhoneNumber()!=null && !patient.getPhoneNumber().isBlank())
            pat.setPhoneNumber(patient.getPhoneNumber());

        return patientRepository.save(pat);
    }

    private Boolean isExist(Patient patient){
        return findAll().stream().anyMatch(x->x.equals(patient));
    }
}
