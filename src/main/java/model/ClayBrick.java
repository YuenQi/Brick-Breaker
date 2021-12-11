package model;

import java.awt.*;
import java.awt.Point;

/**
 * This is ClayBrick class which inherits Brick class.
 */
public class ClayBrick extends Brick {

    /**name of brick*/
    private static final String NAME = "Clay Brick";
    /**inner color of brick*/
    private static final Color INNER_COLOR = new Color(178, 34, 34).darker();
    /**border color of brick*/
    private static final Color BORDER_COLOR = Color.GRAY;
    /**full strength of clay brick*/
    private static final int CLAY_STRENGTH = 1;

    /**
     * This is a constructor which initialises variables in ClayBrick class.
     *
     * @param point point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     */
    public ClayBrick(Point point, Dimension size){
        super(NAME,point,size, BORDER_COLOR, INNER_COLOR,CLAY_STRENGTH);
    }

    /**
     * This method is to make a brick and return the brick
     * that has been created using the specified point and
     * size of type Shape to the calling method.
     *
     * @param position point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     * @return brick that has been created using the specified point and size of type Shape
     */
    @Override
    protected Shape makeBrickFace(Point position, Dimension size) {
        return new Rectangle(position,size);
    }

    /**
     * This method is to return a brick to the calling method.
     *
     * @return brick of type Shape
     */
    @Override
    public Shape getBrick() {
        return super.brickFace;
    }
}