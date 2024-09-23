package Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Шорты".
 * Открывает окно "Шорты", позволяющее пользователю выбрать длину шорт или иной предмет одежды.
 */
public class ShortsButton implements ActionListener {
    //Ссылка на окно "Низ"
    private JFrame bottomFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public ShortsButton(JFrame bottomFrame, boolean[] userSelection, int centerX, int centerY) {
        this.bottomFrame = bottomFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Шорты",
     * открывает окно "Шорты" для выбора длины шорт или иного предмета одежды,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        bottomFrame.setVisible(false);
        JFrame shortsFrame = new JFrame("Шорты");
        shortsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        shortsFrame.setSize(700, 500);
        shortsFrame.setLocation(centerX, centerY);
        shortsFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора длины шорт и иного предмета одежды
        JCheckBox miniCheckBox = new JCheckBox("Мини");
        JCheckBox longCheckBox = new JCheckBox("Удлинённые");
        JCheckBox bikerCheckBox = new JCheckBox("Велосипедки");

        panel.add(miniCheckBox);
        panel.add(longCheckBox);
        panel.add(bikerCheckBox);

        shortsFrame.add(panel);
        shortsFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными опциями
        shortsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (miniCheckBox.isSelected()) {
                    userSelection[3] = true; /*Пример: индекс 3 соответствует длине "Мини" и фотографии,
                    на которой присутствует выбранная длина.*/
                }
                if (longCheckBox.isSelected()) {
                    userSelection[13] = true;
                }
                if (bikerCheckBox.isSelected()) { /*Пример: индекс 0 соответствует категории "Велосипедки" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                    userSelection[0] = true;
                }
                //Отображаем родительское окно
                bottomFrame.setVisible(true);
            }
        });
    }
}
