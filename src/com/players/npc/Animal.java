package com.players.npc;

import com.players.Character;

public class Animal implements Character {
    private String type;
    private String name = null;

    public Animal(){

    }

    public Animal(String name) {
        setName(name);
    }

    @Override
    public void move(){
    System.out.println("The " + getName() + " is moving");
    };

    public void talk(){
     System.out.println("The " + getName() + " is talking");
    };

    public void think(){
     System.out.println("The " + getName() + " is thinking");
    };

    public void doAction(){
     System.out.println("The " + getName() + " is doing something....");
    };




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return super.getClass().getSimpleName() + ":" + getName();
    }
}
