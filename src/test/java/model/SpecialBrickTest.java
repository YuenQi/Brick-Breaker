package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class SpecialBrickTest {

    SpecialBrick specialBrick = new SpecialBrick(new Point(570,20), new Dimension(60,20));

    @Test
    public void setImpactTest() {
        Point2D upBall = new Point2D.Double(494.0, 37.0);
        assertTrue(specialBrick.setImpact(upBall, Crack.DOWN)); //the special brick is broken when the ball hits it for the first time
        assertEquals(0,specialBrick.getStrength()); //the strength of the special brick becomes 0 when the ball hits it for the first time
    }

    @Test
    public void makeBrickFaceTest1() {
        assertEquals(specialBrick.getBrick(),specialBrick.makeBrickFace(new Point(570,20),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest2() {
        assertEquals(new Rectangle(new Point(570,20), new Dimension(60, 20)),specialBrick.makeBrickFace(new Point(570,20),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest3() {
        assertEquals("java.awt.Rectangle[x=570,y=20,width=60,height=20]",specialBrick.makeBrickFace(new Point(570,20),new Dimension(60,20)).toString());
    }

    @Test
    public void getBrickTest1() {
        assertEquals("java.awt.Rectangle[x=570,y=20,width=60,height=20]",specialBrick.getBrick().toString());
    }

    @Test
    public void getBrickTest2() {
        assertEquals(specialBrick.makeBrickFace(new Point(570,20),new Dimension(60,20)),specialBrick.getBrick());
    }

    @Test
    public void getBrickTest3() {
        assertEquals(new Rectangle(new Point(570,20), new Dimension(60, 20)),specialBrick.getBrick());
    }

    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(0x7de893),specialBrick.getInnerColor());
    }

    @Test
    public void getBorderColorTest(){
        assertEquals(new Color(0x006b15),specialBrick.getBorderColor());
    }
}