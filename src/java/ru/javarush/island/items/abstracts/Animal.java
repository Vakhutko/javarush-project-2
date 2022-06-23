package ru.javarush.island.items.abstracts;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends BasicItem {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int LOOSE_PART_OF_SATURATION_BY_MOVE = 4;
    private int speed;
    private double saturation;
    private double maxSaturation;
    private int hungryDieCounter = 0;

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
        basicItem.dead();
    }

    public boolean move(int height, int width) {
        if (!checkDeath()) {
            chooseRouteOfMove(height, width);
            decreaseSaturation();
            return true;
        } else {
            return false;
        }
    }

    private boolean checkDeath() {
        if (this.getSaturation() == 0 && this.getSpeed() > 0) {
            hungryDieCounter++;
        }
        if (this.hungryDieCounter > 2) {
            this.dead();
            return true;
        }
        return false;
    }

    private void chooseRouteOfMove(int height, int width) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < this.getSpeed(); i++) {
            int move = threadLocalRandom.nextInt(4);
            if (move == LEFT) {
                if (getX() % width == 0) {
                    i--;
                } else {
                    setX(getX() - 1);
                }
            } else if (move == RIGHT) {
                if (getX() % width == width - 1) {
                    i--;
                } else {
                    setX(getX() + 1);
                }
            } else if (move == UP) {
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

    private void decreaseSaturation() {
        saturation -= maxSaturation / LOOSE_PART_OF_SATURATION_BY_MOVE;
        saturation = saturation < 0 ? 0 : saturation;
    }

    public Animal reproduction() {
        return null;
    }
}
