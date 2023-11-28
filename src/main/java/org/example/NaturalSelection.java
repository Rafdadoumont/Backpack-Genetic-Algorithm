package org.example;

import java.util.Random;

public class NaturalSelection {

    public static Individual getOffspring(Individual father, Individual mother) {
        boolean valid = false;
        Individual individual = null;

        while (!valid) {
            individual = getMutation(getCrossover(father, mother));
            if ((Calculator.calculateWeight(individual) <= 100) &&
                    Calculator.calculateVolume(individual) <= 50) {
                valid = true;
            }
        }

        return individual;
    }


    private static byte[] getCrossover(Individual father, Individual mother) {
        Random random = new Random();
        int crossOverPoint = random.nextInt(Individual.GENES_COUNT);
        byte[] newGenes = father.getGenes().clone();

        for (int i = 0; i < crossOverPoint; i++) {
            newGenes[i] = mother.getGenes()[i];
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
