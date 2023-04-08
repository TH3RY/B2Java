package PackageS52;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private JButton back, validate, reinitialisation;

    public ButtonsPanel(FormPanel formPanel, MainMenuWindow mainMenuWindow) {
        setLayout(new FlowLayout());
        back = new JButton("Retour");
        back.addActionListener(e -> mainMenuWindow.setDefaultPanel());
        validate = new JButton("Validation");
        validate.addActionListener(e -> formPanel.newStudent());
        reinitialisation = new JButton("Reinitialisation");
        reinitialisation.addActionListener(e -> formPanel.clearGrid());
        add(back);
        add(validate);
        add(reinitialisation);
        setVisible(true);
    }
}
