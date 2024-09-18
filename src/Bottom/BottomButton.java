package Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BottomButton implements ActionListener {
    private JFrame frame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public BottomButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame bottomFrame = new JFrame("Низ");
        bottomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bottomFrame.setSize(700, 500);
        bottomFrame.setLocation(centerX, centerY);
        bottomFrame.setLayout(new FlowLayout());

        JButton buttonJeans = new JButton("Джинсы/брюки");
        buttonJeans.addActionListener(new JeansButton(bottomFrame, userSelection, centerX, centerY));

        JButton buttonShorts = new JButton("Шорты");
        buttonShorts.addActionListener(new ShortsButton(bottomFrame, userSelection, centerX, centerY));

        JButton buttonSkirts = new JButton("Юбки");
        buttonSkirts.addActionListener(new SkirtsButton(bottomFrame, userSelection, centerX, centerY));

        bottomFrame.add(buttonJeans);
        bottomFrame.add(buttonShorts);
        bottomFrame.add(buttonSkirts);
        bottomFrame.setVisible(true);

        bottomFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });
    }
}
