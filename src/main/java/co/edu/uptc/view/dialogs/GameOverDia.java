package co.edu.uptc.view.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Window;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class GameOverDia extends JDialog {
    private final Window window;
    private boolean restart;

    public GameOverDia(Window window) {
        super(window, "GAME OVER", ModalityType.APPLICATION_MODAL);
        this.window = window;
        initDialog();
        addComponents();
    }

    private void initDialog() {
        setSize(300, 200);
        setLocationRelativeTo(window);
        setLayout(new BorderLayout());
    }

    private void addComponents() {
        Box box = Box.createVerticalBox();

        box.add(Box.createVerticalGlue());

        box.add(Box.createVerticalStrut(20));
        addLabel(box);

        box.add(Box.createVerticalStrut(20));
        addButtonsContainer(box);
        box.add(Box.createVerticalGlue());

        add(box, BorderLayout.CENTER);
    }

    private void addLabel(Box container) {
        JLabel label = new JLabel("Perdiste, ¿Quieres volver a jugar?");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }

    private void addButtonsContainer(Box verticalContainer) {
        Box boxHorizontal = Box.createHorizontalBox();
        boxHorizontal.setAlignmentX(Component.CENTER_ALIGNMENT);

        addBtnAccept(boxHorizontal);
        boxHorizontal.add(Box.createHorizontalStrut(20));
        addBtnDecline(boxHorizontal);

        verticalContainer.add(boxHorizontal);
    }

    private void addBtnAccept(Box container) {
        JButton btn = new JButton("Aceptar");
        btn.addActionListener(e -> {
            restart = true;
            dispose();
        });
        container.add(btn);
    }

    private void addBtnDecline(Box container) {
        JButton btn = new JButton("Cancelar");
        btn.addActionListener(e -> {
            restart = false;
            dispose();
        });
        container.add(btn);
    }

    public boolean getRestart() {
        return restart;
    }
}
