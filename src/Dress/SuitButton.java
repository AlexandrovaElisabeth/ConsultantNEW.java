package Dress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuitButton implements ActionListener {
    private JFrame dressFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public SuitButton(JFrame dressFrame, boolean[] userSelection, int centerX, int centerY) {
        this.dressFrame = dressFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dressFrame.setVisible(false);
        JFrame suitFrame = new JFrame("Костюмы");
        suitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        suitFrame.setSize(700, 500);
        suitFrame.setLocation(centerX, centerY);
        suitFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox businessSuitCheckBox = new JCheckBox("Деловой костюм");
        JCheckBox sportsSuitCheckBox = new JCheckBox("Спортивный костюм");

        panel.add(businessSuitCheckBox);
        panel.add(sportsSuitCheckBox);

        suitFrame.add(panel);
        suitFrame.setVisible(true);

        suitFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (businessSuitCheckBox.isSelected()) {
                    userSelection[23] = true;
                }
                if (sportsSuitCheckBox.isSelected()) {
                    userSelection[24] = true;
                }
                dressFrame.setVisible(true);
            }
        });
    }
}
