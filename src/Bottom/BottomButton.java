package Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Низ".
 * Открывает окно "Низ", позволяющее пользователю выбрать дополнительные предметы нижней одежды.
 */
public class BottomButton implements ActionListener {
    //Ссылка на главное окно приложения
    private JFrame frame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public BottomButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Низ".
     *
     * Выполняет следующие действия:
     *  - Скрывает главное окно.
     *  - Создает новое окно "Низ" для выбора дополнительных предметов нижней одежды.
     *  - Добавляет в новое окно кнопки для выбора различных типов нижней одежды.
     *  - При закрытии окна "Низ" восстанавливает видимость главного окна.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame bottomFrame = new JFrame("Низ");
        bottomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bottomFrame.setSize(700, 500);
        bottomFrame.setLocation(centerX, centerY);
        bottomFrame.setLayout(new FlowLayout());

        //Создаем кнопки для выбора различных видов нижней одежды
        JButton buttonJeans = new JButton("Джинсы/брюки");
        buttonJeans.addActionListener(new JeansButton(bottomFrame, userSelection, centerX, centerY));

        JButton buttonShorts = new JButton("Шорты");
        buttonShorts.addActionListener(new ShortsButton(bottomFrame, userSelection, centerX, centerY));

        JButton buttonSkirts = new JButton("Юбки");
        buttonSkirts.addActionListener(new SkirtsButton(bottomFrame, userSelection, centerX, centerY));

        bottomFrame.add(buttonJeans);
        bottomFrame.add(buttonShorts);
        bottomFrame.add(buttonSkirts);
        bottomFrame.setVisible(true);

        //При закрытии окна "Низ" снова отображается главное окно
        bottomFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });
    }
}
