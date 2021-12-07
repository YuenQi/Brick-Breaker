package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is InfoPageView class which displays the description of the game and instruction.
 */
public class InfoPageView extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;

    private JLabel label;

    private JButton startButton;
    private JButton backButton;

    private ImageIcon infoPage;
    private JLabel background;

    private GameFrame owner;
    private InfoPageController infoPageController;

    /**
     * This is a constructor to design info page, add ActionListener,
     * and initialise some variables in InfoPageView class.
     *
     * @param owner GameFrame object
     */
    public InfoPageView(GameFrame owner){

        this.owner = owner;
        infoPageController = new InfoPageController(this);

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
        this.add(background);
    }

    /**
     * This method adds background image to this frame.
     */
    private void addBackgroundImage() {
        infoPage = new ImageIcon("resources/infoPageBackground.jpg");
        background = new JLabel(infoPage);
        background.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        background.add(label);
        background.add(startButton);
        background.add(backButton);
    }

    /**
     * This method create start button
     * and adds ActionListener to the button.
     */
    private void createStartButton() {
        startButton = new JButton("START");
        startButton.setBounds(215,450,80, 30);
        startButton.setHorizontalTextPosition(JButton.CENTER);
        startButton.setVerticalTextPosition(JButton.CENTER);
        startButton.setBackground(Color.GRAY);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusable(false);//get rid of border of text
        startButton.addActionListener(this);
    }

    /**
     * This method displays game description and instruction.
     */
    private void displayInstruction() {
        label = new JLabel();

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

        label.setText(text);
        label.setFont(new Font("Noto Mono", Font.PLAIN, 15));   //set font
        label.setBounds(20,0,FRAME_WIDTH-10,FRAME_HEIGHT-30);
    }

    /**
     * This method creates back button
     * and adds ActionListener to the button.
     */
    public void createBackButton(){
        backButton = new JButton("BACK");
        backButton.setBounds(305,450,80, 30);
        backButton.setHorizontalTextPosition(JButton.CENTER);
        backButton.setVerticalTextPosition(JButton.CENTER);
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);//get rid of border of text
        backButton.addActionListener(this);
    }

    /**
     * If user clicks the start button, this frame will be disposed
     * and enableGameBoard method in GameFrame class will be called to
     * display the game board.
     * If user clicks the back button, this frame will be disposed too and GameFrame object will be created.
     *
     * @param e a semantic event which indicates that a component-defined action occurred
     *          (generated when the button is clicked)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == startButton){
//            dispose();
//            owner.enableGameBoard();
//        } else if(e.getSource() == backButton){
//            dispose();
//            new GameFrame();
//        }
        infoPageController.isActionPerformed(e);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    @Override
    public GameFrame getOwner() {
        return owner;
    }
}