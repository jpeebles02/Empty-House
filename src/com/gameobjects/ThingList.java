package com.gameobjects;

import java.util.ArrayList;

public class ThingList extends ArrayList<Thing> implements java.io.Serializable{

    private String name;

    public ThingList(String aName){
        super();
        name = aName;
    }

    public String getName() {
        return name;
    }

}
