package com.capgemini.model;

public class DistrictContestant extends Contestant{
    //DistrictContestants are cont
    public DistrictContestant() {
        super();
        super.setDefense(super.getDefense()+10); //TODO:Check If this is a relevant bonus, maybe randomize this aswell
    }
}
