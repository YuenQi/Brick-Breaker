/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * This is SteelBrick class which inherits Brick class.
 */
public class SteelBrick extends Brick {

    private static final String NAME = "Steel Brick";
    private static final Color INNER_COLOR = new Color(203, 203, 201);
    private static final Color BORDER_COLOR = Color.BLACK;
    private static final int STEEL_STRENGTH = 1;
    private static final double STEEL_PROBABILITY = 0.4;

    private Random rnd;
    private Shape brickFace;

    private double randomProbability;

    /**
     * This is a constructor which initialises variables of steel brick.
     *
     * @param point point (x-coordinate and y-coordinate) to draw the brick
     * @param size size (width and height) of brick
     */
    public SteelBrick(Point point, Dimension size){
        super(NAME,point,size, BORDER_COLOR, INNER_COLOR,STEEL_STRENGTH);
        rnd = new Random();
        brickFace = super.brickFace;
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
        return brickFace;
    }

    /**
     * This method is to set impact on brick.
     *
     * @param point point at which the ball hits the brick
     * @param direction direction of crack of brick (if there is crack)
     * @return state of brick (broken / not broken)
     */
    public  boolean setImpact(Point2D point , int direction){
        if(super.isBroken())
            return false;
        impact();
        return  super.isBroken();
    }

    /**
     * This method is to reduce strength of brick if the random number
     * generated is less than the broken probability of steel brick.
     * If strength is reduced to 0, set broken state of brick to true.
     */
    public void impact(){
        randomProbability = rnd.nextDouble();
        if(getRandomProbability() < STEEL_PROBABILITY){
            super.impact();
        }
    }

    /**
     * This method is used to return random number generated to the calling method.
     * @return random number generated
     */
    public double getRandomProbability() {
        return randomProbability;
    }

}