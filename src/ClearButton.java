import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс, выполняющий сброс параметров поиска.
 * При нажатии на кнопку "Очистить фильтры" все выбранные пользователем категории сбрасываются.
 */
public class ClearButton implements ActionListener {
    /**
     * Массив, хранящий информацию о выбранных пользователем предметах одежды.
     * Каждый элемент массива соответствует фотографии, на которой присутсвует выбранный элемент одежды,
     * и может иметь значение true (выбрана) или false (не выбрана).
     */
    private boolean[] userSelection;

    public ClearButton(boolean[] userSelection) {

        this.userSelection = userSelection;
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Очистить фильтры".
     * Сбрасывает все значения в массиве userSelection на false, что означает, что ни одна категория не выбрана.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < userSelection.length; i++) {
            userSelection[i] = false;
        }
    }
}