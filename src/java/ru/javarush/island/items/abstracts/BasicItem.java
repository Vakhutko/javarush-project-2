package ru.javarush.island.items.abstracts;

public abstract class BasicItem {
    private int x;
    private int y;
    private double weight;
    private boolean life;

    public BasicItem(int x, int y) {
        this.x = x;
        this.y = y;
        this.life = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean getLife() {
        return life;
    }

    public void dead() {
        this.life = false;
    }
}
