package test;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class CementBrickTest {

    CementBrick cementBrick = new CementBrick(new Point(0,0), new Dimension(60,20));
    Rectangle brickFace = new Rectangle(new Point(0, 0), new Dimension(60, 20));

    @Test
    public void makeBrickFace() {
        Point pos = new Point(0,0);
        Dimension size = new Dimension(60,20);
        assertEquals(brickFace, cementBrick.makeBrickFace(pos, size));
    }

    @Test
    public void setImpact() {
        Point2D down = new Point2D.Double();
        down.setLocation(300.0, 435.0);
        int up = 30;
        assertFalse(cementBrick.setImpact(down, up));
    }

    @Test
    public void getBrick() {
        assertEquals(brickFace, cementBrick.getBrick());
    }

    @Test
    public void repair() {
        cementBrick.repair();
        assertFalse(cementBrick.isBroken());
    }
}