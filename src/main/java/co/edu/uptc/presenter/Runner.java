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

    public void makeMVP() {
        model = new Game();
        presenter = new Presenter();
        view = MainFrame.getInstance();
        model.initialize(950,800);

        view.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
    }

    public void run() {
        makeMVP();
        view.start();
    }
}
