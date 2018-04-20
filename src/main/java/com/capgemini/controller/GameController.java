package com.capgemini.controller;

import com.capgemini.model.CareerContestant;
import com.capgemini.model.Contestant;
import com.capgemini.model.DistrictContestant;
import com.capgemini.view.ContestantView;

import java.util.ArrayList;

public class GameController {
    private ArrayList<Contestant> contestants = new ArrayList<Contestant>();
    private ContestantView contestantView = new ContestantView();

    public void haveReaping(){
        for (int i =0; i<24; i++){ //there are 24 contestants
            while (i<6) {                   // a quarter of the contestants are CareerContestants
                Contestant contestant = new CareerContestant();
                this.contestants.add(contestant);
                i++;
            }
            Contestant contestant = new DistrictContestant();
            this.contestants.add(contestant);
            //TODO: implement volunteering here?
        }
    }

    private void updateStatus(){
        contestantView.showContestantsLeft(this.contestants);
    }

    public void showStatus(){updateStatus();}


}
