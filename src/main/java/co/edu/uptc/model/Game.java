package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;

public class Game implements ModelInterface {
    private Ball ball;
    private Paddle paddle;
    private int panelWidth, panelHeight;

    @Override
    public void initialize(int width, int height) {
        this.panelWidth = width;
        this.panelHeight = height;

        if (panelWidth > 0 && panelHeight > 0) {
            this.ball = new Ball(panelWidth / 2, panelHeight / 2, 40, 10, -10);
            this.paddle = new Paddle(50, panelHeight / 2 - 50, 20, 150, 15);
        }
    }

    @Override
    public void update() {
        ball.update(panelWidth, panelHeight);
        if (paddle.collidesWithBall(ball)) {
            ball.setDx(- ball.getDx());
            //ball.setDy(- ball.getDy());
        }
        if (ball.getX() < 0) {
            resetGame();
        }
    }

    @Override
    public void movePaddleUp() {
        paddle.moveUp(panelHeight);
    }

    @Override
    public void movePaddleDown() {
        paddle.moveDown(panelHeight);
    }

    @Override
    public void resetGame() {
        ball = new Ball(panelWidth / 2, panelHeight / 2, 40, 5, -5);
    }

    @Override
    public Ball getBall() {
        return ball;
    }

    @Override
    public Paddle getPaddle() {
        return paddle;
    }

    @Override
    public void setPanelWidth(int width) {
        this.panelWidth = width;
    }

    @Override
    public void setPanelHeight(int height) {
        this.panelHeight = height;
    }
}
