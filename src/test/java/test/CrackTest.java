package test;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class CrackTest {

    CementBrick cementBrick = new CementBrick(new Point(0,0), new Dimension(60,20));
    Crack crack = new Crack(cementBrick, 1, 35);

    @Test
    public void draw() {
        crack.makeCrack(new Point(62, 59), new Point(90,40));
        crack.draw();
        assertNotNull(crack);
    }

    @Test
    public void reset() {
        crack.reset();
        assertFalse(cementBrick.isBroken());
    }

    @Test
    public void makeCrack() {
        crack.makeCrack(new Point2D.Double(62.0, 59.0), 10);
        assertNotNull(crack);
    }

    @Test
    public void testMakeCrack() {
        crack.makeCrack(new Point(62, 59), new Point(90,40));
        assertNotNull(crack);
    }
}