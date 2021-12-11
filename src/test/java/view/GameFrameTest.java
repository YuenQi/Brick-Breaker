package view;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.WindowEvent;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for GameFrame class*/
class GameFrameTest {

    GameFrame gameFrame = new GameFrame();

    /**
     * This method tests for windowGainedFocus method.
     * When window gained focus, gaming is set to true.
     */
    @Test
    public void windowGainedFocusTest() {
        gameFrame.windowGainedFocus(new WindowEvent(new Window(gameFrame),WindowEvent.WINDOW_GAINED_FOCUS));
        assertTrue(gameFrame.isGaming());
    }

    /**
     * This method tests for windowLostFocus method.
     * When window lost focus, gaming is set to false.
     * "Focus Lost" message will be returned.
     */
    @Test
    public void windowLostFocusTest() {
        gameFrame.setGaming(true);
        gameFrame.windowLostFocus(new WindowEvent(new Window(gameFrame),WindowEvent.WINDOW_LOST_FOCUS));
        assertFalse(gameFrame.getGameBoardView().getGameBoardModel().getGameTimer().isGaming());
        assertEquals("Focus Lost",gameFrame.getGameBoardView().getGameBoardModel().getMessage());
    }

    /**
     * This method tests for setGming and isGaming method.
     */
    @Test
    public void setAndGetGamingTest() {
        gameFrame.setGaming(true);
        assertTrue(gameFrame.isGaming());
        gameFrame.setGaming(false);
        assertFalse(gameFrame.isGaming());
    }

}