package com.example.geoquiz;

public class Calification {
    //Attribute
    private int nAciertos;
    private int nFallos;

    //constructor
    public Calification(){
        this.nAciertos = 0;
        this.nFallos = 0;
    }

    //getters && setters
    public int getnFallos() {
        return nFallos;
    }

    public void setnFallos(int nFallos) {
        this.nFallos = nFallos;
    }

    public int getnAciertos() {
        return nAciertos;
    }

    public void setnAciertos(int nAciertos) {
        this.nAciertos = nAciertos;
    }
}
