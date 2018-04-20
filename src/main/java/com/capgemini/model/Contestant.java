package com.capgemini.model;

public abstract class Contestant {

    private int health;
    private int attack;
    private int defense;

    public Contestant() {
        //I need some randomized initialisation of the attributes
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
