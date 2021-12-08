package model;

import view.DebugConsole;
import view.HighScoreView;

import javax.swing.*;
import java.awt.*;

/**
 * This is GameBoardModel which is used to define game board model and allows other classes
 * to get and set value for GameBoard object.
 */
public class GameBoardModel {
    private Timer timer;

    private Wall wall;
    private Level level;
    private HighScoreView highScoreView;

    private GameTimer gameTimer;
    private Audio audio;

    private String message;
    private String scoreMessage;
    private String highScoreMessage;
    private String timeMessage;

    private boolean showPauseMenu;

    private Font menuFont;

    private Rectangle continueButtonRect;
    private Rectangle exitButtonRect;
    private Rectangle restartButtonRect;
    private int strLen;

    private DebugConsole debugConsole;

    private JFrame owner;

    /**
     * This is a constructor which intialises variable in GameBoardModel class.
     * @param owner game frame
     */
    public GameBoardModel(JFrame owner){
        this.owner = owner;
    }

    /**
     * This method is to return timer to the calling method.
     *
     * @return timer that controls the starting and stopping of the game
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * This method is to set starting and stopping of the game.
     *
     * @param timer timer that controls the starting and stopping of the game
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    /**
     * This method is to return Wall object to the calling method.
     *
     * @return Wall object
     */
    public Wall getWall() {
        return wall;
    }

    /**
     * This method is to set Wall object.
     *
     * @param wall Wall object
     */
    public void setWall(Wall wall) {
        this.wall = wall;
    }

    /**
     * This method is to return the level that user is currently at to the calling method.
     *
     * @return level that user is currently at
     */
    public Level getLevel() {
        return level;
    }

    /**
     * This method is to set level.
     *
     * @param level level
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * This method is to return the highest score to the calling method.
     *
     * @return the highest score
     */
    public HighScoreView getHighScore() {
        return highScoreView;
    }

    /**
     * This method is to set the highest score.
     *
     * @param highScoreView HighScoreView object
     */
    public void setHighScore(HighScoreView highScoreView) {
        this.highScoreView = highScoreView;
    }

    /**
     * This method is to return game timer (how much time taken by the user to play the game) to the calling method.
     *
     * @return how much time taken by the user to play the game (in second)
     */
    public GameTimer getGameTimer() {
        return gameTimer;
    }

    /**
     * This method is to set how much time taken by the user to play the game.
     *
     * @param gameTimer how much time taken by the user to play the game (in second)
     */
    public void setGameTimer(GameTimer gameTimer) {
        this.gameTimer = gameTimer;
    }

    /**
     * This method is to return audio clip to the calling method.
     *
     * @return audio clip
     */
    public Audio getAudio() {
        return audio;
    }

    /**
     * This method is to set audio clip that is to be played.
     *
     * @param audio audio clip that is to be played
     */
    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    /**
     * This method is to return message string that is to be displayed on the screen to the calling method.
     *
     * @return message string that is to be displayed on the screen
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method is to set message string that is to be displayed on the screen.
     *
     * @param message message string that is to be displayed on the screen
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method is to return score message that is to be displayed on the screen to the calling method.
     *
     * @return score message that is to be displayed on the screen
     */
    public String getScoreMessage() {
        return scoreMessage;
    }

    /**
     * This method is to set score message that is to be displayed on the screen.
     *
     * @param scoreMessage score message that is to be displayed on the screen
     */
    public void setScoreMessage(String scoreMessage) {
        this.scoreMessage = scoreMessage;
    }

    /**
     * This method is to return the highest score message that is to be displayed on the screen to the calling method.
     *
     * @return the highest score message that is to be displayed on the screen
     */
    public String getHighScoreMessage() {
        return highScoreMessage;
    }

    /**
     * This method is to set the highest score message that is to be displayed on the screen.
     *
     * @param highScoreMessage the highest score message that is to be displayed on the screen
     */
    public void setHighScoreMessage(String highScoreMessage) {
        this.highScoreMessage = highScoreMessage;
    }

    /**
     * This method is to return the time message that is to be displayed on the screen to the calling method.
     *
     * @return time message that is to be displayed on the screen
     */
    public String getTimeMessage() {
        return timeMessage;
    }

    /**
     * This method is to set the time message that is to be displayed on the screen.
     *
     * @param timeMessage time message that is to be displayed on the screen
     */
    public void setTimeMessage(String timeMessage) {
        this.timeMessage = timeMessage;
    }

    /**
     * This method is to tell the calling method whether pause menu is shown.
     *
     * @return whether pause menu is shown
     */
    public boolean isShowPauseMenu() {
        return showPauseMenu;
    }

    /**
     * This method is to determine whether pause menu needs to be shown.
     *
     * @param showPauseMenu whether pause menu needs to be shown
     */
    public void setShowPauseMenu(boolean showPauseMenu) {
        this.showPauseMenu = showPauseMenu;
    }

    /**
     * This method is to return the font type of menu to the calling method.
     *
     * @return font type of menu
     */
    public Font getMenuFont() {
        return menuFont;
    }

    /**
     * This method is to set the font type of menu.
     *
     * @param menuFont font type of menu
     */
    public void setMenuFont(Font menuFont) {
        this.menuFont = menuFont;
    }

    /**
     * This method is to return the so-called "Continue button" to the calling method.
     *
     * @return the so-called "Continue button"
     */
    public Rectangle getContinueButtonRect() {
        return continueButtonRect;
    }

    /**
     * This method is to set the so-called "Continue button".
     *
     * @param continueButtonRect the so-called "Continue button"
     */
    public void setContinueButtonRect(Rectangle continueButtonRect) {
        this.continueButtonRect = continueButtonRect;
    }

    /**
     * This method is to return the so-called "Exit button" to the calling method.
     *
     * @return the so-called "Exit button"
     */
    public Rectangle getExitButtonRect() {
        return exitButtonRect;
    }

    /**
     * This method is to set the so-called "Exit button".
     *
     * @param exitButtonRect the so-called "Exit button"
     */
    public void setExitButtonRect(Rectangle exitButtonRect) {
        this.exitButtonRect = exitButtonRect;
    }

    /**
     * This method is to return the so-called "Restart button" to the calling method.
     *
     * @return the so-called "Restart button"
     */
    public Rectangle getRestartButtonRect() {
        return restartButtonRect;
    }

    /**
     * This method is to set the so-called "Restart button".
     *
     * @param restartButtonRect the so-called "Restart button"
     */
    public void setRestartButtonRect(Rectangle restartButtonRect) {
        this.restartButtonRect = restartButtonRect;
    }

    /**
     * This method is to return the length of the string to the calling method.
     *
     * @return return the length of the string
     */
    public int getStrLen() {
        return strLen;
    }

    /**
     * This method is to set the length of the string to the calling method.
     *
     * @param strLen the length of the string
     */
    public void setStrLen(int strLen) {
        this.strLen = strLen;
    }

    /**
     * This method is to return debug console to the calling method.
     *
     * @return DebugConsole object
     */
    public DebugConsole getDebugConsole() {
        return debugConsole;
    }

    /**
     * This method is to set debug console.
     *
     * @param debugConsole DebugConsole object
     */
    public void setDebugConsole(DebugConsole debugConsole) {
        this.debugConsole = debugConsole;
    }

    /**
     * This method is to return game frame (owner) to the calling method.
     *
     * @return game frame (owner)
     */
    public JFrame getOwner() {
        return owner;
    }

    /**
     * This method is to set game frame (owner).
     *
     * @param owner game frame (owner)
     */
    public void setOwner(JFrame owner) {
        this.owner = owner;
    }
}
