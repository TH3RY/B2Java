package PackageS4;

import java.awt.*;
import java.util.Random;

public class Hole {

    private Rectangle rectangle;

    public Hole(int x, int y) {
        this.rectangle = new Rectangle(x, y, 10, 10);
    }

    public boolean disappearance(Ball ball) {
        return rectangle.intersects(ball.getRectangle());
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRoundRect(rectangle.x, rectangle.y, 10, 10, 100, 100);
    }
}
