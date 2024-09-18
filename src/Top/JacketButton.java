package Top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JacketButton implements ActionListener {
    private JFrame topFrame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public JacketButton(JFrame topFrame, boolean[] userSelection, int centerX, int centerY) {
        this.topFrame = topFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        topFrame.setVisible(false);
        JFrame jacketFrame = new JFrame("Пиджаки");
        jacketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jacketFrame.setSize(700, 500);
        jacketFrame.setLocation(centerX, centerY);
        jacketFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JCheckBox blazerCheckBox = new JCheckBox("Пиджак");
        JCheckBox vestCheckBox = new JCheckBox("Жилет");

        panel.add(blazerCheckBox);
        panel.add(vestCheckBox);

        jacketFrame.add(panel);
        jacketFrame.setVisible(true);

        jacketFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (blazerCheckBox.isSelected()) {
                    userSelection[11] = true;
                }
                if (vestCheckBox.isSelected()) {
                    userSelection[6] = true;
                }
                topFrame.setVisible(true);
            }
        });
    }
}
