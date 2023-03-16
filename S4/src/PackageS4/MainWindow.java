package PackageS4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private Billiard billiard;
    private Container mainContainer;
    public MainWindow() {
        super("Billiard");
        setBounds(0, 0, 300, 650);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        billiard = new Billiard();
        JPanel panel = new JPanel();
        JButton button = new JButton("Start");
        mainContainer = this.getContentPane();
        mainContainer.add(billiard, BorderLayout.CENTER);
        panel.add(button, BorderLayout.CENTER);
        mainContainer.add(panel, BorderLayout.SOUTH);
        button.addActionListener((e -> billiard.newBall()));
        setVisible(true);
        new PointsWindow(billiard);
    }
}
