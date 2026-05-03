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

        int panelWidth = 950;
        int panelHeight = 800;

        model = new Game();
        presenter = new Presenter();
        view = MainFrame.getInstance();

        view.setPresenter(presenter);
        model.setPanelHeight(panelHeight);
        model.setPanelWidth(panelWidth);

        presenter.setModel(model);
        presenter.setView(view);

        ((Game)model).initialize();

    }

    public void run() {
        makeMVP();
        view.start();
    }
}
