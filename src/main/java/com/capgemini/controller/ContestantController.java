package com.capgemini.controller;

import com.capgemini.model.CareerContestant;
import com.capgemini.model.Contestant;
import com.capgemini.model.DistrictContestant;

import java.util.ArrayList;

public class ContestantController {
    private ArrayList<Contestant> aliveContestants = new ArrayList<Contestant>();
    private ArrayList<Contestant> contestantsDiedToday = new ArrayList<Contestant>();
    private ArrayList<Contestant> deadContestants = new ArrayList<Contestant>();

    public void haveReaping(){
        for (int i =0; i<24; i++){ //there are 24 aliveContestants
            while (i<6) {                   // a quarter of the aliveContestants are CareerContestants
                Contestant contestant = new CareerContestant();
                this.aliveContestants.add(contestant);
                i++;
            }
            Contestant contestant = new DistrictContestant();
            this.aliveContestants.add(contestant);
            //TODO: implement volunteering here?
        }
    }

    public ArrayList<Contestant> decideContact(){
        ArrayList<Contestant> contestantsMeet = new ArrayList<Contestant>(); //TODO: Visibility
        for(Contestant contestant:this.aliveContestants){
            if (Math.random()>0.5){
                contestantsMeet.add(contestant);
            }
        }
        return contestantsMeet;
    }

    public void haveFight(Contestant contestant1, Contestant contestant2){
        //TODO: Something based on attack/Defense/Health to decide who wins
        if (Math.random()>0.5){
            this.contestantsDiedToday.add(contestant1);
            this.aliveContestants.remove(contestant1);
        }else{
            this.contestantsDiedToday.add(contestant2);
            this.aliveContestants.remove(contestant2);
        }
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

    public void emptyContestantsDiedToday(){
        this.contestantsDiedToday.clear();
    }

    private void setContestantsDiedToday(ArrayList<Contestant> contestantsDiedToday) {
        this.contestantsDiedToday = contestantsDiedToday;
    }

    public ArrayList<Contestant> getDeadContestants() {
        return deadContestants;
    }

    public void setDeadContestants(ArrayList<Contestant> deadContestants) {
        for (Contestant contestant:deadContestants) {
            this.deadContestants.add(contestant);
        }
    }
}
