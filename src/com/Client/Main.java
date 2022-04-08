package com.Client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.Client.BackgroundMusic;
import org.json.simple.parser.ParseException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

    static Game game;
    //static BackgroundMusic bg = new BackgroundMusic();

    private static void saveGame() { // writes to Ehouse.sav
        try {
            FileOutputStream fos = new FileOutputStream("Ehouse.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game); // game
            oos.flush(); // write out any buffered bytes
            oos.close();
            System.out.print("Game saved\n");
        } catch (Exception e) {
            System.out.print("Serialization Error! Can't save data.\n"
                    + e.getClass() + ": " + e.getMessage() + "\n");
        }
    }

    private static void loadGame() {
        try {
            FileInputStream fis = new FileInputStream("Ehouse.sav"); // load from Ehouse.sav
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
            //bg.playSound();  //play music
            ois.close();
            System.out.print("\n---Game loaded---\n");
        } catch (Exception e) {
            System.out.print("Serialization Error! Can't load data.\n");
            System.out.print(e.getClass() + ": " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, ParseException {
        BufferedReader in;
        String input;
        String output = "";
// correcting previous commit

        game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.GUI();
        do {
            System.out.print("> ");
            input = in.readLine();
            switch (input) {
                case "save":
                    saveGame();
                    break;
                case "load":
                    loadGame();
                    break;
                default:
                    output = game.runCommand(input);
                    break;
            }
            if (!output.trim().isEmpty()) {
                game.showStr(output);
            }
        } while (!"quit".equals(input));
    }


}
