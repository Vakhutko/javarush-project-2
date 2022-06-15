package ru.javarush.island.items.animals.carnivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Carnivore;

@Emoji(emoji = "\uD83D\uDC3B")
public class Bear extends Carnivore {
    public Bear(int x, int y) {
        super(x, y);
        setWeight(500);
        setSpeed(2);
        setSaturation(80);
        setMaxSaturation(80);
    }
}