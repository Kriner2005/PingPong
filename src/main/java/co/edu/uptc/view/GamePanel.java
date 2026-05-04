package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

import co.edu.uptc.interfaces.PresenterInterface;

public class GamePanel extends JPanel {

    private static final int PANEL_WIDTH = 950;
    private static final int PANEL_HEIGHT = 800;
    private static final int TIMER_DELAY = 16;

    private PresenterInterface presenter;
    private Timer gameTimer;

    private double ballX, ballY;
    private int ballSize;
    private int paddleX, paddleY, paddleW, paddleH;
    // private Ellipse2D ball;

    public GamePanel() {
        initPanel();
        addKeyListener();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);

        gameTimer = new Timer(TIMER_DELAY, e -> updateGameLoop());
        gameTimer.start();
    }

    private void updateGameLoop() {
        if (presenter != null) {
            presenter.update();
            repaint();
        }
    }

    public void upDateGameView(double ballX, double ballY, int ballSize,
            int paddleX, int paddleY, int paddleW, int paddleH) {
        this.ballX = ballX;
        this.ballY = ballY;
        this.ballSize = ballSize;
        this.paddleX = paddleX;
        this.paddleY = paddleY;
        this.paddleW = paddleW;
        this.paddleH = paddleH;

    }

    public void stopGame() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
    }

    private void addKeyListener() {
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    presenter.movePaddleUp();
                    ;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    presenter.movePaddleDown();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.LIGHT_GRAY);
        Ellipse2D ball = new Ellipse2D.Double(ballX, ballY, ballSize, ballSize);
        g2d.fill(ball);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(paddleX, paddleY, paddleW, paddleH);
    }

    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public int getHeight() {
        return super.getHeight(); // Devuelve la altura REAL del panel
    }

    @Override
    public int getWidth() {
        return super.getWidth(); // Devuelve el ancho REAL del panel
    }
}
