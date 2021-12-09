package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class FastBrickTest {

    Brick fastBrick = new FastBrick(new Point(0,0), new Dimension(60,20));

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
}