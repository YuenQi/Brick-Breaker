package model;

import java.awt.geom.Point2D;

//REFACTOR: Use factory design pattern to create ball
/**
 * BallFactory class is used to create different types of Ball objects,
 * in case future developers want to create other balls like steel
 * ball to straight away break the cement break when it first hits
 * the cement brick which I don’t have time to implement.
 * This class abstracts the ball object instantiation process.
 */
public class BallFactory {

    /**
     * This method is to return Ball object to the calling method.
     *
     * @param ballType type of ball to be created
     * @param center center point of ball
     * @return Ball object created
     */
    public Ball getBall(String ballType, Point2D center){
        if (ballType == null)
            return null;
        if(ballType.equalsIgnoreCase("RUBBER"))
            return new RubberBall(center);

        return null;
    }
}