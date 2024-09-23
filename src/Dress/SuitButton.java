package Dress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Костюмы".
 * Открывает окно "Костюмы", позволяющее пользователю выбрать стиль костюма.
 */
public class SuitButton implements ActionListener {
    //Ссылка на окно "Платья/комбинезоны"
    private JFrame dressFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public SuitButton(JFrame dressFrame, boolean[] userSelection, int centerX, int centerY) {
        this.dressFrame = dressFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Костюмы",
     * открывает окно "Костюмы" для выбора стиля костюма,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        dressFrame.setVisible(false);
        JFrame suitFrame = new JFrame("Костюмы");
        suitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        suitFrame.setSize(700, 500);
        suitFrame.setLocation(centerX, centerY);
        suitFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора стиля костюма
        JCheckBox businessSuitCheckBox = new JCheckBox("Деловой костюм");
        JCheckBox sportsSuitCheckBox = new JCheckBox("Спортивный костюм");

        panel.add(businessSuitCheckBox);
        panel.add(sportsSuitCheckBox);

        suitFrame.add(panel);
        suitFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранным стилем костюма
        suitFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (businessSuitCheckBox.isSelected()) {
                    userSelection[23] = true; /*Пример: индекс 23 соответствует категории "Деловой костюм" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                if (sportsSuitCheckBox.isSelected()) {
                    userSelection[24] = true;
                }
                //Отображаем родительское окно
                dressFrame.setVisible(true);
            }
        });
    }
}
