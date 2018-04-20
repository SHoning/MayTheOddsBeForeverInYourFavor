package com.capgemini.view;

import com.capgemini.model.Contestant;
import com.capgemini.model.Item;

public class ItemView {
    public void showResult(Item item, Contestant contestant){
        System.out.println("Contestant" + contestant.getId() + " found " + item);
    }
}
