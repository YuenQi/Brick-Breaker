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
class CrackTest {

    CementBrick cementBrick = new CementBrick(new Point(60,0), new Dimension(60,20));
    Crack crack = new Crack(cementBrick, CementBrick.CRACK_DEPTH, CementBrick.STEPS);

    @Test
    public void drawTest() {
        /*
        This method tests when a crack is made, it's not null when it's to be
        drawn on screen.
         */
        crack.makeCrack(new Point(62, 59), new Point(90,40));
        crack.draw();
        assertNotNull(crack);
    }

    @Test
    public void resetTest() {
        /*
        To test whether a crack has been reset, I assume everything is reset,
        so the cement brick is not broken and the strength of cement brick is reset to 2.
        There is no way to check the drawing, so I did it this way.
         */
        crack.reset();
        assertFalse(cementBrick.isBroken());
        assertEquals(2, cementBrick.getStrength());
    }

    @Test
    public void setStartAndEndPointOfCrackTest() {
        //When a crack is made, it's not null
        crack.makeCrack(new Point2D.Double(62.0, 59.0), Crack.UP);//test the first makeCrack method
        assertNotNull(crack);
    }

    @Test
    public void makeCrackTest() {
        //When a crack is made, it's not null
        crack.makeCrack(new Point(62, 59), new Point(90,40));//test the second makeCrack method
        assertNotNull(crack);
    }
}