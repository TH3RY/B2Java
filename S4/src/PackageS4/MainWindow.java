package PackageS4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
public class MainWindow extends JFrame {
    private Billiard billiard;
    private Container mainContainer;
    public MainWindow () {
        super("Billiard");
        setBounds(0,0,1920,1080);
        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        } );       // Création d’une occurrence du panel représentant le billard
        billiard = new Billiard();   // Récupération de la référence du conteneur de la fenêtre :
        mainContainer = this.getContentPane();       /* Ajout du billard au conteneur de la fenêtre via le gestionnaire de tracé     par défaut */
        mainContainer.add(billiard);              // Affichage de la fenêtre :
        setVisible(true);
    }
}
