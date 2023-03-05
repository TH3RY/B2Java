package PackageS4;

public class ColorChangingThread extends Thread {
    private Billiard billiard;

    public ColorChangingThread(Billiard billiard) {
        this.billiard = billiard;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                billiard.getBalls().forEach(ball -> ball.changeColor());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
