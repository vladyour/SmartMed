package com.smartMed2017.model;

import javax.persistence.*;

/**
 * Created by vladyour on 05.06.17.
 */
@Entity
public class Analysis {
    private int analysisId;
    private String analysisTitle;
    private String analysisKey;
    private String analysisWeights;
    private String analysisDescription;

    @Id
    @Column(name = "analysis_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(int analysisId) {
        this.analysisId = analysisId;
    }

    @Basic
    @Column(name = "analysis_title")
    public String getAnalysisTitle() {
        return analysisTitle;
    }

    public void setAnalysisTitle(String analysisTitle) {
        this.analysisTitle = analysisTitle;
    }

    @Basic
    @Column(name = "analysis_key")
    public String getAnalysisKey() {
        return analysisKey;
    }

    public void setAnalysisKey(String analysisKey) {
        this.analysisKey = analysisKey;
    }

    @Basic
    @Column(name = "analysis_weights")
    public String getAnalysisWeights() {
        return analysisWeights;
    }

    public void setAnalysisWeights(String analysisWeights) {
        this.analysisWeights = analysisWeights;
    }

    @Basic
    @Column(name = "analysis_description")
    public String getAnalysisDescription() {
        return analysisDescription;
    }

    public void setAnalysisDescription(String analysisDescription) {
        this.analysisDescription = analysisDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Analysis analysis = (Analysis) o;

        if (analysisId != analysis.analysisId) return false;
        if (analysisTitle != null ? !analysisTitle.equals(analysis.analysisTitle) : analysis.analysisTitle != null)
            return false;
        if (analysisKey != null ? !analysisKey.equals(analysis.analysisKey) : analysis.analysisKey != null)
            return false;
        if (analysisWeights != null ? !analysisWeights.equals(analysis.analysisWeights) : analysis.analysisWeights != null)
            return false;
        if (analysisDescription != null ? !analysisDescription.equals(analysis.analysisDescription) : analysis.analysisDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = analysisId;
        result = 31 * result + (analysisTitle != null ? analysisTitle.hashCode() : 0);
        result = 31 * result + (analysisKey != null ? analysisKey.hashCode() : 0);
        result = 31 * result + (analysisWeights != null ? analysisWeights.hashCode() : 0);
        result = 31 * result + (analysisDescription != null ? analysisDescription.hashCode() : 0);
        return result;
    }
}
