package com.textAdventure;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class UI {
    JFrame window;
    JPanel titleNamePanel, startPanel, mainTextPanel, choiceButtonPanel, directionButtonPanel, playerPanel, gameInfoButtonPanel, musicPanel;
    JLabel titleNameLabel, healthLabel, healthNumberLabel, inventoryLabel, inventoryNameLabel;
    JButton startButton, gameInfoButton, choice1, choice2, choice3, choice4, north, south, east, west, gameInfo1, gameInfo2, gameInfo3, gameInfo4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);

    public void createUI(Game.ChoiceHandler cHandler){

        //WINDOW
        window = new JFrame();
        window.setSize(850,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        //TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(140, 100, 615, 200);
        titleNamePanel.setBackground(Color.black);

        ImageIcon titleIcon = new ImageIcon("splashlogo.gif");
        titleNameLabel = new JLabel(titleIcon);
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startPanel = new JPanel();
        startPanel.setBounds(250, 350, 380, 100);
        startPanel.setLayout(new GridLayout(2,1));
        startPanel.setBackground(Color.black);
        window.add(startPanel);
        window.add(startPanel, BorderLayout.SOUTH);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startPanel.add(startButton);
        startButton.addActionListener((ActionEvent e) -> {
            try {
                cHandler.buttonSound();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        });

        gameInfoButton = new JButton("GAME SETTINGS");
        gameInfoButton.setBackground(Color.black);
        gameInfoButton.setForeground(Color.black);
        gameInfoButton.setFont(normalFont);
        gameInfoButton.setFocusPainted(false);
        gameInfoButton.addActionListener(cHandler);
        gameInfoButton.setActionCommand("gameInfo");
        startPanel.add(gameInfoButton);
        gameInfoButton.addActionListener((ActionEvent e) -> {
            try {
                cHandler.buttonSound();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        });

        window.add(titleNamePanel);
        window.add(startPanel);

        musicPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        musicPanel.setBounds(20, 10, 50, 115);
        musicPanel.setBackground(Color.black);
        window.add(musicPanel);

        // Buttons to start/stop background music
        ImageIcon playIcon = new ImageIcon("play.png");
        JButton playMusicButton = new JButton(playIcon);
        playMusicButton.setBorderPainted(false);
        playMusicButton.setContentAreaFilled(false);
        playMusicButton.setFocusPainted(false);
        playMusicButton.setOpaque(false);
        musicPanel.add(playMusicButton);
        playMusicButton.addActionListener((ActionEvent e) -> {
            try {
                cHandler.playAudio();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        });

        ImageIcon stopIcon = new ImageIcon("stop.png");
        JButton stopMusicButton = new JButton(stopIcon);
        stopMusicButton.setBorderPainted(false);
        stopMusicButton.setContentAreaFilled(false);
        stopMusicButton.setFocusPainted(false);
        stopMusicButton.setOpaque(false);
        musicPanel.add(stopMusicButton);
        stopMusicButton.addActionListener((ActionEvent e) -> {
            try {
                cHandler.stopAudio();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        });


        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);;
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(100,350,275,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtonPanel);


        gameInfoButtonPanel = new JPanel();
        gameInfoButtonPanel.setBounds(250,350,300,150);
        gameInfoButtonPanel.setBackground(Color.black);
        gameInfoButtonPanel.setLayout(new GridLayout(4,1));
        window.add(gameInfoButtonPanel);

        //CHOICE 1
        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice1.addActionListener((ActionEvent e) -> {
            try {
                cHandler.buttonSound();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        });
//        CHOICE 2
        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice2.addActionListener((ActionEvent e) -> {
            try {
                cHandler.buttonSound();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        });
        //CHOICE 3
        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.black);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice3.addActionListener((ActionEvent e) -> {
            try {
                cHandler.buttonSound();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        });
        //CHOICE 4
        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.black);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        choice4.addActionListener((ActionEvent e) -> {
            try {
                cHandler.buttonSound();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        });

        gameInfo1 = new JButton("gameInfo1");
        gameInfo1.setBackground(Color.black);
        gameInfo1.setForeground(Color.black);
        gameInfo1.setFont(normalFont);
        gameInfo1.setFocusPainted(false);
        gameInfo1.addActionListener(cHandler);
        gameInfo1.setActionCommand("g1");
        gameInfoButtonPanel.add(gameInfo1);

        gameInfo2 = new JButton("gameInfo2");
        gameInfo2.setBackground(Color.black);
        gameInfo2.setForeground(Color.black);
        gameInfo2.setFont(normalFont);
        gameInfo2.setFocusPainted(false);
        gameInfo2.addActionListener(cHandler);
        gameInfo2.setActionCommand("g2");
        gameInfoButtonPanel.add(gameInfo2);

        //Load
        gameInfo3 = new JButton("gameInfo3");
        gameInfo3.setBackground(Color.black);
        gameInfo3.setForeground(Color.black);
        gameInfo3.setFont(normalFont);
        gameInfo3.setFocusPainted(false);
        gameInfo3.addActionListener(cHandler);
        gameInfo3.setActionCommand("g3");
        gameInfoButtonPanel.add(gameInfo3);

        //Save
        gameInfo4 = new JButton("gameInfo4");
        gameInfo4.setBackground(Color.black);
        gameInfo4.setForeground(Color.black);
        gameInfo4.setFont(normalFont);
        gameInfo4.setFocusPainted(false);
        gameInfo4.addActionListener(cHandler);
        gameInfo4.setActionCommand("g4");
        gameInfoButtonPanel.add(gameInfo4);


        directionButtonPanel = new JPanel();
        directionButtonPanel.setBounds(425,350,275,150);
        directionButtonPanel.setBackground(Color.black);
        directionButtonPanel.setLayout(new GridLayout(4,1));
        window.add(directionButtonPanel);
        //CHOICE 1
        north = new JButton("north");
        north.setBackground(Color.black);
        north.setForeground(Color.black);
        north.setFont(normalFont);
        north.setFocusPainted(false);
        north.addActionListener(cHandler);
        north.setActionCommand("n");
        directionButtonPanel.add(north);
//        SOUTH
        south = new JButton("south");
        south.setBackground(Color.black);
        south.setForeground(Color.black);
        south.setFont(normalFont);
        south.setFocusPainted(false);
        south.addActionListener(cHandler);
        south.setActionCommand("s");
        directionButtonPanel.add(south);
        //EAST
        east = new JButton("east");
        east.setBackground(Color.black);
        east.setForeground(Color.black);
        east.setFont(normalFont);
        east.setFocusPainted(false);
        east.addActionListener(cHandler);
        east.setActionCommand("e");
        directionButtonPanel.add(east);
        //WEST
        west = new JButton("west");
        west.setBackground(Color.black);
        west.setForeground(Color.black);
        west.setFont(normalFont);
        west.setFocusPainted(false);
        west.addActionListener(cHandler);
        west.setActionCommand("w");
        directionButtonPanel.add(west);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        window.add(playerPanel);

        healthLabel = new JLabel("Health:");
        healthLabel.setFont(normalFont);
        healthLabel.setForeground(Color.white);
        playerPanel.add(healthLabel);
        healthNumberLabel =  new JLabel();
        healthNumberLabel.setForeground(Color.white);
        healthNumberLabel.setFont(normalFont);
        playerPanel.add(healthNumberLabel);
        inventoryLabel = new JLabel("Inventory:");
        inventoryLabel.setForeground(Color.white);
        inventoryLabel.setFont(normalFont);
        playerPanel.add(inventoryLabel);
        inventoryNameLabel = new JLabel();
        inventoryNameLabel.setForeground(Color.white);
        inventoryNameLabel.setFont(normalFont);
        playerPanel.add(inventoryNameLabel);

        window.setVisible(true);
    }

}
