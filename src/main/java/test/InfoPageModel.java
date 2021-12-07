package test;

import javax.swing.*;

public class InfoPageModel {

    private JLabel label;

    private JButton startButton;
    private JButton backButton;

    private ImageIcon infoPage;

    private JLabel background;

    private GameFrame owner;

    public InfoPageModel(GameFrame owner){
        this.owner = owner;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public ImageIcon getInfoPage() {
        return infoPage;
    }

    public void setInfoPage(ImageIcon infoPage) {
        this.infoPage = infoPage;
    }

    public JLabel getBackground() {
        return background;
    }

    public void setBackground(JLabel background) {
        this.background = background;
    }

    public GameFrame getOwner() {
        return owner;
    }

    public void setOwner(GameFrame owner) {
        this.owner = owner;
    }

}
