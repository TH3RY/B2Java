package PackageS5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu applicationMenu, studentMenu, infoMenu;
    private JMenuItem exit, inscriptionMenu, IESNMenu, helpMenu;
    public MenuWindow() {
        super("Test");
        setBounds(0, 0, 500, 500);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JMenuBar menuBar = new JMenuBar();

        applicationMenu = new JMenu("Application");
        studentMenu = new JMenu("Etudiant");
        infoMenu = new JMenu("Infos");
        exit = new JMenuItem("Quitter");
        inscriptionMenu = new JMenuItem("Inscription");
        IESNMenu = new JMenuItem("IESN");
        helpMenu = new JMenuItem("Aide");
        IesnInformation iesnInformation = new IesnInformation();
        RegistrationForm registrationForm = new RegistrationForm();
        exit.addActionListener(e -> System.exit(0));
        IESNMenu.addActionListener(e -> {
            remove(registrationForm);
            add(iesnInformation, BorderLayout.CENTER);
            revalidate();
            repaint();
            setVisible(true);
        });
        inscriptionMenu.addActionListener(e -> {
            remove(iesnInformation);
            add(registrationForm, BorderLayout.CENTER);
            revalidate();
            repaint();
            setVisible(true);
        });
        helpMenu.addActionListener(e -> {
            JFrame helpFrame = new JFrame("Aide");
            helpFrame.setBounds(0, 0, 300, 500);
            helpFrame.add(new JLabel("lorem ipsum"),BorderLayout.CENTER);
            JButton button = new JButton("Retour à la fenêtre principale");
            button.addActionListener(event -> helpFrame.dispose());
            helpFrame.add(button,BorderLayout.SOUTH);
            helpFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {helpFrame.dispose();}
            });
            helpFrame.setVisible(true);
        });
        applicationMenu.add(exit);
        studentMenu.add(inscriptionMenu);
        infoMenu.add(IESNMenu);
        infoMenu.add(helpMenu);

        menuBar.add(applicationMenu);
        menuBar.add(studentMenu);
        menuBar.add(infoMenu);
        setJMenuBar(menuBar);
        setVisible(true);
        setResizable(false);

    }
}
