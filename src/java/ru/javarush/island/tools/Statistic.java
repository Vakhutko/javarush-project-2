package ru.javarush.island.tools;

public class Statistic {
    private int animalCount = 0;
    private int deathAnimal = 0;
    private int birthNewAnimal = 0;
    private int firstMoveAnimals;
    private int grassCount = 0;
    private int deathGrass = 0;

    public int getGrassCount() {
        return grassCount;
    }

    public void increaseDeathAnimal(int deathAnimal) {
        this.deathAnimal += deathAnimal;
    }

    public void increaseGrassCount(int grassCount) {
        this.grassCount += grassCount;
    }

    public int getDeathGrass() {
        return deathGrass;
    }

    public void increaseDeathGrass(int deathGrass) {
        this.deathGrass += deathGrass;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void increaseAnimalCount(int n) {
        this.animalCount += n;
    }

    public int getFirstMoveAnimals() {
        return firstMoveAnimals;
    }

    public void setFirstMoveAnimals(int firstMoveItems) {
        this.firstMoveAnimals = firstMoveItems;
        increaseAnimalCount(firstMoveItems);
    }

    public int getDeathAnimal() {
        return deathAnimal;
    }

    public int getBirthNewAnimal() {
        return birthNewAnimal;
    }

    public void increaseBirthNewAnimal(int n) {
        this.birthNewAnimal += n;
    }
}
