package com.smartMed2017.controller;

import com.smartMed2017.model.Analysis;
import com.smartMed2017.model.Labwork;
import com.smartMed2017.neuralNetwork.NeuralNetworkHandler;
import com.smartMed2017.service.AnalysisService;
import com.smartMed2017.service.LabworkService;
import com.smartMed2017.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.sql.Date;

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
        labwork.setAnalysisByAnalysisId(analysisService.getAnalysisById(labwork.getAnalysisId()));
        labwork.setPatientByPatient(patientService.getPatientById(labwork.getPatientId()));
        NeuralNetworkHandler neuralNetworkHandler = new NeuralNetworkHandler(labwork.getLabworkResult());
        Analysis analysis = analysisService.getAnalysisById(labwork.getAnalysisId());
        labwork.setDiagnosis(neuralNetworkHandler.getResult(analysis.getAnalysisWeights()));
        labwork.setLabworkDate(Date.valueOf(LocalDate.now()));

        labworkService.addLabwork(labwork);
        return "result";
    }

//    @RequestMapping(value = "result", method = RequestMethod.GET)
//    public ModelAndView getResult(@PathVariable(value = "id")int id) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        //имя представления, куда нужно будет перейти
//        modelAndView.setViewName("result");
//
//        Labwork labwork = labworkService.getLabworkById(id);
//        //записываем в атрибут userJSP (используется на странице *.jsp объект user
//        modelAndView.addObject("labwork", labwork);
//
//        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
//    }

//    @RequestMapping(value = "/result/{id}", method = RequestMethod.GET)
//    public ModelAndView getResult(@PathVariable(value = "id")int id) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        //имя представления, куда нужно будет перейти
//        modelAndView.setViewName("result");
//
//        Labwork labwork = labworkService.getLabworkById(id);
//        //записываем в атрибут userJSP (используется на странице *.jsp объект user
//        modelAndView.addObject("labwork", labwork);
//
//        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
//    }

//    @ModelAttribute
//    @RequestMapping(value = "/result/{id}", method = RequestMethod.GET)
//    public Labwork getResult(@PathVariable(value = "id") int id, Model model) {
//        Labwork labwork = this.labworkService.getLabworkById(id);
//        model.addAttribute("result", labwork);
//        return labwork;
//    }
}
