package Top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Пиджаки".
 * Открывает окно "Пиджаки", позволяющее пользователю выбрать пиджак или жилетку.
 */
public class JacketButton implements ActionListener {
    //Ссылка на окно "Верх"
    private JFrame topFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public JacketButton(JFrame topFrame, boolean[] userSelection, int centerX, int centerY) {
        this.topFrame = topFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Пиджаки",
     * открывает окно "Пиджаки" для выбора пиджака или жилетки,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        topFrame.setVisible(false);
        JFrame jacketFrame = new JFrame("Пиджаки");
        jacketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jacketFrame.setSize(700, 500);
        jacketFrame.setLocation(centerX, centerY);
        jacketFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора пиджака или жилетки
        JCheckBox blazerCheckBox = new JCheckBox("Пиджак");
        JCheckBox vestCheckBox = new JCheckBox("Жилет");

        panel.add(blazerCheckBox);
        panel.add(vestCheckBox);

        jacketFrame.add(panel);
        jacketFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранными опциями
        jacketFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (blazerCheckBox.isSelected()) {
                    userSelection[11] = true; /*Пример: индекс 11 соответствует категории "Пиджак" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                if (vestCheckBox.isSelected()) {
                    userSelection[6] = true;
                }
                //Отображаем родительское окно
                topFrame.setVisible(true);
            }
        });
    }
}
