package com.textAdventure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player();
    }

    @Test
    public void getHealth() {
        assertEquals(0, player.getHealth());
    }

    @Test
    public void getCurrentInventory() {
        assertEquals(null, player.getCurrentInventory());
    }
}