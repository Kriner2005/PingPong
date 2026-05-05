package co.edu.uptc.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
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
    public void updateGameView(double ballX, double ballY, int ballSize,
            int paddleX, int paddleY, int paddleW, int paddleH) {

        gamePanel.upDateGameView(ballX, ballY, ballSize, paddleX, paddleY, paddleW, paddleH);
    }

    @Override
    public void updatePauseButton(boolean isPaused) {
        statsPanel.updatePauseBtn(isPaused);
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
