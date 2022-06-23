package ru.javarush.island.items.animals.carnivore;

import ru.javarush.island.annotations.Emoji;
import ru.javarush.island.items.abstracts.Carnivore;

@Emoji(emoji = "\uD83D\uDC3A")
public class Wolf extends Carnivore {
    public Wolf(int x, int y) {
        super(x, y);
        setWeight(50);
        setSpeed(3);
        setSaturation(8);
        setMaxSaturation(8);
    }
}