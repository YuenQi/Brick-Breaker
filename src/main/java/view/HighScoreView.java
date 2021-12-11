package view;

import controller.HighScoreController;
import model.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;

//ADDITION: current score and highest score screen
/**
 * This is HighScoreView class which displays current score and high score board on the screen.
 */
public class HighScoreView extends JFrame implements ActionListener {

    /*
    Constant is used so that changes can be made in 1 place afterwards
    to reduce errors that might occur.
    This is good programming practice.
     */
    /**width of frame*/
    private static final int FRAME_WIDTH = 450;
    /**height of frame*/
    private static final int FRAME_HEIGHT = 300;

    /*
    ENCAPSULATION:
    "private" access modifier, respective getter and setter for the variables
    is used so that encapsulation is achieved.
    */
    /**quit game button*/
    private JButton quitGameButton;
    /**text label 1*/
    private JLabel label1;
    /**text label 2*/
    private JLabel label2;
    /**text label 3*/
    private JLabel label3;
    /**text label 4*/
    private JLabel label4;
    /**Wall object*/
    private Wall wall;
    /**highest score record*/
    private String highScoreRecord;
    /**background image*/
    private ImageIcon gameOver;
    /**JLabel to put background image*/
    private JLabel background;

    /**HighScoreController object*/
    private HighScoreController highScoreController;

    /**
     * This is a constructor to initialise some variables of HighScoreView class
     * and designs this frame.
     *
     * @param wall Wall object
     */
    public HighScoreView(Wall wall){

        this.wall = wall;
        highScoreRecord = wall.getHighScore();
        createQuitGameButton();
        displayText();
        addBackgroundImage();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);//allows frame to appear in the middle of the screen, not just top left corner
        this.add(background);

        highScoreController = new HighScoreController(this);
    }

    /**
     * This method adds background image to this frame.
     */
    private void addBackgroundImage() {
        gameOver = new ImageIcon("src/main/resources/gameOver.jpeg");
        background = new JLabel(gameOver);
        background.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        background.add(label1);
        background.add(label2);
        background.add(label3);
        background.add(label4);
        background.add(quitGameButton);
    }

    /**
     * This method displays text that will be shown on this frame.
     */
    private void displayText() {
        label1 = new JLabel();

        String text = "<html><h1 align = 'center'>GAME OVER</h1>";
        text = text + "<html><h2 align = 'center'>YOUR CURRENT SCORE IS</h2>";

        label1.setText(text);
        label1.setForeground(Color.WHITE);
        label1.setBounds(110,0,300,150);

        label2=new JLabel();
        label2.setText(Integer.toString(wall.getScore()));
        label2.setForeground(Color.WHITE);
        label2.setBounds(220,105,100,50);
        label2.setFont(new Font(null, Font.PLAIN, 20));

        label3 = new JLabel();
        String text2 = "<html><h2 align = 'center'>HIGH SCORE BOARD</h2>";
        label3.setText(text2);
        label3.setForeground(Color.WHITE);
        label3.setBounds(135,130,300,75);

        label4=new JLabel();
        label4.setText(highScoreRecord);
        label4.setBounds(195,170,100,50);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font(null, Font.PLAIN, 20));
    }

    /**
     * This method creates a quit game button
     * and adds ActionListener to the button.
     */
    private void createQuitGameButton() {
        quitGameButton = new JButton("QUIT GAME");
        quitGameButton.setBounds(125,230,200, 30);
        quitGameButton.setHorizontalTextPosition(JButton.CENTER);
        quitGameButton.setVerticalTextPosition(JButton.CENTER);
        quitGameButton.setBackground(Color.GRAY);
        quitGameButton.setForeground(Color.WHITE);
        quitGameButton.setFocusable(false);//get rid of border of text
        quitGameButton.addActionListener(this);
    }

    /**
     * This method checks if the user clicks the "Quit Game button"
     * and then passes the actionEvent to HighScoreController to update the view.
     * @param e a semantic event which indicates that a component-defined action occurred
     *          (generated when the button is clicked)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        highScoreController.checkActionPerformed(e);
    }

    /**
     * This method is to return "Quit Game button" to the calling method.
     * @return Quit Game button
     */
    public JButton getQuitGameButton() {
        return quitGameButton;
    }

}