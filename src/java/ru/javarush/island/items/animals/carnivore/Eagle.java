package ru.javarush.island.items.animals.carnivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Carnivore;

@Emoji(emoji = "\uD83E\uDD85")
public class Eagle extends Carnivore {
    public Eagle(int x, int y) {
        super(x, y);
        setWeight(6);
        setSpeed(3);
        setSaturation(1);
    }
}
