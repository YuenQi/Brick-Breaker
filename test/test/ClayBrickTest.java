package test;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ClayBrickTest {

    ClayBrick clayBrick = new ClayBrick(new Point(0,40), new Dimension(60,20));
    Rectangle brickFace = new Rectangle(new Point(0, 40), new Dimension(60, 20));

    @Test
    public void makeBrickFace() {
        Point pos = new Point(0,40);
        Dimension size = new Dimension(60,20);
        assertEquals(brickFace, clayBrick.makeBrickFace(pos, size));
    }

    @Test
    public void getBrick() {
        assertEquals(brickFace, clayBrick.getBrick());
    }
}