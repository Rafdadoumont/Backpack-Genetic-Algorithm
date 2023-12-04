package org.example;

public class Main {
    public static void main(String[] args) {
        int generation = 0;
        Population population = new Population();
        boolean found = false;
        boolean includes = false;

        byte[] perfectGenes = new byte[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
        Individual perfectIndividual = new Individual(perfectGenes);

        byte[] sampleGenes = new byte[]{0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
        Individual sampleIndividual = new Individual(sampleGenes);


        while(generation < 10000000) {
            Individual fittest = population.getFittest();
            Individual secondFittest = population.getSecondFittest();

            Individual offspring = NaturalSelection.getOffspring(fittest, secondFittest);
            // includes = offspring.includesItem(4);
            population.addOffspring(offspring);
            generation++;

            int fitness = Calculator.calculateFitness(offspring);
            System.out.println("Current fitness: " + fitness);
        }

        System.out.println(includes);
        System.out.println("Perfect fitness: " + Calculator.calculateFitness(perfectIndividual));
        System.out.println("Total generations: " + generation);
        System.out.println(population);
    }
}