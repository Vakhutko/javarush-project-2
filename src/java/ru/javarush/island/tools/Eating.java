package ru.javarush.island.tools;

import ru.javarush.island.items.abstracts.Animal;
import ru.javarush.island.items.animals.carnivore.*;
import ru.javarush.island.items.animals.herbivore.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Eating {
    private final static int WOLF_EATING_INDEX = 0;
    private final static int BOA_EATING_INDEX = 1;
    private final static int FOX_EATING_INDEX = 2;
    private final static int BEAR_EATING_INDEX = 3;
    private final static int EAGLE_EATING_INDEX = 4;
    private final static int HORSE_EATING_INDEX = 5;
    private final static int DEER_EATING_INDEX = 6;
    private final static int RABBIT_EATING_INDEX = 7;
    private final static int MOUSE_EATING_INDEX = 8;
    private final static int GOAT_EATING_INDEX = 9;
    private final static int SHEEP_EATING_INDEX = 10;
    private final static int BOAR_EATING_INDEX = 11;
    private final static int BUFFALO_EATING_INDEX = 12;
    private final static int DUCK_EATING_INDEX = 13;
    private final static int CATERPILLAR_EATING_INDEX = 14;
    private final static int HERB_EATING_INDEX = 15;
    private final static String KILL_STRING = """
            -\t0\t0\t0\t0\t10\t15\t60\t80\t60\t70\t15\t10\t40\t0\t0
            0\t-\t15\t0\t0\t0\t0\t20\t40\t0\t0\t0\t0\t10\t0\t0
            0\t0\t-\t0\t0\t0\t0\t70\t90\t0\t0\t0\t0\t60\t40\t0
            0\t80\t0\t-\t0\t40\t80\t80\t90\t70\t70\t50\t20\t10\t0\t0
            0\t0\t10\t0\t-\t0\t0\t90\t90\t0\t0\t0\t0\t80\t0\t0
            0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t90\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t0\t50\t0\t0\t-\t0\t0\t90\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t0\t0\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t90\t100
            0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t-\t100""";

    private final int[][] killArray = new int[15][16];
    private final Map<Class<? extends Animal>, int[]> killMap = new HashMap<>();

    public Eating() {
        fillKillArray();
    }

    public static void main(String[] args) {
        Eating eating = new Eating();
        eating.fillKillArray();
//        for (Map.Entry<Class<? extends Animal>, int[]> me : eating.killMap.entrySet()) {
//            System.out.println(me.getKey() + " " + Arrays.toString(me.getValue()));
//        }
//        System.out.println(Arrays.toString(eating.killMap.get(Wolf.class)));
    }

    public void fillKillArray() {
        String[] line = KILL_STRING.split("\n");
        for (int i = 0; i < killArray.length; i++) {
            String[] row = line[i].split("\t");
            for (int j = 0; j < killArray[i].length; j++) {
                if (row[j].equals("-")) {
                    killArray[i][j] = -1;
                } else {
                    killArray[i][j] = Integer.parseInt(row[j]);
                }
            }
        }
        fillKillMap();
    }

    public void fillKillMap() {
        killMap.put(Wolf.class, killArray[0]);
        killMap.put(Boa.class, killArray[1]);
        killMap.put(Fox.class, killArray[2]);
        killMap.put(Bear.class, killArray[3]);
        killMap.put(Eagle.class, killArray[4]);
        killMap.put(Horse.class, killArray[5]);
        killMap.put(Deer.class, killArray[6]);
        killMap.put(Rabbit.class, killArray[7]);
        killMap.put(Mouse.class, killArray[8]);
        killMap.put(Goat.class, killArray[9]);
        killMap.put(Sheep.class, killArray[10]);
        killMap.put(Boar.class, killArray[11]);
        killMap.put(Buffalo.class, killArray[12]);
        killMap.put(Duck.class, killArray[13]);
        killMap.put(Caterpillar.class, killArray[14]);
    }
}
