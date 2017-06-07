package com.smartMed2017.neuralNetwork;

/**
 * Created by vladyour on 05.06.17.
 */
public class NeuralNetworkHandler {
    CSVReader reader;

    public NeuralNetworkHandler(String fileName) {
        reader = new CSVReader(fileName);
    }

    public void train(String weightsFile) {
        reader.readAnalysis();
        NeuralNetwork neuralNetwork = new NeuralNetwork(reader.getPattern(), reader.getOutput(), weightsFile);
    }

    public String getResult(String weightsFile) {
        reader.readLabwork();
        NeuralNetwork neuralNetwork = new NeuralNetwork(weightsFile);

        return neuralNetwork.forwardPass(reader.getInput()) > 0.5 ? "Положительный" : "Отрицательный";
    }
}
