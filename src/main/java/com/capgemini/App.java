package com.capgemini;

import com.capgemini.controller.GameController;

/**
 * Nice Ideas: BattleItem abstract with DefenseItem, AttackItem, HealthItem?! as subclasses
 * Generate names
 * Alliances is nice as well
 * Something with food/water
 * If a contestant died have a loud boom
 * Something with a end of day thing with a show of what happened during the day
 * Something with sponsors
 * Maybe do something with volunteering when either the health is below 20 or the attack or defense is very low and maybe attribute with loved
 * Do something with visibility and meeting
 */
public class App 
{
    public static void main( String[] args )
    {
        GameController hungerGames2018 = new GameController();
        hungerGames2018.playGames();

    }
}
