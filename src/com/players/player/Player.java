package com.players.player;

import com.players.Character;

import java.util.ArrayList;


public class Player implements Character {
    private String name;
    private Commands[] commandsAvailable = Commands.values();

    public Player (){};
    public Player(String name) {
        setName(name);
    }

    @Override
    public void move() {
        System.out.println(getName() + " moving");
    }

    @Override
    public void talk() {
        System.out.println(getName() + " talking");
    }

    @Override
    public void think(){
        System.out.println(getName() + " thinking");
    }

    @Override
    public void doAction(){
        System.out.println(getName() + " action");
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

    public Commands[] getCommandsAvailable() {
        return commandsAvailable;
    }

    public void setCommandsAvailable(Commands[] commandsAvailable) {
        this.commandsAvailable = commandsAvailable;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() + ": " + name;
    }
}
