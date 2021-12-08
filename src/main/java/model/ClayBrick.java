package model;

import model.Brick;

import java.awt.*;
import java.awt.Point;


/**
 * This is ClayBrick class which inherits Brick class.
 */
public class ClayBrick extends Brick {

    private static final String NAME = "Clay Brick";
    private static final Color DEF_INNER = new Color(178, 34, 34).darker();
    private static final Color DEF_BORDER = Color.GRAY;
    private static final int CLAY_STRENGTH = 1;

    /**
     * This is a constructor which initialises variables of clay brick.
     *
     * @param point point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     */
    public ClayBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CLAY_STRENGTH);
    }

    /**
     * This method is to make a brick and return the brick
     * that has been created using the specified point and
     * size of type Shape to the calling method.
     *
     * @param pos point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     * @return brick that has been created using the specified point and size of type Shape
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
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