package com.capgemini.controller;

import com.capgemini.model.EItemType;
import com.capgemini.model.Item;

import java.util.ArrayList;

public class ItemControllerSingleton {
    private static ItemControllerSingleton instance = null;
    private ArrayList<Item> items = new ArrayList<>();

    private ItemControllerSingleton(){
    }

    public static ItemControllerSingleton getInstance(){
        if(instance == null) {
            instance = new ItemControllerSingleton();
        }
        return instance;
    }

    public void generateRandomItemsForTheGame(int numberOfItemsInGame) {
        //An Item will have a weight between 0 and 10, is with 50% chance of type attack and 50% of type defence and
        // will have a bonus between 1 and 5
        for (int i = 0; i < numberOfItemsInGame; i++) {
            Item item = new Item( Math.round(Math.random() * 10), Math.random() < 0.5 ? EItemType.ATTACK : EItemType.DEFENCE, Math.round( (1 + Math.random()*4)));
            this.items.add(item);
        }
    }

    public ArrayList<Item> generateItemsForCareers(int numberOfCareers){ //Get the items the careers get at the start
        ArrayList<Item> itemsForCareers = new ArrayList<>();
        for (int i=0; i<numberOfCareers; i++){
            itemsForCareers.add(items.get(i));
            this.items.remove(itemsForCareers.get(i)); //Remove these items from the available list
        }
        return itemsForCareers;
    }

    public Item getItem(){
        Item item = this.items.get(1);
        items.remove(item);
        return item;
    }
}
