package ru.javarush.island.threads;

import ru.javarush.island.items.abstracts.Animal;
import ru.javarush.island.items.abstracts.BasicItem;
import ru.javarush.island.map.IslandMap;
import ru.javarush.island.tools.Eating;
import ru.javarush.island.tools.ItemFactory;
import ru.javarush.island.tools.Settings;
import ru.javarush.island.tools.Statistic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameMove implements Runnable {
    private final Settings settings;
    private final IslandMap islandMap;
    private final Statistic statistic;
    private final Eating eating;
    private final ItemFactory itemFactory;

    public GameMove(Settings settings, IslandMap islandMap, Statistic statistic) {
        this.settings = settings;
        this.islandMap = islandMap;
        this.statistic = statistic;
        this.eating = new Eating(statistic);
        this.itemFactory = new ItemFactory(settings);
    }

    public void reproductionAnimal() {
        HashMap<Class<Animal>, Integer> map = new HashMap<>();
        for (int height = 0; height < islandMap.getMap().length; height++) {
            for (int width = 0; width < islandMap.getMap()[height].length; width++) {
                for (BasicItem entry : islandMap.getMap()[height][width]) {
                    if (entry instanceof Animal) {
                        if (map.containsKey(entry.getClass())) {
                            map.put((Class<Animal>) entry.getClass(), map.get(entry.getClass()) + 1);
                        } else {
                            map.put((Class<Animal>) entry.getClass(), 1);
                        }
                    }
                }
                for (Map.Entry<Class<Animal>, Integer> m : map.entrySet()) {
                    for (int i = 0; i < m.getValue() / 2; i++) {
                        try {
                            if (countAnimal(islandMap.getMap()[height][width], m.getKey())) {
                                BasicItem basicItem = (BasicItem) m.getKey().getDeclaredConstructors()[0].newInstance(width, height);
                                islandMap.getMap()[height][width].add(basicItem);
                                statistic.increaseAnimalCount(1);
                                statistic.increaseBirthNewAnimal(1);
                            }
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
                map.clear();
            }
        }
    }

    public boolean countAnimal(ArrayList<BasicItem> arrayList, Class<Animal> animalClass) {
        int count = 0;
        for (BasicItem basicItem : arrayList) {
            if (basicItem.getClass().equals(animalClass)) {
                count++;
            }
        }
        return count < itemFactory.getMaxAnimal(animalClass.getSimpleName().toUpperCase());
    }

    public void eatAnimal() {
        for (int height = 0; height < islandMap.getMap().length; height++) {
            for (int width = 0; width < islandMap.getMap()[height].length; width++) {
                for (BasicItem entry : islandMap.getMap()[height][width]) {
                    if (entry instanceof Animal) {
                        eating.bestFoodForAnimal((Animal) entry, islandMap.getMap()[height][width]);
                    }
                }
            }
        }
    }

    private void animalStep() {
        synchronized (islandMap) {
            for (int height = 0; height < islandMap.getMap().length; height++) {
                for (int width = 0; width < islandMap.getMap()[height].length; width++) {
                    for (BasicItem entry : islandMap.getMap()[height][width]) {
                        if (entry instanceof Animal) {
                            if (!((Animal) entry).move(settings.getMapHeight(), settings.getMapWidth())) {
                                statistic.increaseDeathAnimal(1);
                            }
                        }
                    }
                }
            }
            for (int height = 0; height < islandMap.getMap().length; height++) {
                for (int width = 0; width < islandMap.getMap()[height].length; width++) {
                    Iterator<BasicItem> itemIterator = islandMap.getMap()[height][width].iterator();
                    while (itemIterator.hasNext()) {
                        BasicItem basicItem = itemIterator.next();
                        int x = basicItem.getX();
                        int y = basicItem.getY();
                        if (width != x || height != y) {
                            islandMap.getMap()[y][x].add(basicItem);
                            itemIterator.remove();
                        }
                    }
                }
            }
        }
    }

    private void removeDeadItem() {
        synchronized (islandMap) {
            for (int height = 0; height < islandMap.getMap().length; height++) {
                for (int width = 0; width < islandMap.getMap()[height].length; width++) {
                    islandMap.getMap()[height][width].removeIf(o -> (!o.getLife()));
                }
            }
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            removeDeadItem();
            animalStep();
            eatAnimal();
            reproductionAnimal();
        }
    }
}