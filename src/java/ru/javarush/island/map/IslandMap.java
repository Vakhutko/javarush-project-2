package ru.javarush.island.map;

import ru.javarush.island.items.abstracts.BasicItem;
import ru.javarush.island.items.animals.carnivore.*;
import ru.javarush.island.items.animals.herbivore.*;
import ru.javarush.island.items.plants.Herb;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class IslandMap {
    private ArrayList<BasicItem>[][] map;
    private Properties properties;
    private int mapWidth;
    private int mapHeight;
    private final String BEAR = "maxBears";
    private final String BOA = "maxBoas";
    private final String EAGLE = "maxEagles";
    private final String FOX = "maxFoxes";
    private final String WOLF = "maxWolfs";
    private final String BOAR = "maxBoars";
    private final String BUFFALO = "maxBuffalo";
    private final String CATERPILLAR = "maxCaterpillar";
    private final String DEER = "maxDeer";
    private final String DUCK = "maxDucks";
    private final String GOAT = "maxGoats";
    private final String HORSE = "maxHorses";
    private final String MOUSE = "maxMises";
    private final String RABBIT = "maxRabbits";
    private final String SHEEP = "maxSheep";
    private final String PLANT = "maxPlants";

    public ArrayList<BasicItem>[][] getMap() {
        return map;
    }

    public IslandMap() {
        try (InputStream inputStream = new FileInputStream("src/config.properties")) {
            properties = new Properties();
            properties.load(inputStream);
            mapHeight = Integer.parseInt(properties.getProperty("height"));
            mapWidth = Integer.parseInt(properties.getProperty("width"));
            this.map = new ArrayList[mapHeight][mapWidth];
            initializeMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        newAnimal(BEAR, Bear.class);
        newAnimal(BOA, Boa.class);
        newAnimal(EAGLE, Eagle.class);
        newAnimal(FOX, Fox.class);
        newAnimal(WOLF, Wolf.class);
        newAnimal(BOAR, Boar.class);
        newAnimal(BUFFALO, Buffalo.class);
        newAnimal(CATERPILLAR, Caterpillar.class);
        newAnimal(DEER, Deer.class);
        newAnimal(DUCK, Duck.class);
        newAnimal(GOAT, Goat.class);
        newAnimal(HORSE, Horse.class);
        newAnimal(MOUSE, Mouse.class);
        newAnimal(RABBIT, Rabbit.class);
        newAnimal(SHEEP, Sheep.class);
        newAnimal(PLANT, Herb.class);
//        int maxWolfs = Integer.parseInt(properties.getProperty("maxWolfs"));
//        for (int i = 0; i < ThreadLocalRandom.current().nextInt(maxWolfs); i++) {
//            int temp = ThreadLocalRandom.current().nextInt(mapHeight * mapWidth);
//            int y = temp / mapHeight;
//            int x = temp % mapWidth;
//            BasicItems basicItems = new Wolf(x, y);
//            map[y][x].put(basicItems, map[y][x].getOrDefault(basicItems, 1));
//        }
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                map[i][j] = new HashMap();
//                BasicItems basicItems = newAnimal(j, i);
//                if (basicItems != null) {
//                    map[i][j].put(basicItems, map[i][j].getOrDefault(basicItems, 1));
//                }
//            }
//        }
    }

    private BasicItem newAnimal(String name, Class clazz) {
        BasicItem basicItem = null;
        int maxAnimal = Integer.parseInt(properties.getProperty(name));
        for (int i = 0; i < maxAnimal; i++) {
            int temp = ThreadLocalRandom.current().nextInt(mapHeight * mapWidth);
            int height = temp / mapWidth;
            int width = temp % mapWidth;
            try {
                basicItem = (BasicItem) clazz.getDeclaredConstructors()[0].newInstance(width, height);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            map[height][width].add(basicItem);
        }
        return basicItem;
    }

    private BasicItem newRandomAnimal(int x, int y) {
        return switch (ThreadLocalRandom.current().nextInt(100)) {
            case 1 -> new Bear(x, y);
            case 2 -> new Boa(x, y);
            case 3 -> new Eagle(x, y);
            case 4 -> new Fox(x, y);
            case 5 -> new Wolf(x, y);
            case 6 -> new Boar(x, y);
            case 7 -> new Buffalo(x, y);
            case 8 -> new Caterpillar(x, y);
            case 9 -> new Deer(x, y);
            case 10 -> new Duck(x, y);
            case 11 -> new Goat(x, y);
            case 12 -> new Horse(x, y);
            case 13 -> new Mouse(x, y);
            case 14 -> new Rabbit(x, y);
            case 15 -> new Sheep(x, y);
            default -> null;
        };
    }

    private void calculateNewAnimal() {
    }
}
