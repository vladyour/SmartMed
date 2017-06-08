package com.smartMed2017.repository;

import com.smartMed2017.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
@Repository
public class PatientRepositoryImpl implements PatientRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Patient getPatientById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient patient = (Patient) session.get(Patient.class, new Integer(id));

        return patient;
    }

    @SuppressWarnings("unchecked")
    public List<Patient> getAllPatient() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Patient> patientList = session.createQuery("from Patient").list();

        return patientList;
    }
}
