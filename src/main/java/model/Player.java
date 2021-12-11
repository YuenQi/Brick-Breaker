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
package model;

import java.awt.*;

/**
 * This is Player class to define movement, impact and design of player bar which is used to catch the ball.
 */
public class Player {

    /**border color of player bar*/
    public static final Color BORDER_COLOR = Color.GREEN.darker().darker();
    /**inner color of player bar*/
    public static final Color INNER_COLOR = Color.GREEN;

    /**move amount of player bar (constant fixed value that is used to define movement)*/
    private static final int MOVE_AMOUNT = 5;

    /**shape of player bar*/
    private Rectangle playerFace;
    /**center point of ball*/
    private Point ballPoint;
    /**move amount of player bar*/
    private int moveAmount;
    /**minimum move amount of player bar*/
    private int min;
    /**maximum move amount of player bar*/
    private int max;

    /**
     * This is a constructor to initialise some variables in Player class.
     *
     * @param ballPoint center point of ball
     * @param width width of player bar
     * @param height height of player bar
     * @param container draw area to draw the player bar
     */
    public Player(Point ballPoint,int width,int height,Rectangle container) {
        this.ballPoint = ballPoint;
        moveAmount = 0;
        playerFace = makeRectangle(width, height);
        min = container.x + (width / 2);
        max = min + container.width - width;
    }

    /**
     * This method is to make player bar.
     *
     * @param width width of player bar
     * @param height height of player bar
     * @return player bar that has been made
     */
    private Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(ballPoint.getX() - (width / 2)),(int)ballPoint.getY());
        return  new Rectangle(p,new Dimension(width,height));
    }

    /**
     * This method returns true if the ball touches the player, i.e.
     * the bottom of the ball and the centre of the ball touches the player bar.
     *
     * @param b Ball object
     * @return true is returned if the centre and bottom of the ball touches the player bar
     */
    public boolean impact(Ball b){
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.getDown()) ;
    }

    /**
     * This method is used to move the player bar.
     */
    public void move(){
        double x = ballPoint.getX() + moveAmount;
        if(x < min || x > max)
            return;
        ballPoint.setLocation(x,ballPoint.getY());
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }

    /**
     * This method moves the player bar to the left.
     */
    public void moveLeft(){
        moveAmount = -MOVE_AMOUNT;
    }


    /**
     * This method moves the player bar to the right.
     */
    public void moveRight(){ //REFACTOR: change movRight() to moveRight()
        moveAmount = MOVE_AMOUNT;
    }

    /**
     * This method stops the movement of player bar.
     */
    public void stop(){
        moveAmount = 0;
    }

    /**
     * This method returns player bar to the calling method.
     *
     * @return player bar
     */
    public Shape getPlayerFace(){
        return  playerFace;
    }

    /**
     * This method is to move the ball to a particular point specified
     * by the parameter passed to this method.
     *
     * @param p point to move the ball to
     */
    public void moveTo(Point p){
        ballPoint.setLocation(p);
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }

    /**
     * This method is to return move amount of player bar to the calling method (mainly used for testing purpose).
     * @return move amount of player bar
     */
    public int getMoveAmount() {
        return moveAmount;
    }

    /**
     * This method returns center point of ball to the calling method (mainly used for testing purpose).
     * @return center point of ball
     */
    public Point getBallPoint() {
        return ballPoint;
    }

    /**
     * This method sets player bar (mainly used for testing purpose).
     * @param playerFace player bar
     */
    public void setPlayerFace(Rectangle playerFace) {
        this.playerFace = playerFace;
    }

    /**
     * This method sets center point of ball (mainly used for testing purpose).
     * @param ballPoint center point of ball
     */
    public void setBallPoint(Point ballPoint) {
        this.ballPoint = ballPoint;
    }

}