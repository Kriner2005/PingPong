package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class MainFrame extends JFrame implements ViewInterface {
    private static MainFrame instance;
    private PresenterInterface presenter;
    private GamePanel gamePanel;

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
            new DiaAbout(this).setVisible(true);
        });

    }

    private void addPanelGame() {
        // panel game definición
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

    }

    private void addPanelStats() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 800));
        panel.setBackground(Color.blue);
        add(panel, BorderLayout.EAST);
    }

    @Override
    public void updateGameView(double ballX, double ballY, int ballSize,
            int paddleX, int paddleY, int paddleW, int paddleH) {

        gamePanel.upDateGameView(ballX, ballY, ballSize, paddleX, paddleY, paddleW, paddleH);
    }

    @Override
    public int getGamePanelWidth() {
        return gamePanel.getWidth();
    }

    @Override
    public int getGamePanelHeight() {
        return gamePanel.getHeight();
    }
}
