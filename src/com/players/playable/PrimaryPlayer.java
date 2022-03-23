package com.players.playable;

import com.players.Player;

public class PrimaryPlayer implements Player {
    String name = "Bill";

    public PrimaryPlayer(String name) {
        setName(name);
    }

    @Override
    public void move() {
        System.out.println(getName() + " is moving");
    }

    @Override
    public void talk() {
        System.out.println(getName() + " is talking");
    }

    @Override
    public void think(){
        System.out.println(getName() + " is thinking about....");
    }

    @Override
    public void doAction(){
        System.out.println(getName() + " is doing something....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() + ": " + name;
    }
}
