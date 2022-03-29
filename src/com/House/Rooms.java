package com.House;


public class Rooms {
    //FIELDS

    private String name;
    private String description;
    private int n, s, w, e;


    //CONSTRUCTOR
    public Rooms(String aName, String aDescription, int aN, int aS, int aW, int aE) {
        name = aName;
        description = aDescription;
        n = aN;
        s = aS;
        w = aW;
        e = aE;

    }

    //GETTERS & SETTERS

    public int getN(){
        return n;
    }

    public void setN(int aN) {
        n = aN;
    }

    public int getS(){
        return s;
    }

    public void setS(int aS) {
        s = aS;
    }

    public int getW(){
        return w;
    }

    public void setW(int aW) {
        w = aW;
    }

    public int getE(){
        return e;
    }

    public void setE(int aE) {
        e = aE;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return "This is " + description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }


}
