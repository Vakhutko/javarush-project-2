package ru.javarush.island.map;

import ru.javarush.island.items.abstracts.BasicItem;
import ru.javarush.island.tools.Settings;

import java.util.ArrayList;

public class IslandMap {
    private final ArrayList<BasicItem>[][] map;

    public ArrayList<BasicItem>[][] getMap() {
        return map;
    }

    public IslandMap(Settings settings) {
        this.map = new ArrayList[settings.getMapHeight()][settings.getMapWidth()];
        initializeMap();
    }

    private void initializeMap() {
        for (int height = 0; height < map.length; height++) {
            for (int width = 0; width < map[height].length; width++) {
                map[height][width] = new ArrayList<>();
            }
        }
    }
}