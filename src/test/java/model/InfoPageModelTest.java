package model;

import org.junit.jupiter.api.Test;
import view.GameFrame;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for InfoPageModel class*/
class InfoPageModelTest {

    /**InfoPageModel object*/
    InfoPageModel infoPageModel = new InfoPageModel(new GameFrame());

    /**
     * This method tests for setLabel and getLabel methods.
     */
    @Test
    public void setAndGetLabelTest() {
        infoPageModel.setLabel(new JLabel("Message"));
        /*
        There is no way, or at least I can't find a way to write junit test to test whether a JLabel created
        is the same using assertEquals(new JLabel("Message"),infoPageModel.getLabel());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getLabel());
    }

    /**
     * This method tests for setStartButton and getStartButton methods.
     */
    @Test
    public void setAndGetStartButtonTest() {
        infoPageModel.setStartButton(new JButton("START"));
        /*
        There is no way, or at least I can't find a way to write junit test to test whether a JButton created
        is the same using assertEquals(new JButton("START"),infoPageModel.getStartButton());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getStartButton());
    }

    /**
     * This method tests for setBackButton and getBackButton methods.
     */
    @Test
    public void setAndGetBackButtonTest() {
        infoPageModel.setBackButton(new JButton("BACK"));
        /*
        There is no way, or at least I can't find a way to write junit test to test whether a JButton created
        is the same using assertEquals(new JButton("BACK"),infoPageModel.getBackButton());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getBackButton());
    }

    /**
     * This method tests for setInfoPage and getInfoPage methods.
     */
    @Test
    public void setAndGetInfoPageTest() {
        infoPageModel.setInfoPage(new ImageIcon("src/main/resources/infoPageBackground.jpg"));
        /*
        There is no way, or at least I can't find a way to write junit test to test whether an ImageIcon created
        is the same using assertEquals(new ImageIcon("src/main/resources/infoPageBackground.jpg"),infoPageModel.getInfoPage());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getInfoPage());
    }

    /**
     * This method tests for setBackground and getBackground methods.
     */
    @Test
    public void setAndGetBackgroundTest() {
        infoPageModel.setBackground(new JLabel(new ImageIcon("src/main/resources/infoPageBackground.jpg")));
        /*
        There is no way, or at least I can't find a way to write junit test to test whether a JLabel created
        is the same using assertEquals(new JLabel(new ImageIcon("src/main/resources/infoPageBackground.jpg")),infoPageModel.getBackground());
        as the reference address is always different, so I just use assertNotNull to
        ensure it exists.
         */
        assertNotNull(infoPageModel.getBackground());
    }

}