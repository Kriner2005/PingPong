package co.edu.uptc.interfaces;

import co.edu.uptc.view.panels.GamePanel;

public interface ViewInterface {
    void setPresenter(PresenterInterface presenter);

    void start();

    void initFrame();

    void updateGameView(double ballX, double ballY, int ballSize,
            int paddleX, int paddleY, int paddleW, int paddleH);

    void updatePauseButton(boolean isPaused);

    void addComponents();

    void showGameOverDialog();

    int getGamePanelWidth();

    int getGamePanelHeight();

    GamePanel getPanelGame();
}
