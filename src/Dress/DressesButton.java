package Dress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DressesButton implements ActionListener {
    private JFrame dressFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public DressesButton(JFrame dressFrame, boolean[] userSelection, int centerX, int centerY) {
        this.dressFrame = dressFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dressFrame.setVisible(false);
        JFrame dressesFrame = new JFrame("Платья");
        dressesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dressesFrame.setSize(700, 500);
        dressesFrame.setLocation(centerX, centerY);
        dressesFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox maxiCheckBox = new JCheckBox("Макси");
        JCheckBox midiCheckBox = new JCheckBox("Миди");
        JCheckBox miniCheckBox = new JCheckBox("Мини");

        panel.add(maxiCheckBox);
        panel.add(midiCheckBox);
        panel.add(miniCheckBox);

        dressesFrame.add(panel);
        dressesFrame.setVisible(true);

        dressesFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (maxiCheckBox.isSelected()) {
                    userSelection[9] = true;
                }
                if (midiCheckBox.isSelected()) {
                    userSelection[19] = true;
                }
                if (miniCheckBox.isSelected()) {
                    userSelection[14] = true;
                }
                dressFrame.setVisible(true);
            }
        });
    }
}
