package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83D\uDC11")
public class Sheep extends Herbivore {
    public Sheep(int x, int y) {
        super(x, y);
        setWeight(70);
        setSpeed(3);
        setSaturation(15);
        setMaxSaturation(15);
    }
}