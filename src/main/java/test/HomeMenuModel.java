package test;

import java.awt.*;

public class HomeMenuModel {

    private GameFrame owner;
    private Dimension area;

    private Rectangle menuFace;
    private Rectangle startButton;
    private Rectangle exitButton;//REFACTOR: change menuButton to exitButton
    private Rectangle infoButton;

    private Font greetingsFont;
    private Font gameTitleFont;
    private Font creditsFont;
    private Font buttonFont;

    private boolean startClicked;
    private boolean exitClicked;//REFACTOR: change menuClicked to exitClicked
    private boolean infoClicked;

    private Image background;

    public HomeMenuModel(GameFrame owner, Dimension area){
        this.owner = owner;
        this.area = area;
    }

    public GameFrame getOwner() {
        return owner;
    }

    public void setOwner(GameFrame owner) {
        this.owner = owner;
    }

    public Dimension getArea() {
        return area;
    }

    public void setArea(Dimension area) {
        this.area = area;
    }

    public Rectangle getMenuFace() {
        return menuFace;
    }

    public void setMenuFace(Rectangle menuFace) {
        this.menuFace = menuFace;
    }

    public void setStartButton(Rectangle startButton) {
        this.startButton = startButton;
    }

    public void setExitButton(Rectangle exitButton) {
        this.exitButton = exitButton;
    }

    public void setInfoButton(Rectangle infoButton) {
        this.infoButton = infoButton;
    }

    public Font getGreetingsFont() {
        return greetingsFont;
    }

    public void setGreetingsFont(Font greetingsFont) {
        this.greetingsFont = greetingsFont;
    }

    public Font getGameTitleFont() {
        return gameTitleFont;
    }

    public void setGameTitleFont(Font gameTitleFont) {
        this.gameTitleFont = gameTitleFont;
    }

    public Font getCreditsFont() {
        return creditsFont;
    }

    public void setCreditsFont(Font creditsFont) {
        this.creditsFont = creditsFont;
    }

    public Font getButtonFont() {
        return buttonFont;
    }

    public void setButtonFont(Font buttonFont) {
        this.buttonFont = buttonFont;
    }

    public boolean isStartClicked() {
        return startClicked;
    }

    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    public boolean isExitClicked() {
        return exitClicked;
    }

    public void setExitClicked(boolean exitClicked) {
        this.exitClicked = exitClicked;
    }

    public boolean isInfoClicked() {
        return infoClicked;
    }

    public void setInfoClicked(boolean infoClicked) {
        this.infoClicked = infoClicked;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public Rectangle getStartButton() {
        return startButton;
    }

    public Rectangle getExitButton() {
        return exitButton;
    }

    public Rectangle getInfoButton() {
        return infoButton;
    }

}
