package com.capgemini.model;

public class DistrictContestant extends Contestant{
    //DistrictContestants are cont
    public DistrictContestant() {
        super();
        super.setDefense(super.getDefense()+5); //TODO:Check If this is a relevant bonus, maybe randomize this aswell
    }

    @Override
    public String toString() {
        return "District Contestant: " + super.toString();
    }
}
