package co.edu.uptc.presenter;

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
        model.update();

        if (model.isGameOver()) {
            model.setPaused(true);
            view.showGameOverDialog();
            return;
        }
        ArrayList<Ball> balls = model.getBalls();

        view.updateGameView(balls, model.getPaddle());

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
