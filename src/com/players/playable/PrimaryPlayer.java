package com.players.playable;

import com.players.Player;

import java.util.ArrayList;


public class PrimaryPlayer implements Player {
    private String name = "Bill";
    private Commands[] commandsAvailable = Commands.values();


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

    public void listCommands(){
        if(commandsAvailable == null){
            System.out.println(getName() + " has no commands available");
        }else{
            ArrayList<Commands> cList = new ArrayList<>();
            for(Commands c : Commands.values()){
                cList.add(c);
            }
            System.out.println("Your list of commands are: " + cList);
        }
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
