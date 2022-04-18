package com.textAdventure;

import com.utility.ObjectKnife;
import com.utility.SuperObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoryTest {
    Player player = new Player();
    Cat cat = new Cat();
    public SuperObject ObjectKnife;
    public SuperObject ObjectKey;

    @Test
    public void defaultSetup() {
        assertEquals(2, player.health = 2);
        //assertEquals("knife", player.setCurrentInventory(new SuperObject());
    }

    @Test
    public void openDoor() {
        //assertEquals("Key", player.currentInventory.name == "Key");
    }

    @Test
    public void drinkWater() {
        assertEquals(2, player.health + 2);
    }
}