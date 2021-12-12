package controller;

import model.InfoPageModel;
import view.InfoPageView;
import view.GameFrame;

import java.awt.event.ActionEvent;

//REFACTOR: MVC design pattern
/**
 * This is InfoPageController class which receives
 * an input from the user via the InfoPageView, then processes the user's data with
 * the help of InfoPageModel and updates InfoPageView.
 * MVC design pattern:
 * Basically, InfoPageView class will render the view,
 * InfoPageModel class consists of dumb entities (POJO) and
 * InfoPageController class is in charge of changing the InfoPageModel’s state and notify the InfoPageView.
 * ActionListener is inside InfoPageView class. When the listener captures event,
 * it passes the events to InfoPageController class through InfoPageView class to handle action.
 */
public class InfoPageController {

    /**InfoPageModel object*/
    private InfoPageModel infoPageModel;

    /**InfoPageView object*/
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
