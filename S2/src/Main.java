public class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student("Pierre", "Legrand", 'f',2003,10,21,"technoInfo",2);
            System.out.println(student);
        } catch (GenderException e) {
            throw new RuntimeException(e);
        }
    }
}