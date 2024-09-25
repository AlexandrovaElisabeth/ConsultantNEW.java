package Dress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Платья/комбинезоны".
 * Открывает окно "Платья/комбинезоны", позволяющее пользователю выбрать дополнительные элементы одежды.
 */
public class DressButton implements ActionListener {
    //Ссылка на главное окно приложения
    private JFrame frame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public DressButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Платья/комбинезоны".
     *
     * Выполняет следующие действия:
     *  - Скрывает главное окно.
     *  - Создает новое окно "Платья/комбинезоны" для выбора дополнительных предметов одежды.
     *  - Добавляет в новое окно кнопки для выбора различных типов одежды.
     *  - При закрытии окна "Платья/комбинезоны" восстанавливает видимость главного окна.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame dressFrame = new JFrame("Платья/комбинезоны");
        dressFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dressFrame.setSize(700, 500);
        dressFrame.setLocation(centerX, centerY);
        dressFrame.setLayout(new FlowLayout());

        //Создаем кнопки для выбора различных типов одежды
        JButton buttonKom = new JButton("Комбинезоны");
        buttonKom.addActionListener(new JumpsuitButton(dressFrame, userSelection, centerX, centerY));

        JButton buttonCost = new JButton("Костюмы");
        buttonCost.addActionListener(new SuitButton(dressFrame, userSelection, centerX, centerY));

        JButton buttonPlat = new JButton("Платье");
        buttonPlat.addActionListener(new DressesButton(dressFrame, userSelection, centerX, centerY));

        dressFrame.add(buttonKom);
        dressFrame.add(buttonCost);
        dressFrame.add(buttonPlat);
        dressFrame.setVisible(true);

        //При закрытии окна "Платья/комбинезоны" снова отображается главное окно
        dressFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });
    }
}
