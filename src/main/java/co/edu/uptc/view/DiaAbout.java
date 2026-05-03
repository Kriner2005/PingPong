package co.edu.uptc.view;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Window;

public class DiaAbout extends JDialog {
    private final Window window;

    public DiaAbout(Window window) {
        super(window, "About", ModalityType.APPLICATION_MODAL);
        this.window = window;
        initDialog();
        addComponents();
    }

    private void initDialog() {
        setSize(500, 500);
        setLocationRelativeTo(window);
        setLayout(new BorderLayout());
    }

    private void addComponents() {
        Box box = Box.createVerticalBox();

        box.add(Box.createVerticalGlue());
        addLogo(box);

        box.add(Box.createVerticalStrut(60));
        addLabel(box);

        box.add(Box.createVerticalStrut(60));

        addLabelTest(box);
        box.add(Box.createVerticalGlue());

        add(box, BorderLayout.CENTER);
    }

    private void addLogo(Box container) {
        ImageIcon logo = new ImageIcon(getClass().getResource("/imgs/logo.png"));
        JLabel label = new JLabel(logo);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }

    private void addLabel(Box container) {
        JLabel label = new JLabel("Sobre el juego");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }

    private void addLabelTest(Box container) {
        JLabel label = new JLabel("test");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }
}
