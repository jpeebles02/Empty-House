package com.textAdventure;

import com.utility.*;
import com.utility.SuperObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import javax.swing.*;
import java.awt.*;

public class Story {

import java.io.*;

public class Story extends SuperObject{


    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    Cat cat = new Cat();
    SuperEnemy enemy;

    boolean beatEnemy;



    public Story(Game g, UI userInterface, VisibilityManager vManager){
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup(){

        player.health = 2;
        ui.healthNumberLabel.setText("" + player.health);

        player.currentInventory = new ObjectKnife();
        ui.inventoryNameLabel.setText(player.currentInventory.name);

        beatEnemy = false;

    }

    public void selectPosition(String nextPosition){
        switch(nextPosition) {
            case "intro":
                intro();
                break;
            case "openDoor":
                openDoor();
                break;
            case "exploreHouse":
                exploreHouse();
                break;
            case "chargeAtDoor":
                chargeAtDoor();
                break;
            case "lockedDoor":
                lockedDoor();
                break;
            case "kitchen":
                kitchen();
                break;
            case "bathroom":
                bathroom();
                break;
            case "diningRoom":
                diningRoom();
                break;
            case "bedroom":
                bedroom();
                break;
            case "library":
                library();
                break;
            case "talkButler":
                talkButler();
                break;
            case "leave":
                leave();
                break;
            case "lureCat":
                lureCat();
                break;
            case "pickUpKey":
                pickUpKey();
                break;
            case "drinkWater":
                drinkWater();
                break;
            case "fight":
                fight();
                break;
            case "playerAttack":
                playerAttack();
                break;
            case "enemyAttack":
                enemyAttack();
                break;
            case "toTitle":
                toTitle();
                break;
            case "lose":
                lose();
                break;
            case "win":
                win();
                break;
            case "learnStory":
                learnStory();
            break;
            case "gameInfo":
                gameInfo();
                break;
            case "library":
                library();
                break;
            case "kitchen":
                kitchen();
                break;
            case "bathroom":
                bathroom();
                break;
            case "diningRoom":
                diningRoom();
                break;
            case "bedroom":
                bedroom();
                break;
            case "Load":
                loadGame();
                break;
            case "Save":
                saveGame();
                break;

        }

    }



    public void selectDirection(String nextDirection){
        switch(nextDirection) {
            case "lockedDoor":
                lockedDoor();
                break;
            case "library":
                library();
                break;
            case "kitchen":
                kitchen();
                break;
            case "bathroom":
                bathroom();
                break;
            case "diningRoom":
                diningRoom();
                break;
            case "bedroom":
                bedroom();
                break;
            case "exploreHouse":
                exploreHouse();
                break;
            case "lureCat":
                lureCat();
                break;
        }

    }


        public void intro(){
        ui.mainTextArea.setText("\n" + "It’s Halloween night, your friend invites you to an abandoned house to explore. \n"+
                " After some convincing, your friend gives you a knife and you decide to go in and explore.\n" +
                " Your friend immediately darts through the entrance. \n" +
                " As you approach the entrance, the door slams shut in front of you\n" +
                " As you enter through the door, you realize your friend has now disappeared\n" +
                "what would you like to go? \n \n");

        ui.choice1.setText("Go after friend");
        ui.choice2.setText("Return to start screen");
        ui.choice3.setText("Quit");
        ui.choice4.setText("");
        game.nextPosition1 = "lockedDoor";
        game.nextPosition2 = "toTitle";
        game.nextPosition3 = "leave";
        game.nextPosition4 = "";


        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";

    }

    public void saveGame() {

        ui.mainTextArea.setText("Your progress has been saved. ");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("saveGame.txt"));

            bw.write(player.health);
            bw.newLine();
            //bw.write(player.currentInventory));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame () {
        ui.mainTextArea.setText("Load successful");
        try{
            BufferedReader br = new BufferedReader((new FileReader("saveGame.txt")));

            player.health = Integer.parseInt(br.readLine());
            //player.currentInventory = br.readLine();

            br.close();
        }
        catch(Exception e) {

        }

        //ui.inventoryNameLabel.setText("Inventory");
        ui.healthNumberLabel.setText("Health:");

        intro();


    }

    public void lockedDoor(){

            ui.mainTextArea.setText("You have approached a locked door \n" + "You hear music behind the door, but you can't get in \nWhat do you do" + "");
            ui.choice1.setText("Try to open the door");
            ui.choice2.setText("Charge at door!");
            ui.choice3.setText("Explore the house for clues");
            ui.choice4.setText(">");
            game.nextPosition1 = "openDoor";
            game.nextPosition2 = "chargeAtDoor";
            game.nextPosition3 = "exploreHouse";
            game.nextPosition4 = "intro";

            ui.north.setText("");
            ui.south.setText("");
            ui.east.setText("");
            ui.west.setText("");
            game.nextDirection1 = "";
            game.nextDirection2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "";


    }

    public void leave(){
        System.exit(0);
    }

    public void openDoor(){
        if (player.currentInventory.name == "Key"){
            ui.mainTextArea.setText("You attempt to open the door \n" + "It seems like this key does not work \n");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "lockedDoor";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

            ui.north.setText("");
            ui.south.setText("");
            ui.east.setText("");
            ui.west.setText("");
            game.nextDirection1 = "";
            game.nextDirection2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "";
        } else if (player.currentInventory.name == "Skeleton Key"){
            ending();
        }
        else {
            ui.mainTextArea.setText("You attempt to open the door \n" + "It seems like you will need a key to get in \n");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "lockedDoor";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

            ui.north.setText("");
            ui.south.setText("");
            ui.east.setText("");
            ui.west.setText("");
            game.nextDirection1 = "";
            game.nextDirection2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "";

        }
    }
    public void exploreHouse(){
        if (player.currentInventory.name =="Skeleton Key"){
            ui.mainTextArea.setText("You are in the main room of the house \n" + "That skeleton key looks like it can open the locked door to your north ...\nBut why dont you go check out the Library to the east ");
            ui.choice1.setText("look");
            ui.choice2.setText("pick up");
            ui.choice3.setText("drop");
            ui.choice4.setText("leave");
            game.nextPosition1 = "look";
            game.nextPosition2 = "pickUp";
            game.nextPosition3 = "drop";
            game.nextPosition4 = "leave";

            ui.north.setText("Go north");
            ui.south.setText("Go south");
            ui.east.setText("Go east");
            ui.west.setText("Go west");
            game.nextDirection1 = "lockedDoor";
            game.nextDirection2 = "diningRoom";
            game.nextDirection3 = "library";
            game.nextDirection4 = "bathroom";

        } else {
            ui.mainTextArea.setText("You are in the main room of the house \n" + "The locked door is to your north \n" + "All you know is The dining room is to your south, you should check that out \n");
            ui.choice1.setText("look");
            ui.choice2.setText("pick up");
            ui.choice3.setText("drop");
            ui.choice4.setText("leave");
            game.nextPosition1 = "look";
            game.nextPosition2 = "pickUp";
            game.nextPosition3 = "drop";
            game.nextPosition4 = "leave";

            ui.north.setText("Go north");
            ui.south.setText("Go south");
            ui.east.setText("Go east");
            ui.west.setText("Go west");
            game.nextDirection1 = "lockedDoor";
            game.nextDirection2 = "diningRoom";
            game.nextDirection3 = "library";
            game.nextDirection4 = "bathroom";
        }

    }

    public void talkButler(){
        ui.mainTextArea.setText("Butler: Hello , You should check out the kitchen to the west ");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "diningRoom";
        game.nextPosition2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";


        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";
    }

    public void diningRoom(){
        ui.mainTextArea.setText("You enter the dining room and right away you notice a butler standing in the corner with a tray \n");
        ui.choice1.setText("talk to butler");
        ui.choice2.setText("return to main room ");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "talkButler";
        game.nextPosition2 = "exploreHouse";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        ui.north.setText("Go north");
        ui.south.setText("No exit south");
        ui.east.setText("No exit east");
        ui.west.setText("Go west");
        game.nextDirection1 = "exploreHouse";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "kitchen";
    }

    public void kitchen(){
            ui.mainTextArea.setText("You enter the dirty kitchen and are approached by a cat with what appears to be a key around its collar, \n you reach for it thinking it could be a key to the secret door.  The cat runs out of arms distance.\n  You look around the kitchen for anything to lure the cat back out.\n You notice a gallon of water on the kitchen counter.");
            ui.choice1.setText("lure cat");
            ui.choice2.setText("drink some water");
            ui.choice3.setText("return to main room");
            ui.choice4.setText("");
            game.nextPosition1 = "lureCat";
            game.nextPosition2 = "drinkWater";
            game.nextPosition3 = "exploreHouse";
            game.nextPosition4 = "";

            ui.north.setText("Go north");
            ui.south.setText("No exit to the south");
            ui.east.setText("Go east");
            ui.west.setText("No exit to the west");
            game.nextDirection1 = "bathroom";
            game.nextDirection2 = "bathroom";
            game.nextDirection3 = "exploreHouse";
            game.nextDirection4 = "";

    }

    public void lureCat(){
        if (player.currentInventory.name == "Knife"){
            cat.currentInventory = new ObjectKey();
            ui.mainTextArea.setText("You Lured the cat with your " + player.currentInventory.name +"\n" +
                    "You swapped the " + player.currentInventory.name + " for the  " + cat.currentInventory.name );
            player.currentInventory = new ObjectKey();
            cat.currentInventory = new ObjectKnife();
            ui.inventoryNameLabel.setText(player.currentInventory.name);
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "kitchen";
            game.nextPosition2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "";


            ui.north.setText("");
            ui.south.setText("");
            ui.east.setText("");
            ui.west.setText("");
            game.nextDirection1 = "";
            game.nextDirection2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "";
        }else {
            ui.mainTextArea.setText("The cat is no longer around. You should check out the bathroom to the north");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "kitchen";
            game.nextPosition2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "";


            ui.north.setText("");
            ui.south.setText("");
            ui.east.setText("");
            ui.west.setText("");
            game.nextDirection1 = "";
            game.nextDirection2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "";
        }
    }
    public void drinkWater(){
       //deduct from gallon water each time player drinks water
        ui.mainTextArea.setText("You drink water. Your health has slightly increased. Make sure you check out the kitchen to the north");
        player.health = player.health + 2;
        ui.healthNumberLabel.setText("" + player.health);
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "kitchen";
        game.nextPosition2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";


        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";
    }
    public void bathroom(){
        if (player.currentInventory.name =="Skeleton Key"){
            ui.mainTextArea.setText("There is nothing in the bathroom! You should go back to the main room");
            ui.choice1.setText("return to the main room");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "exploreHouse";
            game.nextPosition2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "";

            ui.north.setText("No exit north");
            ui.south.setText("Go south");
            ui.east.setText("Go east");
            ui.west.setText("No exit west");
            game.nextDirection1 = "";
            game.nextDirection2 = "kitchen";
            game.nextDirection3 = "exploreHouse";
            game.nextDirection4 = "";

        } else {
            ui.mainTextArea.setText("In the bathroom you see a bunch of random items on the sink, a skeleton key catches your eye poking out slightly under a box. \nYou should go check out the Library");
            ui.choice1.setText("pick up key");
            ui.choice2.setText("return to the main room");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "pickUpKey";
            game.nextPosition2 = "exploreHouse";
            game.nextDirection3 = "";
            game.nextDirection4 = "";


            ui.north.setText("No exit north");
            ui.south.setText("go south");
            ui.east.setText("Go east");
            ui.west.setText("No exit west");
            game.nextDirection1 = "";
            game.nextDirection2 = "kitchen";
            game.nextDirection3 = "exploreHouse";
            game.nextDirection4 = "";
        }

    }

    public void pickUpKey(){
        ui.mainTextArea.setText("You have swapped the " + player.currentInventory.name + " for the  skeleton key" );
        player.currentInventory = new ObjectSkeletonKey();
        ui.inventoryNameLabel.setText(player.currentInventory.name);
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "bathroom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";


        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";


    }
    public void bedroom(){
        ui.mainTextArea.setText("You enter the  bedroom and see a maid standing in the room \nShe is aware of the Ghost and knows exactly how to kill it \nShe hands you a flash light");
        player.currentInventory = new ObjectFlashLight();
        ui.inventoryNameLabel.setText(player.currentInventory.name);
        ui.choice1.setText("Return to the library");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "library";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        ui.north.setText("Go north");
        ui.south.setText("No exit south");
        ui.east.setText("No exit east");
        ui.west.setText("No exit west");
        game.nextDirection1 = "library";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";
    }

    public void library(){
        if (player.currentInventory.name == "Skeleton Key"){
            enemy = new EnemyGhost();
            ui.mainTextArea.setText("You enter the library and notice a wall of bookshelves, they all appear to be dusty and covered in cobwebs.\n Out of no where a " + enemy.name + " appears and steals your skeleton key. \nThe Ghost is blocking all exits, you can only escape to the bedroom in to the south ");
            player.currentInventory = new ObjectNothing();
            ui.inventoryNameLabel.setText(player.currentInventory.name);
            ui.choice1.setText("run away");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "bedroom";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";


            ui.north.setText("No exit north");
            ui.south.setText("Go south");
            ui.east.setText("No exit east");
            ui.west.setText("No exit west");
            game.nextDirection1 = "";
            game.nextDirection2 = "bedroom";
            game.nextDirection3 = "";
            game.nextDirection4 = "";

        } else if (player.currentInventory.name == "Flash Light"){
            ui.mainTextArea.setText("You enter the library and notice a wall of bookshelves, they all appear to be dusty and covered in cobwebs. \nWhat will you do? ");
            ui.choice1.setText("Fight");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";


            ui.north.setText("No exit north");
            ui.south.setText("No exit north");
            ui.east.setText("No exit east");
            ui.west.setText("Go west");
            game.nextDirection1 = "";
            game.nextDirection2 = "";
            game.nextDirection3 = "";
            game.nextDirection4 = "exploreHouse";

        }

    }

    public void fight(){
        ui.mainTextArea.setText(enemy.name + ": " + enemy.health + "\nWhat do you do?");
        ui.choice1.setText("Attack");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";
    }

    public void playerAttack(){
        int playerDamage = new java.util.Random().nextInt(player.currentInventory.damage);

        if(playerDamage < 50){
            ui.mainTextArea.setText("You attacked the " + enemy.name + " and gave only " + playerDamage + "damage! \nReminder: This ghost can be defeated with a flashlight \nMaybe you should check the bedroom ");
        }
        ui.mainTextArea.setText("You attacked the " + enemy.name + " and gave " + playerDamage + "damage!");

        enemy.health = enemy.health - playerDamage;
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(enemy.health > 0){
            game.nextPosition1 = "enemyAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (enemy.health<1){
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";

    }

    public void enemyAttack(){
        int enemyDamage = new java.util.Random().nextInt(enemy.power);
        player.health = player.health - enemyDamage;
        ui.healthNumberLabel.setText("" + player.health);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");


        if(player.health > 0){
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.health<1){
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }
        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";



    }
    public void win(){
        ui.mainTextArea.setText("You've defeated the " + enemy.name + "!\nThe skeleton key has appeared again");
        player.currentInventory = new ObjectSkeletonKey();
        ui.inventoryNameLabel.setText(player.currentInventory.name);
        beatEnemy = true;


        ui.choice1.setText("Return to main room");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "exploreHouse";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";



        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";

    }

    public void lose(){
     ui.mainTextArea.setText("You are Dead!\n\n<GAME OVER>");
     beatEnemy = true;

     ui.choice1.setText("To the title screen");
     ui.choice2.setText("");
     ui.choice3.setText("");
     ui.choice4.setText("");
     game.nextPosition1 = "toTitle";
     game.nextPosition2 = "";
     game.nextPosition3 = "";
     game.nextPosition4 = "";


        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";

}

    public void ending(){
        ui.mainTextArea.setText("""
                You used the key to open the locked door. You have entered. SURPRISE! All of your friends are in the room! Its a surprise party for you!
                   ♫ ♫♫          ♫ ♫♫        ♫♫         ♫♫ ♫♫
                      ░░┌──┐░░░┌──┐░░░┌──┐░░
                      ░╔╡▐▐╞╝░╚╡▌▌╞╗░╔╡▐▐╞╝░
                      ░░└╥╥┘░░░└╥╥┘░░░└╥╥┘░░
                      ░░░╚╚░░░░░╝╝░░░░░╚╚░░░
                """);
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);

    }
    public void toTitle(){
        defaultSetup();
        vm.showTitleScreen();
    }

    public void chargeAtDoor(){
        ui.mainTextArea.setText("You attempt to run head first into the door \n" + "You have hit your head pretty hard. Door is still locked. \n" + "You lost a little bit of health as a result. \n");
        player.health = player.health - 1;
        ui.healthNumberLabel.setText("" + player.health);
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "lockedDoor";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";


        ui.north.setText("");
        ui.south.setText("");
        ui.east.setText("");
        ui.west.setText("");
        game.nextDirection1 = "";
        game.nextDirection2 = "";
        game.nextDirection3 = "";
        game.nextDirection4 = "";

    }



    public void gameInfo(){
        ui.mainTextArea.setText("What would you like to do?");
        ui.gameInfo1.setText("Learn Back Story");
        ui.gameInfo2.setText(">");
        ui.gameInfo3.setText("Load");
        ui.gameInfo4.setText("Save");


        game.nextPosition1 = "learnStory";
        //need to be able to go back to start screen
        game.nextPosition2 = "toTitle";
        game.nextPosition3 = "Load";
        game.nextPosition4 = "Save";

    }
    public void learnStory(){
        ui.mainTextArea.setText("This is the story");
        ui.gameInfo1.setText(">");
        ui.gameInfo2.setText("");

        game.nextPosition1 = "gameInfo";
        game.nextPosition2 = "";


    }

}
