package com.smartMed2017.neuralNetwork;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by vladyour on 05.06.17.
 */
public class CSVReader {
    private BufferedReader reader;
    private ArrayList<double[][]> weights;
    private double[][] pattern;
    private int[] output;
    private double[] input;
    private int neuronNumber;

    public CSVReader(String name) {
        //init reader
        try {
            String path = getClass().getClassLoader().getResource("/files").getPath() + name;
            this.reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readAnalysis() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //creating patternArray
        pattern = new double[lines.size()][];
        output = new int[lines.size()];
        int iterator = 0;
        for (String line : lines) {
            String[] tempLine = line.split(";");
            pattern[iterator] = new double[tempLine.length - 1];

            for (int i = 0; i < tempLine.length - 1; i++) {
                pattern[iterator][i] = Double.parseDouble(tempLine[i]);
            }

            output[iterator] = Integer.parseInt(tempLine[tempLine.length - 1]);

            iterator++;
        }
        neuronNumber = pattern[0].length;

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWeights() {
        ArrayList<String> lines = new ArrayList<>();
        weights = new ArrayList<>();

        try {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int lineNumber = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                weights.add(new double[lineNumber][]);
                lineNumber = 0;
            }
            else lineNumber++;
        }

        int lineIterator = 0;
        int weightsIterator = 0;

        for (String line : lines) {
            if (line.isEmpty()) {
                weightsIterator++;
                lineIterator = 0;
                continue;
            }
            String[] tempLine = line.split(";");
            weights.get(weightsIterator)[lineIterator] = new double[tempLine.length];

            for (int i = 0; i < tempLine.length; i++) {
                weights.get(weightsIterator)[lineIterator][i] = Double.parseDouble(tempLine[i]);
            }

            lineIterator++;
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readLabwork() {
        String line = null;

        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] inputTemp = line.split(";");
        input = new double[inputTemp.length];

        for (int i = 0; i < inputTemp.length; i++) {
            input[i] = Double.parseDouble(inputTemp[i]);
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double[][] getPattern() {
        return pattern;
    }

    public int[] getOutput() {
        return output;
    }

    public int getNeuronNumber() {
        return neuronNumber;
    }

    public ArrayList<double[][]> getWeights() {
        return weights;
    }

    public double[] getInput() {
        return input;
    }
}
