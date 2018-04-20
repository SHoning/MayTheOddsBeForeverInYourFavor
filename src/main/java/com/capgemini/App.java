package com.capgemini;

import com.capgemini.controller.GameController;

/**
 * Nice Ideas: BattleItem abstract with DefenseItem, AttackItem, HealthItem?! as subclasses
 * Alliances is nice as well
 * Something with food/water
 * If a contestant died have a loud boom
 * Something with a end of day thing with a show of what happened during the day
 * Something with sponsors
 * Maybe do something with volunteering when either the health is below 20 or the attack or defense is very low and maybe attribute with loved
 */
public class App 
{
    public static void main( String[] args )
    {
        GameController hungerGames2018 = new GameController();

        hungerGames2018.haveReaping();
        hungerGames2018.showStatus();

    }
}
