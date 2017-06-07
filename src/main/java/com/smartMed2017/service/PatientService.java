package com.smartMed2017.service;

import com.smartMed2017.model.Patient;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
public interface PatientService {
    Patient getPatientById(int id);
    List<Patient> getAllPatient();
}
