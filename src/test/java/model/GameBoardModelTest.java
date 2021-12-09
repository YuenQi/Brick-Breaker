package model;

import org.junit.jupiter.api.Test;
import view.GameFrame;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardModelTest {

    GameBoardModel gameBoardModel = new GameBoardModel(new GameFrame());

    @Test
    public void setAndGetMessageTest() {
        gameBoardModel.setMessage("Bricks: 31 Balls 3");
        assertEquals("Bricks: 31 Balls 3",gameBoardModel.getMessage());
    }

    @Test
    public void setAndGetScoreMessageTest() {
        gameBoardModel.setScoreMessage("Score: 0");
        assertEquals("Score: 0",gameBoardModel.getScoreMessage());
    }

    @Test
    public void setAndGetHighScoreMessageTest() {
        gameBoardModel.setHighScoreMessage("High Score Record: Yuen Qi:30");
        assertEquals("High Score Record: Yuen Qi:30",gameBoardModel.getHighScoreMessage());
    }

    @Test
    public void setAndGetTimeMessageTest() {
        gameBoardModel.setTimeMessage("Time: 00 minute(s) 30 second(s)");
        assertEquals("Time: 00 minute(s) 30 second(s)",gameBoardModel.getTimeMessage());
    }

    @Test
    public void setAndGetShowPauseMenuTest() {
        gameBoardModel.setShowPauseMenu(false);
        assertEquals(false,gameBoardModel.isShowPauseMenu());
        gameBoardModel.setShowPauseMenu(true);
        assertEquals(true,gameBoardModel.isShowPauseMenu());
    }

    @Test
    public void setAndGetMenuFontTest() {
        gameBoardModel.setMenuFont(new Font("Monospaced",Font.PLAIN,30));
        assertEquals(new Font("Monospaced",Font.PLAIN,30),gameBoardModel.getMenuFont());
    }

    @Test
    public void setAndGetContinueButtonRectTest() {
        gameBoardModel.setContinueButtonRect(new Rectangle(0,-31,148,41));
        assertEquals(new Rectangle(0,-31,148,41),gameBoardModel.getContinueButtonRect());
    }

    @Test
    public void setAndGetExitButtonRectTest() {
        gameBoardModel.setExitButtonRect(new Rectangle(75,71,148,41));
        assertEquals(new Rectangle(75,71,148,41),gameBoardModel.getExitButtonRect());
    }

    @Test
    public void setAndGetRestartButtonRectTest() {
        gameBoardModel.setRestartButtonRect(new Rectangle(75,71,148,41));
        assertEquals(new Rectangle(75,71,148,41),gameBoardModel.getRestartButtonRect());
    }

    @Test
    public void getStrLenTest() {
        assertEquals(0,gameBoardModel.getStrLen());
    }

    @Test
    public void setStrLenTest() {
        gameBoardModel.setStrLen(184);
        assertEquals(184,gameBoardModel.getStrLen());
    }

    @Test
    public void getOwnerTest() {
        assertEquals("view.GameFrame[frame0,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]",gameBoardModel.getOwner().toString());
    }
}