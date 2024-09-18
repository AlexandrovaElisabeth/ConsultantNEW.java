package Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShortsButton implements ActionListener {
    private JFrame bottomFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public ShortsButton(JFrame bottomFrame, boolean[] userSelection, int centerX, int centerY) {
        this.bottomFrame = bottomFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bottomFrame.setVisible(false);
        JFrame shortsFrame = new JFrame("Шорты");
        shortsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        shortsFrame.setSize(700, 500);
        shortsFrame.setLocation(centerX, centerY);
        shortsFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox miniCheckBox = new JCheckBox("Мини");
        JCheckBox longCheckBox = new JCheckBox("Удлинённые");
        JCheckBox bikerCheckBox = new JCheckBox("Велосипедки");

        panel.add(miniCheckBox);
        panel.add(longCheckBox);
        panel.add(bikerCheckBox);

        shortsFrame.add(panel);
        shortsFrame.setVisible(true);

        shortsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (miniCheckBox.isSelected()) {
                    userSelection[3] = true;
                }
                if (longCheckBox.isSelected()) {
                    userSelection[13] = true;
                }
                if (bikerCheckBox.isSelected()) {
                    userSelection[0] = true;
                }
                bottomFrame.setVisible(true);
            }
        });
    }
}
