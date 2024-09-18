package Top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlouseButton implements ActionListener {
    private JFrame topFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public BlouseButton(JFrame topFrame, boolean[] userSelection, int centerX, int centerY) {
        this.topFrame = topFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        topFrame.setVisible(false);
        JFrame blouseFrame = new JFrame("Блузки/рубашки");
        blouseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        blouseFrame.setSize(700, 500);
        blouseFrame.setLocation(centerX, centerY);
        blouseFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox blouseCheckBox = new JCheckBox("Блузка");
        JCheckBox shirtCheckBox = new JCheckBox("Рубашка");

        panel.add(blouseCheckBox);
        panel.add(shirtCheckBox);

        blouseFrame.add(panel);
        blouseFrame.setVisible(true);

        blouseFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (blouseCheckBox.isSelected()) {
                    userSelection[5] = true;
                    userSelection[7] = true;
                }
                if (shirtCheckBox.isSelected()) {
                    userSelection[0] = true;
                }
                topFrame.setVisible(true);
            }
        });
    }
}
