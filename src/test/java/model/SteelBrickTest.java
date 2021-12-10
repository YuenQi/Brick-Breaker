package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class SteelBrickTest {

    SteelBrick steelBrick = new SteelBrick(new Point(0,0), new Dimension(60,20));

    @Test
    public void makeBrickFaceTest1() {
        assertEquals(steelBrick.getBrick(),steelBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest2() {
        assertEquals(new Rectangle(new Point(0, 0), new Dimension(60, 20)),steelBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest3() {
        assertEquals("java.awt.Rectangle[x=0,y=0,width=60,height=20]",steelBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)).toString());
    }

    @Test
    public void getBrickTest1() {
        assertEquals("java.awt.Rectangle[x=0,y=0,width=60,height=20]",steelBrick.getBrick().toString());
    }

    @Test
    public void getBrickTest2() {
        assertEquals(steelBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)),steelBrick.getBrick());
    }

    @Test
    public void getBrickTest3() {
        assertEquals(new Rectangle(new Point(0, 0), new Dimension(60, 20)),steelBrick.getBrick());
    }

    @Test
    public void setImpactTest1() {
        Point2D upBall = new Point2D.Double(494.0, 37.0);
        steelBrick.setImpact(upBall, Crack.DOWN);

        //if steel brick is broken, the return value will be false
        if (steelBrick.isBroken())
            assertFalse(steelBrick.setImpact(upBall, Crack.DOWN));
    }

    @Test
    public void setImpactTest2() {
        Point2D upBall = new Point2D.Double(494.0, 37.0);
        steelBrick.setImpact(upBall, Crack.DOWN);
        /*
        if the random value generated is less than broken probability of
        steel brick (0.4), the steel brick will be broken
         */
        if (steelBrick.getRandomProbability() < 0.4)
            assertTrue(steelBrick.isBroken());
        else
            assertFalse(steelBrick.isBroken());
    }

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

    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(203, 203, 201),steelBrick.getInnerColor());
    }

    @Test
    public void getBorderColorTest(){
        assertEquals(Color.BLACK,steelBrick.getBorderColor());
    }
}