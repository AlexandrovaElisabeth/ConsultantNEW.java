package Accessories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NeckButton implements ActionListener {
    private JFrame accessoryFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public NeckButton(JFrame accessoryFrame, boolean[] userSelection, int centerX, int centerY) {
        this.accessoryFrame = accessoryFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accessoryFrame.setVisible(false);
        JFrame neckFrame = new JFrame("Аксессуары на шею");
        neckFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        neckFrame.setSize(700, 500);
        neckFrame.setLocation(centerX, centerY);
        neckFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox tieCheckBox = new JCheckBox("Галстук");
        JCheckBox handkerchiefCheckBox = new JCheckBox("Платок");

        panel.add(tieCheckBox);
        panel.add(handkerchiefCheckBox);

        neckFrame.add(panel);
        neckFrame.setVisible(true);

        neckFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (tieCheckBox.isSelected()) {
                    userSelection[6] = true;
                }
                if (handkerchiefCheckBox.isSelected()) {
                    userSelection[17] = true;
                }
                accessoryFrame.setVisible(true);
            }
        });
    }
}
