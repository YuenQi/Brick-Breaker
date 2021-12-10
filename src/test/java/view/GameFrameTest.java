package view;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.WindowEvent;

import static org.junit.jupiter.api.Assertions.*;

class GameFrameTest {

    GameFrame gameFrame = new GameFrame();

    @Test
    public void windowGainedFocusTest() {
        gameFrame.windowGainedFocus(new WindowEvent(new Window(gameFrame),WindowEvent.WINDOW_GAINED_FOCUS));
        assertTrue(gameFrame.isGaming());
    }

    @Test
    public void windowLostFocusTest() {
        gameFrame.setGaming(true);
        gameFrame.windowLostFocus(new WindowEvent(new Window(gameFrame),WindowEvent.WINDOW_LOST_FOCUS));
        assertFalse(gameFrame.getGameBoardView().getGameBoardModel().getGameTimer().isGaming());
        assertEquals("Focus Lost",gameFrame.getGameBoardView().getGameBoardModel().getMessage());
    }

    @Test
    public void setAndGetGamingTest() {
        gameFrame.setGaming(true);
        assertTrue(gameFrame.isGaming());
        gameFrame.setGaming(false);
        assertFalse(gameFrame.isGaming());
    }

}