package com.players.npc;

import com.players.Player;

public interface Friend extends Player {
    String name = "Friend interface";

    @Override
     void move();
     void talk();
     void think();
     void doAction();
}
