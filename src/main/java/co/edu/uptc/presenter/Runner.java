package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.Game;
import co.edu.uptc.view.MainFrame;

public class Runner {
    private ModelInterface model;
    private PresenterInterface presenter;
    private ViewInterface view;

    private static final int PANEL_WIDTH = 950;
    private static final int PANEL_HEIGHT = 800;

    public void makeMVP() {
        model = new Game();
        presenter = new Presenter();
        view = MainFrame.getInstance();

        model.setPanelHeight(PANEL_HEIGHT);
        model.setPanelWidth(PANEL_WIDTH);
        model.initialize();

        view.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
    }

    public void run() {
        makeMVP();
        view.start();
    }
}
