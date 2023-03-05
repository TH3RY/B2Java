package PackageS4;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ball {
    private Rectangle rectangle;
    private Billiard billiard;
    private int stepX;
    private int stepY;

    private Color color;
    private int iColor;

    private boolean toEliminate;
    private static Color [] colors = new Color[] {
        Color.BLUE,
        Color.RED,
        Color.GREEN,
        Color.MAGENTA,
        Color.LIGHT_GRAY,
        Color.YELLOW,
        Color.GREEN
    };
    public Rectangle getRectangle() {
        return rectangle;
    }

    public Ball(Billiard billiard, int x, int y, int width, int height ) {
        this.rectangle = new Rectangle(x,y,width,height);
        this.billiard = billiard;
        stepX = 5;
        stepY = 5;
        this.color = Color.BLACK;
        this.iColor = 0;
        this.toEliminate = false;
    }

    public Billiard getBilliard() {
        return billiard;
    }

    public void setBilliard(Billiard billiard) {
        this.billiard = billiard;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(rectangle.x,rectangle.y,rectangle.width,rectangle.height,100,100);
    }

    public void move() {
        if (getBilliard() != null) {
            if (billiard.getHorizontalSides().stream().anyMatch((side -> side.collision(this)))) {
                this.stepY *= -1;
                billiard.getHorizontalSides().forEach(wall -> {
                    if (wall.collision(this)) Billiard.totalPoints += wall.getPoints();
                });
            }
            if (billiard.getVerticalSides().stream().anyMatch((side -> side.collision(this)))) {
                this.stepX *= -1;
                billiard.getVerticalSides().forEach(wall -> {
                    if (wall.collision(this)) Billiard.totalPoints += wall.getPoints();
                });
            }
            if (hasSameAge()) {
                this.stepY *= -1;
                this.stepX *= -1;
            }
            toEliminate = billiard.getHoles().stream().anyMatch(x -> x.disappearance(this));
        }
        this.rectangle.setLocation(rectangle.x + stepX,rectangle.y + stepY);
    }

    public boolean isToEliminate() {
        return toEliminate;
    }

    private boolean hasSameAge() {
        for (int i = 0; i < billiard.getBalls().size() - 1; i++) {
            for (int j = i + 1; j < billiard.getBalls().size(); j++) {
                if (billiard.getBalls().get(i).collision(billiard.getBalls().get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
    public void changeColor() {
        if (iColor == colors.length) iColor = 0;
        color = colors[iColor];
        iColor++;
    }
    public boolean collision(Ball ball) {
        return rectangle.intersects(ball.getRectangle());
    }
}
