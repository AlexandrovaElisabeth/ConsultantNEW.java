package Top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс вызывается при нажатии на кнопку "Верх".
 * Открывает окно "Верх", позволяющее пользователю выбрать дополнительные предметы верхней одежды.
 */
public class TopButton implements ActionListener {
    //Ссылка на главное окно приложения
    private JFrame frame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;

    public TopButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Верх".
     *
     * Выполняет следующие действия:
     *  - Скрывает главное окно.
     *  - Создает новое окно "Верх" для выбора дополнительных предметов верхней одежды.
     *  - Добавляет в новое окно кнопки для выбора различных типов верхней одежды.
     *  - При закрытии окна "Верх" восстанавливает видимость главного окна.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame topFrame = new JFrame("Верх");
        topFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        topFrame.setSize(700, 500);
        topFrame.setLocation(centerX, centerY);
        topFrame.setLayout(new FlowLayout());

        //Создаем кнопки для выбора различных видов верхней одежды
        JButton buttonBlouse = new JButton("Блузки/рубашки");
        buttonBlouse.addActionListener(new BlouseButton(topFrame, userSelection, centerX, centerY));

        JButton buttonOuter = new JButton("Верхняя одежда");
        buttonOuter.addActionListener(new OuterwearButton(topFrame, userSelection, centerX, centerY));

        JButton buttonJacket = new JButton("Пиджаки");
        buttonJacket.addActionListener(new JacketButton(topFrame, userSelection, centerX, centerY));

        topFrame.add(buttonBlouse);
        topFrame.add(buttonOuter);
        topFrame.add(buttonJacket);
        topFrame.setVisible(true);

        //При закрытии окна "Верх" снова отображается главное окно
        topFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });
    }
}
