package com.smartMed2017.controller;

import com.smartMed2017.model.Analysis;
import com.smartMed2017.neuralNetwork.NeuralNetworkHandler;
import com.smartMed2017.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladyour on 05.06.17.
 */
@Controller
public class AddAnalysis {
    private AnalysisService analysisService;

    @Autowired
    @Qualifier(value = "analysisService")
    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @RequestMapping(value = "addanalysis", method = RequestMethod.GET)
    public String fillAnalysis(Model model) {
        model.addAttribute("analysis", new Analysis());

        return "addanalysis";
    }

    @RequestMapping(value = "/addanalysis/add", method = RequestMethod.POST)
    public String addAnalysis(@ModelAttribute("analysis")Analysis analysis) {
        NeuralNetworkHandler neuralNetworkHandler = new NeuralNetworkHandler(analysis.getAnalysisKey());
        analysis.setAnalysisWeights(analysis.getAnalysisWeights() + ".csv");
        neuralNetworkHandler.train(analysis.getAnalysisWeights());

        analysisService.addAnalysis(analysis);
        return "successful";
    }
}
