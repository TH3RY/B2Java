package PackageS5;

import javax.swing.*;

public class ButtonsPanel extends JPanel {

    private JButton back, validate, reinscription;
    public ButtonsPanel() {
        back = new JButton("Retour");
        back.addActionListener(e -> {
            remove(this.getParent().getParent());
            revalidate();
            repaint();
        });
        add(back);
    }
}
