package co.edu.uptc.view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.model.Ball;
import co.edu.uptc.model.Paddle;

public class GamePanel extends JPanel {

    private static final int PANEL_WIDTH = 950;
    private static final int PANEL_HEIGHT = 800;

    private PresenterInterface presenter;

    private ArrayList<Ball> balls;
    private Paddle paddle;

    public GamePanel() {
        initPanel();
        addKeyListener();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.decode("#4E545C"));
        this.setFocusable(true);
    }

    public void upDateGameView(ArrayList<Ball> balls, Paddle paddle) {
        this.balls = balls;
        this.paddle = paddle;
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

        if (balls != null) {
            g2d.setColor(Color.LIGHT_GRAY);
            for (Ball ball : balls) {
                Ellipse2D ballShape = new Ellipse2D.Double(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
                g2d.fill(ballShape);
            }
        }

        if (paddle != null) {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        }
    }

    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }
}
