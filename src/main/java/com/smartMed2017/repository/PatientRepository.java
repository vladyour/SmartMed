package com.smartMed2017.repository;

import com.smartMed2017.model.Patient;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
public interface PatientRepository {
    Patient getPatientById(int id);
    List<Patient> getAllPatient();
}
