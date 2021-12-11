package view;

import model.GameBoardModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**This is test class for GameBoardView class*/
class GameBoardViewTest {

    /**GameBoardModel object*/
    GameBoardModel gameBoardModel = new GameBoardModel(new GameFrame());
    /**GameBoardView object*/
    GameBoardView gameBoardView = new GameBoardView(gameBoardModel);

    /**
     * This method tests for onLostFocus method.
     * When the method is called, gaming is set to false and
     * "Focus Lost" message will be returned.
     */
    @Test
    public void onLostFocusTest() {
        gameBoardView.onLostFocus();
        assertFalse(gameBoardView.getGameBoardModel().getGameTimer().isGaming());
        assertEquals("Focus Lost",gameBoardView.getGameBoardModel().getMessage());
    }
}