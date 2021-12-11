package model;

import org.junit.jupiter.api.Test;
import view.GameFrame;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for GameBoardModel class*/
class GameBoardModelTest {

    /**GameBoardModel object*/
    GameBoardModel gameBoardModel = new GameBoardModel(new GameFrame());

    /**
     * This method tests for setMessage and setMessage methods.
     */
    @Test
    public void setAndGetMessageTest() {
        gameBoardModel.setMessage("Bricks: 31 Balls 3");
        assertEquals("Bricks: 31 Balls 3",gameBoardModel.getMessage());
    }

    /**
     * This method tests for setScoreMessage and getScoreMessage methods.
     */
    @Test
    public void setAndGetScoreMessageTest() {
        gameBoardModel.setScoreMessage("Score: 0");
        assertEquals("Score: 0",gameBoardModel.getScoreMessage());
    }

    /**
     * This method tests for setHighScoreMessage and getHighScoreMessage methods.
     */
    @Test
    public void setAndGetHighScoreMessageTest() {
        gameBoardModel.setHighScoreMessage("High Score Record: Yuen Qi:30");
        assertEquals("High Score Record: Yuen Qi:30",gameBoardModel.getHighScoreMessage());
    }

    /**
     * This method tests for setTimeMessage and getTimeMessage methods.
     */
    @Test
    public void setAndGetTimeMessageTest() {
        gameBoardModel.setTimeMessage("Time: 00 minute(s) 30 second(s)");
        assertEquals("Time: 00 minute(s) 30 second(s)",gameBoardModel.getTimeMessage());
    }

    /**
     * This method tests for setShowPauseMenu and isShowPauseMenu methods.
     */
    @Test
    public void setAndGetShowPauseMenuTest() {
        gameBoardModel.setShowPauseMenu(false);
        assertFalse(gameBoardModel.isShowPauseMenu());
        gameBoardModel.setShowPauseMenu(true);
        assertTrue(gameBoardModel.isShowPauseMenu());
    }

    /**
     * This method tests for setMenuFont and getMenuFont methods.
     */
    @Test
    public void setAndGetMenuFontTest() {
        gameBoardModel.setMenuFont(new Font("Monospaced",Font.PLAIN,30));
        assertEquals(new Font("Monospaced",Font.PLAIN,30),gameBoardModel.getMenuFont());
    }

    /**
     * This method tests for setContinueButtonRect and getContinueButtonRect methods.
     */
    @Test
    public void setAndGetContinueButtonRectTest() {
        gameBoardModel.setContinueButtonRect(new Rectangle(0,-31,148,41));
        assertEquals(new Rectangle(0,-31,148,41),gameBoardModel.getContinueButtonRect());
    }

    /**
     * This method tests for setExitButtonRect and getExitButtonRect methods.
     */
    @Test
    public void setAndGetExitButtonRectTest() {
        gameBoardModel.setExitButtonRect(new Rectangle(75,71,148,41));
        assertEquals(new Rectangle(75,71,148,41),gameBoardModel.getExitButtonRect());
    }

    /**
     * This method tests for setRestartButtonRect and getRestartButtonRect methods.
     */
    @Test
    public void setAndGetRestartButtonRectTest() {
        gameBoardModel.setRestartButtonRect(new Rectangle(75,71,148,41));
        assertEquals(new Rectangle(75,71,148,41),gameBoardModel.getRestartButtonRect());
    }

    /**
     * This method tests for getStrLen method.
     */
    @Test
    public void getStrLenTest() {
        //strLen is initialised to 0
        assertEquals(0,gameBoardModel.getStrLen());
    }

    /**
     * This method tests for setStrLen method.
     */
    @Test
    public void setStrLenTest() {
        gameBoardModel.setStrLen(184);
        assertEquals(184,gameBoardModel.getStrLen());
    }

    /**
     * This method tests for getOwner method.
     */
    @Test
    public void getOwnerTest() {
        assertEquals("view.GameFrame[frame0,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]",gameBoardModel.getOwner().toString());
    }
}