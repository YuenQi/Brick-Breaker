/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package view;

import model.Level;
import model.Wall;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This is a DebugPanel class which acts as a container to put the buttons and
 * sliders inside.
 */
public class DebugPanel extends JPanel {

    /**background color of debug panel*/
    private static final Color DEF_BKG = Color.WHITE;

    /**skip level butto*/
    private JButton skipLevel;
    /**reset ball button*/
    private JButton resetBalls;

    /**slider to adjust speed of ball in x direction*/
    private JSlider ballXSpeed;
    /**slider to adjust speed of ball in y direction*/
    private JSlider ballYSpeed;

    /**Wall object*/
    private Wall wall;
    /**Level object*/
    private Level level;

    /**
     * This is a constructor to initialise some variables of DebugPanel class.
     *
     * @param wall Wall object
     * @param level Level object
     */
    public DebugPanel(Wall wall, Level level){

        this.wall = wall;
        this.level = level;

        initialize();

        skipLevel = makeButton("Skip Level",e -> level.nextLevel());
        resetBalls = makeButton("Reset Balls",e -> wall.resetBallCount());

        ballXSpeed = makeSlider(-4,4,e -> wall.setBallXSpeed(ballXSpeed.getValue()));
        ballYSpeed = makeSlider(-4,4,e -> wall.setBallYSpeed(ballYSpeed.getValue()));

        this.add(skipLevel);
        this.add(resetBalls);

        this.add(ballXSpeed);
        this.add(ballYSpeed);
    }

    /**
     * This method is to set background color of this DebugPanel container to white
     * and set the layout manager for this container as GridLayout with 2 rows and 2 columns.
     */
    private void initialize(){
        this.setBackground(DEF_BKG);
        this.setLayout(new GridLayout(2,2));
    }

    /**
     * This method is to create a button with text specified,
     * add an ActionListener to the button created and return the button
     * to the calling method.
     *
     * @param title text inside button
     * @param e listener for receiving action events
     * @return button with text specified
     */
    private JButton makeButton(String title, ActionListener e){
        JButton out = new JButton(title);
        out.addActionListener(e);
        return out;
    }

    /**
     * This method is to create a horizontal slider using the specified minimum value
     * and maximum value, add a ChangeListener to the slider created and return the
     * slider to the calling method.
     *
     * Speed of ball is shown on sliders to enhance user experience. Also, user
     * can adjust the speed easily and can adjust accordingly
     * to find his / her strategy to win the game.
     * One way I can think of is to hit the ball vertically first then horizontally.
     * This way will make sure user takes shorter time to win the game but the FastBrick
     * and SlowBrick level defeats this as the speed is changed when the ball hits the bricks.
     * This additional level is meant to not let the user always adjust the speed (It's still
     * possible to adjust of course, but it will be a bit annoying xD).
     *
     * @param min minimum value of the slider
     * @param max maximum value of the slider
     * @param e listener which determines if a state has changed in the event source
     * @return horizontal slider with specified minimum value and maximum value
     */
    private JSlider makeSlider(int min, int max, ChangeListener e){
        JSlider out = new JSlider(min,max);
        out.setPaintTicks(true);
        out.setMajorTickSpacing(1);
        /*
        ADDITION: show speed of ball on sliders so that user
        can adjust the speed easily and can adjust accordingly
        to find his / her strategy to win the game
         */
        out.setPaintLabels(true);
        out.setSnapToTicks(true);
        out.addChangeListener(e);
        return out;
    }

    /**
     * This method is to set the speed of ball in x and y direction
     * according to the x and y value received.
     *
     * @param x speed of ball in x direction
     * @param y speed of ball in y direction
     */
    public void setValues(int x,int y){
        ballXSpeed.setValue(x);
        ballYSpeed.setValue(y);
    }
}