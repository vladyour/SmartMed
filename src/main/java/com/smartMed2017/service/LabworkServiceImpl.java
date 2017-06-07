package com.smartMed2017.service;

import com.smartMed2017.model.Labwork;
import com.smartMed2017.repository.LabworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
@Service("labworkService")
public class LabworkServiceImpl implements LabworkService {
    private LabworkRepository labworkRepository;

    @Autowired
    public void setLabworkRepository(LabworkRepository labworkRepository) {
        this.labworkRepository = labworkRepository;
    }

    @Transactional
    public void addLabwork(Labwork labwork) {
        this.labworkRepository.addLabwork(labwork);
    }

    @Transactional
    public Labwork getLabworkById(int id) {
        return labworkRepository.getLabworkById(id);
    }

    @Transactional
    public List<Labwork> getAllLabwork() {
        return labworkRepository.getAllLabwork();
    }
}