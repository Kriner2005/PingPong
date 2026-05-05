package co.edu.uptc.interfaces;

import java.util.ArrayList;

import co.edu.uptc.model.Ball;
import co.edu.uptc.model.Paddle;

public interface ModelInterface {
    public void update();

    public void movePaddleUp();

    public void movePaddleDown();

    public void resetGame();

    public void resetGameOverFlag();

    public boolean isGameOver();

    void initialize(int width, int height);

    public ArrayList<Ball> getBalls();

    public Paddle getPaddle();

    public void setPanelWidth(int width);

    public void setPanelHeight(int height);

    public boolean isPaused();

    public void setPaused(boolean paused);
}
