package ru.javarush.island.threads;

import ru.javarush.island.items.plants.Herb;
import ru.javarush.island.map.IslandMap;
import ru.javarush.island.tools.ItemFactory;
import ru.javarush.island.tools.Settings;
import ru.javarush.island.tools.Statistic;

public class GenerateHerb implements Runnable {
    ItemFactory itemFactory;
    final IslandMap islandMap;
    Statistic statistic;

    public GenerateHerb(ItemFactory itemFactory, IslandMap islandMap, Statistic statistic) {
        this.itemFactory = itemFactory;
        this.islandMap = islandMap;
        this.statistic = statistic;
    }

    @Override
    public void run() {
        synchronized (islandMap) {
            statistic.increaseGrassCount(itemFactory.newAnimal(Settings.PLANT, Herb.class, islandMap.getMap()));
        }
    }
}