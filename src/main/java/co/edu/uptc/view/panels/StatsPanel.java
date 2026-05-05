package co.edu.uptc.view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
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
        setLayout(new BorderLayout());
        setBackground(Color.blue);
    }

    private void addComponents() {

        Box labels = Box.createVerticalBox();
        addTimeStart();
        addTimerLabel();
        Box buttons = Box.createVerticalBox();
        addBtnReset(buttons);
        addBtnPaused(buttons);
        addBtnAddBall(buttons);
    }

    private void addTimerLabel() {
        Box box = Box.createVerticalBox();
        JLabel text = new JLabel("Tiempo transcurrido:");
        timer = new JLabel("00:00:00");
        box.add(text);
        box.add(timer);
        add(box);
    }

    private void addTimeStart() {
        Box box = Box.createVerticalBox();
        JLabel text = new JLabel("Hora de inicio:");
        startTimeGame = new JLabel("xx:xx:xx");
        box.add(text);
        box.add(startTimeGame);

        add(box);

    }

    private void addBtnReset(Box box) {
        JButton btnreset = new JButton("Reiniciar");
        box.add(btnreset);
    }

    private void addBtnPaused(Box box) {
        JButton btnPaused = new JButton("Pausar");
        box.add(btnPaused);
    }

    private void addBtnAddBall(Box box) {
        JButton btnAddBall = new JButton("Agregar peltota");
        box.add(btnAddBall);
    }
}
