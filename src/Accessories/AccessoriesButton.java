package Accessories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccessoriesButton implements ActionListener {
    private JFrame frame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public AccessoriesButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame accessoryFrame = new JFrame("Аксессуары");
        accessoryFrame.setResizable(false);
        accessoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        accessoryFrame.setSize(700, 500);
        accessoryFrame.setLocation(centerX, centerY);
        accessoryFrame.setLayout(new FlowLayout());

        JButton buttonHead = new JButton("Голова");
        buttonHead.addActionListener(new HeadButton(accessoryFrame, userSelection, centerX, centerY));

        JButton buttonLegs = new JButton("Ноги");
        buttonLegs.addActionListener(new LegsButton(accessoryFrame, userSelection, centerX, centerY));

        JButton buttonNeck = new JButton("Шея");
        buttonNeck.addActionListener(new NeckButton(accessoryFrame, userSelection, centerX, centerY));

        accessoryFrame.add(buttonHead);
        accessoryFrame.add(buttonLegs);
        accessoryFrame.add(buttonNeck);
        accessoryFrame.setVisible(true);

        accessoryFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });
    }
}
