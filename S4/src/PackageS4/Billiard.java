package PackageS4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Billiard extends JPanel {
    private ArrayList<Wall> verticalSides;
    private ArrayList<Wall> horizontalSides;

    public Billiard() {
        super(null, false);
        this.verticalSides = new ArrayList<>() ;
        this.horizontalSides = new ArrayList<>();
        verticalSides.add(new Wall(0,0,0,93));
        verticalSides.add(new Wall(187,0,0,93));
        horizontalSides.add(new Wall(0,0,187,0));
        horizontalSides.add(new Wall(0,93,187,0));

    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw((Shape) verticalSides.get(0));
        g2d.draw((Shape) verticalSides.get(1));
        g2d.draw((Shape) horizontalSides.get(0));
        g2d.draw((Shape) horizontalSides.get(1));
        super.paint(g2d);
    }


}
