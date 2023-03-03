package Serie3Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Producer extends Thread {
    private CommonZone commonZone;

    public Producer(CommonZone commonZone) {
        super("producteur");
        this.commonZone = commonZone;
    }

    public void run() {
        synchronized (commonZone) {
            try (FileInputStream fileInput = new FileInputStream ("serializationObj.txt");
                 ObjectInputStream input = new  ObjectInputStream (fileInput);) {
                while (fileInput.available() > 0) {
                    Student tmpStudent = (Student)input.readObject();
                    try {
                        Thread.sleep((int) (Math.random() * 3000));
                        commonZone.setStudent(tmpStudent);
                        System.out.println("Producer écrit : " + tmpStudent);
                        this.commonZone.notify();
                        this.commonZone.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                this.commonZone.complete();
                this.commonZone.notify();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
