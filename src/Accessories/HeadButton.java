package Accessories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Голова".
 * Открывает окно "Аксессуары на голову", позволяющее пользователю выбрать аксессуары на голову.
 */
public class HeadButton implements ActionListener {
    //Ссылка на окно "Аксессуары"
    private JFrame accessoryFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public HeadButton(JFrame accessoryFrame, boolean[] userSelection, int centerX, int centerY) {
        this.accessoryFrame = accessoryFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }


    /**
     * Метод, вызываемый при нажатии на кнопку "Голова",
     * открывает окно "Аксессуары на голову" для выбора головных уборов,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        accessoryFrame.setVisible(false);
        JFrame headFrame = new JFrame("Аксессуары на голову");
        headFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        headFrame.setSize(700, 500);
        headFrame.setLocation(centerX, centerY);
        headFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора различных головных уборов
        JCheckBox hatCheckBox = new JCheckBox("Шляпа");
        JCheckBox capCheckBox = new JCheckBox("Шапка");
        JCheckBox bcapCheckBox = new JCheckBox("Кепка");

        panel.add(hatCheckBox);
        panel.add(capCheckBox);
        panel.add(bcapCheckBox);

        headFrame.add(panel);
        headFrame.setVisible(true);
        //Обновляем массив `userSelection` в соответствии с выбранными головными уборами
        headFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (hatCheckBox.isSelected()) {
                    userSelection[26] = true; /*Пример: индекс 26 соответствует категории "Шляпа" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                if (capCheckBox.isSelected()) {
                    userSelection[7] = true;
                    userSelection[8] = true;
                }
                if (bcapCheckBox.isSelected()) {
                    userSelection[0] = true;
                    userSelection[2] = true;
                    userSelection[11] = true;
                    userSelection[24] = true;
                }
                //Отображаем родительское окно
                accessoryFrame.setVisible(true);
            }
        });
    }
}
