package ru.javarush.island.tools;

import ru.javarush.island.dialog.Dialog;
import ru.javarush.island.dialog.Printer;
import ru.javarush.island.map.IslandMap;
import ru.javarush.island.threads.GameMove;
import ru.javarush.island.threads.GenerateHerb;
import ru.javarush.island.threads.PrintStatistic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    private final Dialog dialog;
    private final Settings settings;
    private final Statistic statistic;

    public Game() {
        this.settings = new Settings();
        this.dialog = new Dialog();
        this.statistic = new Statistic();
    }

    @Override
    public void run() {
        dialog.startDialog(settings);
        settings.applySettings();
        IslandMap islandMap = new IslandMap(settings);
        ItemFactory itemFactory = new ItemFactory(settings);
        statistic.setFirstMoveAnimals(itemFactory.initializeItems(islandMap.getMap()));
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(new GenerateHerb(itemFactory, islandMap, statistic), 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new GameMove(settings, islandMap, statistic), 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new PrintStatistic(statistic, islandMap), 0, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(settings.getMaxGameMoves() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
    }
}