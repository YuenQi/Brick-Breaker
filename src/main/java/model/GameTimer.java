package model;

import java.util.TimerTask;
import java.util.Timer;

//ADDITION: timer to calculate time taken by the user to play the game
/**
 * This is GameTimer class which is used to calculate the time taken by the user
 * to play the game.
 */
public class GameTimer {

    /**time taken by user to play the game*/
    private static int gameTime;
    /**time taken by user to play the game (in seconds)*/
    private int seconds;
    /**time taken by user to play the game (in minutes)*/
    private int minutes;
    /**Timer object*/
    private Timer timer;
    /**task that is to be performed*/
    private TimerTask task;
    /**flag of whether the user is playing the game*/
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

    /**
     * This method returns time taken by the user to play the game to the calling method.
     *
     * @return time taken by the user to play the game
     */
    public static int getGameTime() {
        return gameTime;
    }

    /**
     * This method sets time taken by the user to play the game.
     *
     * @param gameTime time taken by the user to play the game
     */
    public void setGameTime(int gameTime) {
        GameTimer.gameTime = gameTime;
    }

    /**
     * This method is to set seconds (mainly used for testing purpose).
     * @param seconds seconds taken by user to play the game
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * This method is to set minutes (mainly used for testing purpose).
     * @param minutes minutes taken by user to play the game
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

}