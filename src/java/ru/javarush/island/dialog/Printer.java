package ru.javarush.island.dialog;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.BasicItem;

import java.util.ArrayList;
import java.util.Map;

public class Printer {
    public void printMap(ArrayList<BasicItem>[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].isEmpty()) {
                    System.out.print("[ ]");
                } else {
                    System.out.print('[' + map[i][j].get(0).getClass().getAnnotation(Emoji.class).emoji() + ']');
                }
            }
            System.out.println();
        }
    }
}