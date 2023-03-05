package PackageS4;

public class PointsCountingThread extends Thread {
    CounterPanel counterPanel;

    public PointsCountingThread(CounterPanel counterPanel) {
        this.counterPanel = counterPanel;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
                counterPanel.repaint();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
