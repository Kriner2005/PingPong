package co.edu.uptc.interfaces;

import java.time.LocalDateTime;
import java.util.ArrayList;

import co.edu.uptc.model.Ball;
import co.edu.uptc.model.Paddle;
import co.edu.uptc.view.panels.GamePanel;

public interface ViewInterface {
    void setPresenter(PresenterInterface presenter);

    void start();

    void initFrame();

    void updateGameView(ArrayList<Ball> balls, Paddle paddle);

    void updatePauseButton(boolean isPaused);

    void addComponents();

    void showGameOverDialog();

    void updateStartTime(LocalDateTime startTime);

    int getGamePanelWidth();

    int getGamePanelHeight();

    GamePanel getPanelGame();
}
