package Top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OuterwearButton implements ActionListener {
    private JFrame topFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public OuterwearButton(JFrame topFrame, boolean[] userSelection, int centerX, int centerY) {
        this.topFrame = topFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        topFrame.setVisible(false);
        JFrame outerwearFrame = new JFrame("Верхняя одежда");
        outerwearFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        outerwearFrame.setSize(700, 500);
        outerwearFrame.setLocation(centerX, centerY);
        outerwearFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox denimCheckBox = new JCheckBox("Джинсовая куртка");
        JCheckBox leatherCheckBox = new JCheckBox("Кожаная куртка");

        panel.add(denimCheckBox);
        panel.add(leatherCheckBox);

        outerwearFrame.add(panel);
        outerwearFrame.setVisible(true);

        outerwearFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (denimCheckBox.isSelected()) {
                    userSelection[24] = true;
                }
                if (leatherCheckBox.isSelected()) {
                    userSelection[4] = true;
                }
                topFrame.setVisible(true);
            }
        });
    }
}
