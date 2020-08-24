package com.sapient.mowit.constructor;

import com.sapient.mowit.model.Direction;

public class DirectionConstructor {

    private Direction dN, dO, dS, dE;

    public DirectionConstructor() {
        dN = new Direction('N');
        dO = new Direction('W');
        dS = new Direction('S');
        dE = new Direction('E');
        dN.setDroite(dE);
        dN.setGauche(dO);
        dO.setDroite(dN);
        dO.setGauche(dS);
        dS.setDroite(dO);
        dS.setGauche(dE);
        dE.setDroite(dS);
        dE.setGauche(dN);
    }

    public Direction contructDirection(char direction){
        switch (direction) {
            case 'N' : return dN;
            case 'S' : return dS;
            case 'W' : return dO;
            case 'E' : return dE;
        }
        return null;
    }
}
