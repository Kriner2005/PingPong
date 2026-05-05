package co.edu.uptc.interfaces;

public interface PresenterInterface {
    public void setView(ViewInterface view);

    public void setModel(ModelInterface model);

    void update();

    void movePaddleUp();

    void movePaddleDown();

    void addBall();

    void pauseGame();

    void restartGame();

    void startGameLoop();

    void stopGameLoop();
}
