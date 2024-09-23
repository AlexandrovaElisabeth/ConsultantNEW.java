package Dress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Комбинезоны".
 * Открывает окно "Комбинезоны", позволяющее пользователю выбрать комбинезон.
 */
public class JumpsuitButton implements ActionListener {
    //Ссылка на окно "Платья/комбинезоны"
    private JFrame dressFrame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public JumpsuitButton(JFrame dressFrame, boolean[] userSelection, int centerX, int centerY) {
        this.dressFrame = dressFrame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Комбинезоны",
     * открывает окно "Комбинезоны" для выбора комбинезона,
     * обновляет массив `userSelection` при закрытии окна в соответствии с выбранными опциями.
     *
     * Если пользователь выбрал какую-либо категорию, соответствующий элемент массива устанавливается в значение `true`.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        dressFrame.setVisible(false);
        JFrame jumpsuitFrame = new JFrame("Комбинезоны");
        jumpsuitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jumpsuitFrame.setSize(700, 500);
        jumpsuitFrame.setLocation(centerX, centerY);
        jumpsuitFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //Создаем чекбоксы для выбора опции
        JCheckBox jumpsuitCheckBox = new JCheckBox("Комбинезон");

        panel.add(jumpsuitCheckBox);

        jumpsuitFrame.add(panel);
        jumpsuitFrame.setVisible(true);

        //Обновляем массив `userSelection` в соответствии с выбранной опцией
        jumpsuitFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (jumpsuitCheckBox.isSelected()) {
                    userSelection[1] = true; /*Пример: индекс 1 соответствует категории "Комбинезон" и фотографии,
                    на которой присутствует выбранный элемент одежды.*/
                }
                //Отображаем родительское окно
                dressFrame.setVisible(true);
            }
        });
    }
}
