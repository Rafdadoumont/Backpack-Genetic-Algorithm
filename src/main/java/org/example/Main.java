package org.example;

public class Main {
    public static void main(String[] args) {
        int generation = 0;
        Population population = new Population();
        boolean found = false;

        while(!found) {
            Individual fittest = population.getFittest();
            Individual secondFittest = population.getSecondFittest();

            Individual offspring = NaturalSelection.getOffspring(fittest, secondFittest);
            population.addOffspring(offspring);
            generation++;;

            int fitness = Calculator.calculateFitness(offspring);
            System.out.println("Current fitness: " + fitness);

            if (fitness == 1090) {
                found = true;
            }
        }

        System.out.println("Total generations: " + generation);
        System.out.println(population);
    }
}