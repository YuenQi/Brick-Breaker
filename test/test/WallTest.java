package test;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Wall wall = new Wall(new Rectangle(0,0,600, 450),30,3,6/2,new Point(300,430));
    RubberBall rubberBall = new RubberBall(new Point2D.Double(300.0,430.0));

    @Test
    public void findImpacts() {
        wall.findImpacts();
        assertEquals(0, rubberBall.getSpeedY());
    }

    @Test
    public void getBrickCount() {
        assertEquals(0, wall.getBrickCount());
    }

    @Test
    public void getBallCount() {
        assertEquals(3, wall.getBallCount());
    }

    @Test
    public void isBallLost() {
        assertFalse(wall.isBallLost());
    }

    @Test
    public void ballReset() {
        wall.ballReset();
        assertFalse(wall.isBallLost());
    }

    @Test
    public void ballEnd() {
        assertFalse(wall.ballEnd());
    }

    @Test
    public void isDone() {
        assertTrue(wall.isDone());
    }

    @Test
    public void hasLevel() {
        assertTrue(wall.hasLevel());
    }

    @Test
    public void resetBallCount() {
        wall.resetBallCount();
        assertEquals(3,wall.getBallCount());
    }
}