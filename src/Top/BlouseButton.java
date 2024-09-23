package Top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Блузки/рубашки".
 * Открывает окно "Блузки/рубашки", позволяющее пользователю выбрать блузку или рубашку.
 */
public class BlouseButton implements ActionListener {
    //Ссылка на окно "Верх"
    private JFrame topFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public BlouseButton(JFrame topFrame, boolean[] userSelection, int centerX, int centerY) {
        this.topFrame = topFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Блузки/рубашки",
     * открывает окно "Блузки/рубашки" для выбора блузки или рубашки,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        topFrame.setVisible(false);
        JFrame blouseFrame = new JFrame("Блузки/рубашки");
        blouseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        blouseFrame.setSize(700, 500);
        blouseFrame.setLocation(centerX, centerY);
        blouseFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора различных предметов верхней одежды
        JCheckBox blouseCheckBox = new JCheckBox("Блузка");
        JCheckBox shirtCheckBox = new JCheckBox("Рубашка");

        panel.add(blouseCheckBox);
        panel.add(shirtCheckBox);

        blouseFrame.add(panel);
        blouseFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными опциями
        blouseFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (blouseCheckBox.isSelected()) {
                    userSelection[5] = true; /*Пример: индекс 5 соответствует категории "Блузка" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                    userSelection[7] = true;
                }
                if (shirtCheckBox.isSelected()) {
                    userSelection[0] = true;
                }
                //Отображаем родительское окно
                topFrame.setVisible(true);
            }
        });
    }
}
