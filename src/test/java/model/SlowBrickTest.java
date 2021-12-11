package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class SlowBrickTest {

    SlowBrick slowBrick = new SlowBrick(new Point(60,0), new Dimension(60,20));

    @Test
    public void makeBrickFaceTest1() {
        assertEquals(slowBrick.getBrick(),slowBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest2() {
        assertEquals(new Rectangle(new Point(60, 0), new Dimension(60, 20)),slowBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)));
    }

    @Test
    public void makeBrickFaceTest3() {
        assertEquals("java.awt.Rectangle[x=60,y=0,width=60,height=20]",slowBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)).toString());
    }

    @Test
    public void getBrickTest1() {
        assertEquals("java.awt.Rectangle[x=60,y=0,width=60,height=20]",slowBrick.getBrick().toString());
    }

    @Test
    public void getBrickTest2() {
        assertEquals(slowBrick.makeBrickFace(new Point(60,0),new Dimension(60,20)),slowBrick.getBrick());
    }

    @Test
    public void getBrickTest3() {
        assertEquals(new Rectangle(new Point(60, 0), new Dimension(60, 20)),slowBrick.getBrick());
    }

    @Test
    public void getInnerColorTest(){
        assertEquals(new Color(0xa995e8),slowBrick.getInnerColor());
    }

    @Test
    public void getBorderColorTest(){
        assertEquals(new Color(0x8932a8),slowBrick.getBorderColor());
    }

    @Test
    public void findLeftImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(60.0, 10.0));
        assertEquals(SlowBrick.LEFT_IMPACT,slowBrick.findImpact(ball));
    }

    @Test
    public void findRightImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(120.0, 10.0));
        assertEquals(SlowBrick.RIGHT_IMPACT,slowBrick.findImpact(ball));
    }

    @Test
    public void findDownImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(90.0, 20.0));
        assertEquals(SlowBrick.DOWN_IMPACT,slowBrick.findImpact(ball));
    }

    @Test
    public void findNoImpactTest(){
        Ball ball = new RubberBall(new Point2D.Double(100.0, 30.0));
        assertEquals(0,slowBrick.findImpact(ball));
    }

}