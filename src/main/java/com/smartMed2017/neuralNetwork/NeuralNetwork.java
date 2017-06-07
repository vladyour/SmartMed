package com.smartMed2017.neuralNetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by vladyour on 05.06.17.
 */
public class NeuralNetwork {
    private ArrayList<double[]> layers;
    private ArrayList<double[][]> weights;
    private String weightsFile;

    //Constructor for getting result
    public NeuralNetwork(String weightsFile) {
        CSVReader reader = new CSVReader(weightsFile);
        reader.readWeights();

        this.weights = reader.getWeights();

        layers = new ArrayList<>();
        layers.add(new double[weights.get(0)[0].length]);

        for (double[][] element : weights) {
            layers.add(new double[element.length]);
        }
    }

    //Constructor for adding new Analysis
    public NeuralNetwork(double[][] pattern, int[] answer, String weightsFile) {

        this.weightsFile = weightsFile;

        //--------------------------------------------------------------\\
        //--------------------Layers initialization---------------------\\
        //--------------------------------------------------------------\\
        layers = new ArrayList<>();
        layers.add(new double[26]);
        layers.add(new double[26]);
        layers.add(new double[1]);
        //--------------------------------------------------------------\\
        //-----------------End of layers initialization-----------------\\
        //--------------------------------------------------------------\\

        //--------------------------------------------------------------\\
        //-------------------Weights initialization---------------------\\
        //--------------------------------------------------------------\\
        weights = new ArrayList<>();
        weights.add(new double[26][26]);
        weights.add(new double[1][26]);

        for (double[][] weight : weights) {
            for (int j = 0; j < weight.length; j++) {
                for (int k = 0; k < weight[j].length; k++) {
                    weight[j][k] = Math.random() * 0.3 + 0.1;
                }
            }
        }
        //--------------------------------------------------------------\\
        //----------------End of weights initialization-----------------\\
        //--------------------------------------------------------------\\

        //--------------------------------------------------------------\\
        //-------------------------Train start--------------------------\\
        //--------------------------------------------------------------\\
        for (int i = 0; i < pattern.length; i++) {
            train(pattern[i], answer[i]);
        }

        outTheWeights();
    }

    private void train(double[] input, int answer) {
        double output = forwardPass(input);
        double error = countError(output, answer);

        ArrayList<double[]> delta = new ArrayList<>();
        ArrayList<double[][]> deltaWeights = new ArrayList<>();

        //delta and deltaWeights initialization
        for (int i = 1; i < layers.size(); i++) {
            delta.add(new double[layers.get(i).length]);
        }

        for (int i = 0; i < weights.size(); i++) {
            deltaWeights.add(new double[weights.get(i).length][]);
            for (int j = 0; j < weights.get(i).length; j++) {
                deltaWeights.get(i)[j] = new double[weights.get(i)[j].length];
            }
        }

        //Figure out delta and deltaWeights of the last layer
        for (int n = 0; n < delta.get(delta.size() - 1).length; n++) {
            delta.get(delta.size() - 1)[n] = (layers.get(layers.size() - 1)[n] - answer) *
                    (layers.get(layers.size() - 1)[n]) * (1 - layers.get(layers.size() - 1)[n]);

            for (int m = 0; m < weights.get(weights.size() - 1)[n].length; m++) {
                deltaWeights.get(weights.size() - 1)[n][m] = delta.get(delta.size() - 1)[n] *
                        layers.get(layers.size() - 2)[m];
            }
        }


        //Figure out delta and deltaWeights of another layers
        for (int layer = delta.size() - 2; layer >= 0; layer--) {
            for (int rightNeuron = 0; rightNeuron < delta.get(layer).length; rightNeuron++) {
                double weightXDelta = 0.0;
                for (int leftNeuron = 0; leftNeuron < delta.get(layer + 1).length; leftNeuron++) {
                    weightXDelta += weights.get(layer + 1)[leftNeuron][rightNeuron] * delta.get(layer + 1)[leftNeuron];
                }

                delta.get(layer)[rightNeuron] = weightXDelta * layers.get(layer + 1)[rightNeuron] * (1 - layers.get(layer + 1)[rightNeuron]);

                for (int k = 0; k < layers.get(layer).length; k++) {
                    deltaWeights.get(layer)[rightNeuron][k] = layers.get(layer)[k] * delta.get(layer)[rightNeuron];
                }
            }
        }

        double eta = 0.5;

        for (int layer = 0; layer < weights.size(); layer++) {
            for (int i = 0; i < weights.get(layer).length; i++) {
                for (int j = 0; j < weights.get(layer)[i].length; j++) {
                    weights.get(layer)[i][j] -= eta * deltaWeights.get(layer)[i][j];
                }
            }
        }
    }

    public double forwardPass(double[] input) {
        for (int i = 0; i < input.length; i++) {
            layers.get(0)[i] = input[i];
        }

        for (int l = 1; l < layers.size(); l++) {
            for (int n = 0; n < layers.get(l).length; n++) {
                layers.get(l)[n] = activationSigmoidFunction(summaryFunction(l - 1, n));
            }
        }

        return layers.get(layers.size() - 1)[0];
    }

    public double countError(double output, double answer) {
        return (1.0 / 2.0) * Math.pow(output - answer, 2);
    }

    public double summaryFunction(int layerNumber, int neuronNumber) {
        int n = weights.get(layerNumber)[neuronNumber].length;
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            sum += layers.get(layerNumber)[i] * weights.get(layerNumber)[neuronNumber][i];
        }

        return sum;
    }

    public double activationSigmoidFunction(double sum) {
        return 1.0 / (1.0 + Math.exp(-sum));
    }

    public void outTheWeights() {
        try (FileOutputStream stream = new FileOutputStream(new File(getClass().getClassLoader().getResource("/files").getPath() + weightsFile))) {
            for (int i = 0; i < weights.size(); i++) {
                for (int j = 0; j < layers.get(i + 1).length; j++) {
                    for (int k = 0; k < layers.get(i).length; k++) {
                        String toWrite = Double.toString(weights.get(i)[j][k]) + ";";
                        stream.write(toWrite.getBytes());
                    }
                    stream.write("\n".getBytes());
                }
                stream.write("\n".getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<double[]> getLayers() {
        return layers;
    }

    public ArrayList<double[][]> getWeights() {
        return weights;
    }

    public String getWeightsFile() {
        return weightsFile;
    }
}
