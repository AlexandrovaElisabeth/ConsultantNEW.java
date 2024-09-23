import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

/**
 * Класс, запускающий поиск по заданным критериям.
 * При нажатии на кнопку "Найти!" отображается новое окно с результатами поиска,
 * соответствующими выбранным пользователем элементам одежды.
 */
public class SearchButton implements ActionListener {

    //Ссылка на главное окно приложения
    private JFrame frame;
    //Массив, хранящий выбранные пользователем категории одежды
    private boolean[] userSelection;
    //Координаты центра экрана для размещения нового окна
    private int centerX, centerY;
    //Словарь, используемый для сопоставления целых чисел (ключей) со строками (значениями)
    private Map<Integer, String> map;

    public SearchButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
        this.map = new HashMap<>();

        /**
         * Цикл для каждого числа создает строку с путем к изображению в формате "src/image/номер.jpg".
         * Полученный путь и соответствующий номер (индекс в цикле) добавляются в словарь в качестве пары ключ-значение.
         *  - Существует директория "src/image/" с изображениями, пронумерованными от 1 до 60.
         *  - Имена изображений соответствуют формату "номер.jpg".
         */
        for (int i = 0; i < 60; i++) {
            String str = Integer.toString(i + 1);
            map.put(i, "src/image/" + str + ".jpg");
        }
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Найти!".
     *
     * Выполняет следующие действия:
     *  1. Скрывает главное окно приложения.
     *  2. Создает новое окно "Подобранные типы одежды" для отображения подобранных типов одежды.
     *  3. Добавляет в новое окно панель прокрутки с изображениями выбранных предметов одежды.
     *  4. Масштабирует изображения по высоте, чтобы они помещались в панель прокрутки.
     *  5. Отображает новое окно.
     *  6. Делает главное окно снова видимым при закрытии окна "Подобранные типы одежды".
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame newFrame = new JFrame("Подобранные типы одежды");
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(700, 500);
        newFrame.setLocation(centerX, centerY);
        newFrame.setLayout(new FlowLayout());

        //Добавляем панель прокрутки
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(700, 500));

        for (int i = 0; i < 59; i++) {
            if (userSelection[i]) {
                try {
                    //Масштабируем изображения
                    BufferedImage originalImage = ImageIO.read(new File(map.get(i)));
                    int originalWidth = originalImage.getWidth();
                    int originalHeight = originalImage.getHeight();
                    int availableHeight = scrollPane.getPreferredSize().height;
                    int scaledWidth = availableHeight * originalWidth / originalHeight;
                    Image scaledImage = originalImage.getScaledInstance(scaledWidth, availableHeight,
                            Image.SCALE_SMOOTH);
                    JLabel label = new JLabel(new ImageIcon(scaledImage));
                    panel.add(label);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        panel.revalidate();
        panel.repaint();
        newFrame.add(scrollPane);

        //Делаем главное окно видимым при закрытии окна
        newFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });

        newFrame.setVisible(true);
    }
}
