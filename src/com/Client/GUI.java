package com.Client;

import com.Util.Dir;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends Game{

    JFrame frame;
    Container con;
    JPanel panelName, startButtonPanel, mainTextPanel, mainTextPanelNorth, mainTextPanelSouth, mainTextPanelWest, mainTextPanelDinning, mainTextPanelEast, mainTextPanelTwo, choiceButtonPanel, choiceButtonPanelNorth, choiceButtonPanelSouth, choiceButtonPanelEast, choiceButtonPanelWest, choiceButtonPanelDinning, choiceButtonPanelTwo, playerPanel, splashTextPanel;
    JLabel labelName, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font fontTitle = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font textFont = new Font("Times New Roman", Font.PLAIN, 24);
    Font smallFont = new Font("Times New Roman", Font.PLAIN, 12);
    Font tinyFont = new Font("Times New Roman", Font.PLAIN, 6);
    JButton startButton, optionOneButton, optionOneButtonNorth, optionOneButtonSouth, optionOneButtonWest, optionTwoButtonNorth, optionTwoButtonSouth, optionOneButtonEast, optionTwoButtonWest, optionOneButtonDinning, optionTwoButtonDinning, optionThreeButtonDinning, optionFourButtonDinning, optionOneButtonTwo, optionTwoButton, optionTwoButtonEast, optionTwoButtonTwo, optionThreeButton, optionThreeButtonEast, optionThreeButtonWest, optionThreeButtonTwo, optionFourButton, optionFourButtonEast, optionFourButtonWest, optionFourButtonTwo, optionFiveButton;
    JTextArea mainTextArea, mainTextAreaNorth, mainTextAreaSouth, mainTextAreaEast, mainTextAreaWest, mainTextAreaDinning, mainTextAreaTwo, splashTextArea;
    TitleScreenOne tScreenOne = new TitleScreenOne();
    NorthScreen nScreen = new NorthScreen();
    SouthScreen sScreen = new SouthScreen();
    EastScreen eScreen = new EastScreen();
    WestScreen wScreen = new WestScreen();
    EastOfKitchenScreen ekScreen = new EastOfKitchenScreen();
    //TitleScreenTwo tScreenTwo = new TitleScreenTwo();
    LookButton lButton = new LookButton();
    TakeButton tButton = new TakeButton();
    NorthButton nButton = new NorthButton();
    SouthButton sButton = new SouthButton();
    EastOfKitchenButton eastOfKitchenButton = new EastOfKitchenButton();
    EastButton eButton = new EastButton();
    WestButton wButton = new WestButton();

    public static void main (String args[]) {
        new GUI();
    }

    public GUI() {

        frame = new JFrame("Empty House");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setVisible(true);
        con = frame.getContentPane();

        panelName = new JPanel();
        panelName.setBounds(100, 100, 600, 150);
        panelName.setBackground(Color.black);

        labelName = new JLabel("Empty House");
        labelName.setForeground(Color.white);
        labelName.setFont(fontTitle);

        //splashTextPanel = new JPanel();
        //splashTextPanel.setBounds(100, 100, 600, 250);
        //splashTextPanel.setBackground(Color.black);
        //con.add(splashTextPanel);
        //frame.add(labelName, BorderLayout.NORTH);
        //frame.add(splashTextPanel, BorderLayout.WEST);

        //splashTextArea = new JTextArea("\n" +
        //             "                                          ____\n" +
        //             "                                        _           |---||            _\n" +
        //             "                                        ||__________|MSJ||___________||\n" +
        //             "                                       /_ _ _ _ _ _ |:._|'_ _ _ _ _ _ _\\`.\n" +
        //             "                                      /_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\\:`.\n" +
        //             "                                     /_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\\::`.\n" +
        //             "                                    /:.___________________________________\\:::`-._\n" +
        //             "                                _.-'_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _`::::::`-.._\n" +
        //             "                            _.-' _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ `:::::::::`-._\n" +
        //             "                          ,'_:._________________________________________________`:_.::::-';`\n" +
        //             "                           `.'/ || |:::::`.'/::::::::`.'/::::::::`.'/::::::|.`.'/.|     :|\n" +
        //             "                            ||  || |::::::||::::::::::||::::::::::||:::::::|..||..|     ||\n" +
        //             "                            ||  || |  __  || ::  ___  || ::  __   || ::    |..||;||     ||\n" +
        //             "                            ||  || | |::| || :: |:::| || :: |::|  || ::    |.|||:||_____||__\n" +
        //             "                            ||  || | |::| || :: |:::| || :: |::|  || ::    |.|||:||_|_|_||,(      +            +            +\n" +
        //             "                            ||_.|| | |::| || :: |:::| || :: |::|  || ::    |.'||..|    _||,|    .-\"-.        .-:-.        .-\"-.\n" +
        //             "                         .-'::_.:'.:-.--.-::--.-:.--:-::--.--.--.-::--.--.-:.-::,'.--.'_|| |   / RIP \\      / RIP \\      / RIP \\\n" +
        //             "                          );||_|__||_|__|_||__|_||::|_||__|__|__|_||__|__|_|;-'|__|_(,' || '-  |     |      |     |      |     |\n" +
        //             "                           ||||  || |. . . ||. . . . . ||. . . . . ||. . . .|::||;''||   ||:'  \\\\     |//  \\\\\\     |//  \\\\\\     |//\n" +
        //             "                         ||||.;  _|._._._||._._._._._||._._._._._||._._._.|:'||,, ||,, ____, ` \" \"\" \"    ` ' \"\" \"     \" '  \"\"\" \"\n" +
        //             "\n" +
        //             "\n" +
        //             "                                ▓█████  ███▄ ▄███▓ ██▓███  ▄▄▄█████▓▓██   ██▓    ██░ ██  ▒█████   █    ██   ██████ ▓█████\n" +
        //             "                                ▓█   ▀ ▓██▒▀█▀ ██▒▓██░  ██▒▓  ██▒ ▓▒ ▒██  ██▒   ▓██░ ██▒▒██▒  ██▒ ██  ▓██▒▒██    ▒ ▓█   ▀\n" +
        //             "                                ▒███   ▓██    ▓██░▓██░ ██▓▒▒ ▓██░ ▒░  ▒██ ██░   ▒██▀▀██░▒██░  ██▒▓██  ▒██░░ ▓██▄   ▒███\n" +
        //             "                                ▒▓█  ▄ ▒██    ▒██ ▒██▄█▓▒ ▒░ ▓██▓ ░   ░ ▐██▓░   ░▓█ ░██ ▒██   ██░▓▓█  ░██░  ▒   ██▒▒▓█  ▄\n" +
        //             "                                ░▒████▒▒██▒   ░██▒▒██▒ ░  ░  ▒██▒ ░   ░ ██▒▓░   ░▓█▒░██▓░ ████▓▒░▒▒█████▓ ▒██████▒▒░▒████▒\n" +
        //             "                                 ░░ ▒░ ░░ ▒░   ░  ░▒▓▒░ ░  ░  ▒ ░░      ██▒▒▒     ▒ ░░▒░▒░ ▒░▒░▒░ ░▒▓▒ ▒ ▒ ▒ ▒▓▒ ▒ ░░░ ▒░ ░\n" +
        //             "                                 ░ ░  ░░  ░      ░░▒ ░         ░     ▓██ ░▒░     ▒ ░▒░ ░  ░ ▒ ▒░ ░░▒░ ░ ░ ░ ░▒  ░ ░ ░ ░  ░\n" +
        //             "                                    ░   ░      ░   ░░         ░       ▒ ▒ ░░      ░  ░░ ░░ ░ ░ ▒   ░░░ ░ ░ ░  ░  ░     ░\n" +
        //             "                                   ░  ░       ░                      ░ ░         ░  ░  ░    ░ ░     ░           ░     ░  ░\n");
        //splashTextArea.setBounds(100, 100, 600, 250);
        //splashTextArea.setBackground(Color.black);
        //splashTextArea.setForeground(Color.white);
        //splashTextArea.setFont(tinyFont);
        //splashTextArea.setLineWrap(true);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tScreenOne);
        startButton.setFocusPainted(false);

        panelName.add(labelName);
        startButtonPanel.add(startButton);
        //splashTextPanel.add(splashTextArea);

        con.add(panelName);
        con.add(startButtonPanel);
        //con.add(splashTextPanel);
        //Creating the MenuBar and adding components
        frame.setVisible(true);
        //startButton.addActionListener(tScreenOne);
    }

    public void GameScreenOne() {

        panelName.setVisible(false);
        startButtonPanel.setVisible(false);
        //splashTextPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);


        mainTextArea = new JTextArea("It’s Halloween night, your friend invites you to an abandoned house to explore. After some convincing you decide to go in, as you enter the door slams shut behind you. You and your   friend realize it is now locked and decide to split up to try     and find another way out. He decides to go upstairs to look       around, where would you like to go on the ground floor?");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(textFont);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);
        con.add(mainTextPanel);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(5,1));
        con.add(choiceButtonPanel);


        optionOneButton = new JButton("Go north ");
        optionOneButton.setBackground(Color.black);
        optionOneButton.setForeground(Color.black);
        optionOneButton.setFont(smallFont);
        optionOneButton.setFocusPainted(false);
        choiceButtonPanel.add(optionOneButton);
        optionOneButton.addActionListener(nScreen);
        optionOneButton.addActionListener(nButton);



        optionTwoButton = new JButton("Go south");
        optionTwoButton.setBackground(Color.black);
        optionTwoButton.setForeground(Color.black);
        optionTwoButton.setFont(smallFont);
        optionTwoButton.setFocusPainted(false);
        choiceButtonPanel.add(optionTwoButton);
        optionTwoButton.addActionListener(sScreen);
        optionTwoButton.addActionListener(sButton);

        optionThreeButton = new JButton("Go east ");
        optionThreeButton.setBackground(Color.black);
        optionThreeButton.setForeground(Color.black);
        optionThreeButton.setFont(smallFont);
        optionThreeButton.setFocusPainted(false);
        choiceButtonPanel.add(optionThreeButton);
        optionThreeButton.addActionListener(eScreen);
        optionThreeButton.addActionListener(eButton);

        optionFourButton = new JButton("Go west ");
        optionFourButton.setBackground(Color.black);
        optionFourButton.setForeground(Color.black);
        optionFourButton.setFont(smallFont);
        optionFourButton.setFocusPainted(false);
        choiceButtonPanel.add(optionFourButton);
        optionFourButton.addActionListener(wScreen);
        optionFourButton.addActionListener(wButton);

        optionFiveButton = new JButton("Quit");
        optionFiveButton.setBackground(Color.black);
        optionFiveButton.setForeground(Color.black);
        optionFiveButton.setFont(smallFont);
        optionFiveButton.setFocusPainted(false);
        choiceButtonPanel.add(optionFiveButton);
        optionFiveButton.addActionListener(new quitListener());


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }

    public void NorthOption(){
        panelName.setVisible(false);
        startButtonPanel.setVisible(false);
        //splashTextPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        optionOneButton.setVisible(false);
        optionTwoButton.setVisible(false);
        optionThreeButton.setVisible(false);
        optionFourButton.setVisible(false);
        optionFiveButton.setVisible(false);

        mainTextPanelNorth = new JPanel();
        mainTextPanelNorth.setBounds(100, 100, 600, 250);
        mainTextPanelNorth.setBackground(Color.black);


        mainTextAreaNorth = new JTextArea("No Exit! ");
        mainTextAreaNorth.setBounds(100, 100, 600, 250);
        mainTextAreaNorth.setBackground(Color.black);
        mainTextAreaNorth.setForeground(Color.white);
        mainTextAreaNorth.setFont(textFont);
        mainTextAreaNorth.setLineWrap(true);

        mainTextPanelNorth.add(mainTextAreaNorth);
        con.add(mainTextPanelNorth);

        choiceButtonPanelNorth = new JPanel();
        choiceButtonPanelNorth.setBounds(250, 350, 300, 150);
        choiceButtonPanelNorth.setBackground(Color.black);
        choiceButtonPanelNorth.setLayout(new GridLayout(2,1));
        con.add(choiceButtonPanelNorth);

        optionOneButtonNorth = new JButton("Go back");
        optionOneButtonNorth.setBackground(Color.black);
        optionOneButtonNorth.setForeground(Color.black);
        optionOneButtonNorth.setFont(smallFont);
        optionOneButtonNorth.setFocusPainted(false);
        choiceButtonPanelNorth.add(optionOneButtonNorth);
        //optionOneButtonNorth.addActionListener(tScreenOne);

        optionTwoButtonNorth = new JButton("Quit");
        optionTwoButtonNorth.setBackground(Color.black);
        optionTwoButtonNorth.setForeground(Color.black);
        optionTwoButtonNorth.setFont(smallFont);
        optionTwoButtonNorth.setFocusPainted(false);
        choiceButtonPanelNorth.add(optionTwoButtonNorth);
        optionTwoButtonNorth.addActionListener(new quitListener());

        initGame();
        playerSetup();

    }

    public void SouthOption(){
        panelName.setVisible(false);
        startButtonPanel.setVisible(false);
        //splashTextPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);


        mainTextPanelSouth = new JPanel();
        mainTextPanelSouth.setBounds(100, 100, 600, 250);
        mainTextPanelSouth.setBackground(Color.black);


        mainTextAreaSouth = new JTextArea("No Exit! ");
        mainTextAreaSouth.setBounds(100, 100, 600, 250);
        mainTextAreaSouth.setBackground(Color.black);
        mainTextAreaSouth.setForeground(Color.white);
        mainTextAreaSouth.setFont(textFont);
        mainTextAreaSouth.setLineWrap(true);

        mainTextPanelSouth.add(mainTextAreaSouth);
        con.add(mainTextPanelSouth);

        choiceButtonPanelSouth = new JPanel();
        choiceButtonPanelSouth.setBounds(250, 350, 300, 150);
        choiceButtonPanelSouth.setBackground(Color.black);
        choiceButtonPanelSouth.setLayout(new GridLayout(2,1));
        con.add(choiceButtonPanelSouth);

        optionOneButtonSouth = new JButton("Go back");
        optionOneButtonSouth.setBackground(Color.black);
        optionOneButtonSouth.setForeground(Color.black);
        optionOneButtonSouth.setFont(smallFont);
        optionOneButtonSouth.setFocusPainted(false);
        choiceButtonPanelSouth.add(optionOneButtonSouth);
        //optionOneButtonSouth.addActionListener(tScreenOne);

        optionTwoButtonSouth = new JButton("Quit");
        optionTwoButtonSouth.setBackground(Color.black);
        optionTwoButtonSouth.setForeground(Color.black);
        optionTwoButtonSouth.setFont(smallFont);
        optionTwoButtonSouth.setFocusPainted(false);
        choiceButtonPanelSouth.add(optionTwoButtonSouth);
        optionTwoButtonSouth.addActionListener(new quitListener());

        playerSetup();

    }

    public void EastOption(){
        panelName.setVisible(false);
        startButtonPanel.setVisible(false);
        //splashTextPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);


        mainTextPanelEast = new JPanel();
        mainTextPanelEast.setBounds(100, 100, 600, 250);
        mainTextPanelEast.setBackground(Color.black);


        mainTextAreaEast = new JTextArea("You are in the Library. You enter the library and notice a wall of bookshelves, they all appear to be dusty and covered in cobwebs besides one section that looks clean and has a book missing...Things here: paper pencil");
        mainTextAreaEast.setBounds(100, 100, 600, 250);
        mainTextAreaEast.setBackground(Color.black);
        mainTextAreaEast.setForeground(Color.white);
        mainTextAreaEast.setFont(textFont);
        mainTextAreaEast.setLineWrap(true);

        mainTextPanelEast.add(mainTextAreaEast);
        con.add(mainTextPanelEast);

        choiceButtonPanelEast = new JPanel();
        choiceButtonPanelEast.setBounds(250, 350, 300, 150);
        choiceButtonPanelEast.setBackground(Color.black);
        choiceButtonPanelEast.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanelEast);

        optionOneButtonEast = new JButton("Go back");
        optionOneButtonEast.setBackground(Color.black);
        optionOneButtonEast.setForeground(Color.black);
        optionOneButtonEast.setFont(smallFont);
        optionOneButtonEast.setFocusPainted(false);
        choiceButtonPanelEast.add(optionOneButtonEast);
        //optionOneButtonEast.addActionListener(tScreenOne);



        optionTwoButtonEast = new JButton("Look at to inspect an item");
        optionTwoButtonEast.setBackground(Color.black);
        optionTwoButtonEast.setForeground(Color.black);
        optionTwoButtonEast.setFont(smallFont);
        optionTwoButtonEast.setFocusPainted(false);
        choiceButtonPanelEast.add(optionTwoButtonEast);
        optionTwoButtonEast.addActionListener(lButton);

        optionThreeButtonEast = new JButton("Take/drop to pick up or drop an item");
        optionThreeButtonEast.setBackground(Color.black);
        optionThreeButtonEast.setForeground(Color.black);
        optionThreeButtonEast.setFont(smallFont);
        optionThreeButtonEast.setFocusPainted(false);
        choiceButtonPanelEast.add(optionThreeButtonEast);
        optionThreeButtonEast.addActionListener(tButton);

        optionFourButtonEast = new JButton("Quit");
        optionFourButtonEast.setBackground(Color.black);
        optionFourButtonEast.setForeground(Color.black);
        optionFourButtonEast.setFont(smallFont);
        optionFourButtonEast.setFocusPainted(false);
        choiceButtonPanelEast.add(optionFourButtonEast);
        optionFourButtonEast.addActionListener(new quitListener());


        initGame();
        playerSetup();

    }

    public void WestOption(){
        panelName.setVisible(false);
        startButtonPanel.setVisible(false);
        //splashTextPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);


        mainTextPanelWest = new JPanel();
        mainTextPanelWest.setBounds(100, 100, 600, 250);
        mainTextPanelWest.setBackground(Color.black);


        mainTextAreaWest = new JTextArea("You are in the Kitchen. You enter the dirty kitchen and are approached by a cat with what appears to be a key around its collar, you reach for it thinking it could be a key to a way out.  The cat runs out of arms distance. You look around the kitchen for anything to lure the cat back out, you see a knife, fish, and pan..Things here: sack bowl box");
        mainTextAreaWest.setBounds(100, 100, 600, 250);
        mainTextAreaWest.setBackground(Color.black);
        mainTextAreaWest.setForeground(Color.white);
        mainTextAreaWest.setFont(textFont);
        mainTextAreaWest.setLineWrap(true);

        mainTextPanelWest.add(mainTextAreaWest);
        con.add(mainTextPanelWest);

        choiceButtonPanelWest = new JPanel();
        choiceButtonPanelWest.setBounds(250, 350, 300, 150);
        choiceButtonPanelWest.setBackground(Color.black);
        choiceButtonPanelWest.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanelWest);

        optionOneButtonWest = new JButton("Go East");
        optionOneButtonWest.setBackground(Color.black);
        optionOneButtonWest.setForeground(Color.black);
        optionOneButtonWest.setFont(smallFont);
        optionOneButtonWest.setFocusPainted(false);
        choiceButtonPanelWest.add(optionOneButtonWest);
        optionOneButtonWest.addActionListener(eButton);
        optionOneButtonWest.addActionListener(ekScreen);



        optionTwoButtonWest = new JButton("Look at to inspect an item");
        optionTwoButtonWest.setBackground(Color.black);
        optionTwoButtonWest.setForeground(Color.black);
        optionTwoButtonWest.setFont(smallFont);
        optionTwoButtonWest.setFocusPainted(false);
        choiceButtonPanelWest.add(optionTwoButtonWest);
        optionTwoButtonWest.addActionListener(lButton);

        optionThreeButtonWest = new JButton("Take/drop to pick up or drop an item");
        optionThreeButtonWest.setBackground(Color.black);
        optionThreeButtonWest.setForeground(Color.black);
        optionThreeButtonWest.setFont(smallFont);
        optionThreeButtonWest.setFocusPainted(false);
        choiceButtonPanelWest.add(optionThreeButtonWest);
        optionThreeButtonWest.addActionListener(tButton);

        optionFourButtonWest = new JButton("Quit");
        optionFourButtonWest.setBackground(Color.black);
        optionFourButtonWest.setForeground(Color.black);
        optionFourButtonWest.setFont(smallFont);
        optionFourButtonWest.setFocusPainted(false);
        choiceButtonPanelWest.add(optionFourButtonWest);
        optionFourButtonWest.addActionListener(new quitListener());


        initGame();
        playerSetup();

    }

    public void EastOfKitchen(){
        panelName.setVisible(false);
        startButtonPanel.setVisible(false);
        //splashTextPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);


        mainTextPanelDinning = new JPanel();
        mainTextPanelDinning.setBounds(100, 100, 600, 250);
        mainTextPanelDinning.setBackground(Color.black);


        mainTextAreaDinning = new JTextArea("You are in the Library. You enter the library and notice a wall of bookshelves, they all appear to be dusty and covered in cobwebs besides one section that looks clean and has a book missing...Things here: paper pencil");
        mainTextAreaDinning.setBounds(100, 100, 600, 250);
        mainTextAreaDinning.setBackground(Color.black);
        mainTextAreaDinning.setForeground(Color.white);
        mainTextAreaDinning.setFont(textFont);
        mainTextAreaDinning.setLineWrap(true);

        mainTextPanelDinning.add(mainTextAreaDinning);
        con.add(mainTextPanelDinning);

        choiceButtonPanelDinning = new JPanel();
        choiceButtonPanelDinning.setBounds(250, 350, 300, 150);
        choiceButtonPanelDinning.setBackground(Color.black);
        choiceButtonPanelDinning.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanelDinning);

        optionOneButtonDinning = new JButton("Go North");
        optionOneButtonDinning.setBackground(Color.black);
        optionOneButtonDinning.setForeground(Color.black);
        optionOneButtonDinning.setFont(smallFont);
        optionOneButtonDinning.setFocusPainted(false);
        choiceButtonPanelDinning.add(optionOneButtonDinning);
        optionOneButtonDinning.addActionListener(nButton);



        optionTwoButtonDinning = new JButton("Look at to inspect an item");
        optionTwoButtonDinning.setBackground(Color.black);
        optionTwoButtonDinning.setForeground(Color.black);
        optionTwoButtonDinning.setFont(smallFont);
        optionTwoButtonDinning.setFocusPainted(false);
        choiceButtonPanelDinning.add(optionTwoButtonDinning);
        optionTwoButtonDinning.addActionListener(lButton);

        optionThreeButtonDinning = new JButton("Take/drop to pick up or drop an item");
        optionThreeButtonDinning.setBackground(Color.black);
        optionThreeButtonDinning.setForeground(Color.black);
        optionThreeButtonDinning.setFont(smallFont);
        optionThreeButtonDinning.setFocusPainted(false);
        choiceButtonPanelDinning.add(optionThreeButtonDinning);
        optionThreeButtonDinning.addActionListener(tButton);

        optionFourButtonDinning = new JButton("Quit");
        optionFourButtonDinning.setBackground(Color.black);
        optionFourButtonDinning.setForeground(Color.black);
        optionFourButtonDinning.setFont(smallFont);
        optionFourButtonDinning.setFocusPainted(false);
        choiceButtonPanelDinning.add(optionFourButtonDinning);
        optionFourButtonDinning.addActionListener(new quitListener());


        initGame();
        playerSetup();

    }
    //public void GameScreenTwo() {

    //    panelName.setVisible(false);
    //    startButtonPanel.setVisible(false);

    //    mainTextPanelTwo = new JPanel();
    //    mainTextPanelTwo.setBounds(100, 100, 600, 250);
    //    mainTextPanelTwo.setBackground(Color.black);


    //    mainTextAreaTwo = new JTextArea("");
    //    mainTextAreaTwo.setBounds(100, 100, 600, 250);
    //    mainTextAreaTwo.setBackground(Color.black);
    //    mainTextAreaTwo.setForeground(Color.white);
    //    mainTextAreaTwo.setFont(textFont);
    //    mainTextAreaTwo.setLineWrap(true);

    //    mainTextPanelTwo.add(mainTextAreaTwo);
    //    con.add(mainTextPanelTwo);

    //    choiceButtonPanelTwo = new JPanel();
    //    choiceButtonPanelTwo.setBounds(250, 350, 300, 150);
    //    choiceButtonPanelTwo.setBackground(Color.black);
    //    choiceButtonPanelTwo.setLayout(new GridLayout(4,1));
    //    con.add(choiceButtonPanelTwo);


    //    optionOneButtonTwo = new JButton("Enter: north, south, east, west, up, down to move areas");
    //    optionOneButtonTwo.setBackground(Color.black);
    //    optionOneButtonTwo.setForeground(Color.black);
    //    optionOneButtonTwo.setFont(smallFont);
    //    optionOneButtonTwo.setFocusPainted(false);
    //    choiceButtonPanelTwo.add(optionOneButton);
    //    optionOneButtonTwo.addActionListener(eButton);



    //    optionTwoButtonTwo = new JButton("Look at to inspect an item");
    //    optionTwoButtonTwo.setBackground(Color.black);
    //    optionTwoButtonTwo.setForeground(Color.black);
    //    optionTwoButtonTwo.setFont(smallFont);
    //    optionTwoButtonTwo.setFocusPainted(false);
    //    choiceButtonPanelTwo.add(optionTwoButton);
    //    optionTwoButtonTwo.addActionListener(lButton);

    //    optionThreeButtonTwo = new JButton("Take/drop to pick up or drop an item");
    //    optionThreeButtonTwo.setBackground(Color.black);
    //    optionThreeButtonTwo.setForeground(Color.black);
    //    optionThreeButtonTwo.setFont(smallFont);
    //    optionThreeButtonTwo.setFocusPainted(false);
    //    choiceButtonPanelTwo.add(optionThreeButton);
    //    optionThreeButtonTwo.addActionListener(tButton);

    //    optionFourButtonTwo = new JButton("Or quit");
    //    optionFourButtonTwo.setBackground(Color.black);
    //    optionFourButtonTwo.setForeground(Color.black);
    //    optionFourButtonTwo.setFont(smallFont);
    //    optionFourButtonTwo.setFocusPainted(false);
    //    choiceButtonPanelTwo.add(optionFourButton);
    //    optionFourButtonTwo.addActionListener(new quitListener());


    //    playerPanel = new JPanel();
    //    playerPanel.setBounds(100, 15, 600, 50);
    //    playerPanel.setBackground(Color.black);
    //    playerPanel.setLayout(new GridLayout(1, 4));
    //    con.add(playerPanel);

    //    hpLabel = new JLabel("HP:");
    //    hpLabel.setFont(normalFont);
    //    hpLabel.setForeground(Color.white);
    //    playerPanel.add(hpLabel);

    //    hpLabelNumber = new JLabel();
    //    hpLabelNumber.setFont(normalFont);
    //    hpLabelNumber.setForeground(Color.white);
    //    playerPanel.add(hpLabelNumber);

    //    weaponLabel = new JLabel("Weapon:");
    //    weaponLabel.setFont(normalFont);
    //    weaponLabel.setForeground(Color.white);
    //    playerPanel.add(weaponLabel);

    //    weaponLabelName = new JLabel();
    //    weaponLabelName.setFont(normalFont);
    //    weaponLabelName.setForeground(Color.white);
    //    playerPanel.add(weaponLabelName);


    //    playerSetup();
    //    frame.setVisible(true);

    //}

    private class quitListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public void playerSetup(){
        int playerHP = 20;
        String weapon = "Sword";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);
    }

    public class TitleScreenOne implements ActionListener {
        public void actionPerformed(ActionEvent event){
            GameScreenOne();
        }
    }

    public class NorthScreen implements ActionListener {
        public void actionPerformed(ActionEvent event){
            NorthOption();
        }
    }

    public class SouthScreen implements ActionListener {
        public void actionPerformed(ActionEvent event){
            SouthOption();
        }
    }

    public class EastScreen implements ActionListener {
        public void actionPerformed(ActionEvent event){
            EastOption();
        }
    }

    public class WestScreen implements ActionListener {
        public void actionPerformed(ActionEvent event){
            WestOption();
        }
    }

    public class EastOfKitchenScreen implements ActionListener {
        public void actionPerformed(ActionEvent event){
            EastOfKitchen();
        }
    }
    //public class TitleScreenTwo implements ActionListener {
    //    public void actionPerformed(ActionEvent event){
    //        GameScreenTwo();
    //    }
    //}

    public class LookButton implements ActionListener {
        public void actionPerformed(ActionEvent event){
            look();
        }
    }

    public class TakeButton implements ActionListener {
        public void actionPerformed(ActionEvent event){
            showInventory();
        }
    }

    public class NorthButton implements ActionListener {
        public void actionPerformed(ActionEvent event){
            goN();
        }
    }

    public class SouthButton implements ActionListener {
        public void actionPerformed(ActionEvent event){
            goS();
        }
    }

    public class EastOfKitchenButton implements ActionListener {
        public void actionPerformed(ActionEvent event){
            goE();
        }
    }

    public class EastButton implements ActionListener {
        public void actionPerformed(ActionEvent event){
            goE();
        }
    }

    public class WestButton implements ActionListener {
        public void actionPerformed(ActionEvent event){
            goW();
        }
    }
}