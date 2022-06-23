package ru.javarush.island;

import ru.javarush.island.tools.Game;

public class Main {
    public static void main(String[] args) {
        new Thread(new Game()).start();
    }
}