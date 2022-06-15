package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83D\uDC1B")
public class Caterpillar extends Herbivore {
    public Caterpillar(int x, int y) {
        super(x, y);
        setWeight(0.01);
        setSpeed(0);
        setSaturation(0);
    }
}
