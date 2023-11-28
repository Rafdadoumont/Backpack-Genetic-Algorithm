package org.example;

public class FitnessCalculator {

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

    public static int calculate(Individual individual) {
        byte[] genes = individual.getGenes();
        int fitness = 0;

        for (int i = 0; i < Individual.GENES_COUNT; i++) {
            fitness += genes[i] == 1 ? data[i][0] : 0;
        }
        return fitness;
    }

}
