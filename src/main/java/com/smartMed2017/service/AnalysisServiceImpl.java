package com.smartMed2017.service;

import com.smartMed2017.model.Analysis;
import com.smartMed2017.repository.AnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
@Service("analysisService")
public class AnalysisServiceImpl implements AnalysisService {
    private AnalysisRepository analysisRepository;

    @Autowired
    public void setAnalysisRepository(AnalysisRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @Transactional
    public void addAnalysis(Analysis analysis) {
        analysisRepository.addAnalysis(analysis);
    }

    @Transactional
    public Analysis getAnalysisById(int id) {
        return analysisRepository.getAnalysisById(id);
    }

    @Transactional
    public List<Analysis> getAllAnalysis() {
        return analysisRepository.getAllAnalysis();
    }
}
