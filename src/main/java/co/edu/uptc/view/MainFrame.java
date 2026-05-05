package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.Ball;
import co.edu.uptc.model.Paddle;
import co.edu.uptc.view.dialogs.AboutDia;
import co.edu.uptc.view.dialogs.GameOverDia;
import co.edu.uptc.view.panels.GamePanel;
import co.edu.uptc.view.panels.StatsPanel;

public class MainFrame extends JFrame implements ViewInterface {
    private static MainFrame instance;
    private PresenterInterface presenter;
    private GamePanel gamePanel;
    private StatsPanel statsPanel;

    private MainFrame() {
        initFrame();
        addComponents();
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
        gamePanel.setPresenter(presenter);
        statsPanel.setPresenter(presenter);
    }

    @Override
    public void start() {
        this.setVisible(true);
    }

    @Override
    public void initFrame() {
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setTitle("Ping Pong Game");
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                // Parar el game loop del presenter
                if (presenter != null) {
                    presenter.stopGameLoop();
                }
                System.exit(0);
            }
        });
    }

    // adds

    @Override
    public void addComponents() {
        addMenuBar();
        addPanelGame();
        addPanelStats();
    }

    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        addMenuHelp(menuBar);
    }

    private void addMenuHelp(JMenuBar menuBar) {
        JMenu menu = new JMenu("Help");
        menuBar.add(menu);
        addMenuAbout(menu);
    }

    private void addMenuAbout(JMenu menu) {
        JMenuItem menuItem = new JMenuItem("About");
        menu.add(menuItem);
        menuItem.addActionListener(a -> {
            new AboutDia(this).setVisible(true);
        });

    }

    private void addPanelGame() {
        // panel game definición
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

    }

    private void addPanelStats() {
        statsPanel = new StatsPanel();
        statsPanel.setGameReference(gamePanel);
        add(statsPanel, BorderLayout.EAST);
    }

    @Override
    public void updateGameView(ArrayList<Ball> balls, Paddle paddle) {

        gamePanel.upDateGameView(balls, paddle);
    }

    @Override
    public void updatePauseButton(boolean isPaused) {
        statsPanel.updatePauseBtn(isPaused);
    }

    @Override
    public void updateStartTime(LocalDateTime startTime) {
        statsPanel.updateStartTime(startTime);
    }

    @Override
    public void updateElapsedTime(Duration elapsed) {
        statsPanel.updateElapsedTime(elapsed);
    }

    @Override
    public void showGameOverDialog() {
        GameOverDia dialog = new GameOverDia(this);
        dialog.setVisible(true);

        if (dialog.getRestart()) {
            presenter.restartGame();
        }

    }

    // gets
    @Override
    public int getGamePanelWidth() {
        return gamePanel.getWidth();
    }

    @Override
    public int getGamePanelHeight() {
        return gamePanel.getHeight();
    }

    @Override
    public GamePanel getPanelGame() {
        return gamePanel;
    }
}
