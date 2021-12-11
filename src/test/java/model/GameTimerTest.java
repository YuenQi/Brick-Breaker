package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for GameTimer class*/
class GameTimerTest {

    /**GameTimer object*/
    GameTimer gameTimer = new GameTimer();

    /**
     * This method tests for setSeconds and getSeconds methods.
     */
    @Test
    public void setAndGetSecondsTest() {
        gameTimer.setSeconds(5);
        assertEquals(5,gameTimer.getSeconds());
    }

    /**
     * This method tests for setMinutes and getMinutes methods.
     */
    @Test
    public void setAndGetMinutesTest() {
        gameTimer.setMinutes(3);
        assertEquals(3,gameTimer.getMinutes());
    }

    /**
     * This method tests for isGaming method.
     */
    @Test
    public void isGamingTest() {
        //gaming is initialised to false
        assertFalse(gameTimer.isGaming());
    }

    /**
     * This method tests for setGaming method.
     */
    @Test
    public void setGamingTest() {
        gameTimer.setGaming(true);
        assertTrue(gameTimer.isGaming());
    }

    /**
     * This method tests for resetTimer method.
     */
    @Test
    public void resetTimerTest() {
        gameTimer.resetTimer();
        assertEquals(0,GameTimer.getGameTime());
    }

    /**
     * This method tests for setGameTime and getGameTime methods.
     */
    @Test
    public void setAndGetGameTimeTest() {
        gameTimer.setGameTime(10);
        assertEquals(10,GameTimer.getGameTime());
    }
}