package Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Юбки".
 * Открывает окно "Юбки", позволяющее пользователю выбрать длину юбки.
 */
public class SkirtsButton implements ActionListener {
    //Ссылка на окно "Низ"
    private JFrame bottomFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public SkirtsButton(JFrame bottomFrame, boolean[] userSelection, int centerX, int centerY) {
        this.bottomFrame = bottomFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Юбки",
     * открывает окно "Юбки" для выбора длины юбки,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        bottomFrame.setVisible(false);
        JFrame skirtsFrame = new JFrame("Юбки");
        skirtsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        skirtsFrame.setSize(700, 500);
        skirtsFrame.setLocation(centerX, centerY);
        skirtsFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора длины юбки
        JCheckBox maxiCheckBox = new JCheckBox("Макси");
        JCheckBox midiCheckBox = new JCheckBox("Миди");
        JCheckBox miniCheckBox = new JCheckBox("Мини");

        panel.add(maxiCheckBox);
        panel.add(midiCheckBox);
        panel.add(miniCheckBox);

        skirtsFrame.add(panel);
        skirtsFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными опциями
        skirtsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (maxiCheckBox.isSelected()) {
                    userSelection[10] = true; /*Пример: индекс 10 соответствует длине "Макси" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                if (midiCheckBox.isSelected()) {
                    userSelection[4] = true;
                }
                if (miniCheckBox.isSelected()) {
                    userSelection[6] = true;
                }
                //Отображаем родительское окно
                bottomFrame.setVisible(true);
            }
        });
    }
}
