package com.smartMed2017.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by vladyour on 05.06.17.
 */
@Entity
public class Labwork {
    private int labworkId;
    private String labworkResult;
    private int patientId;
    private int analysisId;
    private String description;
    private Date labworkDate;
    private String diagnosis;
    private Patient patientByPatientId;
    private Analysis analysisByAnalysisId;

    @Id
    @Column(name = "labwork_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getLabworkId() {
        return labworkId;
    }

    public void setLabworkId(int labworkId) {
        this.labworkId = labworkId;
    }

    @Basic
    @Column(name = "labwork_result")
    public String getLabworkResult() {
        return labworkResult;
    }

    public void setLabworkResult(String labworkResult) {
        this.labworkResult = labworkResult;
    }


    @Basic
    @Column(name = "patient_id", insertable = false, updatable = false)
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "analysis_id", insertable = false, updatable = false)
    public int getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(int analysisId) {
        this.analysisId = analysisId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "labwork_date")
    public Date getLabworkDate() {
        return labworkDate;
    }

    public void setLabworkDate(Date labworkDate) {
        this.labworkDate = labworkDate;
    }

    @Basic
    @Column(name = "diagnosis")
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Labwork labwork = (Labwork) o;

        if (labworkId != labwork.labworkId) return false;
        if (labworkResult != null ? !labworkResult.equals(labwork.labworkResult) : labwork.labworkResult != null)
            return false;
        if (description != null ? !description.equals(labwork.description) : labwork.description != null) return false;
        if (labworkDate != null ? !labworkDate.equals(labwork.labworkDate) : labwork.labworkDate != null) return false;
        if (diagnosis != null ? !diagnosis.equals(labwork.diagnosis) : labwork.diagnosis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labworkId;
        result = 31 * result + (labworkResult != null ? labworkResult.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (labworkDate != null ? labworkDate.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "analysis_id", referencedColumnName = "analysis_id", nullable = false)
    public Analysis getAnalysisByAnalysisId() {
        return analysisByAnalysisId;
    }

    public void setAnalysisByAnalysisId(Analysis analysisByAnalysisId) {
        this.analysisByAnalysisId = analysisByAnalysisId;
    }

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = false)
    public Patient getPatientByPatient() {
        return patientByPatientId;
    }

    public void setPatientByPatient(Patient patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }
}
