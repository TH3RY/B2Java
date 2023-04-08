package PackageS5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class RegistrationForm extends JPanel {
    public RegistrationForm() {
        add(new FormPanel(),BorderLayout.CENTER);
        add(new ButtonsPanel(),BorderLayout.SOUTH);
    }
}
