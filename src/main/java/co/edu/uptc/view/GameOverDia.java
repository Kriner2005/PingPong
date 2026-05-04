package co.edu.uptc.view;

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
        addBtn(box);

        box.add(Box.createVerticalGlue());

        add(box, BorderLayout.CENTER);
    }

    private void addLabel(Box container) {
        JLabel label = new JLabel("Perdiste, ¿Quiere volver a jugar?");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }

    private void addBtn(Box container) {
        JButton btn = new JButton("Aceptar");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(e -> {
            restart = true;
            dispose();
        });
        container.add(btn);
    }

    public boolean getRestart() {
        return restart;
    }
}
