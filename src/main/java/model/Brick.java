package model;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * This is an abstract Brick class which consists of
 * two abstract methods (makeBrickFace and getBrick)
 * that must be implemented by its subclass if its subclass is not
 * abstract class.
 * It also consists of non-abstract method which is used to set
 * impact and find impact. There are also non-abstract method to
 * define color and state (broken / not broken) of brick.
 */
abstract public class Brick  {

    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;

    public static final int UP_IMPACT = 100;
    public static final int DOWN_IMPACT = 200;
    public static final int LEFT_IMPACT = 300;
    public static final int RIGHT_IMPACT = 400;

    private static Random rnd;

    private String name;

    /* REFACTOR (ENCAPSULATION):
    make the access modifier of brickFace protected so that its child
    class and the class inside the same package with Brick class can use this variable
     */
    protected Shape brickFace;

    private Color borderColor; //REFACTOR: change name from border to borderColor
    private Color innerColor; //REFACTOR: change name from inner to innerColor

    private int fullStrength;
    private int strength;

    private boolean broken;

    /**
     * This is a constructor which initialises variables of brick.
     *
     * @param name name of brick
     * @param position point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     * @param borderColor border color of brick
     * @param innerColor inner color of brick
     * @param strength strength of brick (need to hit how many times in order to break the brick)
     */
    public Brick(String name, Point position, Dimension size, Color borderColor, Color innerColor, int strength){ //REFACTOR: change "pos" to "position"
        rnd = new Random();
        broken = false;
        this.name = name;
        brickFace = makeBrickFace(position,size);
        this.borderColor = borderColor;
        this.innerColor = innerColor;
        this.fullStrength = this.strength = strength;
    }

    /**
     * This method is to provide signature (return type,
     * parameter list) for subclass of Brick which is not abstract
     * to implement the method to make a brick.
     *
     * @param position point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     * @return a brick which is of type Shape
     */
    protected abstract Shape makeBrickFace(Point position,Dimension size); //REFACTOR: change "pos" to "position"

    /**
     * This method is to set impact on brick.
     *
     * @param point point at which the ball hits the brick
     * @param direction direction of crack of brick (if there is crack)
     * @return state of brick (broken / not broken)
     */
    public boolean setImpact(Point2D point , int direction){ //REFACTOR: change "dir" to "direction"
        if(broken)
            return false;
        impact();
        return  broken;
    }

    /**
     * This method is to provide signature (return type,
     * parameter list) for subclass of Brick which is not abstract
     * to implement the method to return a brick to the calling method.
     *
     * @return brick of type Shape
     */
    public abstract Shape getBrick();

    /**
     * This method is to return border color of brick to the calling method.
     *
     * @return border color of brick
     */
    public Color getBorderColor(){
        return borderColor;
    }

    /**
     * This method is to return inner color of brick to the calling method.
     *
     * @return inner color of brick
     */
    public Color getInnerColor(){
        return innerColor;
    }

    /**
     * This method is to find direction of impact of ball on the brick.
     *
     * @param b ball that hits the brick
     * @return direction of impact of ball on the brick
     */
    public final int findImpact(Ball b){
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.getRight()))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.getLeft()))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.getUp()))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.getDown()))
            out = UP_IMPACT;
        return out;
    }

    /**
     * This method is to check if the brick is broken or not.
     *
     * @return state (broken or not broken) of brick
     */
    public final boolean isBroken(){
        return broken;
    }

    /**
     * This method is to reset the brick.
     * Brick is reset to the not broken state and the
     * strength of brick is restored to its original
     * full strength.
     */
    public void repair() {
        broken = false;
        strength = fullStrength;
    }

    /**
     * This method is to reduce strength of brick.
     * If strength is reduced to 0, set broken state of brick to true.
     */
    public void impact(){
        strength--;
        broken = (strength == 0);
    }

    /**
     * This method is to return a random value to the calling method.
     *
     * @return random value generated
     */
    public static Random getRnd() {
        return rnd;
    }
}