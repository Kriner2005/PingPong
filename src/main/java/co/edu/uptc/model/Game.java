package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;

public class Game implements ModelInterface {
    private Ball ball;
    private Paddle paddle;
    private int panelWidth, panelHeight;
    private boolean gameOver;
    private boolean paused;

    @Override
    public void initialize(int width, int height) {
        this.panelWidth = width;
        this.panelHeight = height;
        this.gameOver = false;
        this.paused = false;
        this.ball = new Ball(width / 2, height / 2, 40, 45, 7);
        this.paddle = new Paddle(50, height / 2 - 50, 20, 100, 10);
    }

    @Override
    public void update() {
        if (paused) return;
        
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
        paused = false;
        initialize(panelWidth, panelHeight);
    }

    @Override
    public boolean isGameOver() {
        return gameOver;
    }

    public void resetGameOverFlag() {
        gameOver = false;
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
    public boolean isPaused(){
        return paused;
    }

    @Override 
    public void setPaused(boolean paused) {
        this.paused = paused;
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
