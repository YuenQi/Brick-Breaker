package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTimerTest {

    GameTimer gameTimer = new GameTimer();

    @Test
    public void setAndGetSecondsTest() {
        gameTimer.setSeconds(5);
        assertEquals(5,gameTimer.getSeconds());
    }

    @Test
    public void setAndGetMinutesTest() {
        gameTimer.setMinutes(3);
        assertEquals(3,gameTimer.getMinutes());
    }

    @Test
    public void isGamingTest() {
        assertFalse(gameTimer.isGaming());
    }

    @Test
    public void setGamingTest() {
        gameTimer.setGaming(true);
        assertTrue(gameTimer.isGaming());
    }

    @Test
    public void resetTimerTest() {
        gameTimer.resetTimer();
        assertEquals(0,GameTimer.getGameTime());
    }

    @Test
    public void setAndGetGameTimeTest() {
        gameTimer.setGameTime(10);
        assertEquals(10,GameTimer.getGameTime());
    }
}