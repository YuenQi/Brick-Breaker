package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HighScore extends JFrame implements ActionListener {

    JButton quitGameButton;
    JLabel label1;
    JLabel label2;
    private Wall wall;
    private String highScoreRecord;

    public HighScore(Wall wall){

        highScoreRecord = wall.getHighScore();
        createQuitGameButton();
        displayText();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,300);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);//allows frame to appear in the middle of the screen, not just top left corner
        this.add(label1);
        this.add(label2);
        this.add(quitGameButton);
    }

    private void displayText() {
        label1 = new JLabel();

        String text = "<html><h1 align = 'center'>GAME OVER</h1><br/>";
        text = text + "<html><h2 align = 'center'>HIGH SCORE BOARD</h2>";

        label1.setText(text);
        label1.setBounds(125,30,300,150);

        label2=new JLabel();
        label2.setText(highScoreRecord);
        label2.setBounds(195,160,100,50);
    }

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


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == quitGameButton){
            System.exit(0);
        }
    }
}