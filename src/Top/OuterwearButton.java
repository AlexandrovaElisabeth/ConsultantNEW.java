package Top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Верхняя одежда".
 * Открывает окно "Верхняя одежда", позволяющее пользователю выбрать предметы верхней одежды.
 */
public class OuterwearButton implements ActionListener {
    //Ссылка на окно "Верх"
    private JFrame topFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public OuterwearButton(JFrame topFrame, boolean[] userSelection, int centerX, int centerY) {
        this.topFrame = topFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Верхняя одежда",
     * открывает окно "Верхняя одеждла" для выбора верхней одежды,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        topFrame.setVisible(false);
        JFrame outerwearFrame = new JFrame("Верхняя одежда");
        outerwearFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        outerwearFrame.setSize(700, 500);
        outerwearFrame.setLocation(centerX, centerY);
        outerwearFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора различных предметов верхней одежды
        JCheckBox denimCheckBox = new JCheckBox("Джинсовая куртка");
        JCheckBox leatherCheckBox = new JCheckBox("Кожаная куртка");

        panel.add(denimCheckBox);
        panel.add(leatherCheckBox);

        outerwearFrame.add(panel);
        outerwearFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными опциями
        outerwearFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (denimCheckBox.isSelected()) {
                    userSelection[24] = true; /*Пример: индекс 24 соответствует категории "Джинсовая куртка" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                if (leatherCheckBox.isSelected()) {
                    userSelection[4] = true;
                }
                //Отображаем родительское окно
                topFrame.setVisible(true);
            }
        });
    }
}
