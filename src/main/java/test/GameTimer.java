package test;

import java.util.TimerTask;
import java.util.Timer;

/**
 * This is GameTimer class which is used to calculate the time taken for the user
 * to play the game.
 */
public class GameTimer {

    private int gameTime;
    private int seconds;
    private int minutes;
    private Timer timer;
    private TimerTask task;
    private boolean gaming = false;

    /**
     * This is a constructor to create Timer and TimerTask object
     * and schedule the specified task (increment time taken to play the game)
     * without delay and repeat the task regularly after 1 second.
     */
    public GameTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if (isGaming()) {
                    gameTime++;
                    minutes = gameTime / 60;
                    seconds = gameTime % 60;
                }
            }
        };

        timer.schedule(task, 0, 1000);
    }


    /**
     * This method returns the "second" part of the time taken
     * to play the game to the calling method.
     *
     * @return "second" part of the time taken to play the game
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * This method returns the "minute" part of the time taken
     * to play the game to the calling method.
     *
     * @return "minute" part of the time taken to play the game
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * This method tells the calling method whether the game is starting ot not.
     *
     * @return whether the game is starting ot not
     */
    public boolean isGaming() {
        return gaming;
    }

    /**
     * This method sets whether the game is starting ot not.
     *
     * @param gaming whether the game is starting ot not
     */
    public void setGaming(boolean gaming) {
        this.gaming = gaming;
    }

    /**
     * This method will set the time taken to start the game as 0.
     */
    public void resetTimer(){
        gameTime = 0;
    }
}