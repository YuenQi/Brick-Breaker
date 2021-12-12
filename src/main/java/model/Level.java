package model;

import java.awt.*;

//REFACTOR: extract Level class from Wall class to ensure SOLID principle is adhered.
/**
 * This is Level class to define different levels in this game.
 * Level class is created by extracting it out from Wall class.
 * Level class is responsible for making levels while Wall class
 * handles most of the things happen to the wall. By separating
 * Level class out, single responsibility principle is adhered.
 */
public class Level {

    /**total number of levels*/
    private static final int LEVELS_COUNT = 5;

    /**representation of clay brick in number*/
    private static final int CLAY = 1;
    /**representation of steel brick in number*/
    private static final int STEEL = 2;
    /**representation of cement brick in number*/
    private static final int CEMENT = 3;
    /**representation of fast brick in number*/
    private static final int FAST_BRICK = 4;
    /**representation of slow brick in number*/
    private static final int SLOW_BRICK = 5;
    /**representation of special brick in number*/
    private static final int SPECIAL = 6;

    /**level in 2D array representation*/
    private Brick[][] levels;
    /**level*/
    private int level;

    /**Wall object*/
    private static Wall wall;
    /**BrickFactory object*/
    private BrickFactory brickFactory = new BrickFactory();

    /**
     * This is a constructor to initialise some variables in Level class.
     *
     * @param drawArea draw area to draw all the bricks
     * @param brickCount number of bricks
     * @param lineCount row of bricks to be drawn
     * @param brickDimensionRatio width of brick : height of brick ratio
     * @param wall Wall object
     */
    public Level(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Wall wall){
        levels = makeLevels(drawArea,brickCount,lineCount,brickDimensionRatio);
        level = 0;
        this.wall = wall;
    }

    /**
     * This method is to make a level which consists of only 1 type of brick.
     *
     * @param drawArea draw area to draw the bricks
     * @param brickCnt number of bricks
     * @param lineCnt row of bricks to be drawn
     * @param brickSizeRatio width of brick : height of brick ratio
     * @param type type of brick
     * @return a level which consists of the drawn bricks
     */
    private Brick[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int type){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller than brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp  = new Brick[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            double x = (i % brickOnLine) * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,type);
        }

        /*
        ADDITION (REWARD): Change the original clay brick to special brick to
        reward user additional points. The special brick will decrement the
        timer by 60 seconds and user will have a higher chance to get higher points.
         */
        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = brickFactory.getBrick("SPECIAL",p,brickSize);
        }
        return tmp;
    }

    /**
     * This method is to make a level which consists of 2 types of brick.
     *
     * @param drawArea draw area to draw the bricks
     * @param brickCnt number of bricks
     * @param lineCnt row of bricks to be drawn
     * @param brickSizeRatio width of brick : height of brick ratio
     * @param typeA first type of brick
     * @param typeB second type of brick
     * @return a level which consists of the drawn bricks
     */
    private Brick[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int typeA, int typeB){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller than brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        int centerLeft = brickOnLine / 2 - 1;
        int centerRight = brickOnLine / 2 + 1;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp  = new Brick[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            int posX = i % brickOnLine;
            double x = posX * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);

            boolean b = ((line % 2 == 0 && i % 2 == 0) || (line % 2 != 0 && posX > centerLeft && posX <= centerRight));
            tmp[i] = b ?  makeBrick(p,brickSize,typeA) : makeBrick(p,brickSize,typeB);
        }

        /*
        ADDITION (REWARD): Change the original brick to special brick to
        reward user additional points. The special brick will decrement the
        timer by 60 seconds and user will have a higher chance to get higher points.
         */
        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = brickFactory.getBrick("SPECIAL",p,brickSize);
        }
        return tmp;
    }

    /**
     * This method is to make levels (either single type or chessboard type).
     * @param drawArea draw area to draw the bricks
     * @param brickCount number of bricks
     * @param lineCount row of bricks to be drawn
     * @param brickDimensionRatio width of brick : height of brick ratio
     * @return levels which consist of the drawn bricks
     */
    private Brick[][] makeLevels(Rectangle drawArea,int brickCount,int lineCount,double brickDimensionRatio){
        Brick[][] tmp = new Brick[LEVELS_COUNT][];
        tmp[0] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
        tmp[1] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,CEMENT);
        tmp[2] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,STEEL);
        tmp[3] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,CEMENT);
        tmp[4] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,FAST_BRICK,SLOW_BRICK);
        return tmp;
    }

    /**
     * This method draws bricks and set brick count if there is next level.
     */
    public void nextLevel(){
        if (hasLevel()) {
            wall.setBricks(levels[level++]);
            wall.setBrickCount(wall.getBricks().length);
        }
    }

    /**
     * This method checks if there is another level in this game.
     *
     * @return whether there is another level
     */
    public boolean hasLevel(){
        return level < levels.length;
    }

    /**
     * This method makes bricks of different types.
     *
     * @param point point (x-coordinate and y-coordinate) to start drawing the brick
     * @param size size (width and height) of brick
     * @param type type of brick to be made
     * @return brick that has been made
     */
    private Brick makeBrick(Point point, Dimension size, int type){
        Brick out;
        switch(type){
            case CLAY:
                out = brickFactory.getBrick("CLAY",point,size);
                break;
            case STEEL:
                out = brickFactory.getBrick("STEEL",point,size);
                break;
            case CEMENT:
                out = brickFactory.getBrick("CEMENT",point, size);
                break;
            case FAST_BRICK:
                out = brickFactory.getBrick("FAST_BRICK",point, size);
                break;
            case SLOW_BRICK:
                out = brickFactory.getBrick("SLOW_BRICK",point,size);
                break;
            case SPECIAL:
                out = brickFactory.getBrick("SPECIAL",point,size);
                break;
            default:
                throw  new IllegalArgumentException(String.format("Unknown Type:%d\n",type));
        }
        return  out;
    }

    /**
     * This method is to return Wall object to the calling method.
     *
     * @return Wall object
     */
    public static Wall getWall(){
        return wall;
    }
}