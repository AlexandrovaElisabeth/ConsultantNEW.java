import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class SearchButton implements ActionListener {
    private JFrame frame;
    private boolean[] userSelection;
    private int centerX, centerY;
    private Map<Integer, String> map;

    public SearchButton(JFrame frame, boolean[] userSelection, int centerX, int centerY) {
        this.frame = frame;
        this.userSelection = userSelection;
        this.centerX = centerX;
        this.centerY = centerY;
        this.map = new HashMap<>();

        for (int i = 0; i < 60; i++) {
            String str = Integer.toString(i + 1);
            map.put(i, "src/image/" + str + ".jpg");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //сокрытие главного окна приложения
        frame.setVisible(false);
        //создание нового окна с результатами поиска
        JFrame newFrame = new JFrame("Подобранные типы одежды");
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(700, 500);
        newFrame.setLocation(centerX, centerY);
        newFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        //создание панели прокрутки
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(700, 500));

        //проверка выбранных пользователем категорий
        for (int i = 0; i < 59; i++) {
            if (userSelection[i]) {
                try {
                    //чтение изображения
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

        //обновление и отображение панели:
        panel.revalidate();
        panel.repaint();
        newFrame.add(scrollPane);

        //при закрытии нового окна главное окно снова в области видимости
        newFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
            }
        });

        newFrame.setVisible(true);
    }
}
