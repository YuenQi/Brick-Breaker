package model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for Player class*/
class PlayerTest {

    /**Player object*/
    Player player = new Player(new Point(300,430),150,10, new Rectangle(0,0, 600,450));

    /**
     * This method tests for impact method.
     * If the bottom and center point of the ball hits the player bar, the return value will be true
     * and vice versa.
     */
    @Test
    public void impactTest() {
        Ball ball1 = new RubberBall(new Point(300,430));
        assertTrue(player.impact(ball1));
        Ball ball2 = new RubberBall(new Point(200,300));
        assertFalse(player.impact(ball2));
    }

    /**
     * This method tests for move method.
     * As move amount is 0 at the beginning, the position of ball and player bar does not change.
     * The original position of ball is at x=300, y=430.
     * The original position of player bar is at x=225, y=430.
     */
    @Test
    public void moveTest() {
        player.move();
        /*
        As move amount is 0 at the beginning, the position of ball and player bar does not change.
        The original position of ball is at x=300, y=430.
        The original position of player bar is at x=225, y=430.
         */
        assertEquals(new Point(300,430),player.getBallPoint().getLocation());
        assertEquals(new Point(225,430),((Rectangle) player.getPlayerFace()).getLocation());
    }

    /**
     * This method tests for moveLeft method.
     * Player bar will move left by the defined move amount, which is 5.
     */
    @Test
    public void moveLeftTest() {
        player.moveLeft();
        assertEquals(-5,player.getMoveAmount());
    }

    /**
     * This method tests for moveRight method.
     * Player bar will move right by the defined move amount, which is 5.
     */
    @Test
    public void moveRightTest() {
        player.moveRight();
        assertEquals(5,player.getMoveAmount());
    }

    /**
     * This method tests for stop method.
     * Player bar will stop.
     */
    @Test
    public void stopTest() {
        player.stop();
        assertEquals(0,player.getMoveAmount());
    }

    /**
     * This method tests for getPlayerFace method.
     */
    @Test
    public void getPlayerFaceTest() {
        assertEquals(new Rectangle(225,430,150,10), player.getPlayerFace());
    }

    /**
     * This method tests for moveTo method.
     * The ball and player bar will go to the point specified.
     */
    @Test
    public void moveToTest() {
        player.setBallPoint(new Point(200,400));
        player.setPlayerFace(new Rectangle(200,430,150,10));
        Point startPoint = new Point(300,430);
        player.moveTo(startPoint);
        /*
        As this method moves the ball and player bar back to the starting point,
        the ball and player bar go back to their original position.
         */
        assertEquals(new Point(300,430),player.getBallPoint().getLocation());
        assertEquals(new Point(225,430),((Rectangle) player.getPlayerFace()).getLocation());
    }
}