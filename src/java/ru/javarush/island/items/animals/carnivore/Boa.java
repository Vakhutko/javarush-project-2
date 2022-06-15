package ru.javarush.island.items.animals.carnivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Carnivore;

@Emoji(emoji = "\uD83D\uDC0D")
public class Boa extends Carnivore {
    public Boa(int x, int y) {
        super(x, y);
        setWeight(15);
        setSpeed(1);
        setSaturation(3);
    }
}
