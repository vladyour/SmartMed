package com.smartMed2017.service;

import com.smartMed2017.model.Patient;
import com.smartMed2017.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Patient getPatientById(int id) {
        return patientRepository.getPatientById(id);
    }

    @Transactional
    public List<Patient> getAllPatient() {
        return patientRepository.getAllPatient();
    }
}
