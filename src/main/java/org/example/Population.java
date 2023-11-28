package org.example;

public class Population {
    public static final int POPULATION_SIZE = 10;

    private final Individual[] individuals = new Individual[POPULATION_SIZE];

    public Population() {
        for (int i = 0; i < POPULATION_SIZE; i++) {
            individuals[i] = new Individual();
        }
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        for (Individual individual: individuals) {

            if (FitnessCalculator.calculate(fittest) <  FitnessCalculator.calculate(individual) ) {
                fittest = individual;
            }

        }
        return fittest;
    }

    public Individual getSecondFittest() {
        Individual fittest = individuals[0];
        Individual secondFittest = individuals[1];

        if (FitnessCalculator.calculate(fittest)
                < FitnessCalculator.calculate(secondFittest)) {
            fittest = individuals[1];
            secondFittest = individuals[0];
        }

        for (int i = 2; i < POPULATION_SIZE; i++) {
            if (FitnessCalculator.calculate(individuals[i]) >
                FitnessCalculator.calculate(fittest)) {
                secondFittest = fittest;
                fittest = individuals[i];
            } else if(FitnessCalculator.calculate(individuals[i]) >
                    FitnessCalculator.calculate(secondFittest)) {
                secondFittest = individuals[i];
            }
        }

        return secondFittest;

    }



}
