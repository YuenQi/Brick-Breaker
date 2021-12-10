package view;

import model.GameBoardModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardViewTest {

    GameBoardModel gameBoardModel = new GameBoardModel(new GameFrame());
    GameBoardView gameBoardView = new GameBoardView(gameBoardModel);

    @Test
    public void onLostFocus() {
        gameBoardView.onLostFocus();
        assertFalse(gameBoardView.getGameBoardModel().getGameTimer().isGaming());
        assertEquals("Focus Lost",gameBoardView.getGameBoardModel().getMessage());
    }
}