package Accessories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Аксессуары".
 * Открывает новое окно, позволяющее пользователю выбрать дополнительные аксессуары.
 */
public class AccessoriesButton implements ActionListener {
    //Ссылка на главное окно приложения
    private JFrame frame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public AccessoriesButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Аксессуары".
     *
     * Выполняет следующие действия:
     *  - Скрывает главное окно.
     *  - Создает новое окно "Аксессуары" для выбора дополнительных аксессуаров.
     *  - Добавляет в новое окно кнопки для выбора различных типов аксессуаров.
     *  - При закрытии окна "Аксессуары" восстанавливает видимость главного окна.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame accessoryFrame = new JFrame("Аксессуары");
        accessoryFrame.setResizable(false);
        accessoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        accessoryFrame.setSize(700, 500);
        accessoryFrame.setLocation(centerX, centerY);
        accessoryFrame.setLayout(new FlowLayout());

        //Создаем кнопки для выбора различных аксессуаров
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

        //При закрытии окна "Аксессуары" снова отображается главное окно
        accessoryFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });
    }
}
