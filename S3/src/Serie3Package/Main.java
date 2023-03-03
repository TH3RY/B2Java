package Serie3Package;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student("S1", "NDF1", new SchoolYear("Info", 2, AcademicDegree.BACHELOR));
        Student student2 = new Student("S2", "NDF2", new SchoolYear("AS", 1, AcademicDegree.BACHELOR));
        Student student3 = new Student("S3", "NDF3", new SchoolYear("Info", 3, AcademicDegree.MASTER));
        Student student4 = new Student("S4", "NDF4", new SchoolYear("Info", 2, AcademicDegree.MASTER));
        Student student5 = new Student("S5", "NDF5", new SchoolYear("AS", 1, AcademicDegree.BACHELOR));
        Student student6 = new Student("S6", "NDF6", new SchoolYear("Info", 3, AcademicDegree.BACHELOR));
        Student student7 = new Student("S7", "NDF7", new SchoolYear("Info", 3, AcademicDegree.BACHELOR));
        Student student8 = new Student("S8", "NDF8", new SchoolYear("Info", 1, AcademicDegree.MASTER));
        Student student9 = new Student("S9", "NDF9", new SchoolYear("AS", 2, AcademicDegree.MASTER));
        Student student10 = new Student("S10", "NDF10", new SchoolYear("Info", 2, AcademicDegree.BACHELOR));
        Student [] students = {student1, student10,student2,student3,student4,student5,student6,student7,student8,student9};
        String filename = "serialization.txt";
        String filename2 = "serializationObj.txt";
        CommonZone cz = new CommonZone();
        try (   /*
                    FileWriter fOutput = new FileWriter(filename, false);
                    PrintWriter output = new PrintWriter(fOutput);
                    FileReader fInput = new FileReader(filename);
                    BufferedReader input = new BufferedReader(fInput);
                */
                FileOutputStream fileOutput= new FileOutputStream(filename2);
                ObjectOutputStream output = new ObjectOutputStream(fileOutput);
                FileInputStream fileInput = new FileInputStream (filename2);
                ObjectInputStream input = new  ObjectInputStream ( fileInput);
        ) {
            // Write to file
            // for (int i = 0; i < students.length; i++) {
            //    output.(students[i]);
            // }

            // Read
            // String txtOutput = input.readLine();
            // while (txtOutput != null) {
            //     System.out.println(txtOutput);
            //     txtOutput = input.readLine();
            // }

            // Obj write
            for (int i = 0; i < students.length; i++) {
                output.writeObject(students[i]);
            }
            // Obj read
            // while (fileInput.available() > 0) {
            //     Student tmpStudent = (Student)input.readObject();
            //     System.out.println(tmpStudent);
            // }
            Producer p = new Producer(cz);
            Consumer c = new Consumer(cz);

            p.start();
            c.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

