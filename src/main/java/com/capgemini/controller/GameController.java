package com.capgemini.controller;

import com.capgemini.model.Contestant;
import com.capgemini.view.ContestantView;
import com.capgemini.view.GameInfo;

import java.util.ArrayList;

public class GameController {

    private ContestantView contestantView = new ContestantView();
    private ContestantController contestantController = new ContestantController();
    private GameInfo gameInfo = new GameInfo();

    public void haveReaping() {
        contestantController.haveReaping();
        showAlivePlayerStatus();
    }

    public void playDay() {
        gameInfo.startDay();
        ArrayList<Contestant> contestantsMeet = contestantController.decideContact();
        int meeting;
        if (contestantsMeet.size() % 2 == 0) { //Then the number of contestants meeting is even, so everyone will fight
            meeting = contestantsMeet.size() / 2;
        } else {    // the number of contestants meeting is uneven, so the last one gets off lucky.
            meeting = contestantsMeet.size() / 2 - 1;
        }
        for (int i = 0; i < meeting; i++) {
            contestantController.haveFight(contestantsMeet.get(2 * i), contestantsMeet.get(2 * i + 1));
            gameInfo.deathBoom();
        }
        gameInfo.endOfDayUpdate(contestantController.getContestantsDiedToday());
        contestantController.setDeadContestants(contestantController.getContestantsDiedToday());
        contestantController.emptyContestantsDiedToday();
        gameInfo.endDay();
    }

    public void playGames(){
        while(contestantController.getAliveContestants().size()> 1){
            playDay();
        }
        gameInfo.endOfGames(contestantController.getAliveContestants());
    }


    private void updateAlivePlayerStatus() {
        contestantView.showContestantsLeft(contestantController.getAliveContestants());
    }

    private void showAlivePlayerStatus() {
        updateAlivePlayerStatus();
    }


}
