package com.smartMed2017.repository;

import com.smartMed2017.model.Analysis;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
public interface AnalysisRepository {
    void addAnalysis(Analysis analysis);
    Analysis getAnalysisById(int id);
    List<Analysis> getAllAnalysis();
}
