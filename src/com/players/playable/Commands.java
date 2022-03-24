package com.players.playable;

public enum Commands {
    Crouch("Player has the ability to crouch"),
    Walk("Player has the ability to walk"),
    ReachInBag("Player can reach in their bag");

    final String currentCommand;

    Commands(String s) {
        currentCommand = s;
    }

    String showCommands(){
        return currentCommand;
    }
}
