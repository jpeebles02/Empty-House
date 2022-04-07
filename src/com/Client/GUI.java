package com.Client;

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

public class GUI {

    JFrame frame;
    Container con;
    JPanel panelName, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel labelName, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font fontTitle = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font textFont = new Font("Times New Roman", Font.PLAIN, 24);
    JButton startButton, optionOneButton, optionTwoButton, optionThreeButton, optionFourButton;
    JTextArea mainTextArea;
    TitleScreen tScreen = new TitleScreen();

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

        con.add(panelName);
        con.add(startButtonPanel);
        //Creating the MenuBar and adding components
    }

    public void GameScreen() {

        panelName.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("It’s Halloween night, your friend invites you to an abandoned house to explore. After some convincing you decide to go in, as you enter the door slams shut behind you. You and your   friend realize it is now locked and decide to split up to try     and find another way out. He decides to go upstairs to look       around, where would you like to go on the ground floor?");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(textFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        optionOneButton = new JButton("Option 1");
        optionOneButton.setBackground(Color.black);
        optionOneButton.setForeground(Color.black);
        optionOneButton.setFont(normalFont);
        optionOneButton.setFocusPainted(false);
        choiceButtonPanel.add(optionOneButton);


        optionTwoButton = new JButton("Option 2");
        optionTwoButton.setBackground(Color.black);
        optionTwoButton.setForeground(Color.black);
        optionTwoButton.setFont(normalFont);
        optionTwoButton.setFocusPainted(false);
        choiceButtonPanel.add(optionTwoButton);

        optionThreeButton = new JButton("Option 3");
        optionThreeButton.setBackground(Color.black);
        optionThreeButton.setForeground(Color.black);
        optionThreeButton.setFont(normalFont);
        optionThreeButton.setFocusPainted(false);
        choiceButtonPanel.add(optionThreeButton);

        optionFourButton = new JButton("Option 4");
        optionFourButton.setBackground(Color.black);
        optionFourButton.setForeground(Color.black);
        optionFourButton.setFont(normalFont);
        optionFourButton.setFocusPainted(false);
        choiceButtonPanel.add(optionFourButton);

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

}