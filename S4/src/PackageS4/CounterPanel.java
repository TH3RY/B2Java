package PackageS4;

import javax.swing.*;
import java.awt.*;

public class CounterPanel extends JPanel {
    Billiard billiard;

    public CounterPanel(Billiard billiard) {
        super(null, false);
        this.billiard = billiard;
        Thread thread = new Thread(new PointsCountingThread(this));
        thread.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("POINTS : " + Billiard.totalPoints, 10, 10);
    }
}
