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
        holes.add(new Hole(new Random().nextInt(399) + 51, new Random().nextInt(130) + 195));
        holes.add(new Hole(new Random().nextInt(399) + 51, new Random().nextInt(130) + 195));
        verticalSides.add(new Wall(50, 187, 5, 125, 0));
        verticalSides.add(new Wall(450, 185, 5, 127, 0));
        verticalSides.add(new Wall(350, 200, 5, 40, 1));
        verticalSides.add(new Wall(250, 250, 5, 40, 2));
        horizontalSides.add(new Wall(50, 185, 400, 3, 0));
        horizontalSides.add(new Wall(50, 310, 400, 3, 0));
        horizontalSides.add(new Wall(150, 210, 150, 3, 2));
        horizontalSides.add(new Wall(275, 280, 100, 3, 1));
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
        Ball ball = new Ball(this, new Random().nextInt(399) + 51, new Random().nextInt(127) + 180, 10, 10);
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
