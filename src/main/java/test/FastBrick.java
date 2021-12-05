package test;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;

public class FastBrick extends Brick {

    private static final String NAME = "Fast Brick";
    private static final Color INNER_COLOR = new Color(0x8bd2d9);
    private static final Color BORDER_COLOR = new Color(0x1815bd);
    private static final int FAST_BRICK_STRENGTH = 1;

    public FastBrick(Point point, Dimension size){
        super(NAME,point,size, BORDER_COLOR, INNER_COLOR,FAST_BRICK_STRENGTH);
    }

    @Override
    public boolean setImpact(Point2D point , int dir){
        if(super.isBroken())
            return false;
        else {
            impact();
            makeBallSpeedFaster();
        }
        return super.isBroken();
    }

    /**
     * This method will set the speed of the ball to 5
     * and make the ball move faster when
     * the ball hits the blue color brick
     */
    private void makeBallSpeedFaster() {
        if (super.isBroken()){
            Level.getWall().setBallXSpeed(4);
            Level.getWall().setBallYSpeed(3);
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