package PackageS52;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainMenuWindow extends JFrame {
    private JMenuBar jMenuBar;
    private JMenuItem quitterMenu, inscriptionMenu, IESNMenu, aideMenu;
    private JMenu applicationMenu, etudiantMenu, infosMenu;
    private JLabel mainMenuContent;
private JPanel mainPanel;
    public MainMenuWindow()  {
        super("menu principal", null);
        setBounds(0, 0, 500, 500);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jMenuBar = new JMenuBar();

        applicationMenu = new JMenu("Application");
        etudiantMenu = new JMenu("Etudiant");
        infosMenu = new JMenu("Infos");

        quitterMenu = new JMenuItem("Quitter");
        quitterMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        inscriptionMenu = new JMenuItem("Inscription");
        IESNMenu = new JMenuItem("IESN");
        aideMenu = new JMenuItem("aide");

        IesnInformation iesnInformation = new IesnInformation();
        RegistrationForm registrationForm = new RegistrationForm(this);

        applicationMenu.add(quitterMenu);
        etudiantMenu.add(inscriptionMenu);
        infosMenu.add(IESNMenu);
        infosMenu.add(aideMenu);

        jMenuBar.add(applicationMenu);
        jMenuBar.add(etudiantMenu);
        jMenuBar.add(infosMenu);

        mainPanel = new JPanel();
        mainMenuContent = new JLabel("Bienvenue dans l'exercice de la série 5 en JAVA");
        mainMenuContent.setFont(new Font("Verdana",Font.BOLD,15));
        mainMenuContent.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(mainMenuContent,BorderLayout.CENTER);
        add(mainPanel);

        IESNMenu.addActionListener(a -> {
            mainPanel.remove(mainPanel.getComponent(0));
            mainPanel.add(iesnInformation);
            mainPanel.repaint();
            mainPanel.revalidate();
        });

        aideMenu.addActionListener(e -> {
            JFrame helpFrame = new JFrame("Aide");
            helpFrame.setLayout(new BorderLayout());
            helpFrame.setBounds(0, 0, 300, 500);
            JLabel panel = new JLabel("lorem ipsum");
            panel.setHorizontalAlignment(SwingConstants.CENTER);
            helpFrame.add(panel,BorderLayout.CENTER);
            JButton button = new JButton("Retour à la fenêtre principale");
            button.addActionListener(event -> helpFrame.dispose());
            helpFrame.add(button,BorderLayout.SOUTH);
            helpFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {helpFrame.dispose();}
            });
            helpFrame.setVisible(true);
        });

        inscriptionMenu.addActionListener(e -> {
            mainPanel.remove(mainPanel.getComponent(0));
            mainPanel.add(registrationForm);
            mainPanel.repaint();
            mainPanel.revalidate();
        });

        setJMenuBar(jMenuBar);
        getContentPane();
        setVisible(true);
    }

    public void setDefaultPanel() {
        mainPanel.remove(mainPanel.getComponent(0));
        mainPanel.add(mainMenuContent);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
}
