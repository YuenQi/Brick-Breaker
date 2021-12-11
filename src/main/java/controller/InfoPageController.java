package controller;

import model.InfoPageModel;
import view.InfoPageView;
import view.GameFrame;

import java.awt.event.ActionEvent;

/**
 * This is InfoPageController class which receives
 * an input from the user via the InfoPageView, then processes the user's data with
 * the help of InfoPageModel and updates InfoPageView.
 */
public class InfoPageController {

    private InfoPageModel infoPageModel;
    private InfoPageView infoPageView;

    /**
     * This is a constructor to initialise variables in InfoPageController class.
     * @param infoPageModel InfoPageModel object
     * @param infoPageView InfoPageView object
     */
    public InfoPageController(InfoPageModel infoPageModel, InfoPageView infoPageView){
        this.infoPageModel = infoPageModel;
        this.infoPageView = infoPageView;
    }

    /**
     * If user clicks the start button, the info page frame will be disposed
     * and enableGameBoard method in GameFrame class will be called to
     * display the game board.
     * If user clicks the back button, this frame will be disposed too and GameFrame object will be created.
     *
     * @param actionEvent a semantic event which indicates that a component-defined action occurred
     *          (generated when the button is clicked)
     */
    public void isActionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == infoPageModel.getStartButton()){
            infoPageView.dispose();
            infoPageModel.getOwner().enableGameBoard();
        } else if(actionEvent.getSource() == infoPageModel.getBackButton()){
            infoPageView.dispose();
            new GameFrame();
        }
    }
}
