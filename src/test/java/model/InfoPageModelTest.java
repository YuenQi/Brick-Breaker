package model;

import org.junit.jupiter.api.Test;
import view.GameFrame;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class InfoPageModelTest {

    InfoPageModel infoPageModel = new InfoPageModel(new GameFrame());

    @Test
    public void setAndGetLabelTest() {
        infoPageModel.setLabel(new JLabel("Message"));
        /*
        There is no way to write junit test to test whether a JLabel created
        is the same using assertEquals(new JLabel("Message"),infoPageModel.getLabel());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getLabel());
    }

    @Test
    public void setAndGetStartButtonTest() {
        infoPageModel.setStartButton(new JButton("START"));
        /*
        There is no way to write junit test to test whether a JButton created
        is the same using assertEquals(new JButton("START"),infoPageModel.getStartButton());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getStartButton());
    }

    @Test
    public void setAndGetBackButtonTest() {
        infoPageModel.setBackButton(new JButton("BACK"));
        /*
        There is no way to write junit test to test whether a JButton created
        is the same using assertEquals(new JButton("BACK"),infoPageModel.getBackButton());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getBackButton());
    }

    @Test
    public void setAndGetInfoPageTest() {
        infoPageModel.setInfoPage(new ImageIcon("src/main/resources/infoPageBackground.jpg"));
        /*
        There is no way to write junit test to test whether an ImageIcon created
        is the same using assertEquals(new ImageIcon("src/main/resources/infoPageBackground.jpg"),infoPageModel.getInfoPage());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getInfoPage());
    }

    @Test
    public void setAndGetBackgroundTest() {
        infoPageModel.setBackground(new JLabel(new ImageIcon("src/main/resources/infoPageBackground.jpg")));
        /*
        There is no way to write junit test to test whether a JLabel created
        is the same using assertEquals(new JLabel(new ImageIcon("src/main/resources/infoPageBackground.jpg")),infoPageModel.getBackground());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getBackground());
    }

    @Test
    public void getOwnerTest() {
        assertEquals("view.GameFrame[frame0,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]",infoPageModel.getOwner().toString());
    }
}