package co.edu.uptc.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import co.edu.uptc.interfaces.ModelInterface;

public class Game implements ModelInterface {
    private ArrayList<Ball> balls;
    private Paddle paddle;
    private int panelWidth, panelHeight;
    private boolean gameOver;
    private boolean paused;
    private LocalDateTime startTime;

    @Override
    public void initialize(int width, int height) {
        this.panelWidth = width;
        this.panelHeight = height;
        this.gameOver = false;
        this.paused = false;
        this.startTime = LocalDateTime.now(); // ← Registrar hora
        this.balls = new ArrayList<>();
        balls.add(new Ball(width / 2, height / 2, 40, 45, 7));
        this.paddle = new Paddle(50, height / 2 - 50, 20, 100, 10);
    }

    @Override
    public void update() {
        if (paused)
            return;

        if (startTime != null) {
            Duration elapsed = Duration.between(startTime, LocalDateTime.now());
            long seconds = elapsed.getSeconds();

            // Cada 10 segundos, aumenta velocidad
            if (seconds > 0 && seconds % 30 == 0) {
                for (Ball ball : balls) {
                    ball.setSpeed(ball.getSpeed() + 0.5); // Aumenta 0.5
                }
            }
        }

        for (Ball ball : balls) {
            ball.update(panelWidth, panelHeight);
            if (paddle.collidesWithBall(ball)) {
                ball.countBounces();
                ball.bounceOffPaddle(paddle);
            }
            if (ball.getX() <= 0) {
                gameOver = true;
            }
        }
    }

    @Override
    public void addBall() {
        balls.add(new Ball(panelWidth / 2, panelHeight / 2, 40, 45, 7));
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
    public ArrayList<Ball> getBalls() {
        return balls;
    }

    @Override
    public Paddle getPaddle() {
        return paddle;
    }

    @Override
    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public boolean isPaused() {
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
