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
package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This is HomeMenuView class which displays home menu.
 */
public class HomeMenuView extends JComponent implements MouseListener, MouseMotionListener {

    private static final String GREETINGS = "Welcome to:";
    private static final String GAME_TITLE = "Brick Destroy";
    private static final String CREDITS = "Version 2.0";
    private static final String START_TEXT = "Start";
    private static final String EXIT_TEXT = "Exit"; //REFACTOR: change MENU_TEXT to EXIT_TEXT
    private static final String INFO_TEXT = "Info";

    private static final Color TEXT_COLOR = Color.BLACK;
    private static final Color CLICKED_BUTTON_COLOR = Color.WHITE;
    private static final Color CLICKED_TEXT_COLOR = Color.WHITE;//REFACTOR: change CLICKED_TEXT_COLOR to CLICKED_TEXT_COLOR

    private Rectangle menuFace;
    private Rectangle startButton;
    private Rectangle exitButton;//REFACTOR: change menuButton to exitButton
    private Rectangle infoButton;

    private Font greetingsFont;
    private Font gameTitleFont;
    private Font creditsFont;
    private Font buttonFont;

    private GameFrame owner;
    private InfoPage infoPage;

    private boolean startClicked;
    private boolean exitClicked;//REFACTOR: change menuClicked to exitClicked
    private boolean infoClicked;

    private BufferedImage background = null;

    private HomeMenuController homeMenuController;

    /**
     * This is a constructor to design home menu, add MouseListener,
     * MouseMotionListener and initialise some variables in HomeMenuView class.
     *
     * @param owner GameFrame object
     * @param area width and height of home menu
     */
    public HomeMenuView(GameFrame owner, Dimension area){

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.owner = owner;

        homeMenuController = new HomeMenuController(this);

        menuFace = new Rectangle(new Point(0,0),area);
        this.setPreferredSize(area);

        Dimension btnDim = new Dimension(area.width / 3, area.height / 12);
        startButton = new Rectangle(btnDim);
        exitButton = new Rectangle(btnDim);
        infoButton = new Rectangle(btnDim);

        greetingsFont = new Font("Noto Mono",Font.PLAIN,25);
        gameTitleFont = new Font("Noto Mono",Font.BOLD,40);
        creditsFont = new Font("Monospaced",Font.PLAIN,10);
        buttonFont = new Font("Monospaced",Font.PLAIN,startButton.height-2);
    }

    /**
     * This method calls method to draw the home menu.
     *
     * @param g Graphics object which is used to render output
     *          (can derive Graphics2D object from this Graphics object
     *          in order to render output)
     */
    public void paint(Graphics g){ //Invoked by Swing to draw components
        drawMenu((Graphics2D)g);
    }

    /**
     * This method is to draw home menu.
     *
     * @param g2d Graphics2D object
     */
    public void drawMenu(Graphics2D g2d){

        drawContainer(g2d);

        /*
        all the following method calls need a relative
        painting directly into the HomeMenuView rectangle,
        so the translation is made here so the other methods do not do that.
         */
        Color prevColor = g2d.getColor();
        Font prevFont = g2d.getFont();

        double x = menuFace.getX();
        double y = menuFace.getY();

        g2d.translate(x,y);

        //methods calls
        drawText(g2d);
        drawButton(g2d);
        //end of methods calls

        g2d.translate(-x,-y);
        g2d.setFont(prevFont);
        g2d.setColor(prevColor);
    }

    /**
     * This method displays a background image on the home menu screen.
     *
     * @param g2d Graphics2D object
     */
    private void drawContainer(Graphics2D g2d){

        //ADDITION: A start screen displaying a picture related to the game
        /*
        reading the image inside the if statement to save resources,
        the image will only be loaded if it has not yet been loaded
         */
        if (background == null){
            try {
                background = ImageIO.read(getClass().getResource("/background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        g2d.drawImage(background, 0,0,450,300,null);
    }

    /**
     * This method draws text on the home menu screen.
     *
     * @param g2d Graphics2D object
     */
    private void drawText(Graphics2D g2d){

        g2d.setColor(TEXT_COLOR);

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D greetingsRect = greetingsFont.getStringBounds(GREETINGS,frc);
        Rectangle2D gameTitleRect = gameTitleFont.getStringBounds(GAME_TITLE,frc);
        Rectangle2D creditsRect = creditsFont.getStringBounds(CREDITS,frc);

        /*
         * sX is x-coordinate of the leftmost character of the specified string
         * sY is y-coordinate of the leftmost character of the specified string
         */
        int sX,sY;

        //This calculation is to position the specified string in the middle of the frame
        sX = (int)(menuFace.getWidth() - greetingsRect.getWidth()) / 2;
        sY = (int)(menuFace.getHeight() / 4);

        g2d.setFont(greetingsFont);
        g2d.drawString(GREETINGS,sX,sY);

        sX = (int)(menuFace.getWidth() - gameTitleRect.getWidth()) / 2;
        sY += (int) gameTitleRect.getHeight() * 1.1;//add 10% of String height between the two strings

        g2d.setFont(gameTitleFont);
        g2d.drawString(GAME_TITLE,sX,sY);

        sX = (int)(menuFace.getWidth() - creditsRect.getWidth()) / 2;
        sY += (int) creditsRect.getHeight() * 1.1;

        g2d.setFont(creditsFont);
        g2d.drawString(CREDITS,sX,sY);
    }

    /**
     * This method draws button on the home menu screen.
     *
     * @param g2d Graphics2D object
     */
    private void drawButton(Graphics2D g2d){

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D startTextRect = buttonFont.getStringBounds(START_TEXT,frc); //REFACTOR: change txtRect to startTextRect
        Rectangle2D exitTextRect = buttonFont.getStringBounds(EXIT_TEXT,frc);//REFACTOR: change mTxtRect to exitTextRect
        Rectangle2D infoTextRect = buttonFont.getStringBounds(INFO_TEXT,frc);

        g2d.setFont(buttonFont);

        //create start button
        int x = (menuFace.width - startButton.width) / 2;
        int y =(int) ((menuFace.height - startButton.height) * 0.7);

        startButton.setLocation(x,y);
        //end of creation of start button

        //This calculation is to position the text in the centre of the rectangle button
        x = (int)(startButton.getWidth() - startTextRect.getWidth()) / 2;
        y = (int)(startButton.getHeight() - startTextRect.getHeight()) / 2;

        x += startButton.x;
        y += startButton.y + (startButton.height * 0.9);//

        //draw start rectangle button and the text inside it
        if(startClicked){
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(startButton);
            g2d.setColor(CLICKED_TEXT_COLOR);
            g2d.drawString(START_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(startButton);
            g2d.drawString(START_TEXT,x,y);
        }

        //create exit button
        x = startButton.x;
        y = startButton.y;

        y *= 1.2;

        exitButton.setLocation(x,y);
        //end of creation of exit button

        x = (int)(exitButton.getWidth() - exitTextRect.getWidth()) / 2;
        y = (int)(exitButton.getHeight() - exitTextRect.getHeight()) / 2;

        x += exitButton.x;
        y += exitButton.y + (startButton.height * 0.9);

        //draw exit rectangle button and the text inside it
        if(exitClicked){
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(exitButton);
            g2d.setColor(CLICKED_TEXT_COLOR);
            g2d.drawString(EXIT_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(exitButton);
            g2d.drawString(EXIT_TEXT,x,y);
        }

        //create info button
        x = startButton.x;
        y = exitButton.y;

        //TODO extract the calculation method and automate spacing calculation instead of hardcoding a value
        y += 38.5;

        infoButton.setLocation(x,y);
        //end of creation of info button

        x = (int)(infoButton.getWidth() - infoTextRect.getWidth()) / 2;
        y = (int)(infoButton.getHeight() - infoTextRect.getHeight()) / 2;

        x += infoButton.x;
        y += infoButton.y + (startButton.height * 0.9);

        //draw info rectangle button and the text inside it
        if(infoClicked){
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(infoButton);
            g2d.setColor(CLICKED_TEXT_COLOR);
            g2d.drawString(INFO_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(infoButton);
            g2d.drawString(INFO_TEXT,x,y);
        }

    }

    /**
     * This method is used to define some actions performed when
     * the mouse button has been clicked (pressed and released) on this component.
     * The actions are as followed:
     * 1. If the mouse button clicks on the so-called "Start button", display game board.
     * 2. If the mouse button clicks on the so-called "Exit button", terminates this program.
     * 3. If the mouse button clicks on the so-called "Info button", display the InfoPage Window.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
//        Point p = mouseEvent.getPoint();
//        if(startButton.contains(p)){
//            owner.enableGameBoard();
//        }
//        else if(exitButton.contains(p)){
//            System.out.println("Goodbye " + System.getProperty("user.name"));
//            System.exit(0);
//        }
//        else if(infoButton.contains(p)){
//            infoPage = new InfoPage(owner);
//        }
        homeMenuController.isMouseClicked(mouseEvent);
    }

    /**
     * This method is used to define some actions performed when
     * the mouse button has been pressed on this component.
     * The actions are as followed:
     * 1. If the mouse button clicks on the so-called "Start button", repaint the start button.
     * 2. If the mouse button clicks on the so-called "Exit button", repaint the exit button.
     * 3. If the mouse button clicks on the so-called "Info button", repaint the info button.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
//        Point p = mouseEvent.getPoint();
//        if(startButton.contains(p)){
//            startClicked = true;
//            repaint(startButton.x,startButton.y,startButton.width+1,startButton.height+1);
//        }
//        else if(exitButton.contains(p)){
//            exitClicked = true;
//            repaint(exitButton.x, exitButton.y, exitButton.width+1, exitButton.height+1);
//        }
//        else if(infoButton.contains(p)){
//            infoClicked = true;
//            repaint(infoButton.x, infoButton.y, infoButton.width+1, infoButton.height+1);
//        }
        homeMenuController.isMousePressed(mouseEvent);
    }

    /**
     * This method is used to define some actions performed when
     * the mouse button has been released on this component.
     * The actions are as followed:
     * 1. If the mouse button clicks on the so-called "Start button", repaint the start button.
     * 2. If the mouse button clicks on the so-called "Exit button", repaint the exit button.
     * 3. If the mouse button clicks on the so-called "Info button", repaint the info button.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
//        if(startClicked){
//            startClicked = false;
//            repaint(startButton.x,startButton.y,startButton.width+1,startButton.height+1);
//        }
//        else if(exitClicked){
//            exitClicked = false;
//            repaint(exitButton.x, exitButton.y, exitButton.width+1, exitButton.height+1);
//        }
//        else if(infoClicked){
//            infoClicked = false;
//            repaint(infoButton.x, infoButton.y, infoButton.width+1, infoButton.height+1);
//        }
        homeMenuController.isMouseReleased(mouseEvent);
    }

    /**
     * This method is used to define some actions performed when
     * the mouse enters this component but
     * it does nothing in this class as no implementation is provided.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    /**
     * This method is used to define some actions performed when
     * the mouse exits this component but
     * it does nothing in this class as no implementation is provided.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    /**
     * This method is used to define some actions performed when
     * a mouse button is pressed on this component and then dragged but
     * it does nothing in this class as no implementation is provided.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    /**
     * This method is used to define some actions performed when
     * the mouse cursor has been moved onto this component but no buttons have been pushed.
     * When mouse cursor move to the so-called "Start button", "Exit button" ot "Info button",
     * set the cursor image to hand cursor, otherwise, set the cursor image as the default cursor.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
//        Point p = mouseEvent.getPoint();
//        if(startButton.contains(p) || exitButton.contains(p) || infoButton.contains(p))
//            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        else
//            this.setCursor(Cursor.getDefaultCursor());
        homeMenuController.isMouseMoved(mouseEvent);
    }

    public void setHandCursor(){
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void setDefaultCursor(){
        this.setCursor(Cursor.getDefaultCursor());
    }

    public Rectangle getStartButton() {
        return startButton;
    }

    public Rectangle getExitButton() {
        return exitButton;
    }

    public Rectangle getInfoButton() {
        return infoButton;
    }

    public GameFrame getOwner() {
        return owner;
    }

    public void repaintButton (Rectangle button) {
        repaint(button.x,button.y,button.width+1,button.height+1);
    }

}