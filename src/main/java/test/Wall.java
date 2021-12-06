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
package test;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;

/**
 * This is Wall class which handles most of the things happen to the wall.
 */
public class Wall {

    private Rectangle area;

    private Brick[] bricks;
    private Ball ball;
    private Player player;
    private BallFactory ballFactory;

    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;

    private int ballSpeedX;
    private int ballSpeedY;

    private int score = 0;
    private String highScore = "";

    private GameTimer timer;

    /**
     * This is a constructor to initialise some variables in Wall class.
     * and create Player object.
     *
     * @param drawArea draw area to draw brick / player bar
     * @param ballPos center point of ball
     */
    public Wall(Rectangle drawArea, Point ballPos){

        timer = new GameTimer();

        this.startPoint = new Point(ballPos);

        ballCount = 3;
        ballLost = false;

        makeBall(ballPos);

        initialiseSpeed();

        player = new Player((Point) ballPos.clone(),150,10, drawArea);

        area = drawArea;

        if(highScore.equals(""))
        {
            //initialise high score
            highScore = this.readHighScore();
        }

    }

    /**
     * This method is to give additional reward to user.
     *
     * The reward is give as follows:
     * 1. If the user takes less than 6 minutes to finish the
     * game and the number of brick broken is more than 120, reward
     * additional 10 points.
     * 2. If the user takes less than 3 minutes to finish the
     * game and the number of brick broken is more than 50, reward
     * additional 5 points.
     * 3. If the user takes less than 1 minute to finish the
     * game and the number of brick broken is more than 20, reward
     * additional 3 points.
     */
    public void reward() {
        if (timer.getMinutes() < 6 && score > 120){
            score += 10;
        } else if (timer.getMinutes() < 3 && score > 50){
            score += 5;
        } else if (timer.getMinutes() < 1 && score > 20){
            score += 3;
        }
    }

    /**
     * This method is to set initial speed in x and y direction of ball
     */
    private void initialiseSpeed() {
        ballSpeedX = 2;
        ballSpeedY = -4;
        ball.setSpeed(ballSpeedX,ballSpeedY);
    }

    /**
     * This method is to make ball.
     *
     * @param ballPos center point of ball
     */
    private void makeBall(Point2D ballPos){
        ballFactory = new BallFactory();
        ball = ballFactory.getBall("RUBBER", ballPos);
    }

    /**
     * This method moves the player bar and ball.
     */
    public void move(){
        player.move();
        ball.move();
    }

    /**
     * This method is to define impacts when the ball hits certain thing.
     *
     * The impacts are as followed:
     * 1. If the ball hits the player bar, reverse the direction of the ball.
     * 2. If the ball hits the brick, decrement the brick count and reward point.
     * 3. If the ball hits the border of frame, reverse the direction of the ball.
     * 4. If the player bar can't catch the ball and the ball goes beyond the frame,
     * decrement ball count, set ballLost to true and deduct point.
     */
    public void findImpacts(){

        /*
          If ball touches player, reverse direction of speedY
          if speedY is positive: ball goes down
          if speedY is negative: ball goes up
         */
        if(player.impact(ball)){
            ball.reverseY();
        }
        else if(impactWall()){
            /*
              for efficiency reverse is done into method impactWall
              because for every brick program checks for horizontal and vertical impacts
            */
            brickCount--;
            score++; //REWARD: if ball hits the brick, reward 1 point
        }

        /*
          if the ball hits the border, reverse direction of speedX
          if speedX is positive, ball goes right
          if speedX is negative, ball goes left
         */
        else if(impactBorder()) {
            ball.reverseX();
        }

        /*
          area.getY() is always 0
          if y-coordinate of center of ball < 0, reverse direction of speedY
         */
        else if(ball.getPosition().getY() < area.getY()){
            ball.reverseY();
        }

        /*
          area.getY() is always 0, area.getHeight() is always 450
          if y-coordinate of center of ball > 450, decrement ballCount and set ballLost to true
         */
        else if(ball.getPosition().getY() > area.getY() + area.getHeight()){
            ballCount--;
            ballLost = true;
            score -= 3; //PENALTY: if player can't catch the ball, deduct 3 points
        }
    }

    /**
     * This method is to check if the brick hit is broken or not.
     *
     * @return state of brick (broken / not broken)
     */
    private boolean impactWall(){
        for(Brick b : bricks){
            switch(b.findImpact(ball)) {
                //Vertical Impact
                case Brick.UP_IMPACT:
                    ball.reverseY();
                    return b.setImpact(ball.getDown(), Crack.UP);
                case Brick.DOWN_IMPACT:
                    ball.reverseY();
                    return b.setImpact(ball.getUp(),Crack.DOWN);

                //Horizontal Impact
                case Brick.LEFT_IMPACT:
                    ball.reverseX();
                    /*
                    REFACTOR: change Crack.RIGHT to Crack.LEFT so that
                    crack can be made when the ball hits the left side of the brick
                     */
                    return b.setImpact(ball.getRight(),Crack.LEFT);
                case Brick.RIGHT_IMPACT:
                    ball.reverseX();
                    /*
                    REFACTOR: change Crack.LEFT to Crack.RIGHT so that
                    crack can be made when the ball hits the right side of the brick
                     */
                    return b.setImpact(ball.getLeft(),Crack.RIGHT);

            }
        }
        return false;
    }

    /**
     * This method is to check if the ball hits the border of the frame.
     *
     * @return is the ball hits the border of the frame
     */
    private boolean impactBorder(){
        Point2D p = ball.getPosition();//get position of center of ball
        //area refers to drawArea, area.getX() is always 0, area.getWidth() is always 600
        //if x-coordinate of center of ball is < 0 or > 600, return true
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }

    /**
     * This method is to return brick count to the calling method.
     *
     * @return brick count
     */
    public int getBrickCount(){
        return brickCount;
    }

    /**
     * This method is to set brick count.
     *
     * @param brickCount number of brick
     */
    public void setBrickCount(int brickCount){
        this.brickCount = brickCount;
    }

    /**
     * This method is to return ball count to the calling method.
     *
     * @return number of ball left
     */
    public int getBallCount(){
        return ballCount;
    }

    /**
     * This method checks if the ball is lost.
     *
     * @return is the ball lost
     */
    public boolean isBallLost(){
        return ballLost;
    }

    /**
     * This method resets position of ball and player bar to the original position.
     * It also reinitialise speed of ball and set ballLost to false.
     */
    public void ballReset(){
        player.moveTo(startPoint);
        ball.moveTo(startPoint);
        initialiseSpeed();
        ballLost = false;
    }

    /**
     * This method resets the wall.
     * Brick is repaired.
     * Brick count is restored.
     * Ball count is restored.
     */
    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    }

    /**
     * This method checks if the number of ball left is 0.
     *
     * @return whether the number of ball left is 0
     */
    public boolean ballEnd(){
        return ballCount == 0;
    }

    /**
     * This method checks if the number of brick left is 0.
     *
     * @return whether the number of brick left is 0
     */
    public boolean isDone(){
        return brickCount == 0;
    }

    /**
     * This method sets the speed of ball in x direction.
     *
     * @param s speed of ball in x direction
     */
    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    }

    /**
     * This method sets the speed of ball in y direction.
     *
     * @param s speed of ball in y direction
     */
    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    }

    /**
     * This method resets the number of balls to 3.
     */
    public void resetBallCount(){
        ballCount = 3;
    }

    /**
     * This method return bricks created to the calling method.
     *
     * @return bricks created
     */
    public Brick[] getBricks() {
        return bricks;
    }

    /**
     * This method sets bricks.
     *
     * @param bricks bricks
     */
    public void setBricks(Brick[] bricks) {
        this.bricks = bricks;
    }

    /**
     * This method returns Ball object to the calling method.
     *
     * @return Ball object
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * This method sets Ball object.
     *
     * @param ball Ball object
     */
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    /**
     * This method returns Player object to the calling method.
     *
     * @return Player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * This method returns score to the calling method.
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * This method read the highest score from a file if the highest score record file exists
     * and return the string to the calling method.
     * Otherwise, it return a string "Nobody:0" to the calling method.
     *
     * @return highest score record
     */
    public String readHighScore(){
        FileReader readFile;
        BufferedReader reader = null;
        try {
            readFile = new FileReader("src/main/resources/highscore.dat");
            reader = new BufferedReader(readFile);
            return reader.readLine();
        }
        catch (Exception e) {
            return "Nobody:0";
        }
        finally {
            try{
                if(reader != null)
                    reader.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * This method checks if the current score is higher than the score stored in the file.
     * If current score is higher than the score in the file, prompt the user to input
     * his / her name and write the new highest score record to the file.
     */
    public void checkScore(){
        if (highScore.equals("")) {
            return;
        }
        if(score > Integer.parseInt(highScore.split(":")[1])){
            String name = JOptionPane.showInputDialog("You've created a new high score! What is your name?");
            highScore = name + ":" + score;
            /*
            .dat file is used because I don't want to let user edit the highScore file
            to change the high score
            */
            File scoreFile = new File("src/main/resources/highscore.dat");
            if(!scoreFile.exists())
            {
                try {
                    scoreFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileWriter writeFile;
            BufferedWriter writer = null;
            try {
                writeFile = new FileWriter(scoreFile);
                writer = new BufferedWriter(writeFile);
                /*
                write operation is used instead of
                append operation to ensure only the
                name of the person who scores the highest score and
                the highest score is kept inside highscore.dat file
                 */
                writer.write(this.highScore);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (writer != null)
                        writer.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This method returns the highest score.
     */
    public String getHighScore() {
        return highScore;
    }
}