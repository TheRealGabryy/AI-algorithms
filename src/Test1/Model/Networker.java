package Test1.Model;

import java.util.Random;

public class Networker {
    private double[][][] weights;
    private double[][] biases;
    private int[] architecture;
    private int layers;

    public int[] generateArchitecture(int layers, int miNeurons, int maxNeurons) {
        Random r = new Random();
        architecture = new int[layers];
        for (int i = 0; i < layers; i++) {
            architecture[i] = r.nextInt(miNeurons, maxNeurons);
        }
        return architecture;
    }

    public double[][][] createNetwork(int[] architecture) {
        Random r = new Random();

        this.architecture = architecture;
        this.layers = architecture.length;

        // layers - 1 connections
        this.weights = new double[layers - 1][][];
        this.biases  = new double[layers - 1][];

        for (int l = 0; l < layers - 1; l++) {

            int from = architecture[l];
            int to   = architecture[l + 1];

            // weights: from x to
            weights[l] = new double[from][to];

            // biases: one per output neuron
            biases[l] = new double[to];

            // init biases
            for (int j = 0; j < to; j++) {
                double b = r.nextDouble() * 4.0 - 2.0; // [-2, 2)
                biases[l][j] = Math.round(b * 100.0) / 100.0;
            }

            // init weights
            for (int i = 0; i < from; i++) {
                for (int j = 0; j < to; j++) {
                    double w = r.nextDouble() * 2.0 - 1.0; // [-1, 1)
                    weights[l][i][j] = Math.round(w * 100.0) / 100.0;
                    System.out.print(weights[l][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        printBiases(biases);
        return weights;
    }


    public void printBiases(double[][] biases) {
        for (int i = 0; i < biases.length; i++) {
            for (int j = 0; j < biases[i].length; j++) {
                System.out.print(biases[i][j] + " ");
            }
            System.out.println();
        }
    }

    public double[] forwardPass(int[] tokens) {

        // Convert int tokens to double input vector
        // This is your initial layer input
        double[] input = new double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            input[i] = tokens[i];
        }

        // Iterate over each layer connection
        // layers - 1 because last layer has no outgoing weights
        for (int l = 0; l < layers - 1; l++) {

            int from = architecture[l];
            int to   = architecture[l + 1];

            // Output of the current layer
            double[] output = new double[to];

            // For each neuron in the NEXT layer
            for (int j = 0; j < to; j++) {

                double sum = 0.0;

                // Weighted sum from previous layer neurons
                for (int i = 0; i < from; i++) {
                    sum += input[i] * weights[l][i][j];
                }

                // Add bias for neuron j
                sum += biases[l][j];

                // No activation yet. Raw linear output.
                output[j] = sum;
            }

            // Output becomes input for next layer
            input = output;
        }

        System.out.println("Output array: ");
        for (int i =0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        // Final output of the network
        return input;
    }



}
