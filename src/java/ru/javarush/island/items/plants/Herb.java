package ru.javarush.island.items.plants;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Plant;

@Emoji(emoji = "\uD83C\uDF3F")
public class Herb extends Plant {
    public Herb(int x, int y) {
        super(x, y);
        setWeight(1);
    }
}