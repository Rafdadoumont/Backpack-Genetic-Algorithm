package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Population population = new Population();

        for (Individual individual: population.getIndividuals()) {
            System.out.println(FitnessCalculator.calculate(individual));
            System.out.println(Arrays.toString(individual.getGenes()));
            System.out.println();
        }

        System.out.println("Fittest:");
        System.out.println(FitnessCalculator.calculate(population.getFittest()));
        System.out.println(Arrays.toString(population.getFittest().getGenes()));
        System.out.println();

        System.out.println("Second fittest:");
        System.out.println(FitnessCalculator.calculate(population.getSecondFittest()));
        System.out.println(Arrays.toString(population.getSecondFittest().getGenes()));
    }
}