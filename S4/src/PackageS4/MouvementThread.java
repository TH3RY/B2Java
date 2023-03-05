package PackageS4;

public class MouvementThread extends Thread {
    private Billiard billiard;

    public MouvementThread(Billiard billiard) {
        this.billiard = billiard;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                billiard.repaint();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
