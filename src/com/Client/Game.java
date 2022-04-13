package com.Client;

import com.Util.Dir;

import com.House.Room;
import com.gameobjects.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.Client.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.sound.sampled.*;


public class Game implements java.io.Serializable {

    public ArrayList<Room> map;
    public Actor player;

    public Game() {
        Parser.initVocab();
        initGame();
    }

    public void initGame() {
        this.map = new ArrayList<Room>();


        ThingList entranceList = new ThingList("entranceList");
        ThingList libraryList = new ThingList("libraryList");
        ThingList kitchenList = new ThingList("kitchenList");
        ThingList diningRoomList = new ThingList("diningRoomList");
        ThingList playerList = new ThingList("playerList");
        ThingList passageList = new ThingList("passageList");
        ThingList secretRoom1List = new ThingList("secretRoom1List");
        ThingList secretRoom2List = new ThingList("secretRoom2List");
        ThingList basementList = new ThingList("basementList");
        ThingList bedroomList = new ThingList("bedroomList");
        ThingList secondBedroomList = new ThingList("secondBedroomList");
        ThingList bathroomList = new ThingList("bathroomList");
        ThingList stairsList = new ThingList("stairsList");





        Room entrance = new Room();
        Room library = new Room();
        Room kitchen = new Room();
        Room diningRoom = new Room();
        Room passage = new Room();
        Room stairs = new Room();
        Room secretRoom1 = new Room();
        Room secretRoom2 = new Room();
        Room basement = new Room();
        Room bedroom = new Room();
        Room secondBedroom = new Room();
        Room bathroom = new Room();

        ThingList boxList = new ThingList("boxList");

        ContainerThing box = new ContainerThing("box", "a hand-carved box", true, true, true, false, kitchenList, kitchen);

        boxList.add(new Treasure("severed finger", "very realistic human finger", 3, box));

        entranceList.add(new Treasure("key", "A key to something", 1, entrance));

        kitchenList.add(new ContainerThing("sack", "a smelly old sack", true, true, true, true, new ThingList("sackList"), kitchen));
        kitchenList.add(new ContainerThing("bowl", "a brass bowl", true, true, false, true, new ThingList("bowlList"), kitchen));
        kitchenList.add(box);




        diningRoomList.add(new Treasure("sausage", "It is a plump pork sausage", 10, diningRoom));

        libraryList.add(new Treasure("paper", "Someone has written a message on the scrap of paper using a blunt pencil. It says 'help'", 1, library));
        libraryList.add(new Treasure("pencil", "This pencil is so blunt that it can no longer be used to write.", 1, library));

        secretRoom1List.add(new Treasure("skeleton key", "an ominous-looking key with a skull on the handle", 2, secretRoom1));


        entrance.init("Entrance Room", "After your friend disappears looking for a way out you have to decide what area of the house you want to look first. \n A kitchen to your west \n and a Library to your east \n and a Dining room to your south.", null, diningRoom, kitchen, library, null, null, entranceList);
        library.init("Library", "You enter the library and notice a wall of bookshelves, they all appear to be dusty and covered in cobwebs besides one section that looks clean and has a book missing.", null, bedroom ,entrance, null, null, null, libraryList);
//        secretRoom1.init("Hidden Room", "Once you enter the room you notice a passage going down through the floor. \n you can go south and see where the passage leads \n or go north back into the library", library, passage, null, null, null, null, new ThingList("secretRoom1List"));
        kitchen.init("Kitchen", "You enter the dirty kitchen and are approached by a cat with what appears to be a key around its collar, \n you reach for it thinking it could be a key to a way out.  The cat runs out of arms distance.\n  You look around the kitchen for anything to lure the cat back out, you see a knife, fish, and pan.", null, entrance, null, bathroom, null, null, kitchenList);
        diningRoom.init("Dining Room", "You enter the dining room and right away you notice a butler standing in the corner with a tray.", entrance, null, bathroom, bedroom, null, null, diningRoomList);
//        passage.init("Passage", "You enter the dark passage that has a ladder going down into a dimly lit room", library, null, null, null, null, basement, new ThingList("passageList"));
//        basement.init("Basement", "As you emerge out of the passage you enter a dimly lit room, you look around as your eyes adjust to the light.  You notice dusty items scattered throughout the room besides a tall metal door on the other side.  As you approach the door you see it is locked with a rusty padlock.  Do you have the key in your bag?", null, null, null,secretRoom2,passage,null, new ThingList("basementList"));
//        secretRoom2.init("Secret Basement Room", "This room is locked, once unlocked you open the door to bright lights being turned on \n and you hear people yelling “SURPRISE”, as your vision comes back you see your friend \n that you came there with and about 20 other friends standing in the room.  \n Now you can enjoy your surprise party, YOU WIN!", null, null, basement, null, null,null, new ThingList("secretRoom2List"));
//        stairs.init("Upstairs", "as you stand at the top of the stairs you see three directions you could check. \n to the east is a second bedroom- \n to the west is a main bedroom \n or south and go back to the entrance", null, null, null, secondBedroom, null, entrance, new ThingList("stairsList"));
        bedroom.init("Main Bedroom", "You approach the main bedroom but it is locked and requires a key. \n Have you collected the key?", library, null, diningRoom, null, null, null, new ThingList("bedroomList"));
//        secondBedroom.init("Second Bedroom", "you enter the second bedroom and see a maid standing in the room looking out the window", null, stairs, bedroom, null, null, null, new ThingList("secondBedroomList"));
        bathroom.init("Bathroom", "In the bathroom you see a bunch of random items on the sink, a skeleton key catches your eye poking out slightly under a box", kitchen, null, null, diningRoom, null, null, new ThingList("bathroomList"));
        map.add(entrance);
        map.add(library);
        map.add(kitchen);
        map.add(diningRoom);
        map.add(passage);
        map.add(stairs);
        map.add(bedroom);
        map.add(secondBedroom);
        map.add(secretRoom1);
        map.add(secretRoom2);
        map.add(bathroom);
        map.add(basement);

        // create player and set location
        player = new Actor("player", "It's you", playerList, entrance);
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

    public void GUI() {
        new GUI();
    }
    //public void showIntro() throws FileNotFoundException {

    //    String s;
    //    File file = new File("SplashScreen.txt");
    //    Scanner scan = new Scanner(file);

    //    while(scan.hasNextLine()){
    //        System.out.println(scan.nextLine());
    //    }
    //    s =     "\n" +
    //            "It’s Halloween night, your friend invites you to an abandoned house to explore. \n"+
    //            "After some convincing you decide to go in, as you enter the door slams shut behind you. \n" +
    //            "You and your friend realize it is now locked and decide to split up to try and find another way out. \n" +
    //            "He decides to go upstairs to look around, where would you like to go on the ground floor? \n"
    //            + "\n" +
    //            "Enter: north, south, east, west, up, down to move areas, \n" + "or look at to inspect an item, \n" + "or take,drop to pick up or drop an item, \n"
    //            + "or quit to quit.\n"; // some instructions added to make this make more sense
    //    showStr(s);
    //    look();
    //}

    // Background music
    Clip clip;

    public void playAudio() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File song = new File("./resources/horror.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(song);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.flush();
    }

    public void stopAudio() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        clip.stop();
        clip.flush();
        clip.close();
    }

    public String runCommand(String inputstr) throws IOException, ParseException, UnsupportedAudioFileException, LineUnavailableException{
        List<String> wordlist;
        String s = "\n";
        String lowstr = inputstr.trim().toLowerCase();
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

    void AddItems () {
        //add function to game class
        String input = "";
        String itemNameOption = "";
        String itemLocationOption = "";

        JSONParser jsonParser = new JSONParser();


        JSONObject addItems = new JSONObject();
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to add an item to the game? Type Y or N ");

        input = in.nextLine();
        System.out.println("You have entered: " + input);

        if (input.equals("Y")) {
            try {
                Object obj = jsonParser.parse(new FileReader("items.json"));
                JSONArray jsonArray = (JSONArray) obj;

                System.out.println(jsonArray);

                System.out.println("You have the option of creating an item. Simply type in your command name using one word. ");
                itemNameOption = in.nextLine();
                System.out.println("You have entered: " + itemNameOption);
                addItems.put("itemName", itemNameOption);

                System.out.println("You have the option of adding in an item location. Simply type in your command example. ");
                itemLocationOption = in.nextLine();
                System.out.println("You have entered: " + itemLocationOption);
                addItems.put("itemLocation", itemLocationOption);

                jsonArray.add(addItems);
                System.out.println("Your options have been added to the list ");
                System.out.println(jsonArray);

                FileWriter file = new FileWriter("items.json");
                file.write(jsonArray.toJSONString());
                file.flush();
                file.close();

            } catch(ParseException | IOException e){
                e.printStackTrace();
            }

        }
        else if (input.equals("N")) {
            System.out.println("No additions were made. ");
        } else {
            System.out.println("Invalid command. ");
        }
    }

    void AddLocations(){
        //add function to game class
        String input = "";
        String locationNameOption = "";
        String locationDescriptionOption = "";
        String locationDirectionsOption = "";

        JSONParser jsonParser = new JSONParser();

        JSONObject addLocation = new JSONObject();
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to add a location to the game? Type Y or N ");

        input = sc.nextLine();
        System.out.println("You have entered: " + input);

        if (input.equals("Y")) {
            try {
                Object obj = jsonParser.parse(new FileReader("locations.json"));
                JSONArray jsonArray = (JSONArray)obj;

                System.out.println(jsonArray);


                System.out.println("You have the option of creating a location inside of the house. Simply type in your location name using one word. ");
                locationNameOption = sc.nextLine();
                System.out.println("You have entered: " + locationNameOption);
                addLocation.put("room_name", locationNameOption);

                System.out.println("You have the option of creating a location direction inside of the house. Simply type in your location direction. ");
                locationDirectionsOption = sc.nextLine();
                System.out.println("You have entered: " + locationDirectionsOption);
                addLocation.put("directions", locationDirectionsOption);

                System.out.println("You have the option of creating a location description. Simply type in your location description. ");
                locationDescriptionOption = sc.nextLine();
                System.out.println("You have entered: " + locationDescriptionOption);
                addLocation.put("description", locationDescriptionOption);


                jsonArray.add(addLocation);
                System.out.println("Your options have been added to the list ");
                System.out.println(jsonArray);

                FileWriter file = new FileWriter("locations.json");
                file.write(jsonArray.toJSONString());
                file.flush();
                file.close();

            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        } else if (input.equals("N")) {
            System.out.println("No additions were made. ");
        } else {
            System.out.println("Invalid command. ");
        }

    }



}
