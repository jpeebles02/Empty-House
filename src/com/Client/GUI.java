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
    JPanel panelName, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, splashTextPanel;
    JLabel labelName, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font fontTitle = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font textFont = new Font("Times New Roman", Font.PLAIN, 24);
    Font smallFont = new Font("Times New Roman", Font.PLAIN, 12);
    Font tinyFont = new Font("Times New Roman", Font.PLAIN, 6);
    JButton startButton, optionOneButton, optionTwoButton, optionThreeButton, optionFourButton;
    JTextArea mainTextArea, splashTextArea;
    TitleScreen tScreen = new TitleScreen();
    LookButton lButton = new LookButton();

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
        startButton.addActionListener(tScreen);
        startButton.setFocusPainted(false);

        panelName.add(labelName);
        startButtonPanel.add(startButton);
        //splashTextPanel.add(splashTextArea);

        con.add(panelName);
        con.add(startButtonPanel);
        //con.add(splashTextPanel);
        //Creating the MenuBar and adding components
        frame.setVisible(true);
    }


    public void GameScreen() {

        panelName.setVisible(false);
        startButtonPanel.setVisible(false);

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
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        optionOneButton = new JButton("Enter: north, south, east, west, up, down to move areas");
        optionOneButton.setBackground(Color.black);
        optionOneButton.setForeground(Color.black);
        optionOneButton.setFont(smallFont);
        optionOneButton.setFocusPainted(false);
        choiceButtonPanel.add(optionOneButton);
        startButton.addActionListener(tScreen);


        optionTwoButton = new JButton("Look at to inspect an item");
        optionTwoButton.setBackground(Color.black);
        optionTwoButton.setForeground(Color.black);
        optionTwoButton.setFont(smallFont);
        optionTwoButton.setFocusPainted(false);
        choiceButtonPanel.add(optionTwoButton);
        optionTwoButton.addActionListener(lButton);

        optionThreeButton = new JButton("Take/drop to pick up or drop an item");
        optionThreeButton.setBackground(Color.black);
        optionThreeButton.setForeground(Color.black);
        optionThreeButton.setFont(smallFont);
        optionThreeButton.setFocusPainted(false);
        choiceButtonPanel.add(optionThreeButton);

        optionFourButton = new JButton("Or quit");
        optionFourButton.setBackground(Color.black);
        optionFourButton.setForeground(Color.black);
        optionFourButton.setFont(smallFont);
        optionFourButton.setFocusPainted(false);
        choiceButtonPanel.add(optionFourButton);
        optionFourButton.addActionListener(new quitListener());


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

    private class quitListener implements ActionListener{
        @Override
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

    public class TitleScreen implements ActionListener {
        public void actionPerformed(ActionEvent event){
            GameScreen();
        }
    }

    public class LookButton implements ActionListener {
        public void actionPerformed(ActionEvent event){
            look();
        }
    }

}