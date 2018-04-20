package com.capgemini.view;

import com.capgemini.model.Contestant;

import java.util.ArrayList;

public class GameInfo {
    int day;

    public void deathBoom(){
        System.out.println("BOOM!!");
    }

    public void startDay(){
        this.day = this.day + 1;
        System.out.println("________________________________");
        System.out.println("Starting Day " + this.day);
        System.out.println("________________________________");
    }

    public void endDay(){
        System.out.println("________________________________");
        System.out.println("End of Day " + this.day);
        System.out.println("________________________________");
    }

    public void endOfDayUpdate(ArrayList<Contestant> playersDiedToday){
        if(playersDiedToday.size()!=0) {
            System.out.println("The following contestant(s) have fallen: ");
            for (Contestant contestant : playersDiedToday) {
                System.out.println(contestant);
            }
        }
        else{ //TODO: increase chance of meeting ?!, because Snow Interferes
            System.out.println("No News Today");
        }
    }

    public void endOfGames(ArrayList<Contestant> contestant){
        System.out.println(contestant.get(0) + " has won the games, but is killed by Snow :O");
    }
}
