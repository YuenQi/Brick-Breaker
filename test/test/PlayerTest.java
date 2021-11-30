package test;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player(new Point(300, 430), 150,10, new Rectangle(0,0, 600,450));
    Rectangle playerFace = new Rectangle(225,430,150,10);
    int moveAmount = 0;
    Ball ballPoint = new RubberBall(new Point(300,430));

    @Test
    public void impact() {
        Ball ball = new RubberBall(new Point(300,430));
        assertTrue(player.impact(ball));
    }

    @Test
    public void moveLeft() {
        player.moveLeft();
        assertEquals(-5, moveAmount-5);
    }

    @Test
    public void moveRight() {
        player.moveRight();
        assertEquals(5, moveAmount+5);
    }

    @Test
    public void stop() {
        player.stop();
        assertEquals(0, moveAmount);
    }

    @Test
    public void getPlayerFace() {
        assertEquals(playerFace, player.getPlayerFace());
    }

}