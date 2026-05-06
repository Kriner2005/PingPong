package co.edu.uptc.presenter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.Ball;

public class Presenter implements PresenterInterface {

    private ViewInterface view;
    private ModelInterface model;

    private ExecutorService executor;
    private volatile boolean running = true;

    @Override
    public void startGameLoop() {
        initializeBallLabels();
        executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            while (running) {
                try {
                    update();
                    view.getPanelGame().repaint();
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }

    @Override
    public void stopGameLoop() {
        running = false;
        if (executor != null) {
            executor.shutdown();
        }
    }

    @Override
    public void update() {
        model.setPanelWidth(view.getGamePanelWidth());
        model.setPanelHeight(view.getGamePanelHeight());

        if (model.isPaused())
            return;
        view.updatePauseButton(model.isPaused());
        view.updateStartTime(model.getStartTime());

        if (model.getStartTime() != null) {
            Duration elapsed = Duration.between(model.getStartTime(), LocalDateTime.now());
            view.updateElapsedTime(elapsed);
        }

        model.update();

        if (model.isGameOver()) {
            model.setPaused(true);
            view.showGameOverDialog();
            return;
        }
        ArrayList<Ball> balls = model.getBalls();

        view.updateGameView(balls, model.getPaddle());
        view.updateBallsBounces(balls);

    }

    private void initializeBallLabels() {
        ArrayList<Ball> balls = model.getBalls();
        for (int i = 0; i < balls.size(); i++) {
            view.updateBallsList(i);
        }
    }

    @Override
    public void movePaddleUp() {
        model.movePaddleUp();
    }

    @Override
    public void movePaddleDown() {
        model.movePaddleDown();
    }

    @Override
    public void addBall() {
        model.addBall();
        int lastBall = model.getBalls().size() - 1;
        view.updateBallsList(lastBall);
    }

    @Override
    public void pauseGame() {
        if (!model.isGameOver()) {
            boolean currentState = model.isPaused();
            model.setPaused(!currentState);
        }
    }

    @Override
    public void restartGame() {
        model.resetGameOverFlag();
        model.resetGame();
        view.restartLabels();
        initializeBallLabels();
    }

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }
}
