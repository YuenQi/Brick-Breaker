package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class CementBrickTest {

    CementBrick cementBrick = new CementBrick(new Point(60,0), new Dimension(60,20));

    @Test
    public void makeBrickFaceTest1() {
        assertEquals(cementBrick.getBrick(),cementBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest2() {
        assertEquals(new Rectangle(new Point(60, 0), new Dimension(60, 20)),cementBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest3() {
        assertEquals("java.awt.Rectangle[x=60,y=0,width=60,height=20]",cementBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)).toString());
    }

    @Test
    public void setUpImpactTest() {
        System.out.println("Test - point on the bottom of the ball hits the top part of the brick");
        Point2D downBall = new Point2D.Double(240.0, 22.0);
        assertFalse(cementBrick.setImpact(downBall, Crack.UP)); //the cement brick is not broken when the ball hits it for the first time
        assertEquals(1,cementBrick.getStrength()); //the strength of the cement brick is reduced by 1 when the ball hits it for the first time
        assertTrue(cementBrick.setImpact(downBall, Crack.UP)); //the cement brick is broken when the ball hits it for the second time
        assertEquals(0,cementBrick.getStrength()); //the strength of the cement brick becomes 0 when the ball hits it for the second time
    }

    @Test
    public void setDownImpactTest() {
        System.out.println("Test - point on the top of the ball hits the bottom part of the brick");
        Point2D upBall = new Point2D.Double(494.0, 37.0);
        assertFalse(cementBrick.setImpact(upBall, Crack.DOWN)); //the cement brick is not broken when the ball hits it for the first time
        assertEquals(1,cementBrick.getStrength()); //the strength of the cement brick is reduced by 1 when the ball hits it for the first time
        assertTrue(cementBrick.setImpact(upBall, Crack.DOWN)); //the cement brick is broken when the ball hits it for the second time
        assertEquals(0,cementBrick.getStrength()); //the strength of the cement brick becomes 0 when the ball hits it for the second time
    }

    @Test
    public void setLeftImpactTest() {
        System.out.println("Test - point on the right of the ball hits the left part of the brick");
        Point2D rightBall = new Point2D.Double(392.0, 30.0);
        assertFalse(cementBrick.setImpact(rightBall, Crack.LEFT)); //the cement brick is not broken when the ball hits it for the first time
        assertEquals(1,cementBrick.getStrength()); //the strength of the cement brick is reduced by 1 when the ball hits it for the first time
        assertTrue(cementBrick.setImpact(rightBall, Crack.LEFT)); //the cement brick is broken when the ball hits it for the second time
        assertEquals(0,cementBrick.getStrength()); //the strength of the cement brick becomes 0 when the ball hits it for the second time
    }

    @Test
    public void setRightImpactTest() {
        System.out.println("Test - point on the left of the ball hits the right part of the brick");
        Point2D leftBall = new Point2D.Double(268.0, 30.0);
        assertFalse(cementBrick.setImpact(leftBall, Crack.RIGHT)); //the cement brick is not broken when the ball hits it for the first time
        assertEquals(1,cementBrick.getStrength()); //the strength of the cement brick is reduced by 1 when the ball hits it for the first time
        assertTrue(cementBrick.setImpact(leftBall, Crack.RIGHT)); //the cement brick is broken when the ball hits it for the second time
        assertEquals(0,cementBrick.getStrength()); //the strength of the cement brick becomes 0 when the ball hits it for the second time
    }

    @Test
    public void getBrickTest1() {
        assertEquals("java.awt.Rectangle[x=60,y=0,width=60,height=20]",cementBrick.getBrick().toString());
    }

    @Test
    public void getBrickTest2() {
        assertEquals(cementBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)),cementBrick.getBrick());
    }

    @Test
    public void getBrickTest3() {
        assertEquals(new Rectangle(new Point(60, 0), new Dimension(60, 20)),cementBrick.getBrick());
    }

    @Test
    public void repairTest() {
        cementBrick.repair();
        assertFalse(cementBrick.isBroken());
        assertEquals(2,cementBrick.getStrength());
    }

    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(147, 147, 147),cementBrick.getInnerColor());
    }

    @Test
    public void getBorderColorTest(){
        assertEquals(new Color(217, 199, 175),cementBrick.getBorderColor());
    }

    @Test
    public void findLeftImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(60.0, 10.0));
        assertEquals(CementBrick.LEFT_IMPACT,cementBrick.findImpact(ball));
    }

    @Test
    public void findRightImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(120.0, 10.0));
        assertEquals(CementBrick.RIGHT_IMPACT,cementBrick.findImpact(ball));
    }

    @Test
    public void findDownImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(90.0, 20.0));
        assertEquals(CementBrick.DOWN_IMPACT,cementBrick.findImpact(ball));
    }

    @Test
    public void findNoImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(100.0, 30.0));
        assertEquals(0,cementBrick.findImpact(ball));
    }
}