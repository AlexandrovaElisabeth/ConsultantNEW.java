package Dress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DressButton implements ActionListener {
    private JFrame frame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public DressButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame dressFrame = new JFrame("Платья/комбинезоны");
        dressFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dressFrame.setSize(700, 500);
        dressFrame.setLocation(centerX, centerY);
        dressFrame.setLayout(new FlowLayout());

        JButton buttonKom = new JButton("Комбинезоны");
        buttonKom.addActionListener(new JumpsuitButton(dressFrame, userSelection, centerX, centerY));

        JButton buttonCost = new JButton("Костюмы");
        buttonCost.addActionListener(new SuitButton(dressFrame, userSelection, centerX, centerY));

        JButton buttonPlat = new JButton("Платья");
        buttonPlat.addActionListener(new DressesButton(dressFrame, userSelection, centerX, centerY));

        dressFrame.add(buttonKom);
        dressFrame.add(buttonCost);
        dressFrame.add(buttonPlat);
        dressFrame.setVisible(true);

        dressFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });
    }
}
