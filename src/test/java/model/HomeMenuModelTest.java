package model;

import org.junit.jupiter.api.Test;
import view.GameFrame;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeMenuModelTest {

    HomeMenuModel homeMenuModel = new HomeMenuModel(new GameFrame(),new Dimension(450,300));

    @Test
    public void getOwnerTest() {
        assertEquals("view.GameFrame[frame0,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]",homeMenuModel.getOwner().toString());
    }

    @Test
    public void getAreaTest() {
        assertEquals(new Dimension(450,300),homeMenuModel.getArea());
    }

    @Test
    public void setAndGetMenuFaceTest() {
        homeMenuModel.setMenuFace(new Rectangle(new Point(0,0),new Dimension(450,300)));
        assertEquals(new Rectangle(new Point(0,0),new Dimension(450,300)),homeMenuModel.getMenuFace());
    }

    @Test
    public void setAndGetStartButtonTest() {
        homeMenuModel.setStartButton(new Rectangle(new Dimension(150,25)));
        assertEquals(new Rectangle(new Dimension(150,25)),homeMenuModel.getStartButton());
    }

    @Test
    public void setAndGetExitButtonTest() {
        homeMenuModel.setExitButton(new Rectangle(new Dimension(150,25)));
        assertEquals(new Rectangle(new Dimension(150,25)),homeMenuModel.getExitButton());
    }

    @Test
    public void setAndGetInfoButtonTest() {
        homeMenuModel.setInfoButton(new Rectangle(new Dimension(150,25)));
        assertEquals(new Rectangle(new Dimension(150,25)),homeMenuModel.getInfoButton());
    }

    @Test
    public void setAndGetGreetingsFontTest() {
        homeMenuModel.setGreetingsFont(new Font("Noto Mono",Font.PLAIN,25));
        assertEquals(new Font("Noto Mono",Font.PLAIN,25),homeMenuModel.getGreetingsFont());
    }

    @Test
    public void setAndGetGameTitleFontTest() {
        homeMenuModel.setGameTitleFont(new Font("Noto Mono",Font.BOLD,40));
        assertEquals(new Font("Noto Mono",Font.BOLD,40),homeMenuModel.getGameTitleFont());
    }

    @Test
    public void setAndGetCreditsFontTest() {
        homeMenuModel.setCreditsFont(new Font("Monospaced",Font.PLAIN,10));
        assertEquals(new Font("Monospaced",Font.PLAIN,10),homeMenuModel.getCreditsFont());
    }

    @Test
    public void setAndGetButtonFontTest() {
        homeMenuModel.setButtonFont(new Font("Monospaced",Font.PLAIN,23));
        assertEquals(new Font("Monospaced",Font.PLAIN,23),homeMenuModel.getButtonFont());
    }

    @Test
    public void setAndGetStartClickedTest() {
        homeMenuModel.setStartClicked(true);
        assertTrue(homeMenuModel.isStartClicked());
        homeMenuModel.setStartClicked(false);
        assertFalse(homeMenuModel.isStartClicked());
    }

    @Test
    public void setAndGetExitClickedTest() {
        homeMenuModel.setExitClicked(true);
        assertTrue(homeMenuModel.isExitClicked());
        homeMenuModel.setExitClicked(false);
        assertFalse(homeMenuModel.isExitClicked());
    }

    @Test
    public void setAndGetInfoClickedTest() {
        homeMenuModel.setInfoClicked(true);
        assertTrue(homeMenuModel.isInfoClicked());
        homeMenuModel.setInfoClicked(false);
        assertFalse(homeMenuModel.isInfoClicked());
    }

    @Test
    public void setAndGetBackgroundTest() {
        homeMenuModel.setBackground(new ImageIcon("src/main/resources/background.png").getImage());
        assertEquals(new ImageIcon("src/main/resources/background.png").getImage(),homeMenuModel.getBackground());
    }
}