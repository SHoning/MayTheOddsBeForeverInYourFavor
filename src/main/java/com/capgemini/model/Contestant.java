package com.capgemini.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Contestant {

    private long id; //So we can distinguish the contestants from each other
    private double health;
    private double attack;
    private double defense;
    private double carryingCapacity = 20;
    private ArrayList<Item> carriedItems = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong();

    public Contestant() {
        Random randomNumberGenerator = new Random();
        // we use a normal distribution with mean the number that is plus and deviation the number that is times.
        // Using math round to generate full numbers
        this.health = Math.round(randomNumberGenerator.nextGaussian()*30 + 100);
        this.attack = Math.round(randomNumberGenerator.nextGaussian()*3 + 10);
        this.defense = Math.round(randomNumberGenerator.nextGaussian()*3 + 10);
        this.id = generateUniqueID()+1; //So we have contestant 1 to 24, but could possibly add more when wanted
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static AtomicLong getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(AtomicLong idCounter) {
        Contestant.idCounter = idCounter;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public ArrayList<Item> getCarriedItems() {
        return carriedItems;
    }

    public void setCarriedItems(ArrayList<Item> carriedItems) {
        this.carriedItems = carriedItems;
    }

    private static long generateUniqueID()
    {
        return idCounter.getAndIncrement();
    }

    public void addToCarriedItems(Item item) throws NotEnoughCapacityException {
        if (this.carryingCapacity < item.getWeight()){
            throw new NotEnoughCapacityException();
        }
        this.carriedItems.add(item);
        this.carryingCapacity = this.carryingCapacity - item.getWeight();
        switch(item.getType()){
            case ATTACK:
                this.attack = this.attack + item.getBonus();
                break;
            case DEFENCE:
                this.defense = this.defense + item.getBonus();
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("%-3d%-20s%-20s%-20s", this.id ,"Health: " + this.health, "Attack: " + this.attack, "Defense: "+ this.defense);
    }
}
