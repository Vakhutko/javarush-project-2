package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83D\uDC10")
public class Goat extends Herbivore {
    public Goat(int x, int y) {
        super(x, y);
        setWeight(60);
        setSpeed(3);
        setSaturation(10);
        setMaxSaturation(10);
    }
}