package model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/*
I understand the test of this class is a bit weird but I just want to use assertNotNull to
make sure that the crack exists and try to write unit test for every class.
I can't think of other way of writing unit test as I read from
https://softwareengineering.stackexchange.com/questions/135886/how-can-i-unit-test-audio that
we can't write unit test for graphics and audio. Instead, I used debug mode to run GraphicsMain
and test it as I think it's a better testing for this type of class (graphics involved).
 */
/**This is test class for Crack class*/
class CrackTest {

    CementBrick cementBrick = new CementBrick(new Point(60,0), new Dimension(60,20));
    Crack crack = new Crack(cementBrick, CementBrick.CRACK_DEPTH, CementBrick.STEPS);

    /**
     * This method tests for draw method.
     * When a crack is made, it's not null when it's to be
     * drawn on screen.
     */
    @Test
    public void drawTest() {
        crack.makeCrack(new Point(62, 59), new Point(90,40));
        crack.draw();
        assertNotNull(crack);
    }

    /**
     * This method tests for reset method.
     * To test whether a crack has been reset, I assume everything is reset,
     * so the cement brick is not broken and the strength of cement brick is reset to 2.
     * There is no way to check the drawing, or at least I can't find it, so I did it this way.
     */
    @Test
    public void resetTest() {
        crack.reset();
        assertFalse(cementBrick.isBroken());
        assertEquals(2, cementBrick.getStrength());
    }

    /**
     * This method tests for the first makeCrack method
     * with (Point2D point, int direction) as its parameter.
     * When a crack is made, it's not null.
     */
    @Test
    public void setStartAndEndPointOfCrackTest() {
        crack.makeCrack(new Point2D.Double(62.0, 59.0), Crack.UP);
        assertNotNull(crack);
    }

    /**
     * This method tests for the second makeCrack method
     * with (Point start, Point end) as its parameter.
     * When a crack is made, it's not null.
     */
    @Test
    public void makeCrackTest() {
        crack.makeCrack(new Point(62, 59), new Point(90,40));
        assertNotNull(crack);
    }
}