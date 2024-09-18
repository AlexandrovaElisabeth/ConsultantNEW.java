package Accessories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LegsButton implements ActionListener {
    private JFrame accessoryFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public LegsButton(JFrame accessoryFrame, boolean[] userSelection, int centerX, int centerY) {
        this.accessoryFrame = accessoryFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accessoryFrame.setVisible(false);
        JFrame legsFrame = new JFrame("Аксессуары на ноги");
        legsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        legsFrame.setSize(700, 500);
        legsFrame.setLocation(centerX, centerY);
        legsFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox socksCheckBox = new JCheckBox("Носки");
        JCheckBox stockingsCheckBox = new JCheckBox("Чулки/гольфы");
        JCheckBox tightsCheckBox = new JCheckBox("Колготки");

        panel.add(socksCheckBox);
        panel.add(stockingsCheckBox);
        panel.add(tightsCheckBox);

        legsFrame.add(panel);
        legsFrame.setVisible(true);

        legsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (socksCheckBox.isSelected()) {
                    userSelection[0] = true;
                    userSelection[3] = true;
                }
                if (stockingsCheckBox.isSelected()) {
                    userSelection[5] = true;
                    userSelection[6] = true;
                }
                if (tightsCheckBox.isSelected()) {
                    userSelection[12] = true;
                }
                accessoryFrame.setVisible(true);
            }
        });
    }
}
