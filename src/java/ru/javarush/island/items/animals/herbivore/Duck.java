package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83E\uDD86")
public class Duck extends Herbivore {
    public Duck(int x, int y) {
        super(x, y);
        setWeight(1);
        setSpeed(4);
        setSaturation(0.15);
        setMaxSaturation(0.15);
    }
}