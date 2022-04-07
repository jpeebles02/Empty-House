package com.Client;


import javax.sound.sampled.*;
import java.io.*;

import static com.Client.Game.playAudio;

public class Main {

    static Game game;

    private static void saveGame() { // writes to Ehouse.sav
        try {
            FileOutputStream fos = new FileOutputStream("Ehouse.sav");
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
            game = (Game) ois.readObject();//play music
            ois.close();
            System.out.print("\n---Game loaded---\n");
        } catch (Exception e) {
            System.out.print("Serialization Error! Can't load data.\n");
            System.out.print(e.getClass() + ": " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        BufferedReader in;
        String input;
        String output;
// correcting previous commit

        game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.showIntro();
        do {
            System.out.println("1) Save game\n" + "2) Load game\n" + "3) Play background music\n" + "4) Stop background music\n");
            System.out.print("Enter your command >\n\n");
            input = in.readLine();
            output = "";
            switch (input) {
                case "1" -> saveGame();
                case "2" -> loadGame();
                case "3" -> playAudio();
                case "4" -> game.stopAudio();
                default -> output = game.runCommand(input);
            }
            System.out.println(output);
        } while (!"quit".equals(input));
    }

}


