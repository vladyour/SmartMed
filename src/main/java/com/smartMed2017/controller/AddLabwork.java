package com.smartMed2017.controller;

import com.smartMed2017.model.Labwork;
import com.smartMed2017.neuralNetwork.NeuralNetworkHandler;
import com.smartMed2017.service.AnalysisService;
import com.smartMed2017.service.LabworkService;
import com.smartMed2017.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladyour on 05.06.17.
 */
@Controller
public class AddLabwork {
    private PatientService patientService;
    private AnalysisService analysisService;
    private LabworkService labworkService;

    @Autowired
    @Qualifier(value = "patientService")
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    @Qualifier(value = "analysisService")
    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @Autowired
    @Qualifier(value = "labworkService")
    public void setLabworkService(LabworkService labworkService) {
        this.labworkService = labworkService;
    }

    @RequestMapping(value = "addlabwork", method = RequestMethod.GET)
    public String fillLabwork(Model model) {
        model.addAttribute("patients", this.patientService.getAllPatient());
        model.addAttribute("analyzes", this.analysisService.getAllAnalysis());
        model.addAttribute("labwork", new Labwork());

        return "addlabwork";
    }

    @RequestMapping(value = "/addlabwork/add", method = RequestMethod.POST)
    public String addLabwork(@ModelAttribute("labwork")Labwork labwork) {
        NeuralNetworkHandler neuralNetworkHandler = new NeuralNetworkHandler(labwork.getLabworkResult());
        labwork.setDiagnosis(neuralNetworkHandler.getResult(labwork.getAnalysisByAnalysisId().getAnalysisWeights()));
        labworkService.addLabwork(labwork);

//        return "redirect:/result/" + labwork.getLabworkId();
        return "successful";
    }

    @RequestMapping(value = "result/{id}", method = RequestMethod.GET)
    public String getResult(@PathVariable(value = "id") int id, Model model) {

        model.addAttribute("result", this.labworkService.getLabworkById(id));
        return "addlabwork";
    }
}
