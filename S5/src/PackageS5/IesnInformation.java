package PackageS5;

import javax.swing.*;

public class IesnInformation extends JPanel {
    /*
    *  Rue Joseph Calozet 19, 5000 Namur
    *    081 46 86 10
    *  henallux.be
    * info.iesn@henallux.be
    * */

    private JLabel texte;
    public IesnInformation() {
        texte = new JLabel("<html>" +
                "<i>Adresse : </i>Rue Joseph Calozet 19, 5000 Namur<br>" +
                "<i>N° : </i>081 46 86 10<br>" +
                "<i>Site web : </i>henallux.be<br>" +
                "<i>Email : </i>info.iesn@henallux.be<br>" +
                "</html>");
        this.add(texte);
    }
}
