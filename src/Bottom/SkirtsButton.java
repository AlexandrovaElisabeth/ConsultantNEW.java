package Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SkirtsButton implements ActionListener {
    private JFrame bottomFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public SkirtsButton(JFrame bottomFrame, boolean[] userSelection, int centerX, int centerY) {
        this.bottomFrame = bottomFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bottomFrame.setVisible(false);
        JFrame skirtsFrame = new JFrame("Юбки");
        skirtsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        skirtsFrame.setSize(700, 500);
        skirtsFrame.setLocation(centerX, centerY);
        skirtsFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox maxiCheckBox = new JCheckBox("Макси");
        JCheckBox midiCheckBox = new JCheckBox("Миди");
        JCheckBox miniCheckBox = new JCheckBox("Мини");

        panel.add(maxiCheckBox);
        panel.add(midiCheckBox);
        panel.add(miniCheckBox);

        skirtsFrame.add(panel);
        skirtsFrame.setVisible(true);

        skirtsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (maxiCheckBox.isSelected()) {
                    userSelection[10] = true;
                }
                if (midiCheckBox.isSelected()) {
                    userSelection[4] = true;
                }
                if (miniCheckBox.isSelected()) {
                    userSelection[6] = true;
                }
                bottomFrame.setVisible(true);
            }
        });
    }
}
