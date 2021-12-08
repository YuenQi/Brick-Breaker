package model;

import java.awt.geom.Point2D;

/**
 * This class abstracts the ball object instantiation process.
 */
public class BallFactory {

    /**
     * This method is to return ball object to the calling method.
     *
     * @param ballType type of ball to be created
     * @param center center point of ball
     * @return ball object created
     */
    public Ball getBall(String ballType, Point2D center){
        if (ballType == null)
            return null;
        if(ballType.equalsIgnoreCase("RUBBER"))
            return new RubberBall(center);

        return null;
    }
}