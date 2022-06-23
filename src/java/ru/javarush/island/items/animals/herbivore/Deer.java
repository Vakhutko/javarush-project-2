package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83E\uDD8C")
public class Deer extends Herbivore {
    public Deer(int x, int y) {
        super(x, y);
        setWeight(300);
        setSpeed(4);
        setSaturation(50);
        setMaxSaturation(50);
    }
}