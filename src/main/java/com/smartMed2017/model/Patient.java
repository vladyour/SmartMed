package com.smartMed2017.model;

import javax.persistence.*;

/**
 * Created by vladyour on 05.06.17.
 */
@Entity
public class Patient {
    private int patientId;
    private String patientSecondName;
    private String patientFirstName;
    private String patientPatronymic;

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "patient_second_name")
    public String getPatientSecondName() {
        return patientSecondName;
    }

    public void setPatientSecondName(String patientSecondName) {
        this.patientSecondName = patientSecondName;
    }

    @Basic
    @Column(name = "patient_first_name")
    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    @Basic
    @Column(name = "patient_patronymic")
    public String getPatientPatronymic() {
        return patientPatronymic;
    }

    public void setPatientPatronymic(String patientPatronymic) {
        this.patientPatronymic = patientPatronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (patientId != patient.patientId) return false;
        if (patientSecondName != null ? !patientSecondName.equals(patient.patientSecondName) : patient.patientSecondName != null)
            return false;
        if (patientFirstName != null ? !patientFirstName.equals(patient.patientFirstName) : patient.patientFirstName != null)
            return false;
        if (patientPatronymic != null ? !patientPatronymic.equals(patient.patientPatronymic) : patient.patientPatronymic != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patientId;
        result = 31 * result + (patientSecondName != null ? patientSecondName.hashCode() : 0);
        result = 31 * result + (patientFirstName != null ? patientFirstName.hashCode() : 0);
        result = 31 * result + (patientPatronymic != null ? patientPatronymic.hashCode() : 0);
        return result;
    }
}
