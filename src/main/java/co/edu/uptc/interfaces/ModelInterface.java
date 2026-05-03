package co.edu.uptc.interfaces;

import co.edu.uptc.model.Ball;
import co.edu.uptc.model.Paddle;

public interface ModelInterface {
    public void update();

    public void movePaddleUp();

    public void movePaddleDown();

    public void resetGame();

    void initialize();
    
    public Ball getBall();
    public Paddle getPaddle();

    public void setPanelWidth(int width);
    public void setPanelHeight(int height);
}
