package model;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;

//ADDDITION: Special brick to give reward
/**
 * This is SpecialBrick class which inherits Brick class.
 * Special brick means if the ball hits the brick, the time taken
 * to play the game will be reduced by 60 seconds. This is to give
 * reward to the user so that they stand a higher chance to gain the additional
 * point if the time taken for them to complete the game is less than specified minutes.
 */
public class SpecialBrick extends Brick {

    private static final String NAME = "Special Brick";
    private static final Color INNER_COLOR = new Color(0x7de893);
    private static final Color BORDER_COLOR = new Color(0x006b15);
    private static final int SPECIAL_BRICK_STRENGTH = 1;

    private GameTimer timer;

    /**
     * This is a constructor which initialises variables of special brick.
     *
     * @param point point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     */
    public SpecialBrick(Point point, Dimension size){
        super(NAME,point,size, BORDER_COLOR, INNER_COLOR, SPECIAL_BRICK_STRENGTH);
        timer = new GameTimer();
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
            timer.setGameTime(timer.getGameTime()-60);
        }
        return super.isBroken();
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