package com.capgemini.model;

public class CareerContestant extends Contestant{
    //Career Contestants are normal contestants with some bonus to their attack due to their training
    public CareerContestant() {
        super();
        super.setAttack(super.getAttack() + 5);  //TODO:Check If this is a relevant bonus, maybe randomize this aswell
    }

    @Override
    public String toString() {
        return "CareerContestant: " + super.toString();
    }
}
