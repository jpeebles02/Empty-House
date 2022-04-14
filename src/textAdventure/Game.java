package com.textAdventure;

import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    String nextDirection1, nextDirection2, nextDirection3, nextDirection4;


    public static void main(String[] args) {
        new Game();
    }

    public Game(){

        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "start": vm.titleToEnterHome(); story.intro(); break;
                case "gameInfo": vm.showGameInfo(); story.gameInfo();break;
                case "c1": story.selectPosition(nextPosition1);break;
                case "c2": story.selectPosition(nextPosition2);break;
                case "g1": story.selectPosition(nextPosition1);break;
                case "g2": story.selectPosition(nextPosition2);break;
                case "c3": story.selectPosition(nextPosition3);break;
                case "c4": story.selectPosition(nextPosition4);break;
                case "n": story.selectDirection(nextDirection1);break;
                case "s": story.selectDirection(nextDirection2);break;
                case "e": story.selectDirection(nextDirection3);break;
                case "w": story.selectDirection(nextDirection4);break;
            }

        }
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
        // Sound effect for buttons when clicked
        Clip clip2;

        public void buttonSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
            File sound = new File("./resources/pop.wav");
            AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(sound);
            clip2 = AudioSystem.getClip();
            clip2.open(audioStream2);
            clip2.start();
            clip2.flush();
        }


    }
}
