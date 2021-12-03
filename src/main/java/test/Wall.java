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

public class Wall {

    private Rectangle area;

    private Brick[] bricks;
    private Ball ball;
    private Player player;

    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;

    private int ballSpeedX;
    private int ballSpeedY;

    private int score = 0;



    private String highScore = "";

    public Wall(Rectangle drawArea, Point ballPos){

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
     * This method is to set initial speed in x and y direction of ball
     */
    private void initialiseSpeed() {
        ballSpeedX = 2;
        ballSpeedY = -4;
        ball.setSpeed(ballSpeedX,ballSpeedY);
    }

    private void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    }

    public void move(){
        player.move();
        ball.move();
    }

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
            score-=5; //PENALTY: if player can't catch the ball, deduct 5 points
        }
    }

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
                    return b.setImpact(ball.getRight(),Crack.RIGHT);
                case Brick.RIGHT_IMPACT:
                    ball.reverseX();
                    return b.setImpact(ball.getLeft(),Crack.LEFT);
            }
        }
        return false;
    }

    private boolean impactBorder(){
        Point2D p = ball.getPosition();//get position of center of ball
        //area refers to drawArea, area.getX() is always 0, area.getWidth() is always 600
        //if x-coordinate of center of ball is < 0 or > 600, return true
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }

    public int getBrickCount(){
        return brickCount;
    }

    public void setBrickCount(int brickCount){
        this.brickCount = brickCount;
    }

    public int getBallCount(){
        return ballCount;
    }

    public boolean isBallLost(){
        return ballLost;
    }

    public void ballReset(){
        player.moveTo(startPoint);
        ball.moveTo(startPoint);
        initialiseSpeed();
        ballLost = false;
    }

    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    }

    public boolean ballEnd(){
        return ballCount == 0;
    }

    public boolean isDone(){
        return brickCount == 0;
    }

    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    }

    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    }

    public void resetBallCount(){
        ballCount = 3;
    }

    public Brick[] getBricks() {
        return bricks;
    }

    public void setBricks(Brick[] bricks) {
        this.bricks = bricks;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

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

    public void resetScore() {
        score = 0;
    }

    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }
}