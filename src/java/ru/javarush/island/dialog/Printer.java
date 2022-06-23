package ru.javarush.island.dialog;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.BasicItem;

import java.util.ArrayList;
import java.util.Comparator;

public class Printer {
    public void printMap(ArrayList<BasicItem>[][] map) {
        for (ArrayList<BasicItem>[] arrayLists : map) {
            for (ArrayList<BasicItem> arrayList : arrayLists) {
                if (arrayList.isEmpty()) {
                    System.out.print("[ ]");
                } else if (arrayList.stream().noneMatch(BasicItem::getLife)) {
                    System.out.print("[ ]");
                } else {
                    System.out.print('[' + arrayList.stream().filter(BasicItem::getLife).max(Comparator.comparingDouble(BasicItem::getWeight)).get().getClass().getAnnotation(Emoji.class).emoji() + ']');
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}