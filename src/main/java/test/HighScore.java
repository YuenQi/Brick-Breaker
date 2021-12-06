package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is HighScore class which displays current score and high score board on the screen.
 */
public class HighScore extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 300;

    private JButton quitGameButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private Wall wall;
    private String highScoreRecord;
    private ImageIcon gameOver;
    private JLabel background;

    /**
     * This is a constructor to initialise some variables of HighScore class
     * and designs this frame.
     *
     * @param wall Wall object
     */
    public HighScore(Wall wall){

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
        label4.setBounds(210,170,100,50);
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
     * This method terminates the program if user clicks the quit game button.
     *
     * @param e a semantic event which indicates that a component-defined action occurred
     *          (generated when the button is clicked)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == quitGameButton){
            System.exit(0);
        }
    }
}