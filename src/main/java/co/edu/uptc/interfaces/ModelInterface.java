package co.edu.uptc.interfaces;

import java.time.LocalDateTime;
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

    public void initialize(int width, int height);

    public void addBall();

    public ArrayList<Ball> getBalls();

    public Paddle getPaddle();

    public LocalDateTime getStartTime();

    public void setPanelWidth(int width);

    public void setPanelHeight(int height);

    public boolean isPaused();

    public void setPaused(boolean paused);
}
