package com.capgemini.view;

import com.capgemini.model.Contestant;

import java.util.ArrayList;

public class ContestantView {
    public void showContestantsLeft(ArrayList<Contestant> contestants){
        for (Contestant contestant:contestants){
            System.out.println(contestant.toString());
        }
    }
}
