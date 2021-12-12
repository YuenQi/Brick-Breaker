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
package view;

import controller.HomeMenuController;
import model.HomeMenuModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * This is HomeMenuView class which displays home menu.
 */
public class HomeMenuView extends JComponent implements MouseListener, MouseMotionListener {

    /**greetings text*/
    private static final String GREETINGS = "Welcome to:";
    /**game title*/
    private static final String GAME_TITLE = "Brick Destroy";
    /**credits text*/
    private static final String CREDITS = "Version 2.0";
    /**text of the so-call start button*/
    private static final String START_TEXT = "Start";
    /**text of the so-call exit button*/
    private static final String EXIT_TEXT = "Exit"; //REFACTOR: change MENU_TEXT to EXIT_TEXT
    /**text of the so-call info button*/
    private static final String INFO_TEXT = "Info";

    /**color of text*/
    private static final Color TEXT_COLOR = Color.BLACK;
    /**color button when it's clicked*/
    private static final Color CLICKED_BUTTON_COLOR = Color.WHITE;
    /**color of text when button is clicked*/
    private static final Color CLICKED_TEXT_COLOR = Color.WHITE;//REFACTOR: change CLICKED_TEXT_COLOR to CLICKED_TEXT_COLOR

    /**HomeMenuModel object*/
    private HomeMenuModel homeMenuModel;
    /**HomeMenuController object*/
    private HomeMenuController homeMenuController;

    /**
     * This is a constructor to design home menu, add MouseListener,
     * MouseMotionListener and initialise some variables in HomeMenuView class.
     *
     * @param homeMenuModel HomeMenuModel object
     */
    public HomeMenuView(HomeMenuModel homeMenuModel){

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.homeMenuModel = homeMenuModel;
        homeMenuController = new HomeMenuController(homeMenuModel,this);

        homeMenuModel.setMenuFace(new Rectangle(new Point(0,0),homeMenuModel.getArea()));

        this.setPreferredSize(homeMenuModel.getArea());

        Dimension btnDim = new Dimension(homeMenuModel.getArea().width / 3, homeMenuModel.getArea().height / 12);

        homeMenuModel.setStartButton(new Rectangle(btnDim));
        homeMenuModel.setExitButton(new Rectangle(btnDim));
        homeMenuModel.setInfoButton(new Rectangle(btnDim));

        homeMenuModel.setGreetingsFont(new Font("Noto Mono",Font.PLAIN,25));
        homeMenuModel.setGameTitleFont(new Font("Noto Mono",Font.BOLD,40));
        homeMenuModel.setCreditsFont(new Font("Monospaced",Font.PLAIN,10));
        homeMenuModel.setButtonFont(new Font("Monospaced",Font.PLAIN,homeMenuModel.getStartButton().height-2));
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

        double x = homeMenuModel.getMenuFace().getX();
        double y = homeMenuModel.getMenuFace().getY();

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
        homeMenuModel.setBackground(new ImageIcon(getClass().getResource("/background.png")).getImage());
        g2d.drawImage(homeMenuModel.getBackground(), 0,0,450,300,null);
    }

    /**
     * This method draws text on the home menu screen.
     *
     * @param g2d Graphics2D object
     */
    private void drawText(Graphics2D g2d){

        g2d.setColor(TEXT_COLOR);

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D greetingsRect = homeMenuModel.getGreetingsFont().getStringBounds(GREETINGS,frc);
        Rectangle2D gameTitleRect = homeMenuModel.getGameTitleFont().getStringBounds(GAME_TITLE,frc);
        Rectangle2D creditsRect = homeMenuModel.getCreditsFont().getStringBounds(CREDITS,frc);

        /*
         * sX is x-coordinate of the leftmost character of the specified string
         * sY is y-coordinate of the leftmost character of the specified string
         */
        int sX,sY;

        //This calculation is to position the specified string in the middle of the frame
        sX = (int)(homeMenuModel.getMenuFace().getWidth() - greetingsRect.getWidth()) / 2;
        sY = (int)(homeMenuModel.getMenuFace().getHeight() / 4);

        g2d.setFont(homeMenuModel.getGreetingsFont());
        g2d.drawString(GREETINGS,sX,sY);

        sX = (int)(homeMenuModel.getMenuFace().getWidth() - gameTitleRect.getWidth()) / 2;
        sY += (int) gameTitleRect.getHeight() * 1.1;//add 10% of String height between the two strings

        g2d.setFont(homeMenuModel.getGameTitleFont());
        g2d.drawString(GAME_TITLE,sX,sY);

        sX = (int)(homeMenuModel.getMenuFace().getWidth() - creditsRect.getWidth()) / 2;
        sY += (int) creditsRect.getHeight() * 1.1;

        g2d.setFont(homeMenuModel.getCreditsFont());
        g2d.drawString(CREDITS,sX,sY);
    }

    /**
     * This method draws button on the home menu screen.
     *
     * @param g2d Graphics2D object
     */
    private void drawButton(Graphics2D g2d){

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D startTextRect = homeMenuModel.getButtonFont().getStringBounds(START_TEXT,frc); //REFACTOR: change txtRect to startTextRect
        Rectangle2D exitTextRect = homeMenuModel.getButtonFont().getStringBounds(EXIT_TEXT,frc);//REFACTOR: change mTxtRect to exitTextRect
        Rectangle2D infoTextRect = homeMenuModel.getButtonFont().getStringBounds(INFO_TEXT,frc);

        g2d.setFont(homeMenuModel.getButtonFont());

        //create start button
        int x = (homeMenuModel.getMenuFace().width - homeMenuModel.getStartButton().width) / 2;
        int y =(int) ((homeMenuModel.getMenuFace().height - homeMenuModel.getStartButton().height) * 0.7);

        homeMenuModel.getStartButton().setLocation(x,y);
        //end of creation of start button

        //This calculation is to position the text in the centre of the rectangle button
        x = (int)(homeMenuModel.getStartButton().getWidth() - startTextRect.getWidth()) / 2;
        y = (int)(homeMenuModel.getStartButton().getHeight() - startTextRect.getHeight()) / 2;

        x += homeMenuModel.getStartButton().x;
        y += homeMenuModel.getStartButton().y + (homeMenuModel.getStartButton().height * 0.9);//

        //draw start rectangle button and the text inside it
        if(homeMenuModel.isStartClicked()){
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(homeMenuModel.getStartButton());
            g2d.setColor(CLICKED_TEXT_COLOR);
            g2d.drawString(START_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(homeMenuModel.getStartButton());
            g2d.drawString(START_TEXT,x,y);
        }

        //create exit button
        x = homeMenuModel.getStartButton().x;
        y = homeMenuModel.getStartButton().y;

        y *= 1.2;

        homeMenuModel.getExitButton().setLocation(x,y);
        //end of creation of exit button

        x = (int)(homeMenuModel.getExitButton().getWidth() - exitTextRect.getWidth()) / 2;
        y = (int)(homeMenuModel.getExitButton().getHeight() - exitTextRect.getHeight()) / 2;

        x += homeMenuModel.getExitButton().x;
        y += homeMenuModel.getExitButton().y + (homeMenuModel.getStartButton().height * 0.9);

        //draw exit rectangle button and the text inside it
        if(homeMenuModel.isExitClicked()){
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(homeMenuModel.getExitButton());
            g2d.setColor(CLICKED_TEXT_COLOR);
            g2d.drawString(EXIT_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(homeMenuModel.getExitButton());
            g2d.drawString(EXIT_TEXT,x,y);
        }

        //create info button
        x = homeMenuModel.getStartButton().x;
        y = homeMenuModel.getExitButton().y;

        y += 38.5;

        homeMenuModel.getInfoButton().setLocation(x,y);
        //end of creation of info button

        x = (int)(homeMenuModel.getInfoButton().getWidth() - infoTextRect.getWidth()) / 2;
        y = (int)(homeMenuModel.getInfoButton().getHeight() - infoTextRect.getHeight()) / 2;

        x += homeMenuModel.getInfoButton().x;
        y += homeMenuModel.getInfoButton().y + (homeMenuModel.getStartButton().height * 0.9);

        //draw info rectangle button and the text inside it
        if(homeMenuModel.isInfoClicked()){
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(homeMenuModel.getInfoButton());
            g2d.setColor(CLICKED_TEXT_COLOR);
            g2d.drawString(INFO_TEXT,x,y);
            g2d.setColor(tmp);
        }
        else{
            g2d.draw(homeMenuModel.getInfoButton());
            g2d.drawString(INFO_TEXT,x,y);
        }

    }

    /**
     * This method checks if the mouse button has been clicked (pressed and released) and then passes the mouseEvent to
     * HomeMenuController to update the view.
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        homeMenuController.checkMouseClicked(mouseEvent);
    }

    /**
     * This method checks if the mouse button has been pressed and then passes the mouseEvent to
     * HomeMenuController to update the view.
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        homeMenuController.checkMousePressed(mouseEvent);
    }

    /**
     * This method checks if the mouse button has been released and then passes the mouseEvent to
     * HomeMenuController to update the view.
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        homeMenuController.checkMouseReleased(mouseEvent);
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
     * This method checks if the mouse cursor has been moved onto this component but no buttons have been pushed,
     * then passes the mouseEvent to HomeMenuController to update the view.
     *
     * @param mouseEvent a low-level event which indicates that a mouse action occurred in a component
     *                   (generated when a mouse button is pressed, released or clicked (pressed and released),
     *                   or when the mouse cursor enters or exits the unobscured part of component's geometry)
     */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        homeMenuController.checkMouseMoved(mouseEvent);
    }

    /**
     * This method sets hand cursor.
     */
    public void setHandCursor(){
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * This method sets the default cursor.
     */
    public void setDefaultCursor(){
        this.setCursor(Cursor.getDefaultCursor());
    }

    /**
     * This method repaints the button.
     * @param button button
     */
    public void repaintButton (Rectangle button) {
        repaint(button.x,button.y,button.width+1,button.height+1);
    }

}