package test;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class RubberBallTest {

    RubberBall rubberBall = new RubberBall(new Point2D.Double(300.0,430.0));

    @Test
    public void makeBall() {
        Shape ball = new Ellipse2D.Double(295.0,425.0,10,10);
        assertEquals(ball,rubberBall.makeBall(new Point2D.Double(300.0,430.0), 10, 10));
    }
}