package com.example.demo.service;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findById(Long id){
        return doctorRepository.findById(id).orElseThrow(()->new NoSuchElementException("Doctor not found"));
    }
    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public void delete(Long id){
        doctorRepository.deleteById(id);
    }

    public Doctor save(Doctor doctor){
        if (isExist(doctor))
            throw new NoSuchElementException("Doctor already exist");
        return doctorRepository.save(doctor);
    }
    public Doctor update(Doctor doctor){
        if (!isExist(doctor))
            return save(doctor);

        var doc=findById(doctor.getId());
        if(doctor.getAge()!=null)
            doc.setAge(doctor.getAge());
        if (doctor.getFullName()!= null && !doctor.getFullName().isBlank())
            doc.setFullName(doctor.getFullName());
        if (doctor.getSpecialization()!=null)
            doc.setSpecialization(doctor.getSpecialization());
        return doctorRepository.save(doc);
    }

    private Boolean isExist(Doctor doctor){
        return findAll().stream().anyMatch(x->x.equals(doctor));
    }
}
