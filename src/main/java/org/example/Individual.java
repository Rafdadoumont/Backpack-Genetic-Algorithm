package org.example;

import java.util.Arrays;
import java.util.Random;

public class Individual {
    public static final int GENES_COUNT = 16;
    public static final int MAX_WEIGHT = 100;
    public static final int MAX_VOLUME = 50;

    private byte[] genes = new byte[GENES_COUNT];

    public Individual() {
        generateGenes();
    }

    public Individual(byte[] genes) {
        this.genes = genes;
    }

    public byte[] getGenes() {
        return genes;
    }

    private void generateGenes() {
        Random random = new Random();

        for (byte i = 0; i < GENES_COUNT; i++) {
            genes[i] = (byte) Math.abs(random.nextInt() % 2);
        }
    }

    public boolean includesItem(int item) {
        return genes[item] == 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(genes);
    }
}
