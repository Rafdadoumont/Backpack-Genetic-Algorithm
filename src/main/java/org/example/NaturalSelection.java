package org.example;

import java.util.Random;

public class NaturalSelection {
    private static final double UNIFORM_CROSSOVER_PROBABILITY = 0.5;

    public static Individual getOffspring(Individual father, Individual mother) {
        return getMutation(getUniformCrossover(father, mother));
    }

    private static byte[] getUniformCrossover(Individual father, Individual mother) {
        Random random = new Random();
        byte[] newGenes = new byte[Individual.GENES_COUNT];

        for (int i = 0; i < Individual.GENES_COUNT; i++) {
            if (random.nextDouble() <= UNIFORM_CROSSOVER_PROBABILITY) {
                newGenes[i] = father.getGenes()[i];
            } else {
                newGenes[i] = mother.getGenes()[i];
            }
        }

        return newGenes;
    }

    private static Individual getMutation(byte[] genes) {
        Random random = new Random();

        for (int i = 0; i < genes.length; i++) {
            int randomValue = random.nextInt(100);
            if (randomValue == 1) {
                genes[i] = (byte) (genes[i] == 1 ? 0 : 1);
            }
        }
        return new Individual(genes);
    }
}
