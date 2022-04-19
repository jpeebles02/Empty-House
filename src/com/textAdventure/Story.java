package com.textAdventure;

import com.utility.*;
import com.utility.SuperObject;
import com.textAdventure.Game;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import javax.swing.*;
import java.awt.*;



import java.io.*;
import java.util.TimerTask;

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
        ui.mainTextArea.setText("It’s Halloween night, your friend invites you to an abandoned house to explore. After some convincing, your friend gives you a knife and you decide to go in and explore. Your friend immediately darts through the entrance. As you approach the entrance, the door slams shut in front of you. As you enter through the door, you realize your friend has now disappeared. What would you like to do? \n");

        ui.choice1.setVisible(true);
        ui.choice2.setVisible(true);
        ui.choice3.setVisible(true);
        ui.choice4.setVisible(false);

        ui.choice1.setText("Go after friend");
        ui.choice2.setText("Run away, i'm scared!");
        ui.choice3.setText("QUIT");
        game.nextPosition1 = "lockedDoor";
        game.nextPosition2 = "toTitle";
        game.nextPosition3 = "leave";


        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);

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

        if (player.health >= 1) {
            ui.mainTextArea.setText("You have approached a locked door You hear music behind the door, but you can't get in ... What do you do?" + "");
            ui.choice1.setVisible(true);
            ui.choice2.setVisible(true);
            ui.choice3.setVisible(true);
            ui.choice4.setVisible(true);
            ui.choice1.setText("Try to open the door");
            ui.choice2.setText("Charge at door!");
            ui.choice3.setText("Explore the house.");
            ui.choice4.setText(">");
            game.nextPosition1 = "openDoor";
            game.nextPosition2 = "chargeAtDoor";
            game.nextPosition3 = "exploreHouse";
            game.nextPosition4 = "intro";


            ui.north.setVisible(false);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(false);
        } else {
            lose();
        }



    }

    public void leave(){
        System.exit(0);
    }

    public void openDoor(){
        if (player.currentInventory.name == "Key"){
            ui.mainTextArea.setText("You attempt to open the door It seems like THIS Key does not work.\n\n"
                    + "*** Maybe the Bathroom to the west of the main room is now open *** \n");
            ui.choice1.setVisible(true);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            ui.choice1.setText(">");
            game.nextPosition1 = "lockedDoor";

            ui.north.setVisible(false);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(false);
            player.currentInventory = new ObjectNothing();
            ui.inventoryNameLabel.setText(player.currentInventory.name);

        } else if (player.currentInventory.name == "Skeleton Key"){
            ending();
        }
        else {
            ui.mainTextArea.setText("You attempt to open the door. It seems like you will need a Key to get in. \n");
            ui.choice1.setVisible(true);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            ui.choice1.setText(">");
            game.nextPosition1 = "lockedDoor";

            ui.north.setVisible(false);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(false);

        }
    }
    public void exploreHouse(){
        if (player.currentInventory.name =="Skeleton Key"){
            ui.mainTextArea.setText("You are in the main room of the house \n" + "That skeleton key looks like it can open the locked door to your north ...\nBut why dont you go check out the Library to the east ");
            ui.choice1.setVisible(false);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(true);
            ui.choice4.setText("QUIT");
            game.nextPosition4 = "leave";

            ui.north.setVisible(true);
            ui.south.setVisible(true);
            ui.east.setVisible(true);
            ui.west.setVisible(true);
            ui.north.setText("Go North");
            ui.south.setText("Go South");
            ui.east.setText("Go East");
            ui.west.setText("Go West");
            game.nextDirection1 = "lockedDoor";
            game.nextDirection2 = "diningRoom";
            game.nextDirection3 = "library";
            game.nextDirection4 = "bathroom";

        } else if (player.currentInventory.name =="Key"){
            ui.mainTextArea.setText("You are in the main room of the house. The locked door is to your north. Check it out \n");

            ui.choice1.setVisible(false);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(true);
            ui.choice4.setText("QUIT");
            game.nextPosition4 = "leave";

            ui.north.setVisible(true);
            ui.south.setVisible(true);
            ui.east.setVisible(true);
            ui.west.setVisible(true);
            ui.north.setText("Go North");
            ui.south.setText("Go South");
            ui.east.setText("Go East");
            ui.west.setText("Go West");
            game.nextDirection1 = "lockedDoor";
            game.nextDirection2 = "diningRoom";
            game.nextDirection3 = "library";
            game.nextDirection4 = "bathroom";
        } else if (player.currentInventory.name =="empty") {
            ui.mainTextArea.setText("You are in the main room of the house. That key didnt work, but it seems like the Bathroom wo the west is now open \n");

            ui.choice1.setVisible(false);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(true);
            ui.choice4.setText("QUIT");
            game.nextPosition4 = "leave";

            ui.north.setVisible(true);
            ui.south.setVisible(true);
            ui.east.setVisible(true);
            ui.west.setVisible(true);
            ui.north.setText("Go North");
            ui.south.setText("Go South");
            ui.east.setText("Go East");
            ui.west.setText("Go West");
            game.nextDirection1 = "lockedDoor";
            game.nextDirection2 = "diningRoom";
            game.nextDirection3 = "library";
            game.nextDirection4 = "bathroom";
        }else {
            ui.mainTextArea.setText("You are in the main room of the house. The locked door is to your north. The dining room is to your south, you should check that out ... \n");
            ui.choice1.setVisible(false);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(true);
            ui.choice4.setText("leave");
            game.nextPosition4 = "QUIT";

            ui.north.setVisible(true);
            ui.south.setVisible(true);
            ui.east.setVisible(true);
            ui.west.setVisible(true);
            ui.north.setText("Go North");
            ui.south.setText("Go South");
            ui.east.setText("Go East");
            ui.west.setText("Go West");
            game.nextDirection1 = "lockedDoor";
            game.nextDirection2 = "diningRoom";
            game.nextDirection3 = "library";
            game.nextDirection4 = "bathroom";
        }
    }


    public void talkButler(){
        ui.mainTextArea.setText("Butler: Hello , You should check out the kitchen to the west ");
        ui.choice1.setVisible(true);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        ui.choice1.setText(">");
        game.nextPosition1 = "diningRoom";

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);
    }

    public void diningRoom(){
        ui.mainTextArea.setText("You enter the dining room and right away you notice a butler standing in the corner with a tray \n"
                + "The main room is to the north\n"
                + "The Kitchen is to the west\n");
        ui.choice1.setVisible(true);
        ui.choice2.setVisible(true);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        ui.choice1.setText("talk to butler");
        ui.choice2.setText("return to main room ");
        game.nextPosition1 = "talkButler";
        game.nextPosition2 = "exploreHouse";

        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.north.setVisible(true);
        ui.west.setVisible(true);
        ui.north.setText("Go North");
        ui.west.setText("Go West");
        game.nextDirection1 = "exploreHouse";
        game.nextDirection4 = "kitchen";
    }

    public void kitchen(){
        if( player.currentInventory.name == "Key"){
            ui.mainTextArea.setText("Now that you have a key, you should try to open the locked door \n" +
                    "Unfortunately, the water is all gone ");
            ui.choice1.setVisible(false);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);

            ui.north.setVisible(true);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(false);
            ui.north.setText("Return to main room");
            game.nextDirection1 = "exploreHouse";
        } else {
            ui.mainTextArea.setText("You enter the dirty kitchen and are approached by a cat with what appears to be a key around its collar, you reach for it thinking it could be a key to the secret door.  The cat runs out of arms distance.You look around the kitchen for anything to lure the cat back out. You notice a gallon of water on the kitchen counter.\n"
                    + "The Bathroom is to the north\n"
                    + "The Dining Room is to the east\n");
            ui.choice1.setVisible(true);
            ui.choice2.setVisible(true);
            ui.choice3.setVisible(true);
            ui.choice4.setVisible(false);
            ui.choice1.setText("lure cat");
            ui.choice2.setText("drink some water");
            ui.choice3.setText("return to main room");
            game.nextPosition1 = "lureCat";
            game.nextPosition2 = "drinkWater";
            game.nextPosition3 = "exploreHouse";

            ui.north.setVisible(true);
            ui.south.setVisible(false);
            ui.east.setVisible(true);
            ui.west.setVisible(false);
            ui.north.setText("Go North");
            ui.east.setText("Go East");
            game.nextDirection1 = "bathroom";
            game.nextDirection3 = "diningRoom";
        }

    }

    public void lureCat(){
        if (player.currentInventory.name == "Knife"){
            cat.currentInventory = new ObjectKey();
            ui.mainTextArea.setText("You Lured the cat with your " + player.currentInventory.name +"\n" +
                    "You swapped the " + player.currentInventory.name + " for the  " + cat.currentInventory.name );
            player.currentInventory = new ObjectKey();
            cat.currentInventory = new ObjectKnife();
            ui.inventoryNameLabel.setText(player.currentInventory.name);
            ui.choice1.setVisible(true);
            ui.choice1.setText(">");
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            game.nextPosition1 = "kitchen";

            ui.north.setVisible(false);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(false);
        }else {
            ui.mainTextArea.setText("The cat is no longer around. You should check out the bathroom to the north");
            ui.choice1.setVisible(true);
            ui.choice1.setText(">");
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            game.nextPosition1 = "kitchen";

            ui.north.setVisible(false);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(false);
        }
    }
    public void drinkWater(){
        //deduct from gallon water each time player drinks water
        ui.mainTextArea.setText("You drink water. Your health has slightly increased. Continue to drink more water, but make sure you check out the Bathroom to the north");
        player.health = player.health + 10;
        ui.healthNumberLabel.setText("" + player.health);
        ui.choice1.setVisible(true);
        ui.choice1.setText(">");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        game.nextPosition1 = "kitchen";

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);
    }
    public void bathroom(){
        if (player.currentInventory.name =="Skeleton Key"){
            ui.mainTextArea.setText("There is nothing in the bathroom! You should go back to the main room");
            ui.choice1.setVisible(true);
            ui.choice1.setText("return to the main room");
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            game.nextPosition1 = "exploreHouse";

            ui.north.setVisible(false);
            ui.south.setVisible(true);
            ui.east.setVisible(true);
            ui.west.setVisible(false);
            ui.south.setText("Go South");
            ui.east.setText("Go East");
            game.nextDirection2 = "kitchen";
            game.nextDirection3 = "exploreHouse";

        } else if (player.currentInventory.name == "Knife"){
            ui.mainTextArea.setText("You can't enter the Bathroom at this moment");
            ui.choice1.setVisible(true);
            ui.choice1.setText(">");
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            game.nextPosition1 = "exploreHouse";

            ui.north.setVisible(false);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(false);

        } else {
            ui.mainTextArea.setText("In the bathroom you see a bunch of random items on the sink, a Skeleton Key catches your eye poking out slightly under a box. \n"
                    + "***You should pick up the key***");
            ui.choice1.setVisible(true);
            ui.choice2.setVisible(true);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            ui.choice1.setText("Pick up Skeleton Key");
            ui.choice2.setText("return to the main room");
            game.nextPosition1 = "pickUpKey";
            game.nextPosition2 = "exploreHouse";

            ui.north.setVisible(false);
            ui.south.setVisible(true);
            ui.east.setVisible(true);
            ui.west.setVisible(false);
            ui.south.setText("go South");
            ui.east.setText("Go East");
            game.nextDirection2 = "kitchen";
            game.nextDirection3 = "exploreHouse";
        }

    }

    public void pickUpKey(){
        ui.mainTextArea.setText("You picked up the Skeleton Key!" );
        player.currentInventory = new ObjectSkeletonKey();
        ui.inventoryNameLabel.setText(player.currentInventory.name);
        ui.choice1.setVisible(true);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        ui.choice1.setText(">");
        game.nextPosition1 = "bathroom";

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);
    }
    public void bedroom(){
        ui.mainTextArea.setText("You enter the bedroom and see a maid standing in the room. She is aware of the Ghost and knows exactly how to kill it. She hands you a flash light");
        player.currentInventory = new ObjectFlashLight();
        ui.inventoryNameLabel.setText(player.currentInventory.name);
        ui.choice1.setVisible(true);
        ui.choice1.setText("Return to the library");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        game.nextPosition1 = "library";

        ui.north.setVisible(true);
        ui.north.setText("Go north");
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);
        game.nextDirection1 = "library";
    }

    public void library(){
        if (player.currentInventory.name == "Skeleton Key"){
            enemy = new EnemyGhost();
            ui.mainTextArea.setText("You enter the library and notice a wall of bookshelves, they all appear to be dusty and covered in cobwebs. Out of no where a " + enemy.name + " appears and steals your skeleton key. The Ghost is blocking all exits, you can only escape to the bedroom in to the south ");
            player.currentInventory = new ObjectNothing();
            ui.inventoryNameLabel.setText(player.currentInventory.name);
            ui.choice1.setVisible(true);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            ui.choice1.setText("run away");
            game.nextPosition1 = "bedroom";

            ui.north.setVisible(false);
            ui.south.setText("Go south");
            ui.east.setVisible(false);
            ui.west.setVisible(false);
            game.nextDirection2 = "bedroom";

        } else if (player.currentInventory.name == "Flash Light"){
            ui.mainTextArea.setText("You can use the Flash Light that the maid gave you to fight the ghost. ");
            ui.choice1.setVisible(true);
            ui.choice1.setText("Fight");
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
            game.nextPosition1 = "fight";

            ui.north.setVisible(false);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(true);
            ui.west.setText("I'm scared ... QUIT");
            game.nextDirection4 = "toTitle";
        } else {
            ui.mainTextArea.setText("You enter the library and notice a wall of bookshelves, they all appear to be dusty and covered in cobwebs. Nothing here ");
            ui.choice1.setVisible(true);
            ui.choice1.setText(">");
            game.nextPosition1 = "exploreHouse";

            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);

            ui.north.setVisible(false);
            ui.south.setVisible(false);
            ui.east.setVisible(false);
            ui.west.setVisible(false);
        }

    }

    public void fight(){
        ui.mainTextArea.setText(enemy.name + " Health : " + enemy.health + "\nWhat do you do?");
        ui.choice1.setVisible(true);
        ui.choice1.setText("Attack");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        game.nextPosition1 = "playerAttack";

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);
    }

    public void playerAttack(){
        int playerDamage = new java.util.Random().nextInt(player.currentInventory.damage);

        if(playerDamage < 50){
            ui.mainTextArea.setText("You attacked the " + enemy.name + " and gave only " + playerDamage + "damage! \nReminder: This ghost can be defeated with a flashlight \nMaybe you should check the bedroom ");
        }
        ui.mainTextArea.setText("You attacked the " + enemy.name + " and gave " + playerDamage + " damage!");

        enemy.health = enemy.health - playerDamage;
        ui.choice1.setVisible(true);
        ui.choice1.setText(">");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        if(enemy.health > 0){
            game.nextPosition1 = "enemyAttack";
        }
        else if (enemy.health<1){
            game.nextPosition1 = "win";
        }

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);

    }

    public void enemyAttack(){
        int enemyDamage = new java.util.Random().nextInt(enemy.power);
        player.health = player.health - enemyDamage;
        ui.healthNumberLabel.setText("" + player.health);

        ui.mainTextArea.setText(enemy.attackMessage + "\nYou lost " + enemyDamage + " health!");

        ui.choice1.setVisible(true);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        ui.choice1.setText(">");

        if(player.health > 0){
            game.nextPosition1 = "fight";
        }
        else if (player.health<1){
            game.nextPosition1 = "lose";
        }
        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);
    }
    public void win(){
        ui.mainTextArea.setText("You've defeated the " + enemy.name + "!\nThe Skeleton Key has appeared again");
        player.currentInventory = new ObjectSkeletonKey();
        ui.inventoryNameLabel.setText(player.currentInventory.name);
        beatEnemy = true;

        ui.choice1.setVisible(true);
        ui.choice1.setText("Return to main room");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        game.nextPosition1 = "exploreHouse";

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);

    }

    public void lose(){
        ui.mainTextArea.setText("You are Dead!\n\n<GAME OVER>");
        beatEnemy = true;

        ui.choice1.setVisible(true);
        ui.choice1.setText("To the title screen");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        game.nextPosition1 = "toTitle";

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);

    }

    public void ending(){
        ui.mainTextArea.setText("""     
                You used the Skeleton Key to open the locked door. You have entered. SURPRISE! All of your friends are in the room! Its a surprise party for you!
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
        ui.mainTextArea.setText("You attempt to run head first into the door (not smart) ... You have hit your head pretty hard. Door is still locked. You are a little dizzy and lost a little bit of health as a result. \n");
        player.health = player.health - 1;
        ui.healthNumberLabel.setText("" + player.health);
        ui.choice1.setVisible(true);
        ui.choice1.setText(">");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        game.nextPosition1 = "lockedDoor";

        ui.north.setVisible(false);
        ui.south.setVisible(false);
        ui.east.setVisible(false);
        ui.west.setVisible(false);

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
