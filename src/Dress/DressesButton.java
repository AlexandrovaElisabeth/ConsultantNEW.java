package Dress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Платье".
 * Открывает окно "Платье", позволяющее пользователю выбрать длину платья.
 */
public class DressesButton implements ActionListener {
    //Ссылка на окно "Платья/комбинезоны"
    private JFrame dressFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public DressesButton(JFrame dressFrame, boolean[] userSelection, int centerX, int centerY) {
        this.dressFrame = dressFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Платье",
     * открывает окно "Платье" для выбора длины платья,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        dressFrame.setVisible(false);
        JFrame dressesFrame = new JFrame("Платье");
        dressesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dressesFrame.setSize(700, 500);
        dressesFrame.setLocation(centerX, centerY);
        dressesFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора длины платья
        JCheckBox maxiCheckBox = new JCheckBox("Макси");
        JCheckBox midiCheckBox = new JCheckBox("Миди");
        JCheckBox miniCheckBox = new JCheckBox("Мини");

        panel.add(maxiCheckBox);
        panel.add(midiCheckBox);
        panel.add(miniCheckBox);

        dressesFrame.add(panel);
        dressesFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными опциями
        dressesFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (maxiCheckBox.isSelected()) {
                    userSelection[9] = true; /*Пример: индекс 9 соответствует категории "Макси" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                if (midiCheckBox.isSelected()) {
                    userSelection[19] = true;
                }
                if (miniCheckBox.isSelected()) {
                    userSelection[14] = true;
                }
                //Отображаем родительское окно
                dressFrame.setVisible(true);
            }
        });
    }
}
