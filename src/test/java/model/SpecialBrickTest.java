package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for SpecialBrick class*/
class SpecialBrickTest {

    /**SpecialBrick object*/
    SpecialBrick specialBrick = new SpecialBrick(new Point(570,20), new Dimension(60,20));

    /**
     * This method tests setImpact method.
     * The special brick is broken when the ball hits it for the first time.
     * The strength of the special brick becomes 0 when the ball hits it for the first time.
     */
    @Test
    public void setImpactTest() {
        Point2D upBall = new Point2D.Double(494.0, 37.0);
        assertTrue(specialBrick.setImpact(upBall, Crack.DOWN)); //the special brick is broken when the ball hits it for the first time
        assertEquals(0,specialBrick.getStrength()); //the strength of the special brick becomes 0 when the ball hits it for the first time
    }

    /*
    3 tests are generated for this method to ensure different ways of testing pass the test
    and there is no bug in the makeBrickFace method.
     */
    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest1() {
        assertEquals(specialBrick.getBrick(),specialBrick.makeBrickFace(new Point(570,20),new Dimension(60,20)));
    }

    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest2() {
        assertEquals(new Rectangle(new Point(570,20), new Dimension(60, 20)),specialBrick.makeBrickFace(new Point(570,20),new Dimension(60,20)));
    }

    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest3() {
        assertEquals("java.awt.Rectangle[x=570,y=20,width=60,height=20]",specialBrick.makeBrickFace(new Point(570,20),new Dimension(60,20)).toString());
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
        assertEquals("java.awt.Rectangle[x=570,y=20,width=60,height=20]",specialBrick.getBrick().toString());
    }

    /**
     * This method tests for getBrick method.
     */
    @Test
    public void getBrickTest2() {
        assertEquals(specialBrick.makeBrickFace(new Point(570,20),new Dimension(60,20)),specialBrick.getBrick());
    }

    /**
     * This method tests for getBrick method.
     */
    @Test
    public void getBrickTest3() {
        assertEquals(new Rectangle(new Point(570,20), new Dimension(60, 20)),specialBrick.getBrick());
    }

    /**
     * This method tests for getInnerColor method in Brick class to ensure inner color of brick is returned correctly.
     */
    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(0x7de893),specialBrick.getInnerColor());
    }

    /**
     * This method tests for getBorderColor method in Brick class to ensure border color of brick is returned correctly.
     */
    @Test
    public void getBorderColorTest(){
        assertEquals(new Color(0x006b15),specialBrick.getBorderColor());
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findLeftImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(570.0, 30.0));
        assertEquals(SpecialBrick.LEFT_IMPACT,specialBrick.findImpact(ball));
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findDownImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(590.0, 40.0));
        assertEquals(SpecialBrick.DOWN_IMPACT,specialBrick.findImpact(ball));
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findNoImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(100.0, 30.0));
        assertEquals(0,specialBrick.findImpact(ball));
    }
}