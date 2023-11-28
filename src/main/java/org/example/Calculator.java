package org.example;

public class Calculator {

    static int[][] data = {
            {500, 40, 5},
            {25, 20, 6},
            {55, 10, 8},
            {65, 35, 6},
            {400, 30, 6},
            {25, 20, 5},
            {20, 25, 5},
            {10, 10, 4},
            {450, 25, 10},
            {10, 20, 3},
            {5, 10, 2},
            {15, 7, 9},
            {25, 8, 3},
            {35, 28, 7},
            {45, 9, 12},
            {35, 16, 14}
    };

    public static int calculateFitness(Individual individual) {
        byte[] genes = individual.getGenes();
        int fitness = 0;

        for (int i = 0; i < Individual.GENES_COUNT; i++) {
            fitness += genes[i] == 1 ? data[i][0] : 0;
        }
        return fitness;
    }

    public static int calculateWeight(Individual individual) {
        byte[] genes = individual.getGenes();
        int weight = 0;

        for (int i = 0; i < Individual.GENES_COUNT; i++) {
            weight += genes[i] == 1 ? data[i][1] : 0;
        }
        return weight;
    }

    public static int calculateVolume(Individual individual) {
        byte[] genes = individual.getGenes();
        int volume = 0;

        for (int i = 0; i < Individual.GENES_COUNT; i++) {
            volume += genes[i] == 1 ? data[i][2] : 0;
        }
        return volume;
    }

}
