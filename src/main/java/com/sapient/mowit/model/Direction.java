package com.sapient.mowit.model;

public class Direction {

    private char symbol;
    private Direction droite;
    private Direction gauche;

    public Direction(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Direction getDroite() {
        return droite;
    }

    public void setDroite(Direction droite) {
        this.droite = droite;
    }

    public Direction getGauche() {
        return gauche;
    }

    public void setGauche(Direction gauche) {
        this.gauche = gauche;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "symbol=" + symbol +
                '}';
    }
}
