package com.Client;

import com.Util.Dir;

import com.House.Room;
import com.gameobjects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.Client.*;


public class Game implements java.io.Serializable {

    private ArrayList<Room> map;
    private Actor player;

    public Game() {
        Parser.initVocab();
        initGame();
    }

    private void initGame() {
        this.map = new ArrayList<Room>();


        ThingList entranceList = new ThingList("entranceList");
        ThingList libraryList = new ThingList("libraryList");
        ThingList kitchenList = new ThingList("kitchenList");
        ThingList diningRoomList = new ThingList("diningRoomList");
        ThingList playerList = new ThingList("playerList");
        ThingList passageList = new ThingList("passageList");

        Room entrance = new Room();
        Room library = new Room();
        Room kitchen = new Room();
        Room diningRoom = new Room();
        Room passage = new Room();

        entranceList.add(new Treasure("key", "A key to something", 1, entrance));

        kitchenList.add(new ContainerThing("sack", "a smelly old sack", true, true, true, true, new ThingList("sackList"), kitchen));
        kitchenList.add(new ContainerThing("bowl", "a brass bowl", true, true, false, true, new ThingList("bowlList"), kitchen));
        kitchenList.add(new ContainerThing("box", "a cardboard box", true, true, true, true, new ThingList("boxList"), kitchen));

        diningRoomList.add(new Treasure("sausage", "It is a plump pork sausage", 10, diningRoom));

        libraryList.add(new Treasure("paper", "Someone has written a message on the scrap of paper using a blunt pencil. It says 'help'", 1, library));
        libraryList.add(new Treasure("pencil", "This pencil is so blunt that it can no longer be used to write.", 1, library));


        entrance.init("Entrance Room", "A dank room with some exits and some stairs", null, kitchen, null, library, null, null, entranceList);
        library.init("Library", "Books fill the shelves", passage, null, entrance, null, null, null, libraryList);
        kitchen.init("Kitchen", "A dismal place with bugs crawling on the walls", entrance, null, null, entrance, null, diningRoom, kitchenList);
        diningRoom.init("Dining Room", "A table and chairs are in the center of the room.", null, null, kitchen, null, null, null, diningRoomList);
        passage.init("Passage", "A scary passage", null, null, null, null, library, null, new ThingList("passageList"));

        map.add(entrance);
        map.add(library);
        map.add(kitchen);
        map.add(diningRoom);
        map.add(passage);

        // create player and set location
        player = new Actor("player", "a loveable game-player", playerList, entrance);
    }



    public String putObInContainer(String obname, String containername) {
        return player.putInto(obname, containername);
    }

    public String openOb(String obname) {
        return player.openOb(obname);
    }

    public String closeOb(String obname) {
        return player.closeOb(obname);
    }

    String takeOb(String obname) {
        String retStr;

        retStr = player.take(obname);
        return retStr;
    }

    String dropOb(String obname) {
        String retStr;

        retStr = player.drop(obname);
        return retStr;
    }

    void movePlayerTo(Dir dir) {
        if (player.moveTo(dir)) {
            look();
        } else {
            showStr("No Exit!");
        }
    }

    void goN() {
        movePlayerTo(Dir.NORTH);
    }

    void goS() {
        movePlayerTo(Dir.SOUTH);
    }

    void goW() {
        movePlayerTo(Dir.WEST);
    }

    void goE() {
        movePlayerTo(Dir.EAST);
    }

    void goUp() {
        movePlayerTo(Dir.UP);
    }

    void goDown() {
        movePlayerTo(Dir.DOWN);
    }

    void look() {
        showStr("You are in the " + player.describeLocation());
    }

    // utility method to display string if not empty
    // stripping any trailing newlines
    void showStr(String s) {
        if (s.endsWith("\n")) {
            s = s.substring(0, s.length() - 1);
        }
        if (!s.isEmpty()) {
            System.out.println(s);
        }
    }

    void showInventory() {
        showStr(player.inventory());
    }

    String lookAtOb(String obname) {
        return player.lookAt(obname);
    }

    String lookInOb(String obname) {
        return player.lookIn(obname);
    }

    public void showIntro() throws FileNotFoundException {

        String s;
        File file = new File("SplashScreen.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
        s =     "\n" +
                "It’s Halloween night, your friend invites you to an abandoned house to explore. \n"+
                "After some convincing you decide to go in, as you enter the door slams shut behind you. \n" +
                "You and your friend realize it is now locked and decide to split up to try and find another way out. \n" +
                "He decides to go upstairs to look around, where would you like to go on the ground floor? \n"
                + "\n" +
                "Enter: n, s, w, e, up, down to move areas, \n" + "or look at to inspect an item, \n" + "or take,drop to pick up or drop an item, \n"
                + "or quit to quit.\n"; // some instructions added to make this make more sense
        showStr(s);
        look();
    }

    public String runCommand(String inputstr) {
        List<String> wordlist;
        String s;
        String lowstr;

        s = "ok";
        lowstr = inputstr.trim().toLowerCase();

        if (!lowstr.equals("quit")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = Parser.wordList(lowstr);
                s = Parser.parseCommand(wordlist);
            }
        }
        return s;
    }


}
