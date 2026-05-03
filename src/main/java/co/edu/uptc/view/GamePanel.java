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

    private PresenterInterface presenter;
    private Timer gameTimer;
    private double x, y;
    private int paddleX, paddleY, paddleW, paddleH;
    private int ballSize;
    private Ellipse2D ball;

    public GamePanel() {
        initPanel();
        addKeyListener();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(950, 800));
        this.setBackground(Color.WHITE);

        int delayMs = 16;
        new Timer(delayMs, e -> {
            presenter.update();
            repaint();
        }).start();

    }

    public void upDateGameView(double ballX, double ballY, int ballSize,
            int paddleX, int paddleY, int paddleW, int paddleH) {
        this.x = ballX;
        this.y = ballY;
        this.ballSize = ballSize;
        this.paddleX = paddleX;
        this.paddleY = paddleY;
        this.paddleW = paddleW;
        this.paddleH = paddleH;

    }

    public void stopGame() {
        gameTimer.stop();
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
        ball = new Ellipse2D.Double(x, y, ballSize, ballSize);
        g2d.fill(ball);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(paddleX, paddleY, paddleW, paddleH);
    }

    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }
}
