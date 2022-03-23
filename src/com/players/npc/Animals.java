package com.players.npc;

import com.players.Player;

public interface Animals extends Player {
    String name = null;

    @Override
     void move();
     void talk();
     void think();
     void doAction();
}
