package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83D\uDC0E")
public class Horse extends Herbivore {
    public Horse(int x, int y) {
        super(x, y);
        setWeight(400);
        setSpeed(4);
        setSaturation(60);
        setMaxSaturation(60);
    }
}