package view;

import model.Level;
import model.Wall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DebugPanelTest {

    Wall wall = new Wall(new Rectangle(0,0,600,450),new Point(300,430));
    Level level = new Level(new Rectangle(0,0,600,450),30,3, 3, wall);
    DebugPanel debugPanel = new DebugPanel(wall,level);

    @Test
    public void setValuesTest() {
        debugPanel.setValues(4,4);
        assertEquals(4,wall.getBall().getSpeedX());
        assertEquals(4,wall.getBall().getSpeedY());
    }
}