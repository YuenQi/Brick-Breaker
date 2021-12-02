package test;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SteelBrickTest {

    SteelBrick steelBrick = new SteelBrick(new Point(60,0), new Dimension(60,20));
    Rectangle brickFace = new Rectangle(new Point(60, 0), new Dimension(60, 20));

    @Test
    public void makeBrickFace() {
        Point pos = new Point(60,0);
        Dimension size = new Dimension(60,20);
        assertEquals(brickFace, steelBrick.makeBrickFace(pos, size));
    }

    @Test
    public void getBrick() {
        assertEquals(brickFace, steelBrick.getBrick());
    }

    @Test
    public void setImpact() {
        Point2D down = new Point2D.Double();
        down.setLocation(300.0, 435.0);
        int up = 30;
        assertFalse(steelBrick.setImpact(down, up));
    }

    @Test
    public void impact() {
        Random rnd = new Random();
        steelBrick.impact();
        if (rnd.nextDouble() > 0.4){
            assertFalse(steelBrick.isBroken());
        } else {
            assertTrue(steelBrick.isBroken());
        }
    }
}