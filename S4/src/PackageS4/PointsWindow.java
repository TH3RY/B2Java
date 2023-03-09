package PackageS4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PointsWindow extends JFrame {
    CounterPanel counterPanel;
    private Container mainContainer;
    public PointsWindow(Billiard billiard) {
        super("Points");
        setBounds(0, 0, 100, 100);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        counterPanel = new CounterPanel(billiard);
        mainContainer = this.getContentPane();       /* Ajout du billard au conteneur de la fenêtre via le gestionnaire de tracé     par défaut */
        mainContainer.add(counterPanel);
        setVisible(true);
    }
}
