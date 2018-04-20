package com.capgemini.controller;

import com.capgemini.model.*;
import com.capgemini.view.ItemView;

import java.util.ArrayList;

public class ContestantController {
    private ArrayList<Contestant> aliveContestants = new ArrayList<Contestant>();
    private ArrayList<Contestant> contestantsDiedToday = new ArrayList<Contestant>();
    private ArrayList<Contestant> deadContestants = new ArrayList<Contestant>();
    private ItemControllerSingleton itemController = ItemControllerSingleton.getInstance();
    private ItemView itemView = new ItemView();

    public void haveReaping(ArrayList<Item> items) {
        for (int i = 0; i < 24; i++) { //there are 24 aliveContestants
            while (i < 6) {                   // a quarter of the aliveContestants are CareerContestants
                Contestant contestant = new CareerContestant();
                try {
                    contestant.addToCarriedItems(items.get(i));
                } catch (NotEnoughCapacityException e) {
                    System.out.println("This contestant brought something it cannot carry!");
                }
                this.aliveContestants.add(contestant);
                i++;
            }
            Contestant contestant = new DistrictContestant();
            this.aliveContestants.add(contestant);
            //TODO: implement volunteering here?
        }
    }

    public void findItems() {
        for (Contestant contestant : aliveContestants) {
            if (Math.random() < 0.3) {
                try {
                    Item item = itemController.getItem();
                    itemView.showResult(item, contestant);
                    contestant.addToCarriedItems(item);
                } catch (NotEnoughCapacityException e) {
                    System.out.println(" but could not carry it!");
                }
            }
        }
    }

    public ArrayList<Contestant> decideContact() {
        ArrayList<Contestant> contestantsMeet = new ArrayList<Contestant>(); //TODO: Visibility
        for (Contestant contestant : this.aliveContestants) {
            if (Math.random() > 0.5) {
                contestantsMeet.add(contestant);
            }
        }
        return contestantsMeet;
    }

    public void haveFight(Contestant contestant1, Contestant contestant2) {
        //We calculate a efficiency based on health and defense of opponent and personal strength.
        //There is still a change that the underdog wins
        double contestant1Efficiency = contestant2.getHealth() / (contestant1.getAttack() - contestant2.getDefense());
        double contestant2Efficiency = contestant1.getHealth() / (contestant2.getAttack() - contestant1.getDefense());
        if(contestant2Efficiency>contestant1Efficiency) {
            if (Math.random() > 0.9 ){
                this.contestantsDiedToday.add(contestant2);
                this.aliveContestants.remove(contestant2);
            }
            this.contestantsDiedToday.add(contestant1);
            this.aliveContestants.remove(contestant1);
        } else {
            if (Math.random() > 0.9 ){
                this.contestantsDiedToday.add(contestant1);
                this.aliveContestants.remove(contestant1);
            }
            this.contestantsDiedToday.add(contestant2);
            this.aliveContestants.remove(contestant2);
        }
    //TODO: Have a real simulation
    }

    public ArrayList<Contestant> getAliveContestants() {
        return aliveContestants;
    }

    public void setAliveContestants(ArrayList<Contestant> aliveContestants) {
        this.aliveContestants = aliveContestants;
    }

    public ArrayList<Contestant> getContestantsDiedToday() {
        return contestantsDiedToday;
    }

    public void emptyContestantsDiedToday() {
        this.contestantsDiedToday.clear();
    }

    private void setContestantsDiedToday(ArrayList<Contestant> contestantsDiedToday) {
        this.contestantsDiedToday = contestantsDiedToday;
    }

    public ArrayList<Contestant> getDeadContestants() {
        return deadContestants;
    }

    public void setDeadContestants(ArrayList<Contestant> deadContestants) {
        for (Contestant contestant : deadContestants) {
            this.deadContestants.add(contestant);
        }
    }

}
