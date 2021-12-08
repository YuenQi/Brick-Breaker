package controller;

import view.HighScoreView;

import java.awt.event.ActionEvent;

public class HighScoreController {

    private HighScoreView highScoreView;

    public HighScoreController(HighScoreView highScoreView){
        this.highScoreView = highScoreView;
    }

    public void checkActionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == highScoreView.getQuitGameButton()){
            System.exit(0);
        }
    }
}
