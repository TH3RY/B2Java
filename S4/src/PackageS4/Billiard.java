package PackageS4;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Billiard extends JPanel {
    private ArrayList<Wall> verticalSides;
    private ArrayList<Wall> horizontalSides;
    private ArrayList<Ball> ballsArray;
    private List<Ball> balls;
    private List<Hole> holes;
    public static int totalPoints = 0;

    public Billiard() {
        super(null, false);
        ballsArray = new ArrayList<>();
        balls = Collections.synchronizedList(ballsArray);
        this.verticalSides = new ArrayList<>();
        this.horizontalSides = new ArrayList<>();
        this.holes = new ArrayList<>();
        holes.add(new Hole(50,50));
        holes.add(new Hole(50,500));
        verticalSides.add(new Wall(30, 30, 5, 500, 0));
        verticalSides.add(new Wall(250, 30, 5, 500, 0));

        verticalSides.add(new Wall(125, 50, 5, 100, 2));

        horizontalSides.add(new Wall(30, 30, 225, 5, 0));
        horizontalSides.add(new Wall(30, 530, 225, 5, 0));

        horizontalSides.add(new Wall(150, 400, 80, 5, 2));
        horizontalSides.add(new Wall(120, 200, 100, 5, 2));

        Thread thread = new Thread(new MouvementThread(this));
        thread.start();
        thread = new Thread(new ColorChangingThread(this));
        thread.start();
    }

    public List<Hole> getHoles() {
        return holes;
    }

    public ArrayList<Wall> getVerticalSides() {
        return verticalSides;
    }

    public ArrayList<Wall> getHorizontalSides() {
        return horizontalSides;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        verticalSides.forEach(side -> side.draw(g2d));
        horizontalSides.forEach(side -> side.draw(g2d));
        balls.forEach(ball -> ball.draw(g2d));
        holes.forEach(hole -> hole.draw(g2d));
    }

    public void newBall() {
        Ball ball = new Ball(this, new Random().nextInt(240 - 40)  + 40, new Random().nextInt( 520 - 40)  + 40, 10, 10);
        balls.add(ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void repaint() {
        super.repaint();
        if (balls != null) {
            if (balls.stream().allMatch(Objects::nonNull)) {
                balls.forEach(Ball::move);
                balls.removeIf(Ball::isToEliminate);
            }
        }
    }
}
