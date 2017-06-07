package com.smartMed2017.neuralNetwork;

import com.smartMed2017.model.Analysis;
import com.smartMed2017.model.Labwork;
import com.smartMed2017.neuralNetwork.NeuralNetworkHandler;

/**
 * Created by vladyour on 06.06.17.
 */
public class TryNetwork {
    public static void main(String[] args) {
//        Analysis analysis = new Analysis();
//        Labwork labwork = new Labwork();
//
//        labwork.setLabworkResult("5.csv");
//        analysis.setAnalysisWeights("weights.csv");
//        labwork.setAnalysisByAnalysisId(analysis);
//
//        NeuralNetworkHandler neuralNetworkHandler = new NeuralNetworkHandler(labwork.getLabworkResult());
//        labwork.setDiagnosis(neuralNetworkHandler.getResult(labwork.getAnalysisByAnalysisId().getAnalysisWeights()));
//
//        System.out.print(labwork.getDiagnosis());

        Analysis analysis = new Analysis();
        Labwork labwork = new Labwork();

        analysis.setAnalysisKey("analyzes.csv");

        NeuralNetworkHandler neuralNetworkHandler = new NeuralNetworkHandler(analysis.getAnalysisKey());
        analysis.setAnalysisWeights(analysis.getAnalysisWeights() + ".csv");
        neuralNetworkHandler.train(analysis.getAnalysisWeights());
    }
}
