package controller;

import model.HomeMenuModel;
import model.InfoPageModel;
import view.HomeMenuView;
import view.InfoPageView;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This is HomeMenuController class which receives
 * an input from the user via the HomeMenuView, then processes the user's data with
 * the help of HomeMenuModel and updates HomeMenuView.
 */
public class HomeMenuController {

    private HomeMenuView homeMenuView;
    private HomeMenuModel homeMenuModel;

    private InfoPageView infoPageView;
    private InfoPageModel infoPageModel;

    /**
     * This is a constructor to initialise some variables in HomeMenuController class.
     * @param homeMenuModel HomeMenuModel object
     * @param homeMenuView HomeMenuView object
     */
    public HomeMenuController(HomeMenuModel homeMenuModel, HomeMenuView homeMenuView) {
        this.homeMenuModel = homeMenuModel;
        this.homeMenuView = homeMenuView;
    }

    /**
     * This method is used to define some actions performed when
     * the mouse button has been clicked (pressed and released) on this component.
     * The actions are as followed:
     * 1. If the mouse button clicks on the so-called "Start button", display game board.
     * 2. If the mouse button clicks on the so-called "Exit button", terminates this program.
     * 3. If the mouse button clicks on the so-called "Info button", display the InfoPageView Window.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    public void checkMouseClicked(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p)){
            homeMenuModel.getOwner().enableGameBoard();
        }
        else if(homeMenuModel.getExitButton().contains(p)){
            System.out.println("Goodbye " + System.getProperty("user.name"));
            System.exit(0);
        }
        else if(homeMenuModel.getInfoButton().contains(p)){
            infoPageModel = new InfoPageModel(homeMenuModel.getOwner());
            infoPageView = new InfoPageView(infoPageModel);
        }
    }

    /**
     * This method is used to define some actions performed when
     * the mouse button has been pressed on this component.
     * The actions are as followed:
     * 1. If the mouse button clicks on the so-called "Start button", repaint the start button.
     * 2. If the mouse button clicks on the so-called "Exit button", repaint the exit button.
     * 3. If the mouse button clicks on the so-called "Info button", repaint the info button.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    public void checkMousePressed(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p)){
            homeMenuModel.setStartClicked(true);
            homeMenuView.repaintButton(homeMenuModel.getStartButton());
        }
        else if(homeMenuModel.getExitButton().contains(p)){
            homeMenuModel.setExitClicked(true);
            homeMenuView.repaintButton(homeMenuModel.getExitButton());
        }
        else if(homeMenuModel.getInfoButton().contains(p)){
            homeMenuModel.setInfoClicked(true);
            homeMenuView.repaintButton(homeMenuModel.getInfoButton());
        }
    }

    /**
     * This method is used to define some actions performed when
     * the mouse button has been released on this component.
     * The actions are as followed:
     * 1. If the mouse button clicks on the so-called "Start button", repaint the start button.
     * 2. If the mouse button clicks on the so-called "Exit button", repaint the exit button.
     * 3. If the mouse button clicks on the so-called "Info button", repaint the info button.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    public void checkMouseReleased(MouseEvent mouseEvent) {
        if(homeMenuModel.isStartClicked()){
            homeMenuModel.setStartClicked(false);
            homeMenuView.repaintButton(homeMenuModel.getStartButton());
        }
        else if(homeMenuModel.isExitClicked()){
            homeMenuModel.setExitClicked(false);
            homeMenuView.repaintButton(homeMenuModel.getExitButton());
        }
        else if(homeMenuModel.isInfoClicked()){
            homeMenuModel.setInfoClicked(false);
            homeMenuView.repaintButton(homeMenuModel.getInfoButton());
        }
    }

    /**
     * This method is used to define some actions performed when
     * the mouse cursor has been moved onto this component but no buttons have been pushed.
     * When mouse cursor move to the so-called "Start button", "Exit button" ot "Info button",
     * set the cursor image to hand cursor, otherwise, set the cursor image as the default cursor.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    public void checkMouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p) || homeMenuModel.getExitButton().contains(p) || homeMenuModel.getInfoButton().contains(p))
            homeMenuView.setHandCursor();
        else
            homeMenuView.setDefaultCursor();
    }
}
