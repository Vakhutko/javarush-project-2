package ru.javarush.island.tools;

import ru.javarush.island.items.abstracts.BasicItem;
import ru.javarush.island.items.animals.carnivore.*;
import ru.javarush.island.items.animals.herbivore.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ItemFactory {
    private final Settings settings;

    public ItemFactory(Settings settings) {
        this.settings = settings;
    }

    public int initializeItems(ArrayList<BasicItem>[][] map) {
        int result = 0;
        result += newAnimal(Settings.BEAR, Bear.class, map);
        result += newAnimal(Settings.BOA, Boa.class, map);
        result += newAnimal(Settings.EAGLE, Eagle.class, map);
        result += newAnimal(Settings.FOX, Fox.class, map);
        result += newAnimal(Settings.WOLF, Wolf.class, map);
        result += newAnimal(Settings.BOAR, Boar.class, map);
        result += newAnimal(Settings.BUFFALO, Buffalo.class, map);
        result += newAnimal(Settings.CATERPILLAR, Caterpillar.class, map);
        result += newAnimal(Settings.DEER, Deer.class, map);
        result += newAnimal(Settings.DUCK, Duck.class, map);
        result += newAnimal(Settings.GOAT, Goat.class, map);
        result += newAnimal(Settings.HORSE, Horse.class, map);
        result += newAnimal(Settings.MOUSE, Mouse.class, map);
        result += newAnimal(Settings.RABBIT, Rabbit.class, map);
        result += newAnimal(Settings.SHEEP, Sheep.class, map);
        return result;
    }

    public int getMaxAnimal(String name) {
        return switch (name) {
            case "BEAR" -> settings.getMaxBears();
            case "BOA" -> settings.getMaxBoas();
            case "EAGLE" -> settings.getMaxEagles();
            case "FOX" -> settings.getMaxFoxes();
            case "WOLF" -> settings.getMaxWolfs();
            case "BOAR" -> settings.getMaxBoars();
            case "BUFFALO" -> settings.getMaxBuffalo();
            case "CATERPILLAR" -> settings.getMaxCaterpillar();
            case "DEER" -> settings.getMaxDeer();
            case "DUCK" -> settings.getMaxDucks();
            case "GOAT" -> settings.getMaxGoats();
            case "HORSE" -> settings.getMaxHorses();
            case "MOUSE" -> settings.getMaxMises();
            case "RABBIT" -> settings.getMaxRabbits();
            case "SHEEP" -> settings.getMaxSheep();
            case "PLANT" -> settings.getMaxPlants();
            default -> 0;
        };
    }

    public int newAnimal(String name, Class<? extends BasicItem> clazz, ArrayList<BasicItem>[][] map) {
        int animalCount = 0;
        BasicItem basicItem = null;
        int maxAnimal = Integer.parseInt(settings.getProperties().getProperty(name));
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < maxAnimal; i++) {
            int itemIndex = threadLocalRandom.nextInt(settings.getMapHeight() * settings.getMapWidth());
            int height = itemIndex / settings.getMapWidth();
            int width = itemIndex % settings.getMapWidth();
            try {
                basicItem = (BasicItem) clazz.getDeclaredConstructors()[0].newInstance(width, height);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            map[height][width].add(basicItem);
            animalCount++;
        }
        return animalCount;
    }
}