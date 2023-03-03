package Serie3Package;

public class Consumer extends Thread{
    private CommonZone commonZone;
    public Consumer(CommonZone commonZone) {
        super("consummateur");
        this.commonZone = commonZone;
    }

    public void run() {
        Student student;
        synchronized (commonZone) {
            while (!commonZone.isCompleted()) {
                try {
                    Thread.sleep((int) (Math.random() * 3000));
                    student = commonZone.getStudent();
                    if (student == null) commonZone.wait();
                    else {
                        System.out.println("Consumer lit : " + student);
                        commonZone.setStudent(null);
                        commonZone.notify();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
