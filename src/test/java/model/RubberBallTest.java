package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for RubberBall class*/
class RubberBallTest {

    /**RubberBall object*/
    RubberBall ball = new RubberBall(new Point(300,430));

    /**
     * This method tests for makeBall method.
     */
    @Test
    public void makeBallTest() {
        assertEquals(ball.getBallFace(),ball.makeBall(new Point(300,430),10,10));
    }

    /**
     * This method tests for move method.
     * As speed of ball in x direction and y direction is 0 at the beginning,
     * the center point of the ball remains the same as the original which is (300.0,430.0).
     */
    @Test
    public void moveTest(){
        ball.move();
        /*
        As speed of ball in x direction and y direction is 0 at the beginning,
        the center point of the ball remains the same as the original which is (300.0,430.0).
         */
        assertEquals(new Point2D.Double(300.0,430.0),ball.getPosition());
    }

    /**
     * This method tests for setSpeed method.
     */
    @Test
    public void setSpeedTest(){
        ball.setSpeed(3,3);
        assertEquals(3,ball.getSpeedX());
        assertEquals(3,ball.getSpeedY());
    }

    /**
     * This method tests for setXSpeed method.
     */
    @Test
    public void setAndGetSpeedXTest(){
        ball.setXSpeed(4);
        assertEquals(4,ball.getSpeedX());
    }

    /**
     * This method tests for setYSpeed and getSpeedY methods.
     */
    @Test
    public void setAndGetSpeedYTest(){
        ball.setYSpeed(4);
        assertEquals(4,ball.getSpeedY());
    }

    /**
     * This method tests for reverseX method.
     * Speed of ball in x direction will be reserved.
     */
    @Test
    public void reverseXTest(){
        ball.setXSpeed(3);
        ball.reverseX();
        assertEquals(-3,ball.getSpeedX());
    }

    /**
     * This method tests for reverseY method.
     * Speed of ball in y direction will be reserved.
     */
    @Test
    public void reverseYTest(){
        ball.setYSpeed(3);
        ball.reverseY();
        assertEquals(-3,ball.getSpeedY());
    }

    /**
     * This method tests for getInnerColor method in Ball class to ensure inner color of rubber ball is returned correctly.
     */
    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(255, 219, 88),ball.getInnerColor());
    }

    /**
     * This method tests for getBorderColor method in Ball class to ensure border color of rubber ball is returned correctly.
     */
    @Test
    public void getBorderColorTest(){
        assertEquals(new Color(255, 219, 88).darker().darker(),ball.getBorderColor());
    }

    /**
     * This method tests for getPosition method.
     */
    @Test
    public void getPositionTest(){
        assertEquals(new Point2D.Double(300.0,430.0),ball.getPosition());
    }

    /**
     * This method tests for getBallFace method.
     */
    @Test
    public void getBallFaceTest(){
        assertEquals(new Ellipse2D.Double(295,425,10,10),ball.getBallFace());
    }

    /**
     * This method tests for moveTo method.
     * The ball will go to the point specified.
     */
    @Test
    public void moveToTest(){
        Point point = new Point(305,435);
        ball.moveTo(point);
        assertEquals(new Point(305,435),ball.getPosition());
    }

    /**
     * This method tests for setUp and getUp methods.
     */
    @Test
    public void setAndGetUpTest(){
        ball.setUp(new Point2D.Double(300.0,425.0));
        assertEquals(new Point2D.Double(300.0,425.0),ball.getUp());
    }

    /**
     * This method tests for setDown and getDown methods.
     */
    @Test
    public void setAndGetDownTest(){
        ball.setDown(new Point2D.Double(300.0,435.0));
        assertEquals(new Point2D.Double(300.0,435.0),ball.getDown());
    }

    /**
     * This method tests for setLeft and getLeft methods.
     */
    @Test
    public void setAndGetLeftTest(){
        ball.setLeft(new Point2D.Double(295.0,430.0));
        assertEquals(new Point2D.Double(295.0,430.0),ball.getLeft());
    }

    /**
     * This method tests for setRight and getRight methods.
     */
    @Test
    public void setAndGetRightTest(){
        ball.setRight(new Point2D.Double(305.0,430.0));
        assertEquals(new Point2D.Double(305.0,430.0),ball.getRight());
    }

}