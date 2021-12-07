package test;

import java.awt.*;
import java.awt.event.MouseEvent;

public class HomeMenuController {
    private HomeMenuView homeMenuView;

    private boolean startClicked;
    private boolean exitClicked;
    private boolean infoClicked;

    private InfoPage infoPage;

    public HomeMenuController(HomeMenuView homeMenuView) {
        this.homeMenuView = homeMenuView;
    }

    public void isMouseClicked (MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuView.getStartButton().contains(p)){
            homeMenuView.getOwner().enableGameBoard();
        }
        else if(homeMenuView.getExitButton().contains(p)){
            System.out.println("Goodbye " + System.getProperty("user.name"));
            System.exit(0);
        }
        else if(homeMenuView.getInfoButton().contains(p)){
            infoPage = new InfoPage(homeMenuView.getOwner());
        }

    }

    public void isMousePressed (MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuView.getStartButton().contains(p)){
            startClicked = true;
            homeMenuView.repaintButton(homeMenuView.getStartButton());
        }
        else if(homeMenuView.getExitButton().contains(p)){
            exitClicked = true;
            homeMenuView.repaintButton(homeMenuView.getExitButton());
        }
        else if(homeMenuView.getInfoButton().contains(p)){
            infoClicked = true;
            homeMenuView.repaintButton(homeMenuView.getInfoButton());
        }
    }

    public void isMouseReleased (MouseEvent mouseEvent) {
        if(startClicked){
            startClicked = false;
            homeMenuView.repaintButton(homeMenuView.getStartButton());
        }
        else if(exitClicked){
            exitClicked = false;
            homeMenuView.repaintButton(homeMenuView.getExitButton());
        }
        else if(infoClicked){
            infoClicked = false;
            homeMenuView.repaintButton(homeMenuView.getInfoButton());
        }
    }

    public void isMouseMoved (MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuView.getStartButton().contains(p) || homeMenuView.getExitButton().contains(p) || homeMenuView.getInfoButton().contains(p))
            homeMenuView.setHandCursor();
        else
            homeMenuView.setDefaultCursor();
    }
}
