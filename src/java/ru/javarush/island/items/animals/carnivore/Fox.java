package ru.javarush.island.items.animals.carnivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Carnivore;

@Emoji(emoji = "\uD83E\uDD8A")
public class Fox extends Carnivore {
    public Fox(int x, int y) {
        super(x, y);
        setWeight(8);
        setSpeed(2);
        setSaturation(2);
    }
}
