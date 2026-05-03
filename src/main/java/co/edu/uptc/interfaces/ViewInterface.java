package co.edu.uptc.interfaces;

public interface ViewInterface {
    void setPresenter(PresenterInterface presenter);

    void start();

    void initFrame();

    void updateGameView(double ballX, double ballY, int ballSize,
            int paddleX, int paddleY, int paddleW, int paddleH);

    void addComponents();
}
