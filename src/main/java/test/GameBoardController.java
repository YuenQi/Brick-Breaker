package test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameBoardController {

    private GameBoardView gameBoardView;

    public GameBoardController(GameBoardView gameBoardView){
        this.gameBoardView = gameBoardView;
    }

    public void checkKeyPressed(KeyEvent keyEvent){
        switch(keyEvent.getKeyCode()){
            case KeyEvent.VK_A:
                gameBoardView.getWall().getPlayer().moveLeft();
                break;
            case KeyEvent.VK_D:
                gameBoardView.getWall().getPlayer().moveRight();
                break;
            case KeyEvent.VK_ESCAPE:
                gameBoardView.setShowPauseMenu(!gameBoardView.isShowPauseMenu());
                gameBoardView.getTimer().setGaming(false);
                gameBoardView.repaintGameBoard();
                gameBoardView.getGameTimer().stop();
                break;
            case KeyEvent.VK_SPACE:
                if(!gameBoardView.isShowPauseMenu())
                    if(gameBoardView.getGameTimer().isRunning()) {
                        gameBoardView.getGameTimer().stop();
                        gameBoardView.getTimer().setGaming(false);
                    }
                    else
                        gameBoardView.getGameTimer().start();
                break;
            case KeyEvent.VK_F1:
                if(keyEvent.isAltDown() && keyEvent.isShiftDown())
                    gameBoardView.getDebugConsole().setVisible(true);
            default:
                gameBoardView.getWall().getPlayer().stop();
        }
    }

    public void checkMouseClicked(MouseEvent mouseEvent){
        Point p = mouseEvent.getPoint();
        if(!gameBoardView.isShowPauseMenu())
            return;
        if(gameBoardView.getContinueButtonRect().contains(p)){
            gameBoardView.setShowPauseMenu(false);
            gameBoardView.repaintGameBoard();
        }
        else if(gameBoardView.getRestartButtonRect().contains(p)){
            gameBoardView.setMessage("Restarting Game...");
            gameBoardView.getTimer().resetTimer();
            gameBoardView.getWall().ballReset();
            gameBoardView.getWall().wallReset();
            gameBoardView.setShowPauseMenu(false);
            gameBoardView.repaintGameBoard();
        }
        else if(gameBoardView.getExitButtonRect().contains(p)){
            System.exit(0);
        }
    }

    public void checkMouseMoved(MouseEvent mouseEvent){
        Point p = mouseEvent.getPoint();
        if(gameBoardView.getExitButtonRect() != null && gameBoardView.isShowPauseMenu()) {
            if (gameBoardView.getExitButtonRect().contains(p) || gameBoardView.getContinueButtonRect().contains(p) || gameBoardView.getRestartButtonRect().contains(p))
                gameBoardView.setHandCursor();
            else
                gameBoardView.setDefaultCursor();
        }
        else{
            gameBoardView.setDefaultCursor();
        }
    }
}
