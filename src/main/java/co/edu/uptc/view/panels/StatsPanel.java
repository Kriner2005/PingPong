package co.edu.uptc.view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatsPanel extends JPanel {
    private JLabel timer;
    private JLabel startTimeGame;
    private ArrayList<JLabel> numBounces;
    private boolean start;
    private boolean paused;
    private boolean addBall;

    public StatsPanel() {
        initPanel();
        numBounces = new ArrayList<>();
        addComponents();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(250, 800));
        setBackground(Color.blue);
    }

    private void addComponents() {
        addTimeStart();
        addTimerLabel();
        addBtnReset();
        addBtnPaused();
        addBtnAddBall();
    }

    private void addTimerLabel() {

    }

    private void addTimeStart() {

    }

    private void addBtnReset() {

    }

    private void addBtnPaused() {

    }

    private void addBtnAddBall() {

    }
}
