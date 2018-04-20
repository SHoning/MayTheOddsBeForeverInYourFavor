package com.capgemini.model;

public class Item {
    private double weight;
    private EItemType type;
    private double bonus;

    public Item(double weight, EItemType type, double bonus) {
        this.weight = weight;
        this.type = type;
        this.bonus = bonus;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public EItemType getType() {
        return type;
    }

    public void setType(EItemType type) {
        this.type = type;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
