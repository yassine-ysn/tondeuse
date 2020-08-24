package com.sapient.mowit.model;

public class Mower {

    private int x;
    private int y;
    private Direction direction;

    public Mower(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Mower{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }

    public void mow(char[] commandes, int xmax, int ymax) throws Exception{
        for (char commande: commandes) {
            switch (commande){
                case 'D' : tournerDroite(); break;
                case 'G' : tournerGauche(); break;
                case 'A' : avancer(direction, xmax, ymax); break;
                default: throw new Exception("Unknown command "+ commande);
            }
        }
    }

    private void tournerDroite() {
        this.direction = this.direction.getDroite();
    }

    private void tournerGauche() {
        this.direction = this.direction.getGauche();
    }

    private void avancer(Direction direction, int xmax, int ymax) {
        switch (direction.getSymbol()){
            case 'N' : if(y<ymax) y++; break;
            case 'S' : if(y>0) y--; break;
            case 'E' : if(x<xmax) x++; break;
            case 'W' : if(x>0) x--; break;
        }
    }
}
