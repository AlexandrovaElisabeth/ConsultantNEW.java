import Accessories.AccessoriesButton;
import Bottom.BottomButton;
import Dress.DressButton;
import Top.TopButton;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {
        //основное окно приложения
        JFrame frame = new JFrame("Style Match");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        //хранение информации о выбранных пользователем категориях одежды
        boolean[] userSelection = new boolean[59];

        //центрирование окна
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(30, 0, 0, 0));

        Dimension buttonSize = new Dimension(250, 50);

        //создание кнопок
        JButton buttonA = new JButton("Аксессуары");
        buttonA.addActionListener(new AccessoriesButton(frame, userSelection, centerX, centerY));
        buttonA.setMaximumSize(buttonSize);
        buttonA.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonTop = new JButton("Верх");
        buttonTop.addActionListener(new TopButton(frame, userSelection, centerX, centerY));
        buttonTop.setMaximumSize(buttonSize);
        buttonTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonBottom = new JButton("Низ");
        buttonBottom.addActionListener(new BottomButton(frame, userSelection, centerX, centerY));
        buttonBottom.setMaximumSize(buttonSize);
        buttonBottom.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonDress = new JButton("Платья/комбинезоны");
        buttonDress.addActionListener(new DressButton(frame, userSelection, centerX, centerY));
        buttonDress.setMaximumSize(buttonSize);
        buttonDress.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonSearch = new JButton("Найти!");
        buttonSearch.addActionListener(new SearchButton(frame, userSelection, centerX, centerY));
        buttonSearch.setMaximumSize(buttonSize);
        buttonSearch.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonClear = new JButton("Очистить фильтры");
        buttonClear.addActionListener(new ClearButton(userSelection));
        buttonClear.setMaximumSize(buttonSize);
        buttonClear.setAlignmentX(Component.CENTER_ALIGNMENT);

        //добавление кнопок на панель с вертикальными отступами между ними
        panel.add(Box.createVerticalGlue());
        panel.add(buttonA);
        panel.add(Box.createVerticalStrut(10));
        panel.add(buttonTop);
        panel.add(Box.createVerticalStrut(10));
        panel.add(buttonBottom);
        panel.add(Box.createVerticalStrut(10));
        panel.add(buttonDress);
        panel.add(Box.createVerticalStrut(10));
        panel.add(buttonClear);
        panel.add(Box.createVerticalStrut(100));
        panel.add(buttonSearch);
        panel.add(Box.createVerticalGlue());

        //добавление панели с кнопками в центр окна
        frame.add(panel);
        frame.setVisible(true);
    }
}
