package test;

import java.awt.event.ActionEvent;

public class InfoPageController {

    private InfoPageView infoPageView;

    public InfoPageController(InfoPageView infoPageView){
        this.infoPageView = infoPageView;
    }

    public void isActionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == infoPageView.getStartButton()){
            infoPageView.dispose();
            infoPageView.getOwner().enableGameBoard();
        } else if(actionEvent.getSource() == infoPageView.getBackButton()){
            infoPageView.dispose();
            new GameFrame();
        }
    }
}
