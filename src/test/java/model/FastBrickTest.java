package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class FastBrickTest {

    FastBrick fastBrick = new FastBrick(new Point(0,0), new Dimension(60,20));

    @Test
    public void makeBrickFaceTest1() {
        assertEquals(fastBrick.getBrick(),fastBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest2() {
        assertEquals(new Rectangle(new Point(0, 0), new Dimension(60, 20)),fastBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest3() {
        assertEquals("java.awt.Rectangle[x=0,y=0,width=60,height=20]",fastBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)).toString());
    }

    @Test
    public void getBrickTest1() {
        assertEquals("java.awt.Rectangle[x=0,y=0,width=60,height=20]",fastBrick.getBrick().toString());
    }

    @Test
    public void getBrickTest2() {
        assertEquals(fastBrick.makeBrickFace(new Point(0,0),new Dimension(60,20)),fastBrick.getBrick());
    }

    @Test
    public void getBrickTest3() {
        assertEquals(new Rectangle(new Point(0, 0), new Dimension(60, 20)),fastBrick.getBrick());
    }

    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(0x8bd2d9),fastBrick.getInnerColor());
    }

    @Test
    public void getBorderColorTest(){
        assertEquals(new Color(0x1815bd),fastBrick.getBorderColor());
    }

    @Test
    public void findLeftImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(0.0, 10.0));
        assertEquals(FastBrick.LEFT_IMPACT,fastBrick.findImpact(ball));
    }

    @Test
    public void findRightImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(60.0, 10.0));
        assertEquals(FastBrick.RIGHT_IMPACT,fastBrick.findImpact(ball));
    }

    @Test
    public void findDownImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(30.0, 20.0));
        assertEquals(FastBrick.DOWN_IMPACT,fastBrick.findImpact(ball));
    }

    @Test
    public void findNoImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(100.0, 30.0));
        assertEquals(0,fastBrick.findImpact(ball));
    }

}