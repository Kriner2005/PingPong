package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;

public class Game implements ModelInterface {
    private Ball ball;
    private Paddle paddle;
    private int panelWidth, panelHeight;
    private boolean gameOver;

    @Override
    public void initialize(int width, int height) {
        this.panelWidth = width;
        this.panelHeight = height;
        this.gameOver = false;
        this.ball = new Ball(width / 2, height / 2, 40, 45, 7);
        this.paddle = new Paddle(50, height / 2 - 50, 20, 100, 10);
    }

    @Override
    public void update() {
        ball.update(panelWidth, panelHeight);
        if (paddle.collidesWithBall(ball)) {
            ball.bounceOffPaddle(paddle);
        }
        if (ball.getX() <= 0) {
            gameOver = true;
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
        initialize(panelWidth, panelHeight);
    }

    @Override
    public boolean isGameOver() {
        return gameOver;
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
