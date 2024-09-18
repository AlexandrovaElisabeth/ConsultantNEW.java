package Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JeansButton implements ActionListener {
    private JFrame bottomFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public JeansButton(JFrame bottomFrame, boolean[] userSelection, int centerX, int centerY) {
        this.bottomFrame = bottomFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bottomFrame.setVisible(false);
        JFrame jeansFrame = new JFrame("Джинсы/брюки");
        jeansFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jeansFrame.setSize(700, 500);
        jeansFrame.setLocation(centerX, centerY);
        jeansFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox jeansCheckBox = new JCheckBox("Джинсы");
        JCheckBox trousersCheckBox = new JCheckBox("Брюки");

        panel.add(jeansCheckBox);
        panel.add(trousersCheckBox);

        jeansFrame.add(panel);
        jeansFrame.setVisible(true);

        jeansFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (jeansCheckBox.isSelected()) {
                    userSelection[2] = true;
                }
                if (trousersCheckBox.isSelected()) {
                    userSelection[8] = true;
                }
                bottomFrame.setVisible(true);
            }
        });
    }
}
