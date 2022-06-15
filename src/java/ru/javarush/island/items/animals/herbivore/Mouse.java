package ru.javarush.island.items.animals.herbivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Herbivore;

@Emoji(emoji = "\uD83D\uDC01")
public class Mouse extends Herbivore {
    public Mouse(int x, int y) {
        super(x, y);
        setWeight(0.05);
        setSpeed(1);
        setSaturation(0.01);
    }
}
