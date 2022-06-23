package ru.javarush.island.tools;

import ru.javarush.island.items.abstracts.Animal;
import ru.javarush.island.items.abstracts.BasicItem;
import ru.javarush.island.items.abstracts.Plant;
import ru.javarush.island.items.animals.carnivore.*;
import ru.javarush.island.items.animals.herbivore.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Eating {
    public final static int WOLF = 0;
    public final static int BOA = 1;
    public final static int FOX = 2;
    public final static int BEAR = 3;
    public final static int EAGLE = 4;
    public final static int HORSE = 5;
    public final static int DEER = 6;
    public final static int RABBIT = 7;
    public final static int MOUSE = 8;
    public final static int GOAT = 9;
    public final static int SHEEP = 10;
    public final static int BOAR = 11;
    public final static int BUFFALO = 12;
    public final static int DUCK = 13;
    public final static int CATERPILLAR = 14;
    private final static String KILL_STRING = """
            -\t0\t0\t0\t0\t10\t15\t60\t80\t60\t70\t15\t10\t40\t0\t0
            0\t-\t15\t0\t0\t0\t0\t20\t40\t0\t0\t0\t0\t10\t0\t0
            0\t0\t-\t0\t0\t0\t0\t70\t90\t0\t0\t0\t0\t60\t40\t0
            0\t80\t0\t-\t0\t40\t80\t80\t90\t70\t70\t50\t20\t10\t0\t0
            0\t0\t10\t0\t-\t0\t0\t90\t90\t0\t0\t0\t0\t80\t0\t0
            0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t90\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t0\t50\t0\t0\t-\t0\t0\t90\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t90\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t100""";

    private final int[][] killArray = new int[15][16];
    private final Map<Class<? extends Animal>, int[]> killMap = new HashMap<>();
    private final Statistic statistic;

    public Eating(Statistic statistic) {
        this.statistic = statistic;
        fillKillArray();
    }

    public void bestFoodForAnimal(Animal animal, ArrayList<BasicItem> arrayList) {
        ArrayList<BasicItem> animals = new ArrayList<>();
        int[] animalsToEat = killMap.get(animal.getClass());
        for (BasicItem a : arrayList) {
            if (animalsToEat[checkItemIndex(a)] > 0 && a.getWeight() >= animal.getSaturation()) {
                animals.add(a);
            }
        }
        if (animals.size() > 0) {
            tryToEat(animals, animal, animalsToEat);
        }
    }

    private void tryToEat(ArrayList<BasicItem> animals, Animal animal, int[] animalsToEat) {
        for (int i = 0; i < countOfItemToEat(animal.getClass()); i++) {
            BasicItem basicItem;
            Optional<BasicItem> optionalInteger = animals.stream().filter(BasicItem::getLife).max(Comparator.comparingInt(o -> animalsToEat[checkItemIndex(o)]));
            if (optionalInteger.isPresent()) {
                basicItem = optionalInteger.get();
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                if (threadLocalRandom.nextInt(100) <= animalsToEat[checkItemIndex(basicItem)]) {
                    animal.setSaturation(Math.min((animal.getSaturation() + basicItem.getWeight()), animal.getMaxSaturation()));
                    animal.eat(basicItem);
                    if (basicItem instanceof Animal) {
                        statistic.increaseAnimalCount(-1);
                    } else if (basicItem instanceof Plant) {
                        statistic.increaseDeathGrass(1);
                    }
                }
            }
        }
    }

    private int countOfItemToEat(Class<? extends Animal> animalClass) {
        switch (animalClass.getSimpleName().toUpperCase()) {
            case "BOAR", "DEER", "HORSE" -> {
                return 5;
            }
            case "BUFFALO" -> {
                return 10;
            }
            case "SHEEP", "GOAT" -> {
                return 3;
            }
            default -> {
                return 1;
            }
        }
    }

    private void fillKillArray() {
        String[] line = KILL_STRING.split("\n");
        for (int i = 0; i < killArray.length; i++) {
            String[] row = line[i].split("\t");
            for (int j = 0; j < killArray[i].length; j++) {
                if (row[j].equals("-")) {
                    killArray[i][j] = -1;
                } else {
                    killArray[i][j] = Integer.parseInt(row[j]);
                }
            }
        }
        fillKillMap();
    }

    private int checkItemIndex(BasicItem basicItem) {
        if (basicItem.getClass().getSimpleName().equalsIgnoreCase("WOLF")) return 0;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("BOA")) return 1;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("FOX")) return 2;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("BEAR")) return 3;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("EAGLE")) return 4;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("HORSE")) return 5;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("DEER")) return 6;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("RABBIT")) return 7;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("MOUSE")) return 8;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("GOAT")) return 9;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("SHEEP")) return 10;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("BOAR")) return 11;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("BUFFALO")) return 12;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("DUCK")) return 13;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("CATERPILLAR")) return 14;
        else if (basicItem.getClass().getSimpleName().equalsIgnoreCase("HERB")) return 15;
        return -1;
    }

    private void fillKillMap() {
        killMap.put(Wolf.class, killArray[WOLF]);
        killMap.put(Boa.class, killArray[BOA]);
        killMap.put(Fox.class, killArray[FOX]);
        killMap.put(Bear.class, killArray[BEAR]);
        killMap.put(Eagle.class, killArray[EAGLE]);
        killMap.put(Horse.class, killArray[HORSE]);
        killMap.put(Deer.class, killArray[DEER]);
        killMap.put(Rabbit.class, killArray[RABBIT]);
        killMap.put(Mouse.class, killArray[MOUSE]);
        killMap.put(Goat.class, killArray[GOAT]);
        killMap.put(Sheep.class, killArray[SHEEP]);
        killMap.put(Boar.class, killArray[BOAR]);
        killMap.put(Buffalo.class, killArray[BUFFALO]);
        killMap.put(Duck.class, killArray[DUCK]);
        killMap.put(Caterpillar.class, killArray[CATERPILLAR]);
    }
}
