package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class RubberBallTest {

    RubberBall ball = new RubberBall(new Point(300,430));

    @Test
    public void makeBall() {
        assertEquals(ball.getBallFace(),ball.makeBall(new Point(300,430),10,10));
    }

    @Test
    public void moveTest(){
        ball.move();
        /*
        As speed of ball in x direction and y direction is 0 at the beginning,
        the center point of the ball remains the same as the original which is (300.0,430.0).
         */
        assertEquals(new Point2D.Double(300.0,430.0),ball.getPosition());
    }

    @Test
    public void setSpeedTest(){
        ball.setSpeed(3,3);
        assertEquals(3,ball.getSpeedX());
        assertEquals(3,ball.getSpeedY());
    }

    @Test
    public void setAndGetSpeedXTest(){
        ball.setXSpeed(4);
        assertEquals(4,ball.getSpeedX());
    }

    @Test
    public void setAndGetSpeedYTest(){
        ball.setYSpeed(4);
        assertEquals(4,ball.getSpeedY());
    }

    @Test
    public void reverseXTest(){
        ball.setXSpeed(3);
        ball.reverseX();
        assertEquals(-3,ball.getSpeedX());
    }

    @Test
    public void reverseYTest(){
        ball.setYSpeed(3);
        ball.reverseY();
        assertEquals(-3,ball.getSpeedY());
    }

    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(255, 219, 88),ball.getInnerColor());
    }

    @Test
    public void getBorderColorTest(){
        assertEquals(new Color(255, 219, 88).darker().darker(),ball.getBorderColor());
    }

    @Test
    public void getPositionTest(){
        assertEquals(new Point2D.Double(300.0,430.0),ball.getPosition());
    }

    @Test
    public void getBallFaceTest(){
        assertEquals(new Ellipse2D.Double(295,425,10,10),ball.getBallFace());
    }

    @Test
    public void moveToTest(){
        Point point = new Point(305,435);
        ball.moveTo(point);
        assertEquals(new Point(305,435),ball.getPosition());
    }

    @Test
    public void setAndGetUpTest(){
        ball.setUp(new Point2D.Double(300.0,425.0));
        assertEquals(new Point2D.Double(300.0,425.0),ball.getUp());
    }

    @Test
    public void setAndGetDownTest(){
        ball.setDown(new Point2D.Double(300.0,435.0));
        assertEquals(new Point2D.Double(300.0,435.0),ball.getDown());
    }

    @Test
    public void setAndGetLeftTest(){
        ball.setLeft(new Point2D.Double(295.0,430.0));
        assertEquals(new Point2D.Double(295.0,430.0),ball.getLeft());
    }

    @Test
    public void setAndGetRightTest(){
        ball.setRight(new Point2D.Double(305.0,430.0));
        assertEquals(new Point2D.Double(305.0,430.0),ball.getRight());
    }

}