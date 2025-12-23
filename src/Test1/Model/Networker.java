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

        // layers - 1 connections
        double[][][] weights = new double[architecture.length - 1][][];

        for (int l = 0; l < architecture.length - 1; l++) {

            int from = architecture[l];
            int to = architecture[l + 1];

            weights[l] = new double[from][to];

            for (int i = 0; i < from; i++) {
                for (int j = 0; j < to; j++) {

                    double w = r.nextDouble() * 2.0;     // range [0, 2)
                    w = Math.round(w * 100.0) / 100.0;   // 2 decimals

                    weights[l][i][j] = w;
                    System.out.print(w + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return weights;
    }


}
