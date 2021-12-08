package model;

import model.Brick;
import model.Level;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * This is SlowBrick class which inherits Brick class.
 * Slow brick means if the ball hits the brick, the speed of the ball
 * will become slower.
 */
public class SlowBrick extends Brick {

    private static final String NAME = "Slow Brick";
    private static final Color INNER_COLOR = new Color(0xa995e8);
    private static final Color BORDER_COLOR = new Color(0x8932a8);
    private static final int SLOW_BRICK_STRENGTH = 1;

    /**
     * This is a constructor which initialises variables of slow brick.
     *
     * @param point point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     */
    public SlowBrick(Point point, Dimension size){
        super(NAME,point,size, BORDER_COLOR, INNER_COLOR, SLOW_BRICK_STRENGTH);
    }

    /**
     * This method is to set impact on brick.
     *
     * @param point point at which the ball hits the brick
     * @param direction direction of crack of brick (if there is crack)
     * @return state of brick (broken / not broken)
     */
    @Override
    public boolean setImpact(Point2D point , int direction){
        if(super.isBroken())
            return false;
        else {
            impact();
            makeBallSpeedSlower();
        }
        return super.isBroken();
    }

    /**
     * This method will set the speed of the ball
     * in x direction to 1 and the speed of the ball
     * in y direction to 1 which will make the ball
     * move slower when the ball hits the purple color brick
     */
    private void makeBallSpeedSlower() {
        if (super.isBroken()){
            Level.getWall().setBallXSpeed(1);
            Level.getWall().setBallYSpeed(1);
        }
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