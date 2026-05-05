package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class Presenter implements PresenterInterface {

    private ViewInterface view;
    private ModelInterface model;

    @Override
    public void update() {
        model.setPanelWidth(view.getGamePanelWidth());
        model.setPanelHeight(view.getGamePanelHeight());

        if (model.isPaused())
            return;

        model.update();

        if (model.isGameOver()) {
            model.setPaused(true);
            model.resetGameOverFlag();
            view.showGameOverDialog();
            return;
        }
        view.updateGameView(model.getBall().getX(),
                model.getBall().getY(),
                model.getBall().getSize(),
                model.getPaddle().getX(),
                model.getPaddle().getY(),
                model.getPaddle().getWidth(),
                model.getPaddle().getHeight());
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
    public void restartGame() {
        model.resetGame();
    }

    @Override
    public void pauseGame() {
        if (!model.isGameOver()) {
            boolean currentState = model.isPaused();
            model.setPaused(!currentState); // ← Invierte el estado
        }
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
