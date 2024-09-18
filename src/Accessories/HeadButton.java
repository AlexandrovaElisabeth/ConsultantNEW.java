package Accessories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HeadButton implements ActionListener {
    private JFrame accessoryFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public HeadButton(JFrame accessoryFrame, boolean[] userSelection, int centerX, int centerY) {
        this.accessoryFrame = accessoryFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accessoryFrame.setVisible(false);
        JFrame headFrame = new JFrame("Аксессуары на голову");
        headFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        headFrame.setSize(700, 500);
        headFrame.setLocation(centerX, centerY);
        headFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox hatCheckBox = new JCheckBox("Шляпа");
        JCheckBox capCheckBox = new JCheckBox("Шапка");
        JCheckBox bcapCheckBox = new JCheckBox("Кепка");

        panel.add(hatCheckBox);
        panel.add(capCheckBox);
        panel.add(bcapCheckBox);

        headFrame.add(panel);
        headFrame.setVisible(true);

        headFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (hatCheckBox.isSelected()) {
                    userSelection[26] = true;
                }
                if (capCheckBox.isSelected()) {
                    userSelection[7] = true;
                    userSelection[8] = true;
                }
                if (bcapCheckBox.isSelected()) {
                    userSelection[0] = true;
                    userSelection[2] = true;
                    userSelection[11] = true;
                    userSelection[24] = true;
                }
                accessoryFrame.setVisible(true);
            }
        });
    }
}
