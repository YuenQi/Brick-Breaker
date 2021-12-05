package test;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;

public class SlowBrick extends Brick {

    private static final String NAME = "Slow Brick";
    private static final Color INNER_COLOR = new Color(0xa995e8);
    private static final Color BORDER_COLOR = new Color(0x8932a8);
    private static final int SLOW_BRICK_STRENGTH = 1;

    public SlowBrick(Point point, Dimension size){
        super(NAME,point,size, BORDER_COLOR, INNER_COLOR, SLOW_BRICK_STRENGTH);
    }

    @Override
    public boolean setImpact(Point2D point , int dir){
        if(super.isBroken())
            return false;
        else {
            impact();
            makeBallSpeedSlower();
        }
        return super.isBroken();
    }

    /**
     * This method will set the speed of the ball to 1
     * and make the ball move slower when
     * the ball hits the purple color brick
     */
    private void makeBallSpeedSlower() {
        if (super.isBroken()){
            Level.getWall().setBallXSpeed(1);
            Level.getWall().setBallYSpeed(1);
        }
    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() {
        return super.brickFace;
    }

}