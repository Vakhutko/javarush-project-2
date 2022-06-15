package ru.javarush.island;

import ru.javarush.island.dialog.Printer;
import ru.javarush.island.map.IslandMap;
import ru.javarush.island.tools.GameMove;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Current settings is:");
        try (InputStream inputStream = new FileInputStream("src/config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            for (String s : properties.stringPropertyNames()) {
                System.out.println(s + " = " + properties.getProperty(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Do you want to change setting? (Y/N)");
        IslandMap islandMap = new IslandMap();
//        Printer printer = new Printer();
//        printer.printMap(islandMap.getMap());
        GameMove gameMove = new GameMove(islandMap);
    }
}