package controller;

import view.HighScoreView;

import java.awt.event.ActionEvent;

/**
 * This is HighScoreController class which receives
 * an input from the user via the HighScoreView, then processes the user's data
 * and updates HighScoreView.
 */
public class HighScoreController {

    private HighScoreView highScoreView;

    /**
     * This is a constructor to initialise variable in HighScoreController class.
     * @param highScoreView HighScoreView object
     */
    public HighScoreController(HighScoreView highScoreView){
        this.highScoreView = highScoreView;
    }

    /**
     * This method terminates the program if user clicks the "Quit Game button".
     *
     * @param actionEvent a semantic event which indicates that a component-defined action occurred
     *          (generated when the button is clicked)
     */
    public void checkActionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == highScoreView.getQuitGameButton()){
            System.exit(0);
        }
    }
}
