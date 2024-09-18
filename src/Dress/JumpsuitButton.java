package Dress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JumpsuitButton implements ActionListener {
    private JFrame dressFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public JumpsuitButton(JFrame dressFrame, boolean[] userSelection, int centerX, int centerY) {
        this.dressFrame = dressFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dressFrame.setVisible(false);
        JFrame jumpsuitFrame = new JFrame("Комбинезоны");
        jumpsuitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jumpsuitFrame.setSize(700, 500);
        jumpsuitFrame.setLocation(centerX, centerY);
        jumpsuitFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox jumpsuitCheckBox = new JCheckBox("Комбинезон");

        panel.add(jumpsuitCheckBox);

        jumpsuitFrame.add(panel);
        jumpsuitFrame.setVisible(true);

        jumpsuitFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (jumpsuitCheckBox.isSelected()) {
                    userSelection[1] = true;
                }
                dressFrame.setVisible(true);
            }
        });
    }
}
