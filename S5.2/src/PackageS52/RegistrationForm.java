package PackageS52;

import javax.swing.*;
import java.awt.*;

public class RegistrationForm extends JPanel {
    public RegistrationForm(MainMenuWindow mainMenuWindow) {
        setLayout(new BorderLayout());
        FormPanel formPanel = new FormPanel();
        ButtonsPanel buttonsPanel = new ButtonsPanel(formPanel, mainMenuWindow);
        add(formPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
