package model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player(new Point(300,430),150,10, new Rectangle(0,0, 600,450));

    @Test
    public void impactTest() {
        Ball ball1 = new RubberBall(new Point(300,430));
        assertTrue(player.impact(ball1));
        Ball ball2 = new RubberBall(new Point(200,300));
        assertFalse(player.impact(ball2));
    }

    @Test
    public void move() {
        player.move();
        /*
        As move amount is 0 at the beginning, the position of ball and player bar does not change.
        The original position of ball is at x=300, y=430.
        The original position of player bar is at x=225, y=430.
         */
        assertEquals(new Point(300,430),player.getBallPoint().getLocation());
        assertEquals(new Point(225,430),((Rectangle) player.getPlayerFace()).getLocation());
    }

    @Test
    public void moveLeft() {
        player.moveLeft();
        assertEquals(-5,player.getMoveAmount());
    }

    @Test
    public void moveRight() {
        player.moveRight();
        assertEquals(5,player.getMoveAmount());
    }

    @Test
    public void stop() {
        player.stop();
        assertEquals(0,player.getMoveAmount());
    }

    @Test
    public void getPlayerFace() {
        assertEquals(new Rectangle(225,430,150,10), player.getPlayerFace());
    }

    @Test
    public void moveTo() {
        player.setBallPoint(new Point(200,400));
        player.setPlayerFace(new Rectangle(200,300,150,10));
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