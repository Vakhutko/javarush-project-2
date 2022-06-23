package ru.javarush.island.tools;

import ru.javarush.island.dialog.Printer;
import ru.javarush.island.items.abstracts.Animal;
import ru.javarush.island.items.abstracts.BasicItem;
import ru.javarush.island.map.IslandMap;

public class GameMove {
    public GameMove() {
    }

    public GameMove(IslandMap islandMap) {
        Printer printer = new Printer();
        int n = 0;
        while (n < 3) {
            for (int i = 0; i < islandMap.getMap().length; i++) {
                for (int j = 0; j < islandMap.getMap()[i].length; j++) {
//                    System.out.println(i + " " + j);
                    for (BasicItem entry : islandMap.getMap()[i][j]) {
                        if (entry instanceof Animal) {
                            ((Animal) entry).move();
                        }
//                        System.out.println(entry.getClass().getSimpleName());
                    }
//                    System.out.println();
                }
            }
            for (int i = 0; i < islandMap.getMap().length; i++) {
                for (int j = 0; j < islandMap.getMap()[i].length; j++) {
                    for (BasicItem entry : islandMap.getMap()[i][j]) {
                        int x = entry.getX();
                        int y = entry.getY();
                        if (j != x || i != y) {
                            islandMap.getMap()[y][x].add(entry);
                            islandMap.getMap()[i][j].remove(entry);
                        }
                    }
                }
            }
            n++;
            printer.printMap(islandMap.getMap());
        }
    }
}