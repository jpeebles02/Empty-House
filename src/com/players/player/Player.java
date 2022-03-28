package com.players.player;

import java.util.ArrayList;

//Will make the player a Singleton during the next push
public class Player  {
    private String name;
//    private Commands[] commandsAvailable = Commands.values();
    private ArrayList<String> commands;

    public Player (){};

    public Player(String name, ArrayList<String> commands) {
        setName(name);
        setCommands(commands);
    }


    //    public void listCommands(){
//        if(commandsAvailable == null){
//            System.out.println(getName() + " has no commands available");
//        }else{
//            ArrayList<Commands> cList = new ArrayList<>();
//            for(Commands c : Commands.values()){
//                cList.add(c);
//            }
//            System.out.println("Your list of commands are: " + cList);
//        }
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {

        this.commands = commands;
    }
}
