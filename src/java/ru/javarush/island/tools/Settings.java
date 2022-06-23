package ru.javarush.island.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    public static final String BEAR = "maxBears";
    public static final String BOA = "maxBoas";
    public static final String EAGLE = "maxEagles";
    public static final String FOX = "maxFoxes";
    public static final String WOLF = "maxWolfs";
    public static final String BOAR = "maxBoars";
    public static final String BUFFALO = "maxBuffalo";
    public static final String CATERPILLAR = "maxCaterpillar";
    public static final String DEER = "maxDeer";
    public static final String DUCK = "maxDucks";
    public static final String GOAT = "maxGoats";
    public static final String HORSE = "maxHorses";
    public static final String MOUSE = "maxMises";
    public static final String RABBIT = "maxRabbits";
    public static final String SHEEP = "maxSheep";
    public static final String PLANT = "maxPlants";
    public static final String GAME_MOVES = "maxGameMoves";
    private static final String PATH_TO_PROPERTIES = "src/config.properties";
    private Properties properties;
    private int maxGameMoves;
    private int mapWidth;
    private int mapHeight;
    private int maxBears;
    private int maxBoas;
    private int maxEagles;
    private int maxFoxes;
    private int maxWolfs;
    private int maxBoars;
    private int maxBuffalo;
    private int maxCaterpillar;
    private int maxDeer;
    private int maxDucks;
    private int maxGoats;
    private int maxHorses;
    private int maxMises;
    private int maxRabbits;
    private int maxSheep;
    private int maxPlants;

    public Settings() {
        try (InputStream inputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            this.properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void applySettings() {
        mapHeight = Integer.parseInt(properties.getProperty("height"));
        mapWidth = Integer.parseInt(properties.getProperty("width"));
        maxBears = parseProperty(BEAR);
        maxBoas = parseProperty(BOA);
        maxEagles = parseProperty(EAGLE);
        maxFoxes = parseProperty(FOX);
        maxWolfs = parseProperty(WOLF);
        maxBoars = parseProperty(BOAR);
        maxBuffalo = parseProperty(BUFFALO);
        maxCaterpillar = parseProperty(CATERPILLAR);
        maxDeer = parseProperty(DEER);
        maxDucks = parseProperty(DUCK);
        maxGoats = parseProperty(GOAT);
        maxHorses = parseProperty(HORSE);
        maxMises = parseProperty(MOUSE);
        maxRabbits = parseProperty(RABBIT);
        maxSheep = parseProperty(SHEEP);
        maxPlants = parseProperty(PLANT);
        maxGameMoves = parseProperty(GAME_MOVES);
    }

    private int parseProperty(String property) {
        return Integer.parseInt(properties.getProperty(property));
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(String key, String value) {
        properties.setProperty(key, value);
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMaxBears() {
        return maxBears;
    }

    public int getMaxBoas() {
        return maxBoas;
    }

    public int getMaxEagles() {
        return maxEagles;
    }

    public int getMaxFoxes() {
        return maxFoxes;
    }

    public int getMaxWolfs() {
        return maxWolfs;
    }

    public int getMaxBoars() {
        return maxBoars;
    }

    public int getMaxBuffalo() {
        return maxBuffalo;
    }

    public int getMaxCaterpillar() {
        return maxCaterpillar;
    }

    public int getMaxDeer() {
        return maxDeer;
    }

    public int getMaxDucks() {
        return maxDucks;
    }

    public int getMaxGoats() {
        return maxGoats;
    }

    public int getMaxHorses() {
        return maxHorses;
    }

    public int getMaxMises() {
        return maxMises;
    }

    public int getMaxRabbits() {
        return maxRabbits;
    }

    public int getMaxSheep() {
        return maxSheep;
    }

    public int getMaxPlants() {
        return maxPlants;
    }

    public int getMaxGameMoves() {
        return maxGameMoves;
    }
}