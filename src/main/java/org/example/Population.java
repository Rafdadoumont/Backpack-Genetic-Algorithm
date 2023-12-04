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

            if (Calculator.calculateFitness(fittest) <  Calculator.calculateFitness(individual) ) {
                fittest = individual;
            }

        }
        return fittest;
    }

    public Individual getSecondFittest() {
        Individual fittest = individuals[0];
        Individual secondFittest = individuals[1];

        if (Calculator.calculateFitness(fittest)
                < Calculator.calculateFitness(secondFittest)) {
            fittest = individuals[1];
            secondFittest = individuals[0];
        }

        for (int i = 2; i < POPULATION_SIZE; i++) {
            if (Calculator.calculateFitness(individuals[i]) >
                Calculator.calculateFitness(fittest)) {
                secondFittest = fittest;
                fittest = individuals[i];
            } else if(Calculator.calculateFitness(individuals[i]) >
                    Calculator.calculateFitness(secondFittest)) {
                secondFittest = individuals[i];
            }
        }
        return secondFittest;
    }

    public void addOffspring(Individual offspring) {
        int leastFittestIndex = 0;

        for (int i = 1; i < POPULATION_SIZE; i++) {
            if (Calculator.calculateFitness(individuals[i]) <
                Calculator.calculateFitness(individuals[leastFittestIndex])) {
                leastFittestIndex = i;
            }
        }

        individuals[leastFittestIndex] = offspring;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Individual individual: individuals) {
            stringBuilder.append("Fitness: ").append(Calculator.calculateFitness(individual)).append(" ");
            stringBuilder.append("Weight: ").append(Calculator.calculateWeight(individual)).append(" ");
            stringBuilder.append("Volume: ").append(Calculator.calculateVolume(individual));
            stringBuilder.append('\n');
            stringBuilder.append(individual);
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}
