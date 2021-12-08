package controller;

import model.GameBoardModel;
import view.GameBoardView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameBoardController {

    private GameBoardModel gameBoardModel;
    private GameBoardView gameBoardView;

    public GameBoardController(GameBoardModel gameBoardModel, GameBoardView gameBoardView){
        this.gameBoardModel = gameBoardModel;
        this.gameBoardView = gameBoardView;
    }

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
