package view;

import controller.InfoPageController;
import model.InfoPageModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is InfoPageView class which displays the description of the game and instruction.
 */
public class InfoPageView extends JFrame implements ActionListener {

    /**width of frame*/
    private static final int FRAME_WIDTH = 600;
    /**height of frame*/
    private static final int FRAME_HEIGHT = 500;

    /**InfoPageController object*/
    private InfoPageController infoPageController;
    /**InfoPageModel object*/
    private InfoPageModel infoPageModel;

    /**
     * This is a constructor to design info page, add ActionListener,
     * and initialise some variables in InfoPageView class.
     *
     * @param infoPageModel InfoPageModel object
     */
    public InfoPageView(InfoPageModel infoPageModel){

        this.infoPageModel = infoPageModel;
        infoPageController = new InfoPageController(infoPageModel, this);

        displayInstruction();
        createStartButton();
        createBackButton();
        addBackgroundImage();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);//allows frame to appear in the middle of the screen, not just top left corner
        this.add(infoPageModel.getBackground());
    }

    /**
     * This method adds background image to this frame.
     */
    private void addBackgroundImage() {
        infoPageModel.setInfoPage(new ImageIcon(getClass().getResource("/infoPageBackground.jpg")));
        infoPageModel.setBackground(new JLabel(infoPageModel.getInfoPage()));
        infoPageModel.getBackground().setSize(FRAME_WIDTH,FRAME_HEIGHT);
        infoPageModel.getBackground().add(infoPageModel.getLabel());
        infoPageModel.getBackground().add(infoPageModel.getStartButton());
        infoPageModel.getBackground().add(infoPageModel.getBackButton());
    }

    /**
     * This method create start button
     * and adds ActionListener to the button.
     */
    private void createStartButton() {
        infoPageModel.setStartButton(new JButton("START"));
        infoPageModel.getStartButton().setBounds(215,450,80, 30);
        infoPageModel.getStartButton().setHorizontalTextPosition(JButton.CENTER);
        infoPageModel.getStartButton().setVerticalTextPosition(JButton.CENTER);
        infoPageModel.getStartButton().setBackground(Color.GRAY);
        infoPageModel.getStartButton().setForeground(Color.WHITE);
        infoPageModel.getStartButton().setFocusable(false);//get rid of border of text
        infoPageModel.getStartButton().addActionListener(this);
    }

    /**
     * This method displays game description and instruction.
     */
    private void displayInstruction() {
        infoPageModel.setLabel(new JLabel());

        String text = "<html><h2 align = 'center'>GAME DESCRIPTION</h2>";
        text = text + "This is a brick destroy game.<br/>";
        text = text + "You can win the game by breaking all the bricks using the balls.<br/>";
        text = text + "There are only 3 balls. If you lose all the ball, <b><i>GAME OVER</i></b>.<br/><br/>";

        text = text + "<h2 align = 'center'>INSTRUCTION</h2>";
        text = text + "1. Move LEFT using <b>A</b> key.<br/>";
        text = text + "2. Move RIGHT using <b>D</b> key.<br/>";
        text = text + "3. You can press <b>ESC</b> to prompt Pause Menu to continue, restart or exit the game.<br/>";
        text = text + "4. You can pause the game using the <b>SPACEBAR</b>.<br/>";
        text = text + "5. You can view the debug console by pressing <b>SHIFT+ALT+F1</b>.<br/><br/>";

        text = text + "You can adjust the speed on debug console. <br/>";
        text = text + "The slider on the left is the speed of ball in x direction. <br/>";
        text = text + "The slider on the right is the speed of ball in y direction. <br/>";
        text = text + "Adjust accordingly and plan your strategy to win your game.<br/>";

        text = text + "<h3 align = 'center'>Enjoy your game!</h3>";

        infoPageModel.getLabel().setText(text);
        infoPageModel.getLabel().setFont(new Font("Noto Mono", Font.PLAIN, 15));   //set font
        infoPageModel.getLabel().setBounds(20,0,FRAME_WIDTH-10,FRAME_HEIGHT-30);
    }

    /**
     * This method creates back button
     * and adds ActionListener to the button.
     */
    private void createBackButton(){
        infoPageModel.setBackButton(new JButton("BACK"));
        infoPageModel.getBackButton().setBounds(305,450,80, 30);
        infoPageModel.getBackButton().setHorizontalTextPosition(JButton.CENTER);
        infoPageModel.getBackButton().setVerticalTextPosition(JButton.CENTER);
        infoPageModel.getBackButton().setBackground(Color.GRAY);
        infoPageModel.getBackButton().setForeground(Color.WHITE);
        infoPageModel.getBackButton().setFocusable(false);//get rid of border of text
        infoPageModel.getBackButton().addActionListener(this);
    }

    /**
     * This method checks if there is any action performed on this frame,
     * and then passes the actionEvent to InfoPageController to update the view.
     * @param e a semantic event which indicates that a component-defined action occurred
     *          (generated when the button is clicked)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        infoPageController.isActionPerformed(e);
    }

}