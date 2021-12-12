package model;

import view.GameFrame;

import javax.swing.*;

//REFACTOR: MVC design pattern
/**
 * This is InfoPageModel class which is used to define info page model and allows other classes
 * to get and set value for InfoPageView object.
 * MVC design pattern:
 * Basically, InfoPageView class will render the view,
 * InfoPageModel class consists of dumb entities (POJO) and
 * InfoPageController class is in charge of changing the state of InfoPageModel state and notify the InfoPageView.
 * ActionListener is inside InfoPageView class. When the listener captures event,
 * it passes the events to InfoPageController class through InfoPageView class to handle action.
 */
public class InfoPageModel {

    /**label*/
    private JLabel label;

    /**start button*/
    private JButton startButton;
    /**back button*/
    private JButton backButton;

    /**background image of info screen*/
    private ImageIcon infoPage;

    /**put background image inside JLabel*/
    private JLabel background;

    /**owner (like a window/container to hold everything)*/
    private GameFrame owner;

    /**
     * This is a constructor for InfoPageModel which is used to initialise some variables in InfoPageModel class.
     * @param owner GameFrame object
     */
    public InfoPageModel(GameFrame owner){
        this.owner = owner;
    }

    /**
     * This method is to return label to the calling method.
     * @return label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * This method is to set label to be displayed.
     * @param label label to be displayed
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * This method is to return the "Start button" to the calling method.
     * @return Start button
     */
    public JButton getStartButton() {
        return startButton;
    }

    /**
     * This method is to set the "Start button".
     * @param startButton Start button
     */
    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    /**
     * This method is to return the "Back button" to the calling method.
     * @return Back button
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * This method is to set the "Back button".
     * @param backButton Back button
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    /**
     * This method is to return the image icon of info page to the calling method.
     * @return image icon of info page
     */
    public ImageIcon getInfoPage() {
        return infoPage;
    }

    /**
     * This method is to set the image icon of info page.
     * @param infoPage image icon of info page
     */
    public void setInfoPage(ImageIcon infoPage) {
        this.infoPage = infoPage;
    }

    /**
     * This method is to return the background of info page to the calling method.
     * @return background of info page
     */
    public JLabel getBackground() {
        return background;
    }

    /**
     * This method is to set the background of info page.
     * @param background background of info page
     */
    public void setBackground(JLabel background) {
        this.background = background;
    }

    /**
     * This method is to return game frame (owner) to the calling method.
     * @return game frame (owner)
     */
    public GameFrame getOwner() {
        return owner;
    }

}
