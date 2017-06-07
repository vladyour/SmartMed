package com.smartMed2017.service;

import com.smartMed2017.model.Labwork;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
public interface LabworkService {
    void addLabwork(Labwork labwork);
    Labwork getLabworkById(int id);
    List<Labwork> getAllLabwork();
}
