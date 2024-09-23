package Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Джинсы/брюки".
 * Открывает окно "Джинсы/брюки", позволяющее пользователю выбрать джинсы или брюки
 */
public class JeansButton implements ActionListener {
    //Ссылка на окно "Низ"
    private JFrame bottomFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public JeansButton(JFrame bottomFrame, boolean[] userSelection, int centerX, int centerY) {
        this.bottomFrame = bottomFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Джинсы/брюки",
     * открывает окно "Джинсы/брюки" для выбора джинс или брюк,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        bottomFrame.setVisible(false);
        JFrame jeansFrame = new JFrame("Джинсы/брюки");
        jeansFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jeansFrame.setSize(700, 500);
        jeansFrame.setLocation(centerX, centerY);
        jeansFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора различных предметов нижней одежды
        JCheckBox jeansCheckBox = new JCheckBox("Джинсы");
        JCheckBox trousersCheckBox = new JCheckBox("Брюки");

        panel.add(jeansCheckBox);
        panel.add(trousersCheckBox);

        jeansFrame.add(panel);
        jeansFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными предметами одежды
        jeansFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (jeansCheckBox.isSelected()) {
                    userSelection[2] = true; /*Пример: индекс 2 соответствует категории "Джинсы" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                if (trousersCheckBox.isSelected()) {
                    userSelection[8] = true;
                }
                //Отображаем родительское окно
                bottomFrame.setVisible(true);
            }
        });
    }
}