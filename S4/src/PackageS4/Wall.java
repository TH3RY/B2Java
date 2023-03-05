package PackageS4;

import java.awt.*;

public class Wall {
    private Rectangle rectangle;
    private int points;

    public Wall(int x, int y, int width, int height, int points) {
        this.rectangle = new Rectangle(x, y, width, height);
        this.points = points;
    }

    public void draw(Graphics g) {
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public int getPoints() {
        return points;
    }

    public boolean collision(Ball ball) {
        return rectangle.intersects(ball.getRectangle());
    }
}
