package co.edu.uptc.view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

        Box labelsContainer = Box.createVerticalBox();
        addTimeStart(labelsContainer);
        labelsContainer.add(Box.createVerticalStrut(30));
        addTimerLabel(labelsContainer);
        labelsContainer.setAlignmentX(Component.RIGHT_ALIGNMENT);

        Box btnContainer = Box.createVerticalBox();
        addBtnAddBall(btnContainer);
        btnContainer.add(Box.createVerticalStrut(20));
        addBtnPaused(btnContainer);
        btnContainer.add(Box.createVerticalStrut(20));
        addBtnReset(btnContainer);

        //contenedor central
        Box mainBox = Box.createVerticalBox();
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(labelsContainer);
        mainBox.add(Box.createVerticalGlue());
        mainBox.add(btnContainer);
        mainBox.add(Box.createVerticalStrut(20));

        add(mainBox, BorderLayout.CENTER);
    }

    private void addTimerLabel(Box boxLabels) {
        Box box = Box.createVerticalBox();
        JLabel text = new JLabel("Tiempo transcurrido:");
        timer = new JLabel("00:00:00");
        box.add(text);
        box.add(timer);
        boxLabels.add(box);
    }

    private void addTimeStart(Box boxlabels) {
        Box box = Box.createVerticalBox();
        JLabel text = new JLabel("Hora de inicio:");
        startTimeGame = new JLabel("xx:xx:xx");
        box.add(text);
        box.add(startTimeGame);
        boxlabels.add(box);
    }

    private void addBtnReset(Box box) {
        JButton btnreset = new JButton("Reiniciar");
        btnreset.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(btnreset);
    }

    private void addBtnPaused(Box box) {
        JButton btnPaused = new JButton("Pausar");
        btnPaused.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(btnPaused);
    }

    private void addBtnAddBall(Box box) {
        JButton btnAddBall = new JButton("Agregar peltota");
        btnAddBall.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(btnAddBall);
    }
}
