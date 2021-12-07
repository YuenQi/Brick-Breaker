package test;

import java.awt.*;
import java.awt.event.MouseEvent;

public class HomeMenuController {

    private HomeMenuView homeMenuView;
    private HomeMenuModel homeMenuModel;

    private InfoPageView infoPageView;

    public HomeMenuController(HomeMenuModel homeMenuModel, HomeMenuView homeMenuView) {
        this.homeMenuModel = homeMenuModel;
        this.homeMenuView = homeMenuView;
    }

    public void isMouseClicked (MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p)){
            homeMenuModel.getOwner().enableGameBoard();
        }
        else if(homeMenuModel.getExitButton().contains(p)){
            System.out.println("Goodbye " + System.getProperty("user.name"));
            System.exit(0);
        }
        else if(homeMenuModel.getInfoButton().contains(p)){
            infoPageView = new InfoPageView(homeMenuModel.getOwner());
        }
    }

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

    public void checkMouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(homeMenuModel.getStartButton().contains(p) || homeMenuModel.getExitButton().contains(p) || homeMenuModel.getInfoButton().contains(p))
            homeMenuView.setHandCursor();
        else
            homeMenuView.setDefaultCursor();
    }
}
