package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for SlowBrick class*/
class SlowBrickTest {

    /**SlowBrick object*/
    SlowBrick slowBrick = new SlowBrick(new Point(60,0), new Dimension(60,20));

    /*
    3 tests are generated for this method to ensure different ways of testing pass the test
    and there is no bug in the makeBrickFace method.
     */
    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest1() {
        assertEquals(slowBrick.getBrick(),slowBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)));
    }

    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest2() {
        assertEquals(new Rectangle(new Point(60, 0), new Dimension(60, 20)),slowBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)));
    }

    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest3() {
        assertEquals("java.awt.Rectangle[x=60,y=0,width=60,height=20]",slowBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)).toString());
    }

    /*
    3 tests are generated for this method to ensure different ways of testing pass the test
    and there is no bug in the getBrick method.
     */
    /**
     * This method tests for getBrick method.
     */
    @Test
    public void getBrickTest1() {
        assertEquals("java.awt.Rectangle[x=60,y=0,width=60,height=20]",slowBrick.getBrick().toString());
    }

    /**
     * This method tests for getBrick method.
     */
    @Test
    public void getBrickTest2() {
        assertEquals(slowBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)),slowBrick.getBrick());
    }

    /**
     * This method tests for getBrick method.
     */
    @Test
    public void getBrickTest3() {
        assertEquals(new Rectangle(new Point(60, 0), new Dimension(60, 20)),slowBrick.getBrick());
    }

    /**
     * This method tests for getInnerColor method in Brick class to ensure inner color of brick is returned correctly.
     */
    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(0xa995e8),slowBrick.getInnerColor());
    }

    /**
     * This method tests for getBorderColor method in Brick class to ensure border color of brick is returned correctly.
     */
    @Test
    public void getBorderColorTest(){
        assertEquals(new Color(0x8932a8),slowBrick.getBorderColor());
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findLeftImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(60.0, 10.0));
        assertEquals(SlowBrick.LEFT_IMPACT,slowBrick.findImpact(ball));
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findRightImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(120.0, 10.0));
        assertEquals(SlowBrick.RIGHT_IMPACT,slowBrick.findImpact(ball));
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findDownImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(90.0, 20.0));
        assertEquals(SlowBrick.DOWN_IMPACT,slowBrick.findImpact(ball));
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findNoImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(100.0, 30.0));
        assertEquals(0,slowBrick.findImpact(ball));
    }

}