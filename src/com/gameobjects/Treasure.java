package com.gameobjects;

public class Treasure extends Thing implements java.io.Serializable{


    private int value;

    public Treasure(String aName, String aDescription, ThingHolder aContainer) {
        super(aName, aDescription, aContainer); // init superclass
        this.value = 0;
    }

    public Treasure(String aName, String aDescription, int aValue,
                    ThingHolder aContainer ) {
        super(aName, aDescription, aContainer); // init superclass
        this.value = aValue;
    }

    public int getValue() {
        return value;
    }

}
