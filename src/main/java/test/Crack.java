package test;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * This is Crack class which is used to define crack operations.
 */
public class Crack{

    public static final int LEFT = 10;
    public static final int RIGHT = 20;
    public static final int UP = 30;
    public static final int DOWN = 40;
    public static final int VERTICAL = 100;
    public static final int HORIZONTAL = 200;

    private Brick brick;

    private GeneralPath crack;

    private int crackDepth;
    private int steps;

    /**
     * This is a constructor which initialises some variables in Crack class.
     *
     * @param brick brick object
     * @param crackDepth depth of crack
     * @param steps something like a step of staircase (which is later used to draw crack on brick)
     */
    public Crack(Brick brick, int crackDepth, int steps){
        this.brick = brick;
        crack = new GeneralPath();
        this.crackDepth = crackDepth;
        this.steps = steps;
    }

    /**
     *This method is to draw the crack on the brick.
     *
     * @return a geometric path constructed from straight line to form the crack
     */
    public GeneralPath draw(){
        return crack;
    }

    /**
     * This method is to reset the path to empty. The appended position
     * is set back to the beginning of the path and
     * all coordinates and point types are forgotten.
     * There will be no more crack on the brick.
     */
    public void reset(){
        crack.reset();
    }

    /**
     * This method is to define starting point and ending point on where the crack
     * shall be started drawing from and ending at.
     *
     * @param point point of impact (point at which ball hits the brick)
     * @param direction direction of crack
     */
    protected void makeCrack(Point2D point, int direction){
        //bounds store outline of the brick
        Rectangle bounds = brick.brickFace.getBounds();

        Point impact = new Point((int)point.getX(),(int)point.getY());
        Point start = new Point();
        Point end = new Point();

        switch(direction){
            case LEFT:
                start.setLocation(bounds.x + bounds.width, bounds.y);
                end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
                Point tmp = makeRandomPoint(start,end,VERTICAL);
                makeCrack(impact,tmp);
                break;
            case RIGHT:
                start.setLocation(bounds.getLocation());
                end.setLocation(bounds.x, bounds.y + bounds.height);
                tmp = makeRandomPoint(start,end,VERTICAL);
                makeCrack(impact,tmp);
                break;
            case UP:
                start.setLocation(bounds.x, bounds.y + bounds.height);
                end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
                tmp = makeRandomPoint(start,end,HORIZONTAL);
                makeCrack(impact,tmp);
                break;
            case DOWN:
                start.setLocation(bounds.getLocation());
                end.setLocation(bounds.x + bounds.width, bounds.y);
                tmp = makeRandomPoint(start,end,HORIZONTAL);
                makeCrack(impact,tmp);
                break;

        }
    }

    /**
     * This method is to define the path of the crack.
     *
     * @param start starting point of crack
     * @param end ending point of crack
     */
    protected void makeCrack(Point start, Point end){

        GeneralPath path = new GeneralPath();

        //Adds a point to the path by moving to the specified coordinates specified in float precision.
        path.moveTo(start.x,start.y);

        double w = (end.x - start.x) / (double)steps;
        double h = (end.y - start.y) / (double)steps;

        int bound = crackDepth;

        double x,y;

        for(int i = 1; i < steps;i++){

            x = (i * w) + start.x;
            y = (i * h) + start.y + randomInBounds(bound);

            /*
              Adds a point to the path by drawing a straight line from the
              current coordinates to the new specified coordinates specified in double precision.
            */
            path.lineTo(x,y);

        }

        path.lineTo(end.x,end.y);
        crack.append(path,true);
    }

    /**
     * This method is to generate random value to change y-coordinate of
     * the small crack inside the brick.
     *
     * @param bound a random fixed value to change the y-coordinate to make small crack
     * @return random value that is used to change y-coordinate of the small crack inside the brick
     */
    private int randomInBounds(int bound){
        int n = (bound * 2) + 1;
        return brick.getRnd().nextInt(n) - bound;
    }

    /**
     * This method is to make random ending point of crack
     * depending on whether its direction is horizontal or vertical.
     *
     * @param from starting point of border of point
     * @param to ending point of border of point
     * @param direction direction to place the random generated ending point
     *                  based on the starting point and ending point of border of brick given
     * @return random generated ending point of crack
     */
    private Point makeRandomPoint(Point from,Point to, int direction){

        Point out = new Point();
        int pos;

        switch(direction){
            case HORIZONTAL:
                pos = brick.getRnd().nextInt(to.x - from.x) + from.x;
                out.setLocation(pos,to.y);
                break;
            case VERTICAL:
                pos = brick.getRnd().nextInt(to.y - from.y) + from.y;
                out.setLocation(to.x,pos);
                break;
        }
        return out;
    }
}