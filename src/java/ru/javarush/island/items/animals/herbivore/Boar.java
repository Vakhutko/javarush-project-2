package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83D\uDC17")
public class Boar extends Herbivore {
    public Boar(int x, int y) {
        super(x, y);
        setWeight(400);
        setSpeed(2);
        setSaturation(50);
    }
}
