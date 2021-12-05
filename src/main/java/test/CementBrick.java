package test;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * This is CementBrick class which inherits Brick class.
 */
public class CementBrick extends Brick {

    private static final String NAME = "Cement Brick";
    private static final Color DEF_INNER = new Color(147, 147, 147);
    private static final Color DEF_BORDER = new Color(217, 199, 175);
    private static final int CEMENT_STRENGTH = 2;

    private Crack crack;
    private Shape brickFace;

    /**
     * This is a constructor which initialises variables of cement brick.
     *
     * @param point point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     */
    public CementBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CEMENT_STRENGTH);
        crack = new Crack(this,DEF_CRACK_DEPTH,DEF_STEPS);
        brickFace = super.brickFace;
    }

    /**
     * This method is to return brick that has been created
     * using the specified point and size of type Shape to
     * the calling method.
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
     * This method is to set impact on brick.
     *
     * @param point point at which the ball hits the brick
     * @param dir direction of crack of brick (if there is crack)
     * @return state of brick (broken / not broken)
     */
    @Override
    public boolean setImpact(Point2D point, int dir) {
        //if brick in super is broken, return false
        if(super.isBroken())
            return false;
        super.impact();

        //if brick in super is not broken, make crack
        if(!super.isBroken()){
            crack.makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }

    /**
     * This method is to return a brick to the calling method.
     *
     * @return brick of type Shape
     */
    @Override
    public Shape getBrick() {
        return brickFace;
    }

    /**
     * This method is to update brick (draw a crack on it).
     */
    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = crack.draw();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }

    /**
     * This method is to reset the brick.
     * Brick is reset to the not broken state and the
     * strength of brick is restored to its original
     * full strength.
     * Crack is also reset so that there will be no crack
     * on the brick.
     * The brick is also restored.
     */
    public void repair(){
        super.repair();
        crack.reset();
        brickFace = super.brickFace;
    }
}