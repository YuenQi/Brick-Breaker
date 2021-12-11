package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for Wall class*/
class WallTest {

    /**Wall object*/
    Wall wall = new Wall(new Rectangle(0,0,600,450),new Point(300,430));

    /**
     * This method tests for reward method.
     * Different time taken by user to play the game and different number of brick broken will
     * result in different additional reward based on the reward scheme mentioned in reward method.
     */
    @Test
    public void rewardTest() {
        wall.getTimer().setMinutes(5);
        wall.setScore(130);
        wall.reward();
        assertEquals(140,wall.getScore());

        wall.getTimer().setMinutes(2);
        wall.setScore(60);
        wall.reward();
        assertEquals(65,wall.getScore());

        wall.getTimer().setMinutes(0);
        wall.getTimer().setSeconds(55);
        wall.setScore(30);
        wall.reward();
        assertEquals(33,wall.getScore());
    }

    /**
     * This method tests for move method.
     * As move amount of player bar is 0 at the beginning, the position of player bar does not change.
     * The original position of player bar is at x=225, y=430.
     * As the speed of ball in x direction in Wall class is 2,
     * speed of ball in y direction in Wall class is -4,
     * the center point of ball changes in the Wall class.
     */
    @Test
    public void moveTest() {
        wall.move();
        /*
        As move amount of player bar is 0 at the beginning, the position of player bar does not change.
        The original position of player bar is at x=225, y=430.
         */
        assertEquals(new Point(225,430),((Rectangle) wall.getPlayer().getPlayerFace()).getLocation());

        /*
         As the speed of ball in x direction in Wall class is 2,
         speed of ball in y direction in Wall class is -4,
         the center point of ball changes in the Wall class.
         */
        assertEquals(new Point2D.Double(302.0,426.0),wall.getBall().getPosition());
    }

    /**
     * This method tests for findImpacts method.
     * When the ball hits the player bar, speed of ball in y direction will be reserved.
     */
    @Test
    public void findImpactsTest() {
        System.out.println("Impact when ball hits the player bar - reverse speed of ball in y direction");
        wall.setBall(new RubberBall(new Point(300,430)));
        wall.setBallYSpeed(4);
        wall.findImpacts();
        assertEquals(-4,wall.getBall().getSpeedY());
    }

    /**
     * This method tests for setBrickCount and getBrickCount method.
     */
    @Test
    public void setAndGetBrickCountTest() {
        wall.setBrickCount(31);
        assertEquals(31,wall.getBrickCount());
    }

    /**
     * This method tests for getBallCount method.
     */
    @Test
    public void getBallCountTest() {
        assertEquals(3,wall.getBallCount());
    }

    /**
     * This method tests for isBallLost method.
     */
    @Test
    public void isBallLostTest() {
        assertFalse(wall.isBallLost());
    }

    /**
     * This method tests for ballReset method.
     * When ball is reset, ball and player go back to their original position.
     * Speed of ball in x direction is reset to 2.
     * Speed of ball in y direction is reset to -4.
     * ballLost is set to false.
     */
    @Test
    public void ballResetTest() {
        wall.getPlayer().setBallPoint(new Point(200,400));
        wall.getPlayer().setPlayerFace(new Rectangle(300,430,150,10));
        wall.setBallXSpeed(3);
        wall.setBallYSpeed(3);
        wall.setBallLost(true);

        wall.ballReset();

        //When ball is reset, ball and player go back to their original position
        assertEquals(new Point(300,430),wall.getPlayer().getBallPoint().getLocation());
        assertEquals(new Point(225,430),((Rectangle) wall.getPlayer().getPlayerFace()).getLocation());
        assertEquals(new Point(300,430), wall.getBall().getPosition());

        /*
        Speed of ball in x direction is reset to 2,
        speed of ball in y direction is reset to -4
         */
        assertEquals(2,wall.getBall().getSpeedX());
        assertEquals(-4,wall.getBall().getSpeedY());

        //ballLost is set to false
        assertFalse(wall.isBallLost());
    }

    /**
     * This method tests fot ballEnd method.
     * Originally, ball count is 3, so ballEnd() return false.
     * When the ball count is 0, ballEnd return true.
     */
    @Test
    public void ballEndTest() {
        //Originally, ball count is 3, so ballEnd() return false
        assertFalse(wall.ballEnd());

        //When the ball count is 0, ballEnd return true
        wall.setBallCount(0);
        assertTrue(wall.ballEnd());
    }

    /**
     * This method tests for isDone method.
     * When there are still bricks, wall is not considered done (completely destroyed),
     * so return value is false.
     * When there is no more brick, wall is done (completely destroyed),
     * so return value is true.
     */
    @Test
    public void isDoneTest() {
        //When there are still bricks, wall is not considered done (completely destroyed)
        wall.setBrickCount(31);
        assertFalse(wall.isDone());

        //When there is no more brick, wall is done (completely destroyed)
        wall.setBrickCount(0);
        assertTrue(wall.isDone());
    }

    /**
     * This method tests for setBallXSpeed method.
     */
    @Test
    public void setBallXSpeedTest() {
        wall.setBallXSpeed(4);
        assertEquals(4,wall.getBall().getSpeedX());
    }

    /**
     * This method tests for setBallYSpeed method.
     */
    @Test
    public void setBallYSpeedTest() {
        wall.setBallYSpeed(4);
        assertEquals(4,wall.getBall().getSpeedY());
    }

    /**
     * This method tests for resetBallCount method.
     */
    @Test
    public void resetBallCountTest() {
        wall.setBallCount(1);
        wall.resetBallCount();
        assertEquals(3,wall.getBallCount());
    }

    /**
     * This method tests for getScore method.
     */
    @Test
    public void getScoreTest() {
        //The score is initialised to 0
        assertEquals(0,wall.getScore());
    }
}