import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton implements ActionListener {
    private boolean[] userSelection;

    public ClearButton(boolean[] userSelection) {
        this.userSelection = userSelection;
    }

    //сброс ранее выбранных категорий
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < userSelection.length; i++) {
            userSelection[i] = false;
        }
    }
}