package controller;

import model.GameBoardModel;
import view.GameBoardView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

//REFACTOR: MVC design pattern
/**
 * This is GameBoardController class which receives
 * an input from the user via the GameBoardView, then processes the user's data with
 * the help of GameBoardModel and updates GameBoardView.
 * MVC design pattern:
 * Basically, GameBoardView class will render the view,
 * GameBoardModel class consists of dumb entities (POJO) and
 * GameBoardController class is in charge of changing the state of GameBoardModel and notify the GameBoardView.
 * Listeners are inside GameBoardView class. When the listeners capture event,
 * they pass the events to GameBoardController class through GameBoardView class to handle action.
 */
public class GameBoardController {

    /**GameBoardModel object*/
    private GameBoardModel gameBoardModel;

    /**GameBoardView object*/
    private GameBoardView gameBoardView;

    /**
     * This is a constructor to initialise variables in GameBoardController class.
     * @param gameBoardModel GameBoardModel object
     * @param gameBoardView GameBoardView object
     */
    public GameBoardController(GameBoardModel gameBoardModel, GameBoardView gameBoardView){
        this.gameBoardModel = gameBoardModel;
        this.gameBoardView = gameBoardView;
    }

    /**
     * This method is used to define some actions performed if
     * a key has been pressed.
     * The actions are as followed:
     * 1. If 'A' is pressed, player bar will move to left.
     * 2. If 'D' is pressed, player bar will move to right.
     * 3. If 'ESC' is pressed, pause menu will be shown and timer will stop.
     * 4. If 'SPACE' is pressed, timer will stop if it is running and vice versa.
     * 5. If 'SHIFT', 'ALT' and 'F1' are pressed together, debug console will be shown.
     * 6. All other keys will only result in the player remaining static.
     *
     * @param keyEvent a low-level event which indicates that a keystroke occurred in a component
     *                  (generated by a component object (such as a text field) when a key is pressed, released, or typed)
     */
    public void checkKeyPressed(KeyEvent keyEvent){
        switch(keyEvent.getKeyCode()){
            case KeyEvent.VK_A:
                gameBoardModel.getWall().getPlayer().moveLeft();
                break;
            case KeyEvent.VK_D:
                gameBoardModel.getWall().getPlayer().moveRight();
                break;
            case KeyEvent.VK_ESCAPE:
                gameBoardModel.setShowPauseMenu(!gameBoardModel.isShowPauseMenu());
                gameBoardModel.getGameTimer().setGaming(false);
                gameBoardView.repaintGameBoard();
                gameBoardModel.getTimer().stop();
                break;
            case KeyEvent.VK_SPACE:
                if(!gameBoardModel.isShowPauseMenu())
                    if(gameBoardModel.getTimer().isRunning()) {
                        gameBoardModel.getTimer().stop();
                        gameBoardModel.getGameTimer().setGaming(false);
                    }
                    else
                        gameBoardModel.getTimer().start();
                break;
            case KeyEvent.VK_F1:
                if(keyEvent.isAltDown() && keyEvent.isShiftDown())
                    gameBoardModel.getDebugConsole().setVisible(true);
            default:
                gameBoardModel.getWall().getPlayer().stop();
        }
    }

    /**
     * This method is used to define some actions performed when
     * the mouse button has been clicked (pressed and released) on this component.
     * The actions are as followed:
     * 1. If the mouse button has been clicked but the showPauseMenu variable is false,
     * nothing happens.
     * 2. If the mouse button clicks on the so-called "Continue button", repaint game board.
     * 3. If the mouse button clicks on the so-called "Restart button", reset timer, ball and wall
     * and repaint the game board.
     * 4. If the mouse button clicks on the so-called "Exit button", terminates this program.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    public void checkMouseClicked(MouseEvent mouseEvent){
        Point p = mouseEvent.getPoint();
        if(!gameBoardModel.isShowPauseMenu())
            return;
        if(gameBoardModel.getContinueButtonRect().contains(p)){
            gameBoardModel.setShowPauseMenu(false);
            gameBoardView.repaintGameBoard();
        }
        else if(gameBoardModel.getRestartButtonRect().contains(p)){
            gameBoardModel.setMessage("Restarting Game...");
            gameBoardModel.getGameTimer().resetTimer();
            gameBoardModel.getWall().ballReset();
            gameBoardModel.getWall().wallReset();
            gameBoardModel.setShowPauseMenu(false);
            gameBoardView.repaintGameBoard();
        }
        else if(gameBoardModel.getExitButtonRect().contains(p)){
            System.exit(0);
        }
    }

    /**
     * This method is used to define some actions performed when
     * the mouse cursor has been moved onto this component but no buttons have been pushed.
     * If the so-called "Exit button" exists and showPauseMenu is true (pause menu screen is shown),
     * when mouse cursor move to the so-called "Exit button", "Continue button" or "Restart button",
     * set the cursor image to hand cursor, otherwise, set the cursor image as the default cursor.
     * If the so-called "Exit button" does not exist or showPauseMenu is false,
     * set the cursor image as the default cursor.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    public void checkMouseMoved(MouseEvent mouseEvent){
        Point p = mouseEvent.getPoint();
        if(gameBoardModel.getExitButtonRect() != null && gameBoardModel.isShowPauseMenu()) {
            if (gameBoardModel.getExitButtonRect().contains(p) || gameBoardModel.getContinueButtonRect().contains(p) || gameBoardModel.getRestartButtonRect().contains(p))
                gameBoardView.setHandCursor();
            else
                gameBoardView.setDefaultCursor();
        }
        else{
            gameBoardView.setDefaultCursor();
        }
    }
}
