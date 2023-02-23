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
        File file = new File("myObjects.txt");
        try (   FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream o = new ObjectOutputStream(f);
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
        ) {
            // Write objects to file
            for (int i = 0; i < students.length; i++) {
                o.writeObject(students[i]);
            }
            o.close();
            f.close();

            // Read objects
            Student s1 = (Student) oi.readObject();
            Student s2 = (Student) oi.readObject();
            System.out.println(s1.toString());
            System.out.println(s2);
            oi.close();
            fi.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

