package PackageS4;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Wall extends Object{
    private Rectangle rectangle;

    public Wall(int x, int y, int width, int height ){
        this.rectangle = new Rectangle(x, y, width, height);
        draw();
    }
    public void draw(Graphics g) {
        g.fillRect(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }
}
