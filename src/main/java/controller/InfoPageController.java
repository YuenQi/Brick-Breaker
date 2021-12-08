package controller;

import model.InfoPageModel;
import view.InfoPageView;
import view.GameFrame;

import java.awt.event.ActionEvent;

public class InfoPageController {

    private InfoPageModel infoPageModel;
    private InfoPageView infoPageView;

    public InfoPageController(InfoPageModel infoPageModel, InfoPageView infoPageView){
        this.infoPageModel = infoPageModel;
        this.infoPageView = infoPageView;
    }

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
