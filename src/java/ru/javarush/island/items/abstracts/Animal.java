package ru.javarush.island.items.abstracts;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends BasicItem {
    private int speed;
    private double saturation;
    private double maxSaturation;
    private int hungryDieCounter = 0;
    private int height = 100;
    private int width = 20;

    public Animal(int x, int y) {
        super(x, y);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public void setMaxSaturation(double maxSaturation) {
        this.maxSaturation = maxSaturation;
    }

    public double getMaxSaturation() {
        return maxSaturation;
    }

    public void eat(BasicItem basicItem) {
        if (this.getSaturation() < this.maxSaturation) {
            basicItem.dead();
        }
    }

    public void move() {
        if (this.getSaturation() == 0) {
            hungryDieCounter++;
        }
        if (this.hungryDieCounter > 2) {
            this.dead();
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < this.getSpeed(); i++) {
            int move = threadLocalRandom.nextInt(4);
            if (move == 0) {
                if (getX() % width == 0) {
                    i--;
                } else {
                    setX(getX() - 1);
                }
            } else if (move == 1) {
                if (getX() % width == width - 1) {
                    i--;
                } else {
                    setX(getX() + 1);
                }
            } else if (move == 2) {
                if (getY() % height == 0) {
                    i--;
                } else {
                    setY(getY() - 1);
                }
            } else {
                if (getY() % height == height - 1) {
                    i--;
                } else {
                    setY(getY() + 1);
                }
            }
        }
    }

    public void reproduction() {}
}
