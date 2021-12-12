package model;

import view.GameFrame;

import java.awt.*;

//REFACTOR: MVC design pattern
/**
 * This is HomeMenuModel class which is used to define home menu model and allows other classes
 * to get and set value for HomeMenuView object.
 * MVC design pattern:
 * Basically, HomeMenuView class will render the view,
 * HomeMenuModel class consists of dumb entities (POJO) and
 * HomeMenuController class is in charge of changing the state of HomeMenuModel and notify the HomeMenuView.
 * Listeners are inside HomeMenuView class. When the listeners capture event,
 * they pass the events to HomeMenuController class through HomeMenuView class to handle action.
 */
public class HomeMenuModel {

    /**owner (like a window/container to hold everything)*/
    private GameFrame owner;
    /**area (width and height) of home menu)*/
    private Dimension area;

    /**home menu*/
    private Rectangle menuFace;
    /**something like a start button*/
    private Rectangle startButton;
    /**something like an exit button*/
    private Rectangle exitButton;//REFACTOR: change menuButton to exitButton
    /**something like an info button*/
    private Rectangle infoButton;

    /**font of greeting text*/
    private Font greetingsFont;
    /**font of game title*/
    private Font gameTitleFont;
    /**font of credits*/
    private Font creditsFont;
    /**font of button*/
    private Font buttonFont;

    /**flag to determine whether the so-called start button is clicked*/
    private boolean startClicked;
    /**flag to determine whether the so-called exit button is clicked*/
    private boolean exitClicked;//REFACTOR: change menuClicked to exitClicked
    /**flag to determine whether the so-called info button is clicked*/
    private boolean infoClicked;

    /**background image*/
    private Image background;

    /**
     * This is a constructor for HomeMenuModel which is used to initialise some variables in HomeMenuModel class.
     * @param owner GameFrame object
     * @param area area (width and height) of home menu
     */
    public HomeMenuModel(GameFrame owner, Dimension area){
        this.owner = owner;
        this.area = area;
    }

    /**
     * This method is to return game frame (owner) to the calling method.
     *
     * @return game frame (owner)
     */
    public GameFrame getOwner() {
        return owner;
    }

    /**
     * This method is to return area (width and height) of home menu to the calling method.
     *
     * @return area (width and height) of home menu
     */
    public Dimension getArea() {
        return area;
    }

    /**
     * This method is to return home menu to the calling method.
     *
     * @return home menu
     */
    public Rectangle getMenuFace() {
        return menuFace;
    }

    /**
     * This method is to set home menu.
     *
     * @param menuFace home menu
     */
    public void setMenuFace(Rectangle menuFace) {
        this.menuFace = menuFace;
    }

    /**
     * This method is to set the so-called "Start button".
     *
     * @param startButton the so-called "Start button"
     */
    public void setStartButton(Rectangle startButton) {
        this.startButton = startButton;
    }

    /**
     * This method is to set the so-called "Exit button".
     *
     * @param exitButton the so-called "Exit button"
     */
    public void setExitButton(Rectangle exitButton) {
        this.exitButton = exitButton;
    }

    /**
     * This method is to set the so-called "Info button".
     *
     * @param infoButton the so-called "Info button"
     */
    public void setInfoButton(Rectangle infoButton) {
        this.infoButton = infoButton;
    }

    /**
     * This method is to return the font type of the greeting text to the calling method.
     *
     * @return font type of the greeting text
     */
    public Font getGreetingsFont() {
        return greetingsFont;
    }

    /**
     * This method is to set the font type of the greeting text.
     *
     * @param greetingsFont font type of the greeting text
     */
    public void setGreetingsFont(Font greetingsFont) {
        this.greetingsFont = greetingsFont;
    }

    /**
     * This method is to return the font type of the game title to the calling method.
     *
     * @return font type of the game title
     */
    public Font getGameTitleFont() {
        return gameTitleFont;
    }

    /**
     * This method is to set the font type of the game title.
     *
     * @param gameTitleFont  font type of the game title
     */
    public void setGameTitleFont(Font gameTitleFont) {
        this.gameTitleFont = gameTitleFont;
    }

    /**
     * This method is to return the font type of the credits text to the calling method.
     *
     * @return font type of the credits title
     */
    public Font getCreditsFont() {
        return creditsFont;
    }

    /**
     * This method is to set the font type of the credits text.
     *
     * @param creditsFont font type of the credits text
     */
    public void setCreditsFont(Font creditsFont) {
        this.creditsFont = creditsFont;
    }

    /**
     * This method is to return the font type of the text inside the button to the calling method.
     *
     * @return font type of the text inside the button
     */
    public Font getButtonFont() {
        return buttonFont;
    }

    /**
     * This method is to set the font type of the text inside the button.
     *
     * @param buttonFont font type of the text inside the button
     */
    public void setButtonFont(Font buttonFont) {
        this.buttonFont = buttonFont;
    }

    /**
     * This method is to tell the calling method whether the so-called "Start button" is clicked.
     *
     * @return method whether the so-called "Start button" is clicked
     */
    public boolean isStartClicked() {
        return startClicked;
    }

    /**
     * This method is to set the clicking state of the so-called "Start button".
     *
     * @param startClicked clicking state of the so-called "Start button"
     */
    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    /**
     * This method is to tell the calling method whether the so-called "Exit button" is clicked.
     *
     * @return whether the so-called "Exit button" is clicked
     */
    public boolean isExitClicked() {
        return exitClicked;
    }

    /**
     * This method is to set the clicking state of the so-called "Exit button".
     *
     * @param exitClicked clicking state of the so-called "Exit button"
     */
    public void setExitClicked(boolean exitClicked) {
        this.exitClicked = exitClicked;
    }

    /**
     * This method is to tell the calling method whether the so-called "Info button" is clicked.
     *
     * @return whether the so-called "Exit button" is clicked
     */
    public boolean isInfoClicked() {
        return infoClicked;
    }

    /**
     * This method is to set the clicking state of the so-called "Info button".
     *
     * @param infoClicked clicking state of the so-called "Info button"
     */
    public void setInfoClicked(boolean infoClicked) {
        this.infoClicked = infoClicked;
    }

    /**
     * This method is to return background image to the calling method.
     *
     * @return background image
     */
    public Image getBackground() {
        return background;
    }

    /**
     * This method is to set background image.
     *
     * @param background background image
     */
    public void setBackground(Image background) {
        this.background = background;
    }

    /**
     * This method is to return the so-called "Start button" to the calling method.
     *
     * @return the so-called "Start button"
     */
    public Rectangle getStartButton() {
        return startButton;
    }

    /**
     * This method is to return the so-called "Exit button" to the calling method.
     *
     * @return the so-called "Exit button"
     */
    public Rectangle getExitButton() {
        return exitButton;
    }

    /**
     * This method is to return the so-called "Info button" to the calling method.
     *
     * @return the so-called "Info button"
     */
    public Rectangle getInfoButton() {
        return infoButton;
    }

}
