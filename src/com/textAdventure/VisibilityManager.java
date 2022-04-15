package com.textAdventure;

public class VisibilityManager{

    UI ui;

    public VisibilityManager(UI userInterface){

        ui = userInterface;

    }

    public void showTitleScreen(){

        //SHOW TITLE SCREEN
        ui.titleNamePanel.setVisible(true);
        ui.startPanel.setVisible(true);

        //HIDE THE GAME SCREEN
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.directionButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.gameInfoButtonPanel.setVisible(false);

    }

    public void titleToEnterHome(){

        //Hide TITLE SCREEN
        ui.titleNamePanel.setVisible(false);
        ui.startPanel.setVisible(false);

        //SHOW THE GAME SCREEN
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.directionButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        ui.gameInfoButtonPanel.setVisible(false);

    }

    public void showGameInfo(){

        //Hide TITLE SCREEN
        ui.titleNamePanel.setVisible(false);
        ui.startPanel.setVisible(false);

        //SHOW THE GAME SCREEN
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);
        ui.directionButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.gameInfoButtonPanel.setVisible(true);
    }

    //OPEN CLOSE: MENU, BATTLE SCREEN
}

