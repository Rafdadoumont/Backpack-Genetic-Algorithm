package org.example;

import java.util.Arrays;
import java.util.Random;

public class Individual {
    public static final int GENES_COUNT = 16;
    private byte[] genes = new byte[GENES_COUNT];

    public Individual() {
        Random random = new Random();

        for (byte i = 0; i < GENES_COUNT; i++) {
            genes[i] = (byte) Math.abs(random.nextInt() % 2);
        }
    }

    public byte[] getGenes() {
        return genes;
    }

    public void setGenes(byte[] genes) {
        this.genes = genes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual that = (Individual) o;
        return Arrays.equals(genes, that.genes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(genes);
    }
}
