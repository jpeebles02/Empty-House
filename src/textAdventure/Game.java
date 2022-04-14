package textAdventure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
}
