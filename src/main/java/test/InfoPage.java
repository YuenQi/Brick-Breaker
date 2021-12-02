package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPage extends JFrame implements ActionListener {

    private JLabel label;
    private JButton startButton;
    private JButton backButton;

    private GameFrame owner;

    public InfoPage(GameFrame owner){

        this.owner = owner;

        displayInstruction();
        createStartButton();
        createBackButton();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);//allows frame to appear in the middle of the screen, not just top left corner
        this.add(label);
        this.add(startButton);
        this.add(backButton);
    }

    private void createStartButton() {
        startButton = new JButton("START");
        startButton.setBounds(250,470,100, 30);
        startButton.setHorizontalTextPosition(JButton.CENTER);
        startButton.setVerticalTextPosition(JButton.CENTER);
        startButton.setBackground(Color.GRAY);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusable(false);//get rid of border of text
        startButton.addActionListener(this);
    }

    private void displayInstruction() {
        label = new JLabel();

        String text = "<html><h2 align = 'center'>GAME DESCRIPTION</h2>";
        text = text + "<font style=\"font-family: 'Courier New'; font size: 30pt;\">";
        text = text + "This is a brick destroy game.<br/>";
        text = text + "You can win the game by breaking all the bricks using the ball.<br/><br/><br/>";

        text = text + "<h2 align = 'center'>INSTRUCTION</h2>";
        text = text + "1. Move LEFT using \"A\" key.<br/>";
        text = text + "2. Move RIGHT using \"D\" key.<br/>";
        text = text + "3. You can pause the game using the SPACEBAR.<br/>";
        text = text + "4. You can view the debug console by pressing SHIFT+ALT+F1.<br/><br/><br/>";

        text = text + "Enjoy your game =)";

        label.setText(text);
        label.setBounds(50,50,500,400);

    }
    public void createBackButton(){
        backButton = new JButton("BACK");
        backButton.setBounds(250,510,100, 30);
        backButton.setHorizontalTextPosition(JButton.CENTER);
        backButton.setVerticalTextPosition(JButton.CENTER);
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);//get rid of border of text
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            dispose();
            owner.enableGameBoard();
        } else if(e.getSource() == backButton){
            dispose();
            new GameFrame();
        }
    }
}
