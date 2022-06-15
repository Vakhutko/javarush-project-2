package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83D\uDC07")
public class Rabbit extends Herbivore {
    public Rabbit(int x, int y) {
        super(x, y);
        setWeight(2);
        setSpeed(2);
        setSaturation(0.45);
    }
}
