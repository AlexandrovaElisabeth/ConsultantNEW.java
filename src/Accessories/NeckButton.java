package Accessories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Шея".
 * Открывает окно "Аксессуары на шею", позволяющее пользователю выбрать аксессуары на шею.
 */
public class NeckButton implements ActionListener {
    //Ссылка на окно "Аксессуары"
    private JFrame accessoryFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public NeckButton(JFrame accessoryFrame, boolean[] userSelection, int centerX, int centerY) {
        this.accessoryFrame = accessoryFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Шея",
     * открывает окно "Аксессуары на шею" для выбора аксессуаров на шею,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        accessoryFrame.setVisible(false);
        JFrame neckFrame = new JFrame("Аксессуары на шею");
        neckFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        neckFrame.setSize(700, 500);
        neckFrame.setLocation(centerX, centerY);
        neckFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора различных аксессуаров на шею
        JCheckBox tieCheckBox = new JCheckBox("Галстук");
        JCheckBox handkerchiefCheckBox = new JCheckBox("Платок");

        panel.add(tieCheckBox);
        panel.add(handkerchiefCheckBox);

        neckFrame.add(panel);
        neckFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными аксессуарами на шею
        neckFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (tieCheckBox.isSelected()) {
                    userSelection[6] = true; /*Пример: индекс 6 соответствует категории "Галстук" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                if (handkerchiefCheckBox.isSelected()) {
                    userSelection[17] = true;
                }
                //Отображаем родительское окно
                accessoryFrame.setVisible(true);
            }
        });
    }
}
