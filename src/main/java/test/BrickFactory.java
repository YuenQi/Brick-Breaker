package test;

import java.awt.*;

public class BrickFactory {

    public Brick getBrick(String brickType, Point point, Dimension size){
        if (brickType == null)
            return null;
        if(brickType.equalsIgnoreCase("CLAY"))
            return new ClayBrick(point, size);
        else if(brickType.equalsIgnoreCase("STEEL"))
            return new SteelBrick(point, size);
        else if(brickType.equalsIgnoreCase("CEMENT"))
            return new CementBrick(point, size);
        else if(brickType.equalsIgnoreCase("FAST_BRICK"))
            return new FastBrick(point, size);
        else if(brickType.equalsIgnoreCase("SLOW_BRICK"))
            return new SlowBrick(point, size);

        return null;
    }
}
