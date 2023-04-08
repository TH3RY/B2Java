package PackageS5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class FormPanel extends JPanel{
    private JLabel matriculeLabel, nameLabel, surnameLabel, birthDateLabel, sectionLabel, originLabel;
    private JCheckBox boursierCheckBox, foreignerCheckBox;
    private JComboBox<String> originComboBox;
    private JRadioButton newStudentRadioBtn, oldStudentRadioBtn;
    private ButtonGroup buttonGroup;
    private JTextField matriculeField, nameField, surnameField, birthDateField, sectionField;

    public FormPanel () {
        setLayout(new GridLayout(8, 2, 5, 5));
        matriculeLabel = new JLabel("Matricule");
        matriculeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(matriculeLabel, Component.RIGHT_ALIGNMENT);
        matriculeField = new JTextField();
        add(matriculeField, LEFT_ALIGNMENT);
        matriculeField.addActionListener(e -> {
            char first = '0';
            if (matriculeField.getText().toCharArray().length != 0) {
                first = matriculeField.getText().toCharArray()[0];
            }
            switch (first) {
                case '1' -> sectionField.setText("Informatique de gestion");
                case '2' -> sectionField.setText("Technologie de l'informatique");
                case '3' -> sectionField.setText("Sécurité des systèmes");
                case '4' -> sectionField.setText("Comptabilité");
                case '5' -> sectionField.setText("Marketing");
                case '6' -> sectionField.setText("Automatique");
                case '7' -> sectionField.setText("Droit");
                default -> JOptionPane.showMessageDialog(null, "Erreur matricule, premier chiffre de 1 a 7", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        nameLabel = new JLabel("Prénom");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(nameLabel, Component.RIGHT_ALIGNMENT);

        nameField = new JTextField();
        add(nameField, LEFT_ALIGNMENT);

        surnameLabel = new JLabel("Nom");
        surnameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(surnameLabel, Component.RIGHT_ALIGNMENT);

        surnameField = new JTextField();
        add(surnameField, LEFT_ALIGNMENT);

        birthDateLabel = new JLabel("Date de naissance");
        birthDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(birthDateLabel, Component.RIGHT_ALIGNMENT);

        birthDateField = new JTextField();
        add(birthDateField, LEFT_ALIGNMENT);

        sectionLabel = new JLabel("Section");
        sectionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(sectionLabel, Component.RIGHT_ALIGNMENT);

        sectionField = new JTextField();
        sectionField.setEnabled(false);
        add(sectionField, LEFT_ALIGNMENT);

        boursierCheckBox = new JCheckBox("Boursier");
        boursierCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
        foreignerCheckBox = new JCheckBox("Etranger");
        foreignerCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                originComboBox.setEnabled(true);
            else {
                originComboBox.setSelectedIndex(0);
                originComboBox.setEnabled(false);
            }
        });
        add(boursierCheckBox, Component.RIGHT_ALIGNMENT);
        add(foreignerCheckBox, LEFT_ALIGNMENT);

        originLabel = new JLabel("Origine");
        originLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(originLabel, Component.RIGHT_ALIGNMENT);

        originComboBox = new JComboBox<>();
        originComboBox.addItem("Europe");
        originComboBox.addItem("Afrique");
        originComboBox.addItem("Asie");
        originComboBox.addItem("Amérique");
        originComboBox.addItem("Océanie");
        originComboBox.setEnabled(false);
        add(originComboBox, Component.LEFT_ALIGNMENT);

        newStudentRadioBtn = new JRadioButton("Nouvel Etudiant");
        oldStudentRadioBtn = new JRadioButton("Réinscription");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(newStudentRadioBtn);
        buttonGroup.add(oldStudentRadioBtn);
        newStudentRadioBtn.setHorizontalAlignment(SwingConstants.RIGHT);

        newStudentRadioBtn.addActionListener(e -> {
            if (boursierCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Veuillez vous rendre au secrétariat", "Attention", JOptionPane.WARNING_MESSAGE);
            }
        });

        oldStudentRadioBtn.addActionListener(e -> JOptionPane.showMessageDialog(null, "Veuillez remplire votre PAE", "Attention", JOptionPane.WARNING_MESSAGE));

        add(newStudentRadioBtn, RIGHT_ALIGNMENT);
        add(oldStudentRadioBtn, LEFT_ALIGNMENT);

    }
}
