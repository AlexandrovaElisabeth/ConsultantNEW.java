package Accessories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Ноги".
 * Открывает окно "Аксессуары на ноги", позволяющее пользователю выбрать аксессуары на ноги.
 */
public class LegsButton implements ActionListener {
    //Ссылка на окно "Аксессуары"
    private JFrame accessoryFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public LegsButton(JFrame accessoryFrame, boolean[] userSelection, int centerX, int centerY) {
        this.accessoryFrame = accessoryFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Ноги",
     * открывает окно "Аксессуары на ноги" для выбора аксессуаров на ноги,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        accessoryFrame.setVisible(false);
        JFrame legsFrame = new JFrame("Аксессуары на ноги");
        legsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        legsFrame.setSize(700, 500);
        legsFrame.setLocation(centerX, centerY);
        legsFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора различных аксессуаров на ноги
        JCheckBox socksCheckBox = new JCheckBox("Носки");
        JCheckBox stockingsCheckBox = new JCheckBox("Чулки/гольфы");
        JCheckBox tightsCheckBox = new JCheckBox("Колготки");

        panel.add(socksCheckBox);
        panel.add(stockingsCheckBox);
        panel.add(tightsCheckBox);

        legsFrame.add(panel);
        legsFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными аксессуарами на ноги
        legsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (socksCheckBox.isSelected()) {
                    userSelection[0] = true; /*Пример: индекс 0 соответствует категории "Носки" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                    userSelection[3] = true;
                }
                if (stockingsCheckBox.isSelected()) {
                    userSelection[5] = true;
                    userSelection[6] = true;
                }
                if (tightsCheckBox.isSelected()) {
                    userSelection[12] = true;
                }
                //Отображаем родительское окно
                accessoryFrame.setVisible(true);
            }
        });
    }
}
