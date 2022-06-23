package ru.javarush.island.threads;

import ru.javarush.island.dialog.Printer;
import ru.javarush.island.map.IslandMap;
import ru.javarush.island.tools.Statistic;

public class PrintStatistic implements Runnable {
    private final Statistic statistic;
    private final IslandMap islandMap;
    private final Printer printer;

    public PrintStatistic(Statistic statistic, IslandMap islandMap) {
        this.statistic = statistic;
        this.islandMap = islandMap;
        this.printer = new Printer();
    }

    @Override
    public void run() {
        synchronized (islandMap) {
            System.out.println("Statistic:");
            System.out.println("All animal = " + statistic.getAnimalCount());
            System.out.println("All grass = " + statistic.getGrassCount());
            System.out.println("Death animal = " + statistic.getDeathAnimal());
            System.out.println("Death grass = " + statistic.getDeathGrass());
            System.out.println("Birth animal = " + statistic.getBirthNewAnimal());
            System.out.println("First move animals - current = " + (statistic.getFirstMoveAnimals() - statistic.getAnimalCount()));
            System.out.println("Map:");
            printer.printMap(islandMap.getMap());
        }
    }
}
