package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for SteelBrick class*/
class SteelBrickTest {

    SteelBrick steelBrick = new SteelBrick(new Point(0,0), new Dimension(60,20));

     /*
    3 tests are generated for this method to ensure different ways of testing pass the test
    and there is no bug in the makeBrickFace method.
     */
    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest1() {
        assertEquals(steelBrick.getBrick(),steelBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)));
    }

    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest2() {
        assertEquals(new Rectangle(new Point(0, 0), new Dimension(60, 20)),steelBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)));
    }

    /**
     * This method tests for makeBrickFace method.
     */
    @Test
    public void makeBrickFaceTest3() {
        assertEquals("java.awt.Rectangle[x=0,y=0,width=60,height=20]",steelBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)).toString());
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
        assertEquals("java.awt.Rectangle[x=0,y=0,width=60,height=20]",steelBrick.getBrick().toString());
    }

    /**
     * This method tests for getBrick method.
     */
    @Test
    public void getBrickTest2() {
        assertEquals(steelBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)),steelBrick.getBrick());
    }

    /**
     * This method tests for getBrick method.
     */
    @Test
    public void getBrickTest3() {
        assertEquals(new Rectangle(new Point(0, 0), new Dimension(60, 20)),steelBrick.getBrick());
    }

    /**
     * This method tests setImpact method.
     * If steel brick is broken, the return value will be false.
     */
    @Test
    public void setImpactTest1() {
        Point2D upBall = new Point2D.Double(494.0, 37.0);
        steelBrick.setImpact(upBall, Crack.DOWN);

        //if steel brick is broken, the return value will be false
        if (steelBrick.isBroken())
            assertFalse(steelBrick.setImpact(upBall, Crack.DOWN));
    }

    /**
     * This method tests setImpact method.
     * If the random value generated is less than broken probability of
     * steel brick (0.4), the steel brick will be broken and vice versa.
     */
    @Test
    public void setImpactTest2() {
        Point2D upBall = new Point2D.Double(494.0, 37.0);
        steelBrick.setImpact(upBall, Crack.DOWN);
        /*
        if the random value generated is less than broken probability of
        steel brick (0.4), the steel brick will be broken and vice versa.
         */
        if (steelBrick.getRandomProbability() < 0.4)
            assertTrue(steelBrick.isBroken());
        else
            assertFalse(steelBrick.isBroken());
    }

    /**
     * This method tests for impact method.
     * If the random value generated is less than broken probability of steel brick,
     * the strength of steel brick will become 0 and the steel brick will be broken.
     * if the random value generated is more than broken probability of steel brick,
     * the strength of steel brick will remain as 1 and the steel brick will not break.
     */
    @Test
    public void impactTest() {
        steelBrick.impact();
        /*
        if the random value generated is less than broken probability of steel brick,
        the strength of steel brick will become 0 and
        the steel brick will be broken
         */
        if (steelBrick.getRandomProbability() < 0.4){
            assertEquals(0,steelBrick.getStrength());
            assertTrue(steelBrick.isBroken());
        }
        /*
        if the random value generated is more than broken probability of steel brick,
        the strength of steel brick will remain as 1 and
        the steel brick will not break
         */
        else {
            assertEquals(1,steelBrick.getStrength());
            assertFalse(steelBrick.isBroken());
        }
    }

    /**
     * This method tests for getInnerColor method in Brick class to ensure inner color of brick is returned correctly.
     */
    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(203, 203, 201),steelBrick.getInnerColor());
    }

    /**
     * This method tests for getBorderColor method in Brick class to ensure border color of brick is returned correctly.
     */
    @Test
    public void getBorderColorTest(){
        assertEquals(Color.BLACK,steelBrick.getBorderColor());
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findLeftImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(0.0, 10.0));
        assertEquals(SteelBrick.LEFT_IMPACT,steelBrick.findImpact(ball));
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findRightImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(60.0, 10.0));
        assertEquals(SteelBrick.RIGHT_IMPACT,steelBrick.findImpact(ball));
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findDownImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(30.0, 20.0));
        assertEquals(SteelBrick.DOWN_IMPACT,steelBrick.findImpact(ball));
    }

    /**
     * This method tests for findImpact method in Brick class to ensure the impact is correct.
     */
    @Test
    public void findNoImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(100.0, 30.0));
        assertEquals(0,steelBrick.findImpact(ball));
    }
}