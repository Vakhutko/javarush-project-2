package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83D\uDC03")
public class Buffalo extends Herbivore {
    public Buffalo(int x, int y) {
        super(x, y);
        setWeight(700);
        setSpeed(3);
        setSaturation(100);
    }
}
