package model;

import view.GameFrame;

import javax.swing.*;

/**
 * This is InfoPageModel class which is used to define info page model and allows other classes
 * to get and set value for InfoPageView object.
 */
public class InfoPageModel {

    private JLabel label;

    private JButton startButton;
    private JButton backButton;

    private ImageIcon infoPage;

    private JLabel background;

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

    /**
     * This method is to set game frame (owner).
     * @param owner game frame (owner)
     */
    public void setOwner(GameFrame owner) {
        this.owner = owner;
    }

}
