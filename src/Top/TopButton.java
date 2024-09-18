package Top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopButton implements ActionListener {
    private JFrame frame;
    private boolean[] userSelection;
    private int centerX, centerY;

    public TopButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame topFrame = new JFrame("Верх");
        topFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        topFrame.setSize(700, 500);
        topFrame.setLocation(centerX, centerY);
        topFrame.setLayout(new FlowLayout());

        JButton buttonBlouse = new JButton("Блузки/рубашки");
        buttonBlouse.addActionListener(new BlouseButton(topFrame, userSelection, centerX, centerY));

        JButton buttonOuter = new JButton("Верхняя одежда");
        buttonOuter.addActionListener(new OuterwearButton(topFrame, userSelection, centerX, centerY));

        JButton buttonJacket = new JButton("Пиджаки");
        buttonJacket.addActionListener(new JacketButton(topFrame, userSelection, centerX, centerY));

        topFrame.add(buttonBlouse);
        topFrame.add(buttonOuter);
        topFrame.add(buttonJacket);
        topFrame.setVisible(true);

        topFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });
    }
}
