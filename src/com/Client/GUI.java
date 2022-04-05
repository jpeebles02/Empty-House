package com.Client;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Font;

public class GUI {

    JFrame frame;
    Container con;
    JPanel panelName;
    JLabel labelName;
    Font fontTitle = new Font("Times New Roman", Font.PLAIN, 90);

    public static void main (String args[]) {
        new GUI();
    }

    public GUI() {

        frame = new JFrame("Empty_House");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setVisible(true);
        con = frame.getContentPane();

        panelName = new JPanel();
        panelName.setBounds(100, 100, 600, 150);
        panelName.setBackground(Color.orange);

        labelName = new JLabel("Empty_House");
        labelName.setForeground(Color.white);
        labelName.setFont(fontTitle);

        panelName.add(labelName);
        con.add(panelName);
        //Creating the MenuBar and adding components

    }
}