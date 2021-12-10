package model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * This is an abstract Ball class which consists of
 * an abstract method (makeBall) that must be implemented
 * by its subclass if its subclass is not abstract class.
 * It also consists of non-abstract method which defines movement,
 * color and speed of ball.
 */
abstract public class Ball {

    private Shape ballFace;
    private Point2D center;

    private Point2D up;
    private Point2D down;
    private Point2D left;
    private Point2D right;

    private Color borderColor; //REFACTOR: change name from border to borderColor
    private Color innerColor; //REFACTOR: change name from inner to innerColor

    private int speedX;
    private int speedY;

    /**
     * This is a constructor which initialises variables in Ball class.
     *
     * @param center center point of ball
     * @param radiusA diameter of ball (width of rectangle)
     * @param radiusB diameter of ball (height of rectangle)
     * @param innerColor inner color of ball
     * @param borderColor border color of ball
     */
    public Ball(Point2D center, int radiusA, int radiusB, Color innerColor, Color borderColor){
        this.center = center;

        up = new Point2D.Double();
        down = new Point2D.Double();
        left = new Point2D.Double();
        right = new Point2D.Double();

        up.setLocation(center.getX(),center.getY()-(radiusB / 2));
        down.setLocation(center.getX(),center.getY()+(radiusB / 2));

        left.setLocation(center.getX()-(radiusA /2),center.getY());
        right.setLocation(center.getX()+(radiusA /2),center.getY());

        ballFace = makeBall(center,radiusA,radiusB);
        this.borderColor = borderColor;
        this.innerColor = innerColor;
        speedX = 0;
        speedY = 0;
    }

    /**
     * This method is to provide signature (return type,
     * parameter list) for subclass of Ball which is not abstract
     * to implement the method to make a ball.
     *
     * @param center center point of ball
     * @param radiusA diameter of ball (width of rectangle)
     * @param radiusB diameter of ball (height of rectangle)
     * @return a ball which is of type Shape
     */
    protected abstract Shape makeBall(Point2D center,int radiusA,int radiusB);

    /**
     * This method defines movement of ball.
     */
    public void move(){
        RectangularShape tmp = (RectangularShape) ballFace;
        center.setLocation((center.getX() + speedX),(center.getY() + speedY));
        double w = tmp.getWidth();
        double h = tmp.getHeight();
        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        setPoints(w,h);
        ballFace = tmp;
    }

    /**
     * This method is to set speed of ball in x and y direction.
     *
     * @param x speed of ball in x direction
     * @param y speed of ball in y direction
     */
    public void setSpeed(int x,int y){
        speedX = x;
        speedY = y;
    }

    /**
     * This method is to set speed of ball in x direction.
     *
     * @param s speed of ball in x direction
     */
    public void setXSpeed(int s){
        speedX = s;
    }

    /**
     * This method is to set speed of ball in y direction.
     *
     * @param s speed of ball in y direction
     */
    public void setYSpeed(int s){
        speedY = s;
    }

    /**
     * This method is to reverse x direction of ball.
     */
    public void reverseX(){
        speedX *= -1;
    }

    /**
     * This method is to reverse y direction of ball.
     */
    public void reverseY(){
        speedY *= -1;
    }

    /**
     * This method is to return the value of borderColor color of ball.
     *
     * @return border color of ball
     */
    public Color getBorderColor(){
        return borderColor;
    }

    /**
     * This method is to return the value of innerColor color of ball.
     *
     * @return inner color of ball
     */
    public Color getInnerColor(){
        return innerColor;
    }

    /**
     * This method is to return center point of ball.
     *
     * @return center point of ball
     */
    public Point2D getPosition(){
        return center;
    }

    /**
     * This method is to return a ball.
     *
     * @return a ball which is of type Shape
     */
    public Shape getBallFace(){
        return ballFace;
    }

    /**
     * This method is to move the ball to a certain location.
     *
     * @param p a point which consists of x-coordinate and y-coordinate of the location to move the ball to
     */
    public void moveTo(Point p){
        center.setLocation(p);

        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        ballFace = tmp;
    }

    /**
     * This method is to set the point on the top, bottom, left and right of the ball.
     *
     * @param width diameter of ball (width of rectangle)
     * @param height diameter of ball (height of rectangle)
     */
    private void setPoints(double width,double height){
        up.setLocation(center.getX(),center.getY()-(height / 2));
        down.setLocation(center.getX(),center.getY()+(height / 2));

        left.setLocation(center.getX()-(width / 2),center.getY());
        right.setLocation(center.getX()+(width / 2),center.getY());
    }

    /**
     * This method is to return speed of ball in x direction.
     *
     * @return speed of ball in x direction
     */
    public int getSpeedX(){
        return speedX;
    }

    /**
     * This method is to return speed of ball in y direction.
     *
     * @return speed of ball in y direction
     */
    public int getSpeedY(){
        return speedY;
    }

    /**
     * This method is to return point on the top of the ball.
     *
     * @return point on the top of the ball
     */
    public Point2D getUp() {
        return up;
    }

    /**
     * This method is to set point on the top of the ball.
     *
     * @param up point on the top of the ball
     */
    public void setUp(Point2D up) {
        this.up = up;
    }

    /**
     * This method is to return point on the bottom of the ball.
     *
     * @return point on the bottom of the ball
     */
    public Point2D getDown() {
        return down;
    }

    /**
     * This method is to set point on the bottom of the ball.
     *
     * @param down point on the bottom of the ball
     */
    public void setDown(Point2D down) {
        this.down = down;
    }

    /**
     * This method is to return point on the left of the ball.
     *
     * @return point on the left of the ball
     */
    public Point2D getLeft() {
        return left;
    }

    /**
     * This method is to set point on the left of the ball.
     *
     * @param left point on the left of the ball
     */
    public void setLeft(Point2D left) {
        this.left = left;
    }

    /**
     * This method is to return point on the right of the ball.
     *
     * @return point on the right of ball
     */
    public Point2D getRight() {
        return right;
    }

    /**
     * This method is to set point on the right of the ball.
     *
     * @param right point on the right of ball
     */
    public void setRight(Point2D right) {
        this.right = right;
    }
}